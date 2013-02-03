package com.kblaney.hockey;

import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public final class DraftEligiblesSummaryTable
{
  private final Map<DraftEligiblePlayer, SummaryStatistics> goalDifferentialStatsMap;

  public DraftEligiblesSummaryTable(final Map<DraftEligiblePlayer, SummaryStatistics> goalDifferentialStatsMap)
  {
    this.goalDifferentialStatsMap = Maps.newHashMap(goalDifferentialStatsMap);
  }

  public String toHtml()
  {
    final StringBuilder html = new StringBuilder();
    html.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n");
    html.append("<html lang=\"en\">\n");
    html.append("<head>\n");
    html.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n");
    html.append("<meta name=\"google\" value=\"notranslate\">");
    html.append("</meta>\n");
    html.append("</head>\n");
    html.append("<table>\n");
    for (final Map.Entry<DraftEligiblePlayer, SummaryStatistics> entry : goalDifferentialStatsMap.entrySet())
    {
      html.append(getTableRowFor(entry));
      html.append("\n");
    }
    html.append("</table>\n");
    html.append("</html>");
    return html.toString();
  }

  private String getTableRowFor(final Map.Entry<DraftEligiblePlayer, SummaryStatistics> entry)
  {
    final DraftEligiblePlayer player = entry.getKey();
    final long numGoals = entry.getValue().getN();
    final double averageGoalDifferential = entry.getValue().getMean();

    final StringBuilder row = new StringBuilder();
    row.append("<tr>");
    row.append(getTableCellFor(player.getNhlCssRanking()));
    row.append(getTableCellForPlayerName(player.getName()));
    row.append(getTableCellFor(player.getPosition()));
    row.append(getTableCellFor(player.getTeam()));
    row.append(getTableCellFor(player.getLeague()));
    row.append(getTableCellFor(numGoals));
    row.append(getTableCellFor(averageGoalDifferential));
    row.append("</tr>");
    return row.toString();
  }

  private String getTableCellFor(final Object o)
  {
    return "<td>" + ObjectUtils.toString(o) + "</td>";
  }

  private String getTableCellForPlayerName(final String playerName)
  {
    return "<td><a href=\"" + getOutputFile(playerName) + "\">" + playerName + "</a></td>";
  }

  private String getOutputFile(final String playerName)
  {
    return playerName.toLowerCase(Locale.US).replace(' ', '-') + ".txt";
  }
}
