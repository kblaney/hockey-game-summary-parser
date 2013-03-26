package com.kblaney.hockey;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import java.util.Map;
import java.util.Locale;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public final class EntryPoint
{
  private static final File OUTPUT_FOLDER = new File("C:/data/vancouverCanucks/draftEligibles");

  public static void main(final String[] args) throws Exception
  {
    // @formatter:off
    final List<DraftEligiblePlayer> draftEligiblePlayers = Lists.newArrayList(
//          new DraftEligiblePlayer("Seth Jones", League.WHL, "Portland", "D", "26336", 1),
//          new DraftEligiblePlayer("Nathan McKinnon", League.QMJHL, "Halifax", "C", "11126", 2),
//          new DraftEligiblePlayer("Jonathan Drouin", League.QMJHL, "Halifax", "LW", "11188", 3),
//          new DraftEligiblePlayer("Sean Monahan", League.OHL, "Ottawa", "C", "5566", 4),
//          new DraftEligiblePlayer("Hunter Shinkaruk", League.WHL, "Medicine Hat", "C/LW", "25851", 5),
//          new DraftEligiblePlayer("Ryan Pulock", League.WHL, "Brandon", "D", "25712", 6),
//          new DraftEligiblePlayer("Frederik Gauthier", League.QMJHL, "Rimouski", "C", "11255", 7),
//          new DraftEligiblePlayer("Valentin Zykov", League.QMJHL, "Baie-Comeau", "LW", "11891", 8),
//          new DraftEligiblePlayer("Darnell Nurse", League.OHL, "Sault Ste. Marie", "D", "5920", 9),
//          new DraftEligiblePlayer("Anthony Mantha", League.QMJHL, "Val D'Or", "RW", "1150", 10),
//          new DraftEligiblePlayer("Joshua Morrissey", League.WHL, "Prince Albert", "D", "25942", 11),
//          new DraftEligiblePlayer("Mirco Mueller", League.WHL, "Everett", "D", "26319", 12),
//          new DraftEligiblePlayer("Adam Erne", League.QMJHL, "Quebec", "LW", "11190", 13),
//          new DraftEligiblePlayer("William Carrier", League.QMJHL, "Cape Breton", "LW", "248", 14),
//          new DraftEligiblePlayer("Bo Horvat", League.OHL, "London", "C", "5856", 15),
//          new DraftEligiblePlayer("Jason Dickinson", League.OHL, "Guelph", "C", "5898", 16),
//          new DraftEligiblePlayer("Shea Theodore", League.WHL, "Seattle", "C", "25944", 17),
//          new DraftEligiblePlayer("Kerby Rychel", League.OHL, "Windsor", "LW", "5583", 18),
//          new DraftEligiblePlayer("Chris Bigras", League.OHL, "Owen Sound", "D", "5839", 19),
//          new DraftEligiblePlayer("Madison Bowey", League.WHL, "Kelowna", "D", "25903", 22),
//          new DraftEligiblePlayer("Max Domi", League.OHL, "London", "C/LW", "5967", 23),
//          new DraftEligiblePlayer("Morgan Klimchuk", League.WHL, "Regina", "LW", "25901", 24),
//          new DraftEligiblePlayer("Ryan Hartman", League.OHL, "Plymouth", "RW", "6212", 25),
//          new DraftEligiblePlayer("Curtis Lazar", League.WHL, "Edmonton", "C/RW", "25727", 26),
//          new DraftEligiblePlayer("Nick Sorensen", League.QMJHL, "Quebec", "RW", "11358", 27),
//          new DraftEligiblePlayer("Jimmy Lodge", League.OHL, "Saginaw", "C", "5853", 28),
//          new DraftEligiblePlayer("Oliver Bjorkstrand", League.WHL, "Portland", "RW", "26331", 29),
//          new DraftEligiblePlayer("Nikita Zadorov", League.OHL, "London", "D", "6311", 30),
//          new DraftEligiblePlayer("Zach Nastasiuk", League.OHL, "Owen Sound", "RW", "5837", 33),
//          new DraftEligiblePlayer("Nicolas Petan", League.WHL, "Portland", "C", "25907", 34),
//          new DraftEligiblePlayer("Anthony Duclair", League.QMJHL, "Quebec", "LW", "11236", 35),
//          new DraftEligiblePlayer("Justin Bailey", League.OHL, "Kitchener", "RW", "6153", 37),
//          new DraftEligiblePlayer("Stephen Harper", League.OHL, "Erie", "LW", "5830", 38),
//          new DraftEligiblePlayer("Eric Roy", League.WHL, "Brandon", "D", "25713", 39),
//          new DraftEligiblePlayer("Jan Kostalek", League.QMJHL, "Rimouski", "D", "11873", 40),
//          new DraftEligiblePlayer("Laurent Dauphin", League.QMJHL, "Chicoutimi", "C", "11152", 41),
//          new DraftEligiblePlayer("Emile Poirier", League.QMJHL, "Gatineau", "LW", "11176", 43),
//          new DraftEligiblePlayer("Dillon Heatherington", League.WHL, "Swift Current", "D", "25934", 44),
//          new DraftEligiblePlayer("Jonathan-Ismael Diaby", League.QMJHL, "Victoriaville", "D", "1144", 45),
//          new DraftEligiblePlayer("Nick Moutrey", League.OHL, "Saginaw", "C/LW", "5849", 48),
//          new DraftEligiblePlayer("Kayle Doetzel", League.WHL, "Red Deer", "D", "25985", 50),
//          new DraftEligiblePlayer("Kurt Etchegary", League.QMJHL, "Quebec", "C", "11235", 52),
//          new DraftEligiblePlayer("Vincent Dunn", League.QMJHL, "Val D'Or", "C", "11295", 53),
//          new DraftEligiblePlayer("Gabryel Paquin-Boudreau", League.QMJHL, "Baie-Comeau", "LW", "11604", 54),
//          new DraftEligiblePlayer("Mason Geertsen", League.WHL, "Vancouver", "D", "25730", 55),
//          new DraftEligiblePlayer("Remi Elie", League.OHL, "London", "LW", "6318", 56),
//          new DraftEligiblePlayer("Marc-Olivier Roy", League.QMJHL, "Blainville-Boisbriand", "C", "1212", 58),
//          new DraftEligiblePlayer("Cole Cassels", League.OHL, "Oshawa", "C", "5882", 60),
//          new DraftEligiblePlayer("Roberts Lipsbergs", League.WHL, "Seattle", "LW", "26368", 61),
//          new DraftEligiblePlayer("Mitchell Wheaton", League.WHL, "Kelowna", "LW", "26538", 63),
//          new DraftEligiblePlayer("Spenser Jensen", League.WHL, "Medicine Hat", "D", "25983", 65),
//          new DraftEligiblePlayer("Jeff Corbett", League.OHL, "Sudbury", "D", "5805", 66),
//          new DraftEligiblePlayer("Tyler Lewington", League.WHL, "Medicine Hat", "D", "26132", 67),
//          new DraftEligiblePlayer("Ty Stanton", League.WHL, "Medicine Hat", "D", "26138", 68),
//          new DraftEligiblePlayer("Ryan Kujawinski", League.OHL, "Kingston", "C", "5892", 69),
//          new DraftEligiblePlayer("Jared Hauf", League.WHL, "Seattle", "D", "25945", 70),
//          new DraftEligiblePlayer("Justin Auger", League.OHL, "Guelph", "RW", "5895", 71),
//          new DraftEligiblePlayer("Thomas Gobeil", League.QMJHL, "Chicoutimi", "RW", "1278", 74),
//          new DraftEligiblePlayer("Samuel Morin", League.QMJHL, "Rimouski", "D", "11252", 76),
//          new DraftEligiblePlayer("Ben Harpur", League.OHL, "Guelph", "D", "5899", 80),
//          new DraftEligiblePlayer("Jordan Subban", League.OHL, "Belleville", "D", "5852", 81),
//          new DraftEligiblePlayer("Hunter Garlent", League.OHL, "Guelph", "D", "5897", 82),
//          new DraftEligiblePlayer("Marc Mcnulty", League.WHL, "Prince George", "D", "26182", 84),
//          new DraftEligiblePlayer("Myles Bell", League.WHL, "Kelowna", "LW", "25376", 87),
//          new DraftEligiblePlayer("Miles Liberati", League.OHL, "London", "D", "6316", 88),
//          new DraftEligiblePlayer("Joshua Burnside", League.OHL, "Mississauga", "LW", "6046", 92),
//          new DraftEligiblePlayer("Jeremy Gregoire", League.QMJHL, "Baie-Comeau", "C", "11150", 93),
//          new DraftEligiblePlayer("Gregory Chase", League.WHL, "Calgary", "C/RW", "25794", 94),
//          new DraftEligiblePlayer("Dylan Labbe", League.QMJHL, "Shawinigan", "D", "11285", 95),
//          new DraftEligiblePlayer("JC Lipon", League.WHL, "Kamloops", "RW", "25479", 96),
//          new DraftEligiblePlayer("Cole Ully", League.WHL, "Kamloops", "RW", "25955", 97),
//          new DraftEligiblePlayer("Maxime Gravel", League.QMJHL, "Rimouski", "D", "11272", 99),
//          new DraftEligiblePlayer("Cameron Brace", League.OHL, "Owen Sound", "C", "5546", 101),
//          new DraftEligiblePlayer("Nicholas Paul", League.OHL, "Brampton", "LW", "6260", 102),
//          new DraftEligiblePlayer("Bronson Beaton", League.QMJHL, "Cape Breton", "RW", "11281", 103),
//          new DraftEligiblePlayer("Nicholas Baptiste", League.OHL, "Sudbury", "RW", "5901", 105),
//          new DraftEligiblePlayer("Nick Betz", League.OHL, "Erie", "RW", "5946", 106),
//          new DraftEligiblePlayer("Brody Silk", League.OHL, "Sudbury", "C", "5708", 107),
//          new DraftEligiblePlayer("Matthew Murphy", League.QMJHL, "Halifax", "D", "11294", 110),
//          new DraftEligiblePlayer("Johnathon Merkley", League.WHL, "Swift Current", "C", "26225", 111),
//          new DraftEligiblePlayer("Jackson Houck", League.WHL, "Vancouver", "RW", "26109", 112),
//          new DraftEligiblePlayer("Kyle Platzer", League.OHL, "London", "C", "6027", 116),
//          new DraftEligiblePlayer("Ryan Graves", League.QMJHL, "PEI", "D", "11223", 118),
//          new DraftEligiblePlayer("Carter Verhaeghe", League.OHL, "Niagara", "C", "5908", 122),
//          new DraftEligiblePlayer("Curtis Valk", League.WHL, "Medicine Hat", "C", "25535", 123),
//          new DraftEligiblePlayer("Erik Bradford", League.OHL, "Barrie", "C", "5802", 126),
//          new DraftEligiblePlayer("Brent Pedersen", League.OHL, "Kitchener", "LW", "5823", 127),
//          new DraftEligiblePlayer("Zach Hall", League.OHL, "Barrie", "C", "5457", 128),
//          new DraftEligiblePlayer("Matthieu Bellerive", League.WHL, "Red Deer", "RW", "25623", 129),
//          new DraftEligiblePlayer("Michael Joly", League.QMJHL, "Rimouski", "RW", "11752", 130),
//          new DraftEligiblePlayer("Sergey Kuptsov", League.OHL, "Ottawa", "RW", "5910", 131),
//          new DraftEligiblePlayer("Connor Rankin", League.WHL, "Tri-City", "LW", "25689", 138),
//          new DraftEligiblePlayer("Jayden Hart", League.WHL, "Prince Albert", "C", "25929", 139),
//          new DraftEligiblePlayer("Colby Cave", League.WHL, "Swift Current", "C", "25960", 140),
//          new DraftEligiblePlayer("Connor Honey", League.WHL, "Seattle", "RW", "26045", 144),
//          new DraftEligiblePlayer("Tommy Veilleux", League.QMJHL, "Victoriaville", "LW", "11305", 145),
//          new DraftEligiblePlayer("Dominik Kubalik", League.OHL, "Sudbury", "LW", "6083", 146),
//          new DraftEligiblePlayer("Mark Raycroft", League.OHL, "Brampton", "D", "6263", 147),
//          new DraftEligiblePlayer("Nikolas Brouillard", League.QMJHL, "Drummondville", "D", "11165", 148),
//          new DraftEligiblePlayer("Sergey Tolchinsky", League.OHL, "Sault Ste. Marie", "LW", "6360", 149),
          new DraftEligiblePlayer("Joshua Brown", League.OHL, "Oshawa", "D", "5680", 151),
          new DraftEligiblePlayer("Tim Mcgauley", League.WHL, "Brandon", "C", "25918", 152),
          new DraftEligiblePlayer("Jerret Smith", League.WHL, "Seattle", "D", "26363", 153),
          new DraftEligiblePlayer("Ayrton Nikkel", League.WHL, "Everett", "D", "25893", 155),
          new DraftEligiblePlayer("Dakota Mermis", League.OHL, "London", "D", "6455", 156),
          new DraftEligiblePlayer("Michael Webster", League.OHL, "Barrie", "D", "6384", 157),
          new DraftEligiblePlayer("Riley Sheen", League.WHL, "Seattle", "LW", "25922", 158),
          new DraftEligiblePlayer("Greg Betzold", League.OHL, "Peterborough", "C/LW", "6336", 159),
          new DraftEligiblePlayer("Trent Lofthouse", League.WHL, "Victoria", "RW", "26235", 165),
          new DraftEligiblePlayer("Vladimir Bryukvin", League.QMJHL, "Rimouski", "RW", "11886", 167),
          new DraftEligiblePlayer("Steven Duda", League.QMJHL, "Saint John", "D", "12121", 169),
          new DraftEligiblePlayer("Jurij Repe", League.QMJHL, "Saint John", "D", "11881", 171),
          new DraftEligiblePlayer("Carson Perreaux", League.WHL, "Prince Albert", "D", "26080", 175),
          new DraftEligiblePlayer("Alexandre Boivin", League.QMJHL, "Quebec", "C", "12134", 176),
          new DraftEligiblePlayer("Martin Reway", League.QMJHL, "Gatineau", "LW", "11871", 177),
          new DraftEligiblePlayer("Wil Tomchuk", League.WHL, "Tri-City", "D", "26365", 179),
          new DraftEligiblePlayer("Jean-Sebastien Dea", League.QMJHL, "Rouyn-Noranda", "C", "11267", 181),
          new DraftEligiblePlayer("Jamal Watson", League.WHL, "Lethbridge", "RW", "26228", 182),
          new DraftEligiblePlayer("Jean Dupuy", League.OHL, "Kingston", "LW", "5942", 183),
          new DraftEligiblePlayer("Anthony Difruscia", League.OHL, "Niagara", "LW", "6209", 184),
          new DraftEligiblePlayer("Axel Blomqvist", League.WHL, "Lethbridge", "RW", "26523", 185),
          new DraftEligiblePlayer("Adam Power", League.WHL, "Spokane", "D", "26415", 187),
          new DraftEligiblePlayer("Stephen Nosad", League.OHL, "Peterborough", "RW", "5834", 188),
          new DraftEligiblePlayer("Mathieu Lemay", League.QMJHL, "Rouyn-Noranda", "RW", "1182", 190),
          new DraftEligiblePlayer("Landon Schiller", League.OHL, "Sault Ste. Marie", "RW", "6357", 193),
          new DraftEligiblePlayer("Keegan Kanzig", League.WHL, "Victoria", "D", "26101", 194),
          new DraftEligiblePlayer("Austin Adam", League.WHL, "Everett", "D", "26098", 195));
//          new DraftEligiblePlayer("Aaron Berisha", League.OHL, "Belleville", "RW", "6159", 199),
//          new DraftEligiblePlayer("Simon Fortier", League.QMJHL, "Rimouski", "RW", "11749", 202),
//          new DraftEligiblePlayer("Colby Williams", League.WHL, "Regina", "D", "25940", 203),
//          new DraftEligiblePlayer("Simon Tremblay", League.QMJHL, "Chicoutimi", "LW", "11154", 204),
//          new DraftEligiblePlayer("Kyle Burroughs", League.WHL, "Regina", "D", "26040", 206),
//          new DraftEligiblePlayer("Mackenzie Weegar", League.QMJHL, "Halifax", "D", "11422", 208));
    // @formatter:on

    final Map<DraftEligiblePlayer, SummaryStatistics> goalDifferentialStatsMap = Maps.newHashMap();
    for (final DraftEligiblePlayer player : draftEligiblePlayers)
    {
      System.out.println("Getting report for " + player.getName());

      final List<GameReport> gameReports = new PlayerToGameReportsFunctionImpl().getGameReports(player);
      final PrintStream printStream = getPrintStreamFor(player);
      try
      {
        final SummaryStatistics goalDifferentialStats = new GameReportsToGoalDifferentialStatsFunctionImpl()
              .getGoalDifferentialStats(gameReports, player);
        goalDifferentialStatsMap.put(player, goalDifferentialStats);

        printStream.println(player.getName());
        printStream.println(Joiner.on(", ").join(player.getPosition(), player.getTeam(), player.getLeague()));
        printStream.print("NHL CSS Ranking: ");
        printStream.println(player.getNhlCssRanking());
        printStream.println();
        printStream.println("Number of goals: " + goalDifferentialStats.getN());
        printStream.println("Average Goal Differential: " + goalDifferentialStats.getMean());
        printStream.println();
        printStream
              .println(new GameReportsToGoalsSummaryFunctionImpl().getGoalsSummary(gameReports, player.getPhpId()));
      }
      finally
      {
        printStream.close();
      }
    }
    writeSummaryFile(goalDifferentialStatsMap);
  }

  private static void writeSummaryFile(final Map<DraftEligiblePlayer, SummaryStatistics> goalDifferentialStatsMap)
        throws FileNotFoundException
  {
    final PrintStream printStream = getPrintStreamForFile(new File(OUTPUT_FOLDER,
          "chl-draft-eligible-skaters-goal-reports.html"));
    try
    {
      printStream.println(new DraftEligiblesSummaryTable(goalDifferentialStatsMap).toHtml());
    }
    finally
    {
      printStream.close();
    }
  }

  private static PrintStream getPrintStreamForFile(final File outputFile) throws FileNotFoundException
  {
    try
    {
      return new PrintStream(outputFile, Charsets.UTF_8.name());
    }
    catch (final UnsupportedEncodingException e)
    {
      throw new IllegalStateException(e);
    }
  }

  private static PrintStream getPrintStreamFor(final Player player) throws FileNotFoundException
  {
    return getPrintStreamForFile(new File(OUTPUT_FOLDER, getOutputFile(player)));
  }

  private static String getOutputFile(final Player player)
  {
    return player.getName().toLowerCase(Locale.US).replace(' ', '-') + ".txt";
  }
}
