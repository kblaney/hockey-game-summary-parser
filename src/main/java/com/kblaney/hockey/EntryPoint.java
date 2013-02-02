package com.kblaney.hockey;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    final List<Player> draftEligiblePlayers = Lists.newArrayList(new Player("Nathan McKinnon", League.QMJHL, "Halifax",
          "C", "11126"));
    for (final Player player : draftEligiblePlayers)
    {
      final List<GameReport> gameReports = new PlayerToGameReportsFunctionImpl().getGameReports(player);
      final PrintStream printStream = getPrintStreamFor(player);
      try
      {
        printStream.println(player.getName());
        printStream.println();
        printStream.println("Average Goal Differential: " +
              new GameReportsToAverageGoalDifferentialFunctionImpl().getAverageGoalDifferential(gameReports, player));
        printStream.println();
        printStream
              .println(new GameReportsToGoalsSummaryFunctionImpl().getGoalsSummary(gameReports, player.getPhpId()));
      }
      finally
      {
        printStream.close();
      }
    }
  }

  private static PrintStream getPrintStreamFor(final Player player) throws FileNotFoundException
  {
    final File outputFile = new File("C:/data/vancouverCanucks/draftEligibles", player.getName() + ".txt");
    try
    {
      return new PrintStream(outputFile, Charsets.UTF_8.name());
    }
    catch (final UnsupportedEncodingException e)
    {
      throw new IllegalStateException(e);
    }
  }
}
