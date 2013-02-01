package com.kblaney.hockey;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.joda.time.LocalDate;
import org.jsoup.nodes.Document;

final class GameSummaryUrlToGameReportFunctionImpl implements GameSummaryUrlToGameReportFunction
{
  private final DocumentSupplier documentSupplier = new DocumentSupplierImpl();
  private final DocumentParserTo<LocalDate> gameDateSupplier = new GameDateSupplier();
  private final TeamSupplier teamSupplier = new TeamSupplierImpl();
  private final DocumentParserTo<List<GoalReport>> goalReportsSupplier = new GoalReportsSupplier();

  @Override
  public GameReport getGameReport(final String gameSummaryUrl) throws IOException, ParseException
  {
    final Document document = getDocument(gameSummaryUrl);
    final LocalDate gameDate = getGameDate(document);
    final String roadTeam = getRoadTeam(document);
    final String homeTeam = getHomeTeam(document);
    final List<GoalReport> goalReports = getGoalReports(document);
    return new GameReport(gameDate, roadTeam, homeTeam, goalReports);
  }

  private Document getDocument(final String gameSummaryUrl) throws IOException
  {
    return documentSupplier.getDocument(gameSummaryUrl);
  }

  private LocalDate getGameDate(final Document document)
  {
    return gameDateSupplier.parse(document);
  }

  private String getRoadTeam(final Document document)
  {
    return teamSupplier.getRoadTeam(document);
  }

  private String getHomeTeam(final Document document)
  {
    return teamSupplier.getHomeTeam(document);
  }

  private List<GoalReport> getGoalReports(final Document document)
  {
    return goalReportsSupplier.parse(document);
  }
}
