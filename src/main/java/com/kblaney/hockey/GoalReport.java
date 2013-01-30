package com.kblaney.hockey;

import com.kblaney.assertions.ArgAssert;

public final class GoalReport
{
  private final Period period;
  private final String scorerPhpId;
  private final String goalDescription;

  public GoalReport(final Period period, final String goalScorerPhpId, final String goalDescription)
  {
    this.period = ArgAssert.assertNotNull(period, "period");
    this.scorerPhpId = ArgAssert.assertNotNull(goalScorerPhpId, "goalScorerPhpId");
    this.goalDescription = ArgAssert.assertNotNull(goalDescription, "goalDescription");
  }

  public Period getPeriod()
  {
    return period;
  }

  public String getScorerPhpId()
  {
    return scorerPhpId;
  }

  public String getGoalDescription()
  {
    return goalDescription;
  }
}
