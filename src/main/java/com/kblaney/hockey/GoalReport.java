package com.kblaney.hockey;

import com.kblaney.assertions.ArgAssert;

public final class GoalReport
{
  private final Period period;
  private final String scorerPhpId;
  private final String timeOfGoal;
  private final String goalCategories;

  public GoalReport(final Period period, final String goalScorerPhpId, final String timeOfGoal,
        final String goalCategories)
  {
    this.period = ArgAssert.assertNotNull(period, "period");
    this.scorerPhpId = ArgAssert.assertNotNull(goalScorerPhpId, "goalScorerPhpId");
    this.timeOfGoal = ArgAssert.assertNotNull(timeOfGoal, "timeOfGoal");
    this.goalCategories = ArgAssert.assertNotNull(goalCategories, "goalCategories");
  }

  public Period getPeriod()
  {
    return period;
  }

  public String getScorerPhpId()
  {
    return scorerPhpId;
  }

  public String getTimeOfGoal()
  {
    return timeOfGoal;
  }

  public String getGoalCategories()
  {
    return goalCategories;
  }
}
