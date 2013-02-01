package com.kblaney.hockey;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.google.common.collect.Lists;
import java.util.List;
import org.joda.time.LocalDate;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public final class GameSummaryUrlToGameReportFunctionImplTest
{
  private DocumentSupplier documentSupplier;
  private DocumentParserTo<LocalDate> gameDateSupplier;
  private TeamSupplier teamSupplier;
  private DocumentParserTo<List<GoalReport>> goalReportsSupplier;
  private GameSummaryUrlToGameReportFunction function;
  private String gameSummaryUrl;
  private Document document;
  private LocalDate gameDate;
  private String homeTeam;
  private String roadTeam;
  private List<GoalReport> goalReports;

  @Before
  @SuppressWarnings("unchecked")
  public void setUp()
  {
    documentSupplier = mock(DocumentSupplier.class);
    gameDateSupplier = mock(DocumentParserTo.class);
    teamSupplier = mock(TeamSupplier.class);
    goalReportsSupplier = mock(DocumentParserTo.class);
    function = new GameSummaryUrlToGameReportFunctionImpl(documentSupplier, gameDateSupplier, teamSupplier,
          goalReportsSupplier);

    gameSummaryUrl = "GAME_SUMMARY_URL";
    document = mock(Document.class);
    gameDate = new LocalDate(2013, 1, 31);
    homeTeam = "HOME_TEAM";
    roadTeam = "ROAD_TEAM";
    goalReports = Lists.newArrayList();
  }

  @Test
  public void getGameReport() throws Exception
  {
    when(documentSupplier.getDocument(gameSummaryUrl)).thenReturn(document);
    when(gameDateSupplier.parse(document)).thenReturn(gameDate);
    when(teamSupplier.getHomeTeam(document)).thenReturn(homeTeam);
    when(teamSupplier.getRoadTeam(document)).thenReturn(roadTeam);
    when(goalReportsSupplier.parse(document)).thenReturn(goalReports);

    final GameReport gameReport = function.getGameReport(gameSummaryUrl);
    assertEquals(gameDate, gameReport.getGameDate());
    assertEquals(homeTeam, gameReport.getHomeTeam());
    assertEquals(roadTeam, gameReport.getRoadTeam());
    assertEquals(goalReports, gameReport.getGoalReports());
  }
}
