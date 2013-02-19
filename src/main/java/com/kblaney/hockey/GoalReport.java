package com.kblaney.hockey;

import com.kblaney.assertions.ArgAssert;

public final class GoalReport
{
  private final Period period;
  private final GameScore scoreAfterThisGoal;
  private final String scorerPhpId;
  private final String goalDescription;

  public GoalReport(final Period period, final GameScore scoreAfterThisGoal, final String goalScorerPhpId,
        final String goalDescription)
  {
    this.period = ArgAssert.assertNotNull(period, "period");
    this.scoreAfterThisGoal = new GameScore(ArgAssert.assertNotNull(scoreAfterThisGoal, "scoreAfterThisGoal"));
    this.scorerPhpId = ArgAssert.assertNotNull(goalScorerPhpId, "goalScorerPhpId");
    this.goalDescription = ArgAssert.assertNotNull(goalDescription, "goalDescription");
  }

  public Period getPeriod()
  {
    return period;
  }

  public GameScore getScoreAfterThisGoal()
  {
    return new GameScore(scoreAfterThisGoal);
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
