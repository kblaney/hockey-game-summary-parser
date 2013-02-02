package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;

final class PlayerToGameReportsFunctionImpl implements PlayerToGameReportsFunction
{
  private final PlayerToGameByGameUrlFunction playerToGameByGameUrlFunction = new PlayerToGameByGameUrlFunctionImpl();
  private final PlayerGameByGameUrlToGameSummaryUrlsFunction playerGameByGameUrlToGameSummaryUrlsFunction = new PlayerGameByGameUrlToGameSummaryUrlsFunctionImpl();
  private final GameSummaryUrlToGameReportFunction gameSummaryUrlToGameReportFunction = new GameSummaryUrlToGameReportFunctionImpl();

  @Override
  public List<GameReport> getGameReports(final Player player) throws IOException
  {
    final String playerGameByGameUrl = playerToGameByGameUrlFunction.getGameByGameUrl(player);
    final List<String> gameSummaryUrls = playerGameByGameUrlToGameSummaryUrlsFunction.getGameSummaryUrls(
          player.getLeague(), playerGameByGameUrl);
    return getGameReports(gameSummaryUrls);
  }

  private List<GameReport> getGameReports(final List<String> gameSummaryUrls) throws IOException
  {
    final List<GameReport> gameReports = Lists.newArrayList();
    for (final String gameSummaryUrl : gameSummaryUrls)
    {
      gameReports.add(gameSummaryUrlToGameReportFunction.getGameReport(gameSummaryUrl));
    }
    return gameReports;
  }
}
