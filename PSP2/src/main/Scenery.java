package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Scenery {
	private List<Team> teams;

	@Override
	public int hashCode() {
		return Objects.hash(teams);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scenery other = (Scenery) obj;
		return Objects.equals(teams, other.teams);
	}

	public Scenery() {
		super();
		this.teams = new ArrayList<>();
	}

	public Scenery(List<Team> teams) {
		super();
		this.teams = teams;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public void clear() {
		this.teams.clear();
		Team.clear();
	}

	public String generateRanking() {
		StringBuilder rank = new StringBuilder();

		if (this.teams.size() == 1) {
			return String.valueOf(this.teams.get(0).getId());
		}

		Collections.sort(this.teams, Comparator.comparing(Team::getPoints).reversed());

		int i = 0;
		for (; i < this.teams.size() - 1; i++) {
			if (this.teams.get(i).getPoints() > this.teams.get(i + 1).getPoints()) {
				rank.append(this.teams.get(i).getId());
				rank.append(" ");
			} else {
				int index = i;
				Predicate<Team> byPoint = team -> team.getPoints() == this.teams.get(index).getPoints();
				List<Team> draw = this.teams.stream().filter(byPoint).collect(Collectors.toList());
				Collections.sort(draw, Comparator.comparing(Team::getRate).reversed());

				int j = 0;
				for (; j < draw.size() - 1; j++) {
					if (draw.get(j).getRate() > draw.get(j + 1).getRate()) {
						rank.append(draw.get(j).getId());
						rank.append(" ");
					} else {
						int indexJ = j;
						Predicate<Team> byRate = team -> team.getRate() == draw.get(indexJ).getRate();
						List<Team> drawRate = draw.stream().filter(byRate).collect(Collectors.toList());
						Collections.sort(drawRate, Comparator.comparing(Team::getPointsMaked).reversed());

						int k = 0;
						for (; k < drawRate.size() - 1; k++) {
							if (drawRate.get(k).getPointsMaked() > drawRate.get(k + 1).getPointsMaked()) {
								rank.append(drawRate.get(k).getId());
								rank.append(" ");
							} else {
								List<Team> drawId = drawRate;
								Collections.sort(drawId, Comparator.comparing(Team::getId));

								for (int l = 0; l < drawId.size() - 1; l++) {
									if (drawId.get(l).getId() < drawId.get(l + 1).getId()) {
										rank.append(drawId.get(l).getId());
										rank.append(" ");
									}
								}
								rank.append(drawId.get(drawId.size() - 1).getId());
								rank.append(" ");
								k += drawId.size() - 1;
							}
						}
						if (k < drawRate.size()) {
							rank.append(drawRate.get(drawRate.size() - 1).getId());
							rank.append(" ");
						}
						j += drawRate.size() - 1;
					}
				}
				if (j < draw.size()) {
					rank.append(draw.get(draw.size() - 1).getId());
					rank.append(" ");
				}
				i += draw.size() - 1;
			}
		}
		if (i < this.teams.size()) {
			rank.append(teams.get(teams.size() - 1).getId());
		}
		return rank.toString().charAt(rank.toString().length()-1) == ' ' ?  rank.toString().substring(0, rank.toString().length()-1) : rank.toString();
	}

	public void addTeam(Team team) {
		this.teams.add(team);
	}

	public void addPointsToTeam(int id, int points, int pointsMaked, int pointsTaked) {
		for (Team team : this.teams) {
			if (team.getId() == id) {
				team.addPoints(points, pointsMaked, pointsTaked);
				break;
			}
		}
	}
}
