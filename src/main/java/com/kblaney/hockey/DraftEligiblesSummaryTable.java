package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.ObjectUtils;

public final class DraftEligiblesSummaryTable
{
  private final List<DraftEligiblePlayer> players;

  public DraftEligiblesSummaryTable(final List<DraftEligiblePlayer> players)
  {
    this.players = Lists.newArrayList(players);
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
    for (final DraftEligiblePlayer player : players)
    {
      html.append(getTableRowFor(player));
      html.append("\n");
    }
    html.append("</table>\n");
    html.append("</html>");
    return html.toString();
  }

  private String getTableRowFor(final DraftEligiblePlayer player)
  {
    final StringBuilder row = new StringBuilder();
    row.append("<tr>");
    row.append(getTableCellFor(player.getNhlCssRanking()));
    row.append(getTableCellForPlayerName(player.getName()));
    row.append(getTableCellFor(player.getPosition()));
    row.append(getTableCellFor(player.getTeam()));
    row.append(getTableCellFor(player.getLeague()));
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
