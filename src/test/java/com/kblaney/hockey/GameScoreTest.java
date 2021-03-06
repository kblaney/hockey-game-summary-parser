package com.kblaney.hockey;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public final class GameScoreTest
{
  private GameScore gameScore;

  @Before
  public void setUp()
  {
    gameScore = new GameScore();
  }

  @Test
  public void shutoutConstructor()
  {
    final GameScore gameScore = new GameScore("Team A", 5);
    assertEquals("Team A 5 - 0", gameScore.toString());
  }

  @Test
  public void copyConstructor_GameTiedAtZero()
  {
    final GameScore copy = new GameScore(gameScore);
    assertEquals("0 - 0", copy.toString());
  }

  @Test
  public void copyConstructor_ThreeOneLead()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team B");
    final GameScore copy = new GameScore(gameScore);
    assertEquals("Team B 3 - Team A 1", copy.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addGoal_ThirdTeam()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team C");
  }

  @Test
  public void toString_GameTiedAtZero()
  {
    assertEquals("0 - 0", gameScore.toString());
  }

  @Test
  public void toString_AfterFirstGoal()
  {
    gameScore.addGoal("Team A");
    assertEquals("Team A 1 - 0", gameScore.toString());
  }

  @Test
  public void toString_AfterSecondGoalForSameTeam()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team A");
    assertEquals("Team A 2 - 0", gameScore.toString());
  }

  @Test
  public void toString_GameTiedAtOne()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    assertEquals("Team A 1 - Team B 1", gameScore.toString());
  }

  @Test
  public void toString_TrailingTeamTakesLead()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team B");
    assertEquals("Team B 2 - Team A 1", gameScore.toString());
  }

  @Test
  public void getGoalDifferential_GameTiedAtZero()
  {
    assertEquals(0, new GameScore().getGoalDifferential());
  }

  @Test
  public void getGoalDifferential_OneGoalInGame()
  {
    gameScore.addGoal("Team A");
    assertEquals(1, gameScore.getGoalDifferential());
  }

  @Test
  public void getGoalDifferential_GameTiedAtOne()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    assertEquals(0, gameScore.getGoalDifferential());
  }

  @Test
  public void getGoalDifferential_FirstTeamToScoreLosesLead()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team B");
    assertEquals(1, gameScore.getGoalDifferential());
  }

  @Test
  public void getGoalDifferential_BlowoutWithManyGoals()
  {
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team B");
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team A");
    gameScore.addGoal("Team A");
    assertEquals(6, gameScore.getGoalDifferential());
  }
}
