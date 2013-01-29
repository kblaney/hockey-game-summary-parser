package com.kblaney.hockey;

import java.util.List;
import java.util.Map;

interface GameReportsToNumGoalsPerPeriodFunction
{
  Map<Period, Integer> getNumGoalsPerPeriod(List<GameReport> gameReports, String playerPhpId);
}
