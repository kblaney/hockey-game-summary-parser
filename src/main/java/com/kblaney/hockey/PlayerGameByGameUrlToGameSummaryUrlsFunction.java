package com.kblaney.hockey;

import java.io.IOException;
import java.util.List;

interface PlayerGameByGameUrlToGameSummaryUrlsFunction
{
  List<String> getGameSummaryUrls(League league, String playerGameByGameUrl) throws IOException;
}
