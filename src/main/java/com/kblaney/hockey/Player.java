package com.kblaney.hockey;

public class Player
{
  private final String name;
  private final League league;
  private final String team;
  private final String position; 
  private final String phpId;

  public Player(final String name, final League league, final String team, final String position, final String phpId)
  {
    this.name = name;
    this.league = league;
    this.team = team;
    this.position = position;
    this.phpId = phpId;
  }

  public final String getName()
  {
    return name;
  }

  public final League getLeague()
  {
    return league;
  }

  public final String getTeam()
  {
    return team;
  }

  public final String getPosition()
  {
    return position;
  }

  public final String getPhpId()
  {
    return phpId;
  }
}
