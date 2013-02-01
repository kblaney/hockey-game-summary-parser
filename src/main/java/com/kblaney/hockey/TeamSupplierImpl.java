package com.kblaney.hockey;

import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

final class TeamSupplierImpl implements TeamSupplier
{
  @Override
  public String getRoadTeam(final Document document)
  {
    return getTeam(document.select("b.content-w:matchesOwn(VISITORS)"));
  }

  private String getTeam(final Elements teamElements)
  {
    if (teamElements.size() != 1)
    {
      throw new IllegalArgumentException("Invalid number of team elements :" + teamElements.size());
    }
    final String elementText = teamElements.first().text();
    return elementText.substring(elementText.lastIndexOf(": ") + 2);
  }

  @Override
  public String getHomeTeam(final Document document)
  {
    return getTeam(document.select("b.content-w:matchesOwn(HOME)"));
  }
}
