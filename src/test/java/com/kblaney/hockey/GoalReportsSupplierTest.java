package com.kblaney.hockey;

import static org.junit.Assert.*;
import java.util.List;
import org.jsoup.nodes.Document;
import org.junit.Test;

public final class GoalReportsSupplierTest
{
  @Test
  public void parse_zeroGoals()
  {
    final Document document = Documents.getEmptyDocument();
    assertTrue(new GoalReportsSupplier().parse(document).isEmpty());
  }

  @Test
  public void parse_ohlGame63197() throws Exception
  {
    final Document document = Documents.getDocumentForOhlGameNum63197();
    final List<GoalReport> goalReports = new GoalReportsSupplier().parse(document);
    assertEquals(11, goalReports.size());
    assertEquals("6360", goalReports.get(0).getScorerPhpId());
    assertEquals("5398", goalReports.get(1).getScorerPhpId());
    assertEquals("5688", goalReports.get(2).getScorerPhpId());
    assertEquals("5681", goalReports.get(3).getScorerPhpId());
    assertEquals("5175", goalReports.get(4).getScorerPhpId());
    assertEquals("6217", goalReports.get(5).getScorerPhpId());
    assertEquals("5350", goalReports.get(6).getScorerPhpId());
    assertEquals("5347", goalReports.get(7).getScorerPhpId());
    assertEquals("5737", goalReports.get(8).getScorerPhpId());
    assertEquals("6175", goalReports.get(9).getScorerPhpId());
    assertEquals("5398", goalReports.get(10).getScorerPhpId());
  }
}
