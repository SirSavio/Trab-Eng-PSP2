package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import main.Scenery;
import main.Team;

class TeamTest {
	
	@Test
	void createNewTeamWithoutPointsTest(){
		Team t = new Team();
		
		assertEquals(0, t.getPoints());
		assertEquals(0, t.getPointsMaked());
		assertEquals(0, t.getPointsTaked());
	}
	
	@Test
	void createNewTeamWithPointsTest(){
		Team t = new Team(1,1,1);
		
		assertEquals(1, t.getPoints());
		assertEquals(1, t.getPointsMaked());
		assertEquals(1, t.getPointsTaked());
	}
	
	@Test
	void addPointsToTeamWithoutPointsTest(){
		Team t = new Team();
		
		t.addPoints(1, 1, 1);
		
		assertEquals(1, t.getPoints());
		assertEquals(1, t.getPointsMaked());
		assertEquals(1, t.getPointsTaked());
	}
	
	@Test
	void addPointsToTeamWithPointsTest(){
		Team t = new Team(1,1,1);
		
		t.addPoints(1, 1, 1);
		
		assertEquals(2, t.getPoints());
		assertEquals(2, t.getPointsMaked());
		assertEquals(2, t.getPointsTaked());
	}
	
	@Test
	void getRateWithoutTakedPoints(){
		Team t = new Team(1,1,0);
		
		assertEquals(1, t.getRate());
	}
	
	@Test
	void getRateWithTakedPoints(){
		Team t = new Team(1,2,1);
		
		assertEquals(2, t.getRate());
	}
}