package com.kblaney.hockey;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

final class PlayerPhpIdToGameByGameUrlFunctionImpl implements PlayerPhpIdToGameByGameUrlFunction
{
  private final DocumentSupplier documentSupplier = new DocumentSupplierImpl();

  @Override
  public String getGameByGameUrl(final League league, final String playerPhpId) throws IOException
  {
    final String url = league.getUrlProtocolAndHost() + "/stats/player.php?id=" + playerPhpId;
    final Document document = documentSupplier.getDocument(url);
    final Elements elements = document.select("a[href*=gameByGame");
    if (elements.size() != 1)
    {
      throw new IllegalArgumentException("Invalid number of elements:" + elements.size());
    }
    final String href = elements.first().attr("href");
    if (href.startsWith("/"))
    {
      return league.getUrlProtocolAndHost() + href;
    }
    else
    {
      return href;
    }
  }
}
