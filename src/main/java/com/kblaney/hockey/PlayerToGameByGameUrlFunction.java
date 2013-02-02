package com.kblaney.hockey;

import java.io.IOException;

public interface PlayerToGameByGameUrlFunction
{
  String getGameByGameUrl(Player player) throws IOException;
}
