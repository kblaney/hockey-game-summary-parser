package com.kblaney.hockey;

import com.google.common.collect.Lists;
import com.kblaney.assertions.ArgAssert;
import java.util.Date;
import java.util.List;

public final class GameReport
{
  private final Date gameDate;
  private final String roadTeam;
  private final String homeTeam;
  private final List<GoalReport> goalReports;

  public GameReport(final Date gameDate, final String roadTeam, final String homeTeam,
        final List<GoalReport> goalReports)
  {
    this.gameDate = new Date(gameDate.getTime());
    this.roadTeam = roadTeam;
    this.homeTeam = homeTeam;
    this.goalReports = Lists.newArrayList(ArgAssert.assertNotNull(goalReports, "goalReports"));
  }

  public Date getGameDate()
  {
    return new Date(gameDate.getTime());
  }

  public String getRoadTeam()
  {
    return roadTeam;
  }

  public String getHomeTeam()
  {
    return homeTeam;
  }

  public List<GoalReport> getGoalReports()
  {
    return Lists.newArrayList(goalReports);
  }

  public List<GoalReport> getGoalReportsForPlayer(final String playerPhpId)
  {
    final List<GoalReport> goalReportsForPlayer = Lists.newArrayList();
    for (final GoalReport goalReport : goalReports)
    {
      if (goalReport.getScorerPhpId().equals(playerPhpId))
      {
        goalReportsForPlayer.add(goalReport);
      }
    }
    return goalReportsForPlayer;
  }
}
