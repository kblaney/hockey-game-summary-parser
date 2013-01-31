package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

final class GameSummaryUrlToGameReportFunctionImpl implements GameSummaryUrlToGameReportFunction
{
  @Override
  public GameReport getGameReport(final String gameSummaryUrl) throws IOException, ParseException
  {
    final Document document = getDocument(gameSummaryUrl);
    final Date gameDate = getGameDate(document);
    final String roadTeam = getRoadTeam(document);
    final String homeTeam = getHomeTeam(document);
    final List<GoalReport> goalReports = getGoalReports(document);
    return new GameReport(gameDate, roadTeam, homeTeam, goalReports);
  }

  private Document getDocument(final String gameSummaryUrl) throws IOException
  {
    return Jsoup.connect(gameSummaryUrl).timeout(0).get();
  }

  private Date getGameDate(final Document document) throws ParseException
  {
    final Elements gameDateElements = document.select("b.title:matchesOwn(GAME SUMMARY) ~ b");
    if (gameDateElements.size() != 1)
    {
      throw new IllegalArgumentException("Invalid number of game date elements :" + gameDateElements.size());
    }
    final String date = gameDateElements.first().text();
    final SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
    return dateFormat.parse(date);
  }

  private String getRoadTeam(final Document document)
  {
    return getTeam(document.select("b.content-w:matchesOwn(VISITORS)"));
  }

  private String getTeam(final Elements teamElements)
  {
    if (teamElements.size() != 1)
    {
      throw new IllegalArgumentException("Invalid number of team elements :" + teamElements.size());
    }
    final String elementText = teamElements.first().text();
    return elementText.substring(elementText.lastIndexOf(": ") + 2);
  }

  private String getHomeTeam(final Document document)
  {
    return getTeam(document.select("b.content-w:matchesOwn(HOME)"));
  }

  private List<GoalReport> getGoalReports(final Document document) throws IOException
  {
    final Elements goalRows = getGoalRows(document);
    final GameScore gameScore = new GameScore();
    final List<GoalReport> goalReports = Lists.newArrayList();
    for (final Element goalRow : goalRows)
    {
      goalReports.add(getGoalReport(goalRow, gameScore));
    }
    return goalReports;
  }

  private Elements getGoalRows(final Document document) throws IOException
  {
    return document.select("tr:matches(Scoring) ~ tr.light");
  }

  private GoalReport getGoalReport(final Element goalRow, final GameScore gameScore)
  {
    final Period period = getPeriod(goalRow);
    final String goalScorerPhpId = getGoalScorerPhpId(goalRow);
    final String goalDescription = getGoalDescription(goalRow);
    final String goalScoringTeam = getGoalScoringTeam(goalDescription);
    gameScore.addGoal(goalScoringTeam);
    return new GoalReport(period, gameScore, goalScorerPhpId, goalDescription);
  }

  private Period getPeriod(final Element goalRow)
  {
    final Elements periodElements = goalRow.select("td > i");
    if (periodElements.size() != 1)
    {
      throw new IllegalArgumentException("Invalid number of period elements: " + periodElements.size());
    }
    return Period.fromString(periodElements.first().text());
  }

  private String getGoalScorerPhpId(final Element goalRow)
  {
    final String goalScorerHref = goalRow.select("td > a[href*=player.php]").first().attr("href");
    return goalScorerHref.substring(goalScorerHref.indexOf("id=") + 3);
  }

  private String getGoalDescription(final Element goalRow)
  {
    return goalRow.text();
  }

  private String getGoalScoringTeam(final String goalDescription)
  {
    final Pattern pattern = Pattern.compile("\\. (\\w+)");
    final Matcher matcher = pattern.matcher(goalDescription);
    if (matcher.find())
    {
      return matcher.group(1);
    }
    else
    {
      throw new IllegalStateException("Can't find goal-scoring team: " + goalDescription);
    }
  }
}
