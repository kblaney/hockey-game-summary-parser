package com.kblaney.hockey;

import java.io.IOException;
import java.util.List;
import org.joda.time.LocalDate;
import org.jsoup.nodes.Document;

final class GameSummaryUrlToGameReportFunctionImpl implements GameSummaryUrlToGameReportFunction
{
  private final DocumentSupplier documentSupplier;
  private final DocumentParserTo<LocalDate> gameDateSupplier;
  private final TeamSupplier teamSupplier;
  private final DocumentParserTo<List<GoalReport>> goalReportsSupplier;

  public GameSummaryUrlToGameReportFunctionImpl()
  {
    this(new DocumentSupplierImpl(), new GameDateSupplier(), new TeamSupplierImpl(), new GoalReportsSupplier());
  }

  GameSummaryUrlToGameReportFunctionImpl(final DocumentSupplier documentSupplier,
        final DocumentParserTo<LocalDate> gameDateSupplier, final TeamSupplier teamSupplier,
        final DocumentParserTo<List<GoalReport>> goalReportsSupplier)
  {
    this.documentSupplier = documentSupplier;
    this.gameDateSupplier = gameDateSupplier;
    this.teamSupplier = teamSupplier;
    this.goalReportsSupplier = goalReportsSupplier;
  }

  @Override
  public GameReport getGameReport(final String gameSummaryUrl) throws IOException
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
