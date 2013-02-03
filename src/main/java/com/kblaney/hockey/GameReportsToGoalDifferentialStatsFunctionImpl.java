package com.kblaney.hockey;

import java.util.List;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

final class GameReportsToGoalDifferentialStatsFunctionImpl implements GameReportsToGoalDifferentialStatsFunction
{
  @Override
  public SummaryStatistics getGoalDifferentialStats(final List<GameReport> gameReports, final Player player)
  {
    final SummaryStatistics stats = new SummaryStatistics();
    for (final GameReport gameReport : gameReports)
    {
      for (final GoalReport goalReport : gameReport.getGoalReportsForPlayer(player.getPhpId()))
      {
        stats.addValue(goalReport.getScoreAfterThisGoal().getGoalDifferential());
      }
    }
    return stats;
  }
}
