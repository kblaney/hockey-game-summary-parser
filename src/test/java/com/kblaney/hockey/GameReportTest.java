package com.kblaney.hockey;

import static org.junit.Assert.*;
import org.junit.Test;
import com.google.common.collect.Lists;
import org.junit.Before;
import java.util.List;
import org.joda.time.LocalDate;

public final class GameReportTest
{
  private LocalDate gameDate;
  private String roadTeam;
  private String homeTeam;
  private List<GoalReport> emptyGoalReports;
  private GameReport zeroZeroTieGameReport;

  @Before
  public void setUp()
  {
    gameDate = new LocalDate(2013, 1, 31);
    roadTeam = "ROAD_TEAM";
    homeTeam = "HOME_TEAM";
    emptyGoalReports = Lists.newArrayList();
    zeroZeroTieGameReport = new GameReport(gameDate, roadTeam, homeTeam, emptyGoalReports);
  }

  @Test
  public void constructor_EnsureDefensiveCopyOfGoalReports()
  {
    emptyGoalReports.add(getArbitraryGoalReport());

    assertTrue(zeroZeroTieGameReport.getGoalReports().isEmpty());
  }

  private GoalReport getArbitraryGoalReport()
  {
    final GameScore gameScore = new GameScore();
    gameScore.addGoal("LDN");
    return new GoalReport(Period.FIRST_PERIOD, gameScore, "GOAL_SCORER_PHP_ID", "GOAL_DESCRIPTION");
  }

  @Test
  public void getGameDate()
  {
    assertEquals(gameDate, zeroZeroTieGameReport.getGameDate());
  }

  @Test
  public void getRoadTeam()
  {
    assertEquals(roadTeam, zeroZeroTieGameReport.getRoadTeam());
  }

  @Test
  public void getHomeTeam()
  {
    assertEquals(homeTeam, zeroZeroTieGameReport.getHomeTeam());
  }

  @Test
  public void getGoalReports_ZeroZeroTie()
  {
    assertEquals(emptyGoalReports, zeroZeroTieGameReport.getGoalReports());
  }

  @Test
  public void getGoalReports_EnsureDefensiveCopy()
  {
    final List<GoalReport> goalReports = zeroZeroTieGameReport.getGoalReports();
    goalReports.add(getArbitraryGoalReport());

    assertTrue(zeroZeroTieGameReport.getGoalReports().isEmpty());
  }

  @Test
  public void getGoalReportsForPlayer_ZeroZeroTie()
  {
    assertTrue(zeroZeroTieGameReport.getGoalReportsForPlayer("PLAYER_PHP_ID").isEmpty());
  }

  @Test
  public void getGoalReportsForPlayer()
  {
    final List<GoalReport> goalReports = Lists.newArrayList(
          new GoalReport(Period.FIRST_PERIOD, new GameScore("LDN", 1), "PLAYER_A_PHP_ID", "GOAL_DESCRIPTION"),
          new GoalReport(Period.FIRST_PERIOD, new GameScore("LDN", 2), "PLAYER_B_PHP_ID", "GOAL_DESCRIPTION"),
          new GoalReport(Period.FIRST_PERIOD, new GameScore("LDN", 3), "PLAYER_A_PHP_ID", "GOAL_DESCRIPTION"));
    final GameReport gameReport = new GameReport(gameDate, roadTeam, homeTeam, goalReports);

    assertEquals(2, gameReport.getGoalReportsForPlayer("PLAYER_A_PHP_ID").size());
    assertEquals(1, gameReport.getGoalReportsForPlayer("PLAYER_B_PHP_ID").size());
  }
}
