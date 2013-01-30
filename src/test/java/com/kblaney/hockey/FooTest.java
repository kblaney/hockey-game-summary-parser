package com.kblaney.hockey;

import java.util.List;
import org.junit.Test;

public final class FooTest
{
  @Test
  public void foo() throws Exception
  {
    final League league = League.OHL;
    final String playerPhpId = "5461";
    final List<GameReport> gameReports = new PlayerPhpIdToGameReportsFunctionImpl().getGameReports(league, playerPhpId);
    final String goalsSummary = new GameReportsToGoalsSummaryFunctionImpl().getGoalsSummary(gameReports, playerPhpId);
    System.out.println(goalsSummary);
  }
}