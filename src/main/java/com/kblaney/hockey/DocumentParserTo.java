package com.kblaney.hockey;

import org.jsoup.nodes.Document;

interface DocumentParserTo<T>
{
  T parse(Document document);
}
