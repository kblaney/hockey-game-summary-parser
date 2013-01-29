package com.kblaney.hockey;

import java.io.IOException;

public interface PlayerPhpIdToGameByGameUrlFunction
{
  String getGameByGameUrl(League league, String phpId) throws IOException;
}
