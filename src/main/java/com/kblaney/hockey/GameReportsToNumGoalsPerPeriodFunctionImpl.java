package com.kblaney.hockey;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

final class GameReportsToNumGoalsPerPeriodFunctionImpl implements GameReportsToNumGoalsPerPeriodFunction
{
  @Override
  public Map<Period, Integer> getNumGoalsPerPeriod(final List<GameReport> gameReports, final String playerPhpId)
  {
    final Map<Period, Integer> numGoalsPerPeriod = getZeroGoalsPerPeriod();
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

  private Map<Period, Integer> getZeroGoalsPerPeriod()
  {
    final Map<Period, Integer> goalsPerPeriod = Maps.newHashMap();
    goalsPerPeriod.put(Period.FIRST_PERIOD, 0);
    goalsPerPeriod.put(Period.SECOND_PERIOD, 0);
    goalsPerPeriod.put(Period.THIRD_PERIOD, 0);
    goalsPerPeriod.put(Period.OVERTIME, 0);
    return goalsPerPeriod;
  }
}
