package com.kblaney.hockey;

import java.io.File;
import org.apache.commons.io.Charsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public final class Documents
{
  public static Document getEmptyDocument()
  {
    return Jsoup.parseBodyFragment("");
  }

  public static Document getDocumentForOhlGameNum63197() throws Exception
  {
    final File file = new File(Documents.class.getResource("/ohl-2012-2013-game-63197.htm").toURI());
    return Jsoup.parse(file, Charsets.UTF_8.name());
  }
}
