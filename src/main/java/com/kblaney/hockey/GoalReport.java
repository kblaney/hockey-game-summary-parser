package com.kblaney.hockey;

import com.google.common.collect.Lists;
import com.kblaney.assertions.ArgAssert;
import java.util.List;

public final class GoalReport
{
  private final Period period;
  private final GameScore scoreAfterThisGoal;
  private final String scorerPhpId;
  private final String goalDescription;
  private final List<String> plusPlayers;
  private final List<String> minusPlayers;

  public GoalReport(final Period period, final GameScore scoreAfterThisGoal, final String goalScorerPhpId,
        final String goalDescription, final List<String> plusPlayers, final List<String> minusPlayers)
  {
    this.period = ArgAssert.assertNotNull(period, "period");
    this.scoreAfterThisGoal = new GameScore(ArgAssert.assertNotNull(scoreAfterThisGoal, "scoreAfterThisGoal"));
    this.scorerPhpId = ArgAssert.assertNotNull(goalScorerPhpId, "goalScorerPhpId");
    this.goalDescription = ArgAssert.assertNotNull(goalDescription, "goalDescription");
    this.plusPlayers = Lists.newArrayList(ArgAssert.assertNotNull(plusPlayers, "plusPlayers"));
    this.minusPlayers = Lists.newArrayList(ArgAssert.assertNotNull(minusPlayers, "minusPlayers"));
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

  public List<String> getPlusPlayers()
  {
    return Lists.newArrayList(plusPlayers);
  }

  public List<String> getMinusPlayers()
  {
    return Lists.newArrayList(minusPlayers);
  }
}
