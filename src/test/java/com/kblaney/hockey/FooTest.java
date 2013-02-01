package com.kblaney.hockey;

import org.junit.Ignore;
import java.util.List;
import org.junit.Test;

public final class FooTest
{
  //@Ignore
  @Test
  public void foo() throws Exception
  {
    final League league = League.ECHL;
    final String playerPhpId = "2417";
    final List<GameReport> gameReports = new PlayerPhpIdToGameReportsFunctionImpl().getGameReports(league, playerPhpId);
    final String goalsSummary = new GameReportsToGoalsSummaryFunctionImpl().getGoalsSummary(gameReports, playerPhpId);
    System.out.println(goalsSummary);
  }
}
