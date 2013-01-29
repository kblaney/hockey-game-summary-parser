package com.kblaney.hockey;

import java.text.ParseException;
import java.io.IOException;
import java.util.List;

interface PlayerPhpIdToGameReportsFunction
{
  List<GameReport> getGameReports(League league, String playerPhpId) throws IOException, ParseException;
}
