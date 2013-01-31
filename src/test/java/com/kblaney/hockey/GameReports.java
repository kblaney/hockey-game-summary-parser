package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.joda.time.LocalDate;

final class GameReports
{
  private GameReports()
  {
  }

  public static GameReport getReportForScorelessGame()
  {
    final LocalDate gameDate = new LocalDate(2013, 1, 30);
    final String roadTeam = "Kingston";
    final String homeTeam = "Belleville";
    final List<GoalReport> goalReports = Collections.emptyList();
    return new GameReport(gameDate, roadTeam, homeTeam, goalReports);
  }

  public static GameReport getReportForGameWithOneGoal()
  {
    final LocalDate gameDate = new LocalDate(2013, 1, 30);
    final String roadTeam = "Kingston";
    final String homeTeam = "Belleville";
    final List<GoalReport> goalReports = Lists.newArrayList(GoalReports.getArbitraryReport());
    return new GameReport(gameDate, roadTeam, homeTeam, goalReports);
  }

  public static GameReport getReportForGameWithOneGoalScoredBy(final String playerPhpId, final Period period)
  {
    final LocalDate gameDate = new LocalDate(2013, 1, 30);
    final String roadTeam = "Kingston";
    final String homeTeam = "Belleville";
    final List<GoalReport> goalReports = Lists.newArrayList(GoalReports.getReportForGoalScoredBy(playerPhpId, period));
    return new GameReport(gameDate, roadTeam, homeTeam, goalReports);
  }
}
