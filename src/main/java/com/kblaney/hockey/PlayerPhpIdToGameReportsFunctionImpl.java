package com.kblaney.hockey;

import java.text.ParseException;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;

final class PlayerPhpIdToGameReportsFunctionImpl implements PlayerPhpIdToGameReportsFunction
{
  private final PlayerPhpIdToGameByGameUrlFunction playerPhpIdToGameByGameUrlFunction = new PlayerPhpIdToGameByGameUrlFunctionImpl();
  private final PlayerGameByGameUrlToGameSummaryUrlsFunction playerGameByGameUrlToGameSummaryUrlsFunction = new PlayerGameByGameUrlToGameSummaryUrlsFunctionImpl();
  private final GameSummaryUrlToGameReportFunction gameSummaryUrlToGameReportFunction = new GameSummaryUrlToGameReportFunctionImpl();

  @Override
  public List<GameReport> getGameReports(final League league, final String playerPhpId) throws IOException,
        ParseException
  {
    final String playerGameByGameUrl = playerPhpIdToGameByGameUrlFunction.getGameByGameUrl(league, playerPhpId);
    final List<String> gameSummaryUrls = playerGameByGameUrlToGameSummaryUrlsFunction.getGameSummaryUrls(league,
          playerGameByGameUrl);
    return getGameReports(gameSummaryUrls);
  }

  private List<GameReport> getGameReports(final List<String> gameSummaryUrls) throws IOException, ParseException
  {
    final List<GameReport> gameReports = Lists.newArrayList();
    for (final String gameSummaryUrl : gameSummaryUrls)
    {
      gameReports.add(gameSummaryUrlToGameReportFunction.getGameReport(gameSummaryUrl));
    }
    return gameReports;
  }
}
