package com.kblaney.hockey;

import com.google.common.collect.Maps;
import java.util.Map;

final class GoalsPerPeriod
{
  public static Map<Period, Integer> getMapWithZeroGoalsPerPeriod()
  {
    final Map<Period, Integer> goalsPerPeriod = Maps.newHashMap();
    goalsPerPeriod.put(Period.FIRST_PERIOD, 0);
    goalsPerPeriod.put(Period.SECOND_PERIOD, 0);
    goalsPerPeriod.put(Period.THIRD_PERIOD, 0);
    goalsPerPeriod.put(Period.OVERTIME, 0);
    return goalsPerPeriod;
  }

  private GoalsPerPeriod()
  {
  }
}
