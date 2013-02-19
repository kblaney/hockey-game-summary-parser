package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.util.List;

final class GoalReports
{
  public GoalReports()
  {
  }

  public static GoalReport getArbitraryReport()
  {
    final GameScore scoreAfterThisGoal = new GameScore("TEAM_ONE", 1);
    final List<String> plusPlayers = Lists.newArrayList();
    final List<String> minusPlayers = Lists.newArrayList();
    return new GoalReport(Period.FIRST_PERIOD, scoreAfterThisGoal, "GOAL_SCORER_PHP_ID", "GOAL_DESCRIPTION",
          plusPlayers, minusPlayers);
  }

  public static GoalReport getReportForGoalScoredBy(final String goalScorerPhpId, final Period period)
  {
    final GameScore scoreAfterThisGoal = new GameScore("TEAM_ONE", 1);
    final List<String> plusPlayers = Lists.newArrayList();
    final List<String> minusPlayers = Lists.newArrayList();
    return new GoalReport(period, scoreAfterThisGoal, goalScorerPhpId, "GOAL_DESCRIPTION", plusPlayers, minusPlayers);
  }
}
