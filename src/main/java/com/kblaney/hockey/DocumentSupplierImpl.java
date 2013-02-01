package com.kblaney.hockey;

import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.nodes.Document;

public class DocumentSupplierImpl implements DocumentSupplier
{
  @Override
  public Document getDocument(final String url) throws IOException
  {
    return Jsoup.connect(url).timeout(0).get();
  }
}
