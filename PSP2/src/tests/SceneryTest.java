package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Scenery;
import main.Team;

class SceneryTest {
	@Test
	void difPointsTest() {
		Scenery scenery = new Scenery();
		scenery.clear();
		Team team_8_476_370 = new Team(8, 476, 370);
		Team team_7_312_325 = new Team(7, 312, 325);
		Team team_4_354_380 = new Team(4, 354, 380);
		Team team_6_360_422 = new Team(6, 360, 422);
		Team team_5_382_387 = new Team(5, 382, 387);
		
		scenery.addTeam(team_8_476_370);
		scenery.addTeam(team_7_312_325);
		scenery.addTeam(team_4_354_380);
		scenery.addTeam(team_6_360_422);
		scenery.addTeam(team_5_382_387);
		
		assertEquals("1 2 4 5 3", scenery.generateRanking());
	}
	
	
	@Test
	void difRateTest() {
		Scenery scenery = new Scenery();
		scenery.clear();
		Team team_3_30_25 = new Team(3, 30, 25);
		Team team_3_20_16 = new Team(3, 20, 16);
		Team team_3_21_30 = new Team(3, 21, 30);
		
		scenery.addTeam(team_3_30_25);
		scenery.addTeam(team_3_20_16);
		scenery.addTeam(team_3_21_30);
		
		assertEquals("2 1 3", scenery.generateRanking());
	}
	
	@Test
	void noPointsTakedTest() {
		Scenery scenery = new Scenery();
		scenery.clear();
		Team team_3_30_0 = new Team(3, 30, 0);
		Team team_3_20_0 = new Team(3, 20, 0);
		Team team_3_1_30 = new Team(3, 1, 30);
		
		scenery.addTeam(team_3_30_0);
		scenery.addTeam(team_3_20_0);
		scenery.addTeam(team_3_1_30);
		
		assertEquals("1 2 3", scenery.generateRanking());
	}
	  
	@Test
	void difIndexTest() {
		Scenery scenery = new Scenery();
		scenery.clear();
		Team team_3_20_20_1 = new Team(3, 20, 20);
		Team team_3_20_20_2 = new Team(3, 20, 20);
		Team team_3_20_20_3 = new Team(3, 20, 20);
		
		scenery.addTeam(team_3_20_20_1);
		scenery.addTeam(team_3_20_20_2);
		scenery.addTeam(team_3_20_20_3);
		
		assertEquals("1 2 3", scenery.generateRanking());
	}
	
	@Test
	void addPointsToTeamFromZeroTest() {
		Scenery scenery = new Scenery();
		scenery.clear();
		
		Team t = new Team();
		scenery.addTeam(t);
		scenery.addPointsToTeam(t.getId(), 5, 5, 5);
		
		int p = scenery.getTeams().get(0).getPoints();
		int pM = scenery.getTeams().get(0).getPointsMaked();
		int pT = scenery.getTeams().get(0).getPointsTaked();
		
		String str = String.valueOf(p) + " " + String.valueOf(pM) + " " + String.valueOf(pT);
		assertEquals("5 5 5", str);
	}
	
	@Test
	void addPointsToTeamTest() {
		Scenery scenery = new Scenery();
		scenery.clear();
		Team team_3_20_20 = new Team(3, 20, 20);
		
		scenery.addTeam(team_3_20_20);
		scenery.addPointsToTeam(team_3_20_20.getId(), 5, 5, 5);
		
		int p = scenery.getTeams().get(0).getPoints();
		int pM = scenery.getTeams().get(0).getPointsMaked();
		int pT = scenery.getTeams().get(0).getPointsTaked();
		
		String str = String.valueOf(p) + " " + String.valueOf(pM) + " " + String.valueOf(pT);
		assertEquals("8 25 25", str);
	}	
}
