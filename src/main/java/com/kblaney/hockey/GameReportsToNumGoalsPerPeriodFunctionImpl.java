package com.kblaney.hockey;

import java.util.List;
import java.util.Map;

final class GameReportsToNumGoalsPerPeriodFunctionImpl implements GameReportsToNumGoalsPerPeriodFunction
{
  @Override
  public Map<Period, Integer> getNumGoalsPerPeriod(final List<GameReport> gameReports, final String playerPhpId)
  {
    final Map<Period, Integer> numGoalsPerPeriod = GoalsPerPeriod.getMapWithZeroGoalsPerPeriod();
    for (final GameReport gameReport : gameReports)
    {
      for (final GoalReport goalReport : gameReport.getGoalReportsForPlayer(playerPhpId))
      {
        final int numGoals = numGoalsPerPeriod.get(goalReport.getPeriod());
        numGoalsPerPeriod.put(goalReport.getPeriod(), numGoals + 1);
      }
    }
    return numGoalsPerPeriod;
  }
}
