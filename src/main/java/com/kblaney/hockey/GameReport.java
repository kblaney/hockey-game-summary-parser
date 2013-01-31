package com.kblaney.hockey;

import com.google.common.collect.Lists;
import com.kblaney.assertions.ArgAssert;
import java.util.List;
import org.joda.time.LocalDate;

public final class GameReport
{
  private final LocalDate gameDate;
  private final String roadTeam;
  private final String homeTeam;
  private final List<GoalReport> goalReports;

  public GameReport(final LocalDate gameDate, final String roadTeam, final String homeTeam,
        final List<GoalReport> goalReports)
  {
    this.gameDate = gameDate;
    this.roadTeam = roadTeam;
    this.homeTeam = homeTeam;
    this.goalReports = Lists.newArrayList(ArgAssert.assertNotNull(goalReports, "goalReports"));
  }

  public LocalDate getGameDate()
  {
    return gameDate;
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
