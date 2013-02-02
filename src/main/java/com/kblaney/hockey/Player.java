package com.kblaney.hockey;

public final class Player
{
  private final String name;
  private final League league;
  private final String phpId;

  public Player(final String name, final League league, final String phpId)
  {
    this.name = name;
    this.league = league;
    this.phpId = phpId;
  }

  public String getName()
  {
    return name;
  }

  public League getLeague()
  {
    return league;
  }

  public String getPhpId()
  {
    return phpId;
  }
}
