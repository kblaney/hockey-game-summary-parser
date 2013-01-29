package com.kblaney.hockey;

import com.kblaney.assertions.ArgAssert;

public final class GoalReport
{
  private final Period period;
  private final String scorerPhpId;

  public GoalReport(final Period period, final String goalScorerPhpId)
  {
    this.period = ArgAssert.assertNotNull(period, "period");
    this.scorerPhpId = ArgAssert.assertNotNull(goalScorerPhpId, "goalScorerPhpId");
  }

  public Period getPeriod()
  {
    return period;
  }

  public String getScorerPhpId()
  {
    return scorerPhpId;
  }
}
