package com.kblaney.hockey;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DraftEligiblePlayerTest
{
  private String name;
  private League league;
  private String team;
  private String position;
  private String phpId;
  private int nhlCssRanking;
  private DraftEligiblePlayer player;

  @Before
  public void setUp()
  {
    name = "Nathan McKinnon";
    league = League.QMJHL;
    team = "Halifax";
    position = "C";
    phpId = "11126";
    nhlCssRanking = 2;
    player = new DraftEligiblePlayer(name, league, team, position, phpId, nhlCssRanking);
  }

  @Test
  public void getName()
  {
    assertEquals(name, player.getName());
  }

  @Test
  public void getLeague()
  {
    assertEquals(league, player.getLeague());
  }

  @Test
  public void getTeam()
  {
    assertEquals(team, player.getTeam());
  }

  @Test
  public void getPosition()
  {
    assertEquals(position, player.getPosition());
  }

  @Test
  public void getPhpId()
  {
    assertEquals(phpId, player.getPhpId());
  }

  @Test
  public void getNhlCssRanking()
  {
    assertEquals(nhlCssRanking, player.getNhlCssRanking());
  }
}
