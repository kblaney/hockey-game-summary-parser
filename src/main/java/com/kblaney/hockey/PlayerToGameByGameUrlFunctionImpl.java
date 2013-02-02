package com.kblaney.hockey;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

final class PlayerToGameByGameUrlFunctionImpl implements PlayerToGameByGameUrlFunction
{
  private final DocumentSupplier documentSupplier = new DocumentSupplierImpl();

  @Override
  public String getGameByGameUrl(final Player player) throws IOException
  {
    final String url = player.getLeague().getUrlProtocolAndHost() + "/stats/player.php?id=" + player.getPhpId();
    final Document document = documentSupplier.getDocument(url);
    final Elements elements = document.select("a[href*=gameByGame");
    if (elements.size() != 1)
    {
      throw new IllegalArgumentException("Invalid number of elements:" + elements.size());
    }
    final String href = elements.first().attr("href");
    if (href.startsWith("/"))
    {
      return player.getLeague().getUrlProtocolAndHost() + href;
    }
    else
    {
      return href;
    }
  }
}
