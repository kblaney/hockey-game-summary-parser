package com.kblaney.hockey;

final class GoalReports
{
  public GoalReports(){}

  public static GoalReport getArbitraryReport()
  {
    final GameScore scoreAfterThisGoal = new GameScore("TEAM_ONE", 1);
    return new GoalReport(Period.FIRST_PERIOD, scoreAfterThisGoal, "GOAL_SCORER_PHP_ID", "GOAL_DESCRIPTION");
  }

  public static GoalReport getReportForGoalScoredBy(final String goalScorerPhpId, final Period period)
  {
    final GameScore scoreAfterThisGoal = new GameScore("TEAM_ONE", 1);
    return new GoalReport(period, scoreAfterThisGoal, goalScorerPhpId, "GOAL_DESCRIPTION");
  }
}
