package com.kblaney.hockey;

import org.jsoup.nodes.Document;

interface TeamSupplier
{
  String getRoadTeam(Document document);

  String getHomeTeam(Document document);
}
