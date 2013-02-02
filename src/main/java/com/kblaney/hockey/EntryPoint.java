package com.kblaney.hockey;

import java.util.List;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    final League league = League.ECHL;
    final String playerPhpId = "2417";
    final List<GameReport> gameReports = new PlayerPhpIdToGameReportsFunctionImpl().getGameReports(league, playerPhpId);
    final String goalsSummary = new GameReportsToGoalsSummaryFunctionImpl().getGoalsSummary(gameReports, playerPhpId);
    System.out.println(goalsSummary);
  }
}
