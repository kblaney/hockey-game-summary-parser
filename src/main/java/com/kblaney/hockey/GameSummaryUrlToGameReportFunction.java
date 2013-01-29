package com.kblaney.hockey;

import java.text.ParseException;
import java.io.IOException;

interface GameSummaryUrlToGameReportFunction
{
  GameReport getGameReport(String gameSummaryUrl) throws IOException, ParseException;
}
