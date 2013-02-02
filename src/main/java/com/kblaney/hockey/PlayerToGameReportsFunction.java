package com.kblaney.hockey;

import java.io.IOException;
import java.util.List;

interface PlayerToGameReportsFunction
{
  List<GameReport> getGameReports(Player player) throws IOException;
}
