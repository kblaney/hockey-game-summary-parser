package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

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
    final StringBuilder s = new StringBuilder();
    s.append(gameReport.getGameDate());
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
      s.append(goalReport.getScoreAfterThisGoal());
      s.append(": ");
      s.append(goalReport.getGoalDescription());
      s.append('\n');
      if (!goalReport.getPlusPlayers().isEmpty())
      {
        s.append("Plus players: ");
        s.append(goalReport.getPlusPlayers());
        s.append('\n');
        s.append("Minus players: ");
        s.append(goalReport.getMinusPlayers());
        s.append('\n');
      }
    }
    return s.toString();
  }
}
