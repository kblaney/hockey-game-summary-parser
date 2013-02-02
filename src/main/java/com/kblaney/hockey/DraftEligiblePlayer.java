package com.kblaney.hockey;

public final class DraftEligiblePlayer extends Player
{
  private final int nhlCssRanking;

  public DraftEligiblePlayer(final String name, final League league, final String team, final String position,
        final String phpId, final int nhlCssRanking)
  {
    super(name, league, team, position, phpId);
    this.nhlCssRanking = nhlCssRanking;
  }

  public int getNhlCssRanking()
  {
    return nhlCssRanking;
  }
}
