package com.kblaney.hockey;

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
    final List<DraftEligiblePlayer> draftEligiblePlayers = Lists.newArrayList(new DraftEligiblePlayer("Seth Jones",
          League.WHL, "Portland", "D", "26336", 1), new DraftEligiblePlayer("Nathan McKinnon", League.QMJHL, "Halifax",
          "C", "11126", 2), new DraftEligiblePlayer("Jonathan Drouin", League.QMJHL, "Halifax", "LW", "11188", 3),
          new DraftEligiblePlayer("Sean Monahan", League.OHL, "Ottawa", "C", "5566", 4), new DraftEligiblePlayer(
                "Hunter Shinkaruk", League.WHL, "Medicine Hat", "C/LW", "25851", 5), new DraftEligiblePlayer(
                "Ryan Pulock", League.WHL, "Brandon", "D", "25712", 6), new DraftEligiblePlayer("Frederik Gauthier",
                League.QMJHL, "Rimouski", "C", "11255", 7), new DraftEligiblePlayer("Valentin Zykov", League.QMJHL,
                "Baie-Comeau", "LW", "11891", 8), new DraftEligiblePlayer("Darnell Nurse", League.OHL,
                "Sault Ste. Marie", "D", "5920", 9), new DraftEligiblePlayer("Anthony Mantha", League.QMJHL,
                "Val D'Or", "RW", "1150", 10), new DraftEligiblePlayer("Joshua Morrissey", League.WHL, "Prince Albert",
                "D", "25942", 11), new DraftEligiblePlayer("Mirco Mueller", League.WHL, "Everett", "D", "26319", 12),
          new DraftEligiblePlayer("Adam Erne", League.QMJHL, "Quebec", "LW", "11190", 13), new DraftEligiblePlayer(
                "William Carrier", League.QMJHL, "Cape Breton", "LW", "248", 14), new DraftEligiblePlayer("Bo Horvat",
                League.OHL, "London", "C", "5856", 15), new DraftEligiblePlayer("Jason Dickinson", League.OHL,
                "Guelph", "C", "5898", 16), new DraftEligiblePlayer("Shea Theodore", League.WHL, "Seattle", "C",
                "25944", 17), new DraftEligiblePlayer("Kerby Rychel", League.OHL, "Windsor", "LW", "5583", 18),
          new DraftEligiblePlayer("Chris Bigras", League.OHL, "Owen Sound", "D", "5839", 19), new DraftEligiblePlayer(
                "Madison Bowey", League.WHL, "Kelowna", "D", "25903", 22), new DraftEligiblePlayer("Max Domi",
                League.OHL, "London", "C/LW", "5967", 23), new DraftEligiblePlayer("Morgan Klimchuk", League.WHL,
                "Regina", "LW", "25901", 24), new DraftEligiblePlayer("Ryan Hartman", League.OHL, "Plymouth", "RW",
                "6212", 25), new DraftEligiblePlayer("Curtis Lazar", League.WHL, "Edmonton", "C/RW", "25727", 26),
          new DraftEligiblePlayer("Nick Sorensen", League.QMJHL, "Quebec", "RW", "11358", 27), new DraftEligiblePlayer(
                "Jimmy Lodge", League.OHL, "Saginaw", "C", "5853", 28), new DraftEligiblePlayer("Oliver Bjorkstrand",
                League.WHL, "Portland", "RW", "26331", 29), new DraftEligiblePlayer("Nikita Zadorov", League.OHL,
                "London", "D", "6311", 30));
    // 31 MCCARRON, MICHAEL RW USA U-18 USHL
    // 32 HURLEY, CONNOR C EDINA HIGH HIGH-MN
    // 33 NASTASIUK, ZACH RW OWEN SOUND OHL
    // 34 PETAN, NICOLAS C PORTLAND WHL
    // 35 DUCLAIR, ANTHONY LW QUEBEC QMJHL
    // 36 PESCE, BRETT D NEW HAMPSHIRE H-EAST
    // 37 BAILEY, JUSTIN RW KITCHENER OHL
    // 38 HARPER, STEPHEN LW ERIE OHL
    // 39 ROY, ERIC D BRANDON WHL
    // 40 KOSTALEK, JAN D RIMOUSKI QMJHL
    // 41 DAUPHIN, LAURENT C CHICOUTIMI QMJHL
    // 42 FASCHING, HUDSON RW USA U-18 USHL
    // 43 POIRIER, EMILE LW GATINEAU QMJHL
    // 44 HEATHERINGTON, DILLON D SWIFT CURRENT WHL
    // 45 DIABY, JONATHAN-ISMAEL D VICTORIAVILLE QMJHL
    // 46 FITZGERALD, RYAN C VALLEY EJHL
    // 47 SANTINI, STEVEN D USA U-18 USHL
    // 48 MOUTREY, NICK C/LW SAGINAW OHL
    // 49 DOWNING, MICHAEL D DUBUQUE USHL
    // 50 DOETZEL, KAYLE D RED DEER WHL
    // 51 THOMPSON, KEATON D USA U-18 USHL
    // 52 ETCHEGARY, KURT C QUEBEC QMJHL
    // 53 DUNN, VINCENT C VAL-D'OR QMJHL
    // 54 PAQUIN-BOUDREAU, GABRYEL LW BAIE-COMEAU QMJHL
    // 55 GEERTSEN, MASON D VANCOUVER WHL
    // 56 ELIE, REMI LW LONDON OHL
    // 57 OLOFSSON, GUSTAV D GREEN BAY USHL
    // 58 ROY, MARC-OLIVIER C BLAINVILLE-BOISBRIAND QMJHL
    // 59 HAYDEN, JOHN C USA U-18 USHL
    // 60 CASSELS, COLE C OSHAWA OHL
    // 61 LIPSBERGS, ROBERTS LW SEATTLE WHL
    // 62 TAMBELLINI, ADAM C SURREY BCHL
    // 63 WHEATON, MITCHELL D KELOWNA WHL
    // 64 RIPLEY, LUKE D POWELL RIVER BCHL
    // 65 JENSEN, SPENSER D MEDICINE HAT WHL
    // 66 CORBETT, JEFF D SUDBURY OHL
    // 67 LEWINGTON, TYLER D MEDICINE HAT WHL
    // 68 STANTON, TY D MEDICINE HAT WHL
    // 69 KUJAWINSKI, RYAN C KINGSTON OHL
    // 70 HAUF, JARED D SEATTLE WHL
    // 71 AUGER, JUSTIN RW GUELPH OHL
    // 72 HEINRICH, BLAKE D SIOUX CITY USHL
    // 73 CLIFTON, CONNOR D USA U-18 USHL
    // 74 GOBEIL, THOMAS RW CHICOUTIMI QMJHL
    // 75 KIVIHALME, TEEMU D BURNSVILLE HIGH-MN
    // 76 MORIN, SAMUEL D RIMOUSKI QMJHL
    // 77 VANNELLI, THOMAS D MINNETONKA HIGH-MN
    // 78 JOHNSON, LUKE C LINCOLN USHL
    // 79 FLORENTINO, ANTHONY D SOUTH KENT SCHOOL HIGH-CT
    // 80 HARPUR, BEN D GUELPH OHL
    // 81 SUBBAN, JORDAN D BELLEVILLE OHL
    // 82 GARLENT, HUNTER C GUELPH OHL
    // 83 SANFORD, ZACHARY LW ISLANDERS EJHL
    // 84 MCNULTY, MARC D PRINCE GEORGE WHL
    // 85 HILL, TYLER LW HOTCHKISS SCHOOL HIGH-CT
    // 86 PETERSON, AVERY C GRAND RAPIDS HIGH-MN
    // 87 BELL, MYLES LW KELOWNA WHL
    // 88 LIBERATI, MILES D LONDON OHL
    // 89 BYRON, BLAINE C SMITHS FALLS CCHL
    // 90 SALVAGGIO, JASON C/LW SOUTH KENT SCHOOL HIGH-CT
    // 91 COULOMBE, ALEX D STANSTEAD COLLEGE HIGH-QC
    // 92 BURNSIDE, JOSHUA LW MISSISSAUGA OHL
    // 93 GREGOIRE, JEREMY C BAIE-COMEAU QMJHL
    // 94 CHASE, GREGORY C/RW CALGARY WHL
    // 95 LABBE, DYLAN D SHAWINIGAN QMJHL
    // 96 LIPON, JC RW KAMLOOPS WHL
    // 97 ULLY, COLE LW KAMLOOPS WHL
    // 98 MALONE, SEAN C USA U-18 USHL
    // 99 GRAVEL, MAXIME D RIMOUSKI QMJHL
    // 100 EBBING, THOMAS C CHICAGO USHL
    // 101 BRACE, CAMERON C OWEN SOUND OHL
    // 102 PAUL, NICHOLAS LW BRAMPTON OHL
    // 103 BEATON, BRONSON RW CAPE BRETON QMJHL
    // 104 POPE, DAVID LW WEST KELOWNA BCHL
    // 105 BAPTISTE, NICHOLAS RW SUDBURY OHL
    // 106 BETZ, NICK RW ERIE OHL
    // 107 SILK, BRODY C SUDBURY OHL
    // 108 MOORE, TREVOR LW TRI-CITY USHL
    // 109 MOTTE, TYLER C USA U-18 USHL
    // 110 MURPHY, MATTHEW D HALIFAX QMJHL
    // 111 MERKLEY, JOHNATHON C SWIFT CURRENT WHL
    // 112 HOUCK, JACKSON RW VANCOUVER WHL
    // 113 HARMS, BRENDAN RW FARGO USHL
    // 114 GUENTZEL, JAKE C SIOUX CITY USHL
    // 115 GLIENKE, ZACH LW EAGAN HIGH-MN
    // 116 PLATZER, KYLE C LONDON OHL
    // 117 PINHO, BRIAN C ST. JOHN'S PREP HIGH-MA
    // 118 GRAVES, RYAN D PEI QMJHL
    // 119 RENO, PARKER D EDINA HIGH HIGH-MN
    // 120 ELLIS, EDDIE LW ANDOVER HIGH-MA
    // 121 OLSSON, ROSS RW LINCOLN USHL
    // 122 VERHAEGHE, CARTER C NIAGARA OHL
    // 123 VALK, CURTIS C MEDICINE HAT WHL
    // 124 BESSE, GRANT RW BENILDE-ST.MARGARET'S HIGH-MN
    // 125 SHERMAN, WILEY D HOTCHKISS SCHOOL HIGH-CT
    // 126 BRADFORD, ERIK C BARRIE OHL
    // 127 PEDERSEN, BRENT LW KITCHENER OHL
    // 128 HALL, ZACH C BARRIE OHL
    // 129 BELLERIVE, MATTHIEU RW RED DEER WHL
    // 130 JOLY, MICHAEL RW RIMOUSKI QMJHL
    // 131 KUPTSOV, SERGEY RW OTTAWA OHL
    // 132 RUSH, COOPER D CHILLIWACK BCHL
    // 133 HUTCHINSON, NICK C AVON OLD FARMS HIGH-CT
    // 134 BUCKLES, MATT C ST. MICHAELS OJHL
    // 135 JOHNSON, ADAM C HIBBING HS HIGH-MN
    // 136 SEGALLA, RYAN D SALISBURY HIGH-CT
    // 137 SOUCY, CARSON D SPRUCE GROVE AJHL
    // 138 RANKIN, CONNOR LW TRI-CITY WHL
    // 139 HART, JAYDEN C PRINCE ALBERT WHL
    // 140 CAVE, COLBY C SWIFT CURRENT WHL
    // 141 GUILTINAN, KEVIN D PRINCE GEORGE BCHL
    // 142 VALIEV, RINAT D INDIANA USHL
    // 143 JACKSON, JACOB C TARTAN HIGH-MN
    // 144 HONEY, CONNOR RW SEATTLE WHL
    // 145 VEILLEUX, TOMMY LW VICTORIAVILLE QMJHL
    // 146 KUBALIK, DOMINIK LW SUDBURY OHL
    // 147 RAYCROFT, MARK D BRAMPTON OHL
    // 148 BROUILLARD, NIKOLAS D DRUMMONDVILLE QMJHL
    // 149 TOLCHINSKY, SERGEY LW SAULT STE. MARIE OHL
    // 150 DE JONG, NOLAN D VICTORIA BCHL
    // 151 BROWN, JOSHUA D OSHAWA OHL
    // 152 MCGAULEY, TIM C BRANDON WHL
    // 153 SMITH, JERRET D SEATTLE WHL
    // 154 DANCS, DEXTER LW VERNON BCHL
    // 155 NIKKEL, AYRTON D EVERETT WHL
    // 156 MERMIS, DAKOTA D LONDON OHL
    // 157 WEBSTER, MICHAEL D BARRIE OHL
    // 158 SHEEN, RILEY LW SEATTLE WHL
    // 159 BETZGOLD, GREG C/LW PETERBOROUGH OHL
    // 160 POMPI, QUIN D BERKSHIRE HIGH-MA
    // 161 BIRKS, DANE D MERRITT BCHL
    // 162 STEVENS, JOHN C DUBUQUE USHL
    // 163 WOOD, MILES LW NOBLES HIGH-MA
    // 164 LEWIS, CLINT D USA U-18 USHL
    // 165 LOFTHOUSE, TRENT RW VICTORIA WHL
    // 166 JOSEPHS, TROY C ST. MICHAELS OJHL
    // 167 BRYUKVIN, VLADIMIR RW RIMOUSKI QMJHL
    // 168 FORNEY, CHRISTOPHER D THIEF RIVER FALLS HIGH-MN
    // 169 DUDA, STEVEN D SAINT JOHN QMJHL
    // 170 BUTCHER, WILL D USA U-18 USHL
    // 171 REPE, JURIJ D SAINT JOHN QMJHL
    // 172 LAFONTAINE, DANIEL C AVON OLD FARMS HIGH-CT
    // 173 RASKOB, WILLIE D SHATTUCK-ST.MARYS PREP HIGH-MN
    // 174 PIONK, NEAL D HERMANTOWN HIGH-MN
    // 175 PERREAUX, CARSON C PRINCE ALBERT WHL
    // 176 BOIVIN, ALEXANDRE C QUEBEC QMJHL
    // 177 REWAY, MARTIN LW GATINEAU QMJHL
    // 178 LIGHT, CONNOR D ANDOVER HIGH-MA
    // 179 TOMCHUK, WIL D TRI-CITY WHL
    // 180 ALLEN, EVAN C USA U-18 USHL
    // 181 DEA, JEAN-SEBASTIEN C ROUYN-NORANDA QMJHL
    // 182 WATSON, JAMAL RW LETHBRIDGE WHL
    // 183 DUPUY, JEAN LW KINGSTON OHL
    // 184 DIFRUSCIA, ANTHONY LW NIAGARA OHL
    // 185 BLOMQVIST, AXEL RW LETHBRIDGE WHL
    // 186 SHORE, QUENTIN C U OF DENVER WCHA
    // 187 POWER, ADAM D SPOKANE WHL
    // 188 NOSAD, STEPHEN RW PETERBOROUGH OHL
    // 189 COPP, ANDREW C U OF MICHIGAN CCHA
    // 190 LEMAY, MATHIEU RW ROUYN-NORANDA QMJHL
    // 191 HAMILTON, MARK D SALISBURY HIGH-CT
    // 192 QUENNEVILLE, PETER C DUBUQUE USHL
    // 193 SCHILLER, LANDON RW SAULT STE. MARIE OHL
    // 194 KANZIG, KEEGAN D VICTORIA WHL
    // 195 ADAM, AUSTIN D EVERETT WHL
    // 196 RAUHAUSER, ALEC D BISMARCK HIGH-ND
    // 197 WOOD, TYLER D NOBLES HIGH-MA
    // 198 SHERWOOD, KIEFER C/RW OHIO BLUE JACKETS USMAAAE
    // 199 BERISHA, AARON RW BELLEVILLE OHL
    // 200 VESEL, TYLER C SHATTUCK-ST.MARYS PREP HIGH-MN
    // 201 BOEHM, BRETT LW FLIN FLON SJHL
    // 202 FORTIER, SIMON RW RIMOUSKI QMJHL
    // 203 WILLIAMS, COLBY D REGINA WHL
    // 204 TREMBLAY, SIMON LW CHICOUTIMI QMJHL
    // 205 BARDREAU, COLE C CORNELL ECAC
    // 206 BURROUGHS, KYLE D REGINA WHL
    // 207 ANDREW, TYLER RW TOPEKA NAHL
    // 208 WEEGAR, MACKENZIE D HALIFAX QMJHL
    // 209 BEAUDIN, NICOLAS LW STANSTEAD COLLEGE HIGH-QC
    // 210 MONTGOMERY, JACOB LW SIOUX CITY USHL
    // LV LAPLANTE, YAN PAVEL C PEI QMJHL
    // LV BERTUZZI, TYLER LW GUELPH OHL
    // LV HENRY, ADAM D LETHBRIDGE WHL
    // LV OTTERMAN, CHAD LW NEW JERSEY HITMEN EJHL );

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
    final PrintStream printStream = getPrintStreamForFile(new File(OUTPUT_FOLDER, "chl-skaters-goal-reports.html"));
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
