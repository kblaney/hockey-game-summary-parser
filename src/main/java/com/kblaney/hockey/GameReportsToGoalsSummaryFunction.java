package com.kblaney.hockey;

import java.util.List;

interface GameReportsToGoalsSummaryFunction
{
  String getGoalsSummary(List<GameReport> gameReports, String playerPhpId);
}
