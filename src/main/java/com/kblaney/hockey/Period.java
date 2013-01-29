package com.kblaney.hockey;

public enum Period
{
  FIRST_PERIOD, SECOND_PERIOD, THIRD_PERIOD, OVERTIME;

  public static Period fromString(final String s)
  {
    if ("1".equals(s))
    {
      return FIRST_PERIOD;
    }
    if ("2".equals(s))
    {
      return SECOND_PERIOD;
    }
    if ("3".equals(s))
    {
      return THIRD_PERIOD;
    }
    if (s.startsWith("OT"))
    {
      return OVERTIME;
    }
    throw new IllegalArgumentException("Invalid period string:" + s);
  }
}
