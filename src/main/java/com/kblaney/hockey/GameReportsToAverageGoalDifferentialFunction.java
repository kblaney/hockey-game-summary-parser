package com.kblaney.hockey;

import java.util.List;

interface GameReportsToAverageGoalDifferentialFunction
{
  double getAverageGoalDifferential(List<GameReport> gameReports, Player player);
}
