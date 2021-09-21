import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.Team;
import main.Scenery;

public class Main {

	public static void main(String[] args) {
		int teamNumber;
		List<Team> teams = new ArrayList<>();

		Scanner in = new Scanner(System.in);
		teamNumber = in.nextInt();

		for (int i = 0; i < teamNumber; i++) {
			teams.add(new Team());
		}

		Scenery scenery = new Scenery(teams);
		for (int i = 0; i < (teamNumber * (teamNumber - 1)) / 2; i++) {
			int teamOneId = in.nextInt();
			int teamOneMakedPoints = in.nextInt();
			int teamTwoId = in.nextInt();
			int teamTwoMakedPoints = in.nextInt();

			scenery.addPointsToTeam(teamOneId, teamOneMakedPoints > teamTwoMakedPoints ? 2 : 1, teamOneMakedPoints,
					teamTwoMakedPoints);
			scenery.addPointsToTeam(teamTwoId, teamOneMakedPoints > teamTwoMakedPoints ? 1 : 2, teamTwoMakedPoints,
					teamOneMakedPoints);
		}

		System.out.print(scenery.generateRanking());
	}
}
