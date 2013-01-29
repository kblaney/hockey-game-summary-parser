package com.kblaney.hockey;

enum League
{
  ECHL("http://www.echl.com"), WHL("http://www.whl.ca"), OHL("http://www.ontariohockeyleague.com"), QMJHL(
        "http://www.theqmjhl.ca");

  private final String urlProtocolAndHost;

  private League(final String urlProtocolAndHost)
  {
    this.urlProtocolAndHost = urlProtocolAndHost;
  }

  public String getUrlProtocolAndHost()
  {
    return urlProtocolAndHost;
  }
}
