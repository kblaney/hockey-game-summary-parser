package com.kblaney.hockey;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PlayerTest
{
  private String name;
  private League league;
  private String phpId;
  private Player player;

  @Before
  public void setUp()
  {
    name = "Nathan McKinnon";
    league = League.QMJHL;
    phpId = "11126";
    player = new Player(name, league, phpId);
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
  public void getPhpId()
  {
    assertEquals(phpId, player.getPhpId());
  }
}
