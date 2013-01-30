package com.kblaney.hockey;

import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import java.text.SimpleDateFormat;
import java.util.List;

final class GameReportsToGoalsSummaryFunctionImpl implements GameReportsToGoalsSummaryFunction
{
  @Override
  public String getGoalsSummary(final List<GameReport> gameReports, final String playerPhpId)
  {
    final List<String> gameSummaries = Lists.newArrayListWithExpectedSize(gameReports.size());
    for (final GameReport gameReport : gameReports)
    {
      gameSummaries.add(getGameSummary(gameReport, playerPhpId));
    }
    return StringUtils.join(gameSummaries, '\n');
  }

  private String getGameSummary(final GameReport gameReport, final String playerPhpId)
  {
    final SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    final StringBuilder s = new StringBuilder();
    s.append(outputDateFormat.format(gameReport.getGameDate()));
    s.append(" - ");
    s.append(gameReport.getRoadTeam());
    s.append(" @ ");
    s.append(gameReport.getHomeTeam());
    s.append(" - ");
    s.append(getGoalsSummaryForGame(gameReport, playerPhpId));
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
