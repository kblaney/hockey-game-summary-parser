package com.kblaney.hockey;

import static org.junit.Assert.*;
import org.joda.time.LocalDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public final class GameDateSupplierTest
{
  private DocumentParserTo<LocalDate> gameDateSupplier;

  @Before
  public void setUp()
  {
    gameDateSupplier = new GameDateSupplier();
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_EmptyDocument()
  {
    final Document document = Jsoup.parseBodyFragment("");
    gameDateSupplier.parse(document);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_TwoGameDateElements()
  {
    final Document document = Jsoup.parseBodyFragment("<b class=\"title\">GAME SUMMARY</b><br>"
          + "<b>Thursday, January 31, 2013</b><b>Friday, February 1, 2013</b>");
    gameDateSupplier.parse(document);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_DateInImproperFormat()
  {
    final Document document = Jsoup.parseBodyFragment("<b class=\"title\">GAME SUMMARY</b><br><b>NOT A DATE</b>");
    gameDateSupplier.parse(document);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_GameSummaryTitleNotDirectlyInBElement()
  {
    final Document document = Jsoup.parseBodyFragment("<b class=\"title\"><a>GAME SUMMARY</a></b><br>"
          + "<b>Friday, February 1, 2013</b>");
    gameDateSupplier.parse(document);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_GameSummaryTitleNotInUppercase()
  {
    final Document document = Jsoup.parseBodyFragment("<b class=\"title\">game summary</b><br>"
          + "<b>Thursday, January 31, 2013</b>");
    gameDateSupplier.parse(document);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_GameSummaryNotTitleClass()
  {
    final Document document = Jsoup.parseBodyFragment("<b>GAME SUMMARY</b><br><b>Thursday, January 31, 2013</b>");
    gameDateSupplier.parse(document);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parse_GameSummaryNotInBElement()
  {
    final Document document = Jsoup.parseBodyFragment("<c class=\"title\">GAME SUMMARY</c><br>"
          + "<b>Thursday, January 31, 2013</b>");
    gameDateSupplier.parse(document);
  }

  @Test
  public void parse_OneGameDateElement()
  {
    final Document document = Jsoup.parseBodyFragment("<b class=\"title\">GAME SUMMARY</b><br>"
          + "<b>Thursday, January 31, 2013</b>");
    assertEquals(new LocalDate(2013, 1, 31), gameDateSupplier.parse(document));
  }
}
