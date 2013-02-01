package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

final class PlayerGameByGameUrlToGameSummaryUrlsFunctionImpl implements PlayerGameByGameUrlToGameSummaryUrlsFunction
{
  private final DocumentSupplier documentSupplier = new DocumentSupplierImpl();

  @Override
  public List<String> getGameSummaryUrls(final League league, final String playerGameByGameUrl) throws IOException
  {
    final Document document = documentSupplier.getDocument(playerGameByGameUrl);
    final List<Element> gameElements = document.select("table.statsTable > tbody > tr:not(.totals)");
    final List<String> gameSummaryUrls = Lists.newArrayList();
    for (final Element gameElement : gameElements)
    {
      final String gameSummaryHref = gameElement.select("td:eq(1) > a").first().attr("href");
      final String gameSummaryUrl;
      if (gameSummaryHref.startsWith("/"))
      {
        gameSummaryUrl = league.getUrlProtocolAndHost() + gameSummaryHref;
      }
      else
      {
        gameSummaryUrl = gameSummaryHref;
      }
      gameSummaryUrls.add(gameSummaryUrl);
    }
    return gameSummaryUrls;
  }
}
