package com.kblaney.hockey;

import java.text.SimpleDateFormat;
import java.util.List;

final class GameReportsToGoalsSummaryFunctionImpl implements GameReportsToGoalsSummaryFunction
{
  @Override
  public String getGoalsSummary(final List<GameReport> gameReports, final String playerPhpId)
  {
    final StringBuilder s = new StringBuilder();
    final SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    for (final GameReport gameReport : gameReports)
    {
      s.append(outputDateFormat.format(gameReport.getGameDate()));
      s.append(" - ");
      s.append(gameReport.getRoadTeam());
      s.append(" @ ");
      s.append(gameReport.getHomeTeam());
      s.append(" - ");
      s.append(getGoalsSummaryForGame(gameReport, playerPhpId));
    }
    return s.toString();
  }

  private String getGoalsSummaryForGame(final GameReport gameReport, final String playerPhpId)
  {
    final List<GoalReport> goalReports = gameReport.getGoalReportsForPlayer(playerPhpId);
    final StringBuilder s = new StringBuilder(goalReports.size() + " goals\n");
    for (final GoalReport goalReport : goalReports)
    {
      s.append("   ");
      s.append(goalReport.getGoalDescription());
      s.append('\n');
    }
    return s.toString();
  }
}
