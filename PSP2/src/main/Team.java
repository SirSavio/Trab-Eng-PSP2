package main;

import java.util.Objects;

public class Team {
	private static int idCount = 1;

	private int id;
	private int points;
	private int pointsMaked;
	private int pointsTaked;
	
	public Team() {
		super();
		this.points = 0;
		this.pointsTaked = 0;
		this.pointsMaked = 0;
		this.id = idCount;
		idCount++;
	}

	public Team(int points, int pointsMaked, int pointsTaked) {
		super();
		this.points = points;
		this.pointsMaked = pointsMaked;
		this.pointsTaked = pointsTaked;
		this.id = idCount;
		idCount++;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pointsMaked, pointsTaked);
	}
	
	public static void clear() {
		idCount = 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return pointsMaked == other.pointsMaked && pointsTaked == other.pointsTaked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPointsMaked() {
		return pointsMaked;
	}

	public int getPointsTaked() {
		return pointsTaked;
	}

	public void setPointsTaked(int points) {
		this.pointsTaked = points;
	}

	public void setPointsMaked(int points) {
		this.pointsMaked = points;
	}

	public void addPoints(int points, int pointsMaked, int pointsTaked) {
		this.points += points;
		this.pointsMaked += pointsMaked;
		this.pointsTaked += pointsTaked;
	}

	public double getRate() {
		if (this.pointsTaked != 0) {
			return ((double) this.pointsMaked) / this.pointsTaked;
		} else {
			return this.pointsMaked;
		}

	}

}
