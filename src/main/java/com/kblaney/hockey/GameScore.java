package com.kblaney.hockey;

import com.google.common.base.Optional;

public final class GameScore
{
  private Optional<String> teamOne;
  private Optional<String> teamTwo;
  private int numTeamOneGoals;
  private int numTeamTwoGoals;

  /**
   * Constructs an instance in which neither team is defined and the score is 0-0.
   */
  public GameScore()
  {
    teamOne = Optional.absent();
    teamTwo = Optional.absent();
    numTeamOneGoals = 0;
    numTeamTwoGoals = 0;
  }

  /**
   * Constructs an instance in which one team is being shutout.
   *
   * @param teamOne the team that is not being shutout
   * @param numTeamOneGoals the number of goals for {@code teamOne}
   */
  public GameScore(final String teamOne, final int numTeamOneGoals)
  {
    this.teamOne = Optional.of(teamOne);
    this.numTeamOneGoals = numTeamOneGoals;
  }

  /**
   * Constructs an instance in which both both teams have scored.
   *
   * @param teamOne the first team
   * @param numTeamOneGoals the number of goals for {@code teamOne}
   * @param teamTwo the second team
   * @param numTeamOneGoals the number of goals for {@code teamTwo}
   */
  public GameScore(final String teamOne, final int numTeamOneGoals, final String teamTwo, final int numTeamTwoGoals)
  {
    this.teamOne = Optional.of(teamOne);
    this.numTeamOneGoals = numTeamOneGoals;
    this.teamTwo = Optional.of(teamTwo);
    this.numTeamTwoGoals = numTeamTwoGoals;
  }

  /**
   * Copy constructor.
   *
   * @param gameScore the original game score from which to create this instance
   */
  public GameScore(final GameScore gameScore)
  {
    teamOne = gameScore.teamOne;
    teamTwo = gameScore.teamTwo;
    numTeamOneGoals = gameScore.numTeamOneGoals;
    numTeamTwoGoals = gameScore.numTeamTwoGoals;
  }

  public void addGoal(final String team)
  {
    if (isTeamOne(team))
    {
      numTeamOneGoals++;
    }
    else if (isTeamTwo(team))
    {
      numTeamTwoGoals++;
    }
    else if (areBothTeamsDefined())
    {
      throw new IllegalArgumentException("Can't add goal to third team: " + team);
    }
    else if (teamOne.isPresent())
    {
      teamTwo = Optional.of(team);
      numTeamTwoGoals = 1;
    }
    else
    {
      teamOne = Optional.of(team);
      numTeamOneGoals = 1;
    }
  }

  private boolean isTeamOne(final String team)
  {
    return areEqual(teamOne, team);
  }

  private boolean areEqual(final Optional<String> optionalTeam, final String team)
  {
    return (optionalTeam.isPresent() && optionalTeam.get().equals(team));
  }

  private boolean isTeamTwo(final String team)
  {
    return areEqual(teamTwo, team);
  }

  private boolean areBothTeamsDefined()
  {
    return (teamOne.isPresent() && teamTwo.isPresent());
  }

  @Override
  public String toString()
  {
    final String leadingTeamScore;
    final String trailingTeamScore;
    if (areBothTeamsDefined())
    {
      if (numTeamOneGoals >= numTeamTwoGoals)
      {
        leadingTeamScore = getScore(teamOne, numTeamOneGoals);
        trailingTeamScore = getScore(teamTwo, numTeamTwoGoals);
      }
      else
      {
        leadingTeamScore = getScore(teamTwo, numTeamTwoGoals);
        trailingTeamScore = getScore(teamOne, numTeamOneGoals);
      }
    }
    else if (teamOne.isPresent())
    {
      leadingTeamScore = getScore(teamOne, numTeamOneGoals);
      trailingTeamScore = "0";
    }
    else
    {
      leadingTeamScore = "0";
      trailingTeamScore = "0";
    }
    return leadingTeamScore + " - " + trailingTeamScore;
  }

  private String getScore(final Optional<String> team, final int numGoals)
  {
    return team.get() + " " + numGoals;
  }
}
