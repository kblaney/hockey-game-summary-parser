package com.kblaney.hockey;

import org.joda.time.format.DateTimeFormat;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.joda.time.LocalDate;

final class GameDateSupplier implements DocumentParserTo<LocalDate>
{
  @Override
  public LocalDate parse(final Document document)
  {
    final Elements gameDateElements = document.select("b.title:matchesOwn(GAME SUMMARY) ~ b");
    if (gameDateElements.size() != 1)
    {
      throw new IllegalArgumentException("Invalid number of game date elements :" + gameDateElements.size());
    }
    final String date = gameDateElements.first().text();
    return LocalDate.parse(date, DateTimeFormat.forPattern("EEEE, MMMM dd, yyyy"));
  }
}
