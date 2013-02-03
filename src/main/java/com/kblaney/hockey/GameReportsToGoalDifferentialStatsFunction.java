package com.kblaney.hockey;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import java.util.List;

interface GameReportsToGoalDifferentialStatsFunction
{
  SummaryStatistics getGoalDifferentialStats(List<GameReport> gameReports, Player player);
}
