package com.kblaney.hockey;

import java.io.IOException;
import org.jsoup.nodes.Document;

interface DocumentSupplier
{
  Document getDocument(String url) throws IOException;
}
