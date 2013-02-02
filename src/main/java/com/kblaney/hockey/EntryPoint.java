package com.kblaney.hockey;

import java.util.List;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    final Player player = new Player("Nathan McKinnon", League.QMJHL, "11126");
    final List<GameReport> gameReports = new PlayerToGameReportsFunctionImpl().getGameReports(player);
    final String goalsSummary = new GameReportsToGoalsSummaryFunctionImpl().getGoalsSummary(gameReports,
          player.getPhpId());
    System.out.println(goalsSummary);
  }
}
