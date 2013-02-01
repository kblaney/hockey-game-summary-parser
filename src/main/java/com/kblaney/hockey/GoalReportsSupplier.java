package com.kblaney.hockey;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

final class GoalReportsSupplier implements DocumentParserTo<List<GoalReport>>
{
  @Override
  public List<GoalReport> parse(final Document document)
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

  private Elements getGoalRows(final Document document)
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
