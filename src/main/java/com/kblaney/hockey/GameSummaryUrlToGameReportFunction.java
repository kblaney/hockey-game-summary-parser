package com.kblaney.hockey;

import java.io.IOException;

interface GameSummaryUrlToGameReportFunction
{
  GameReport getGameReport(String gameSummaryUrl) throws IOException;
}
