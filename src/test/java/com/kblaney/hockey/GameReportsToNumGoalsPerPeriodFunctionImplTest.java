package com.kblaney.hockey;

import static org.junit.Assert.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public final class GameReportsToNumGoalsPerPeriodFunctionImplTest
{
  private GameReportsToNumGoalsPerPeriodFunction function;

  @Before
  public void setUp()
  {
    function = new GameReportsToNumGoalsPerPeriodFunctionImpl();
  }

  @Test
  public void getNumGoalsPerPeriod_ZeroGames()
  {
    final List<GameReport> gameReports = Collections.emptyList();
    assertEquals(GoalsPerPeriod.getMapWithZeroGoalsPerPeriod(),
          function.getNumGoalsPerPeriod(gameReports, "PLAYER_PHP_ID"));
  }

  @Test
  public void getNumGoalsPerPeriod_OneScorelessGame()
  {
    final List<GameReport> gameReports = Lists.newArrayList(GameReports.getReportForScorelessGame());
    assertEquals(GoalsPerPeriod.getMapWithZeroGoalsPerPeriod(),
          function.getNumGoalsPerPeriod(gameReports, "PLAYER_PHP_ID"));
  }

  @Test
  public void getNumGoalsPerPeriod_OneGamePlayerHasZeroGoals()
  {
    final List<GameReport> gameReports = Lists.newArrayList(GameReports.getReportForGameWithOneGoal());
    assertEquals(GoalsPerPeriod.getMapWithZeroGoalsPerPeriod(),
          function.getNumGoalsPerPeriod(gameReports, "PHP_ID_OF_PLAYER_THAT_DID_NOT_SCORE"));
  }

  @Test
  public void getNumGoalsPerPeriod_OneGamePlayerHasOnlyGoalInFirstPeriod()
  {
    final String playerPhpId = "PLAYER_PHP_ID";
    final Period period = Period.FIRST_PERIOD;
    final List<GameReport> gameReports = Lists.newArrayList(GameReports.getReportForGameWithOneGoalScoredBy(
          playerPhpId, period));

    final Map<Period, Integer> expected = Maps.newHashMap();
    expected.put(Period.FIRST_PERIOD, 1);
    expected.put(Period.SECOND_PERIOD, 0);
    expected.put(Period.THIRD_PERIOD, 0);
    expected.put(Period.OVERTIME, 0);
    assertEquals(expected, function.getNumGoalsPerPeriod(gameReports, playerPhpId));
  }

  @Test
  public void getNumGoalsPerPeriod_OneGamePlayerHasOnlyGoalInSecondPeriod()
  {
    final String playerPhpId = "PLAYER_PHP_ID";
    final Period period = Period.SECOND_PERIOD;
    final List<GameReport> gameReports = Lists.newArrayList(GameReports.getReportForGameWithOneGoalScoredBy(
          playerPhpId, period));

    final Map<Period, Integer> expected = Maps.newHashMap();
    expected.put(Period.FIRST_PERIOD, 0);
    expected.put(Period.SECOND_PERIOD, 1);
    expected.put(Period.THIRD_PERIOD, 0);
    expected.put(Period.OVERTIME, 0);
    assertEquals(expected, function.getNumGoalsPerPeriod(gameReports, playerPhpId));
  }

  @Test
  public void getNumGoalsPerPeriod_OneGamePlayerHasOnlyGoalInThirdPeriod()
  {
    final String playerPhpId = "PLAYER_PHP_ID";
    final Period period = Period.THIRD_PERIOD;
    final List<GameReport> gameReports = Lists.newArrayList(GameReports.getReportForGameWithOneGoalScoredBy(
          playerPhpId, period));

    final Map<Period, Integer> expected = Maps.newHashMap();
    expected.put(Period.FIRST_PERIOD, 0);
    expected.put(Period.SECOND_PERIOD, 0);
    expected.put(Period.THIRD_PERIOD, 1);
    expected.put(Period.OVERTIME, 0);
    assertEquals(expected, function.getNumGoalsPerPeriod(gameReports, playerPhpId));
  }

  @Test
  public void getNumGoalsPerPeriod_OneGamePlayerHasOnlyGoalInOvertime()
  {
    final String playerPhpId = "PLAYER_PHP_ID";
    final Period period = Period.OVERTIME;
    final List<GameReport> gameReports = Lists.newArrayList(GameReports.getReportForGameWithOneGoalScoredBy(
          playerPhpId, period));

    final Map<Period, Integer> expected = Maps.newHashMap();
    expected.put(Period.FIRST_PERIOD, 0);
    expected.put(Period.SECOND_PERIOD, 0);
    expected.put(Period.THIRD_PERIOD, 0);
    expected.put(Period.OVERTIME, 1);
    assertEquals(expected, function.getNumGoalsPerPeriod(gameReports, playerPhpId));
  }

  @Test
  public void getNumGoalsPerPeriod_TwoScorelessGames()
  {
    final List<GameReport> gameReports = Lists.newArrayList(GameReports.getReportForScorelessGame(),
          GameReports.getReportForScorelessGame());
    assertEquals(GoalsPerPeriod.getMapWithZeroGoalsPerPeriod(),
          function.getNumGoalsPerPeriod(gameReports, "PLAYER_PHP_ID"));
  }

  @Test
  public void getNumGoalsPerPeriod_PlayerHasGoalsInTwoOfThreeGames()
  {
    final String playerPhpId = "PLAYER_PHP_ID";
    final String otherPlayerPhpId = "OTHER_PLAYER_PHP_ID";
    // @formatter:off
    final List<GameReport> gameReports = Lists.newArrayList(
          new GameReport(new LocalDate(2013, 1, 1), "Kingston", "Belleville", Lists.newArrayList(
                getGoalReport(Period.FIRST_PERIOD, new GameScore("KGN", 1), playerPhpId),
                getGoalReport(Period.FIRST_PERIOD, new GameScore("KGN", 2), otherPlayerPhpId),
                getGoalReport(Period.FIRST_PERIOD, new GameScore("KGN", 3), playerPhpId),
                getGoalReport(Period.FIRST_PERIOD, new GameScore("KGN", 4), playerPhpId),
                getGoalReport(Period.SECOND_PERIOD, new GameScore("KGN", 5), otherPlayerPhpId),
                getGoalReport(Period.SECOND_PERIOD, new GameScore("KGN", 6), playerPhpId),
                getGoalReport(Period.THIRD_PERIOD, new GameScore("KGN", 7), otherPlayerPhpId),
                getGoalReport(Period.THIRD_PERIOD, new GameScore("KGN", 8), playerPhpId),
                getGoalReport(Period.THIRD_PERIOD, new GameScore("KGN", 9), playerPhpId),
                getGoalReport(Period.OVERTIME, new GameScore("KGN", 10), otherPlayerPhpId))),
          new GameReport(new LocalDate(2013, 1, 2), "Belleville", "Kingston", Lists.newArrayList(
                getGoalReport(Period.FIRST_PERIOD, new GameScore("KGN", 1), playerPhpId),
                getGoalReport(Period.FIRST_PERIOD, new GameScore("KGN", 2), otherPlayerPhpId),
                getGoalReport(Period.SECOND_PERIOD, new GameScore("KGN", 3), playerPhpId),
                getGoalReport(Period.SECOND_PERIOD, new GameScore("KGN", 4), playerPhpId),
                getGoalReport(Period.THIRD_PERIOD, new GameScore("KGN", 5), otherPlayerPhpId),
                getGoalReport(Period.OVERTIME, new GameScore("KGN", 6), playerPhpId))),
          GameReports.getReportForScorelessGame());
    // @formatter:on

    final Map<Period, Integer> expected = Maps.newHashMap();
    expected.put(Period.FIRST_PERIOD, 4);
    expected.put(Period.SECOND_PERIOD, 3);
    expected.put(Period.THIRD_PERIOD, 2);
    expected.put(Period.OVERTIME, 1);
    assertEquals(expected, function.getNumGoalsPerPeriod(gameReports, playerPhpId));
  }

  private GoalReport getGoalReport(final Period period, final GameScore gameScore, final String playerPhpId)
  {
    final List<String> plusPlayers = Lists.newArrayList();
    final List<String> minusPlayers = Lists.newArrayList();
    return new GoalReport(period, gameScore, playerPhpId, "GOAL_DESCRIPTION", plusPlayers, minusPlayers);
  }
}
