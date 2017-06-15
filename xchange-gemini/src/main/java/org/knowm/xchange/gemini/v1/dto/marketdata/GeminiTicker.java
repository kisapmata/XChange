package org.knowm.xchange.gemini.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class GeminiTicker {

  private final BigDecimal bid;
  private final BigDecimal ask;
  private final BigDecimal last;
  private final GeminiVolume volume;

  /**
   * Constructor
   *
   * @param bid The highest bid currently available
   * @param ask The lowest ask currently available
   * @param last The price of the last executed trade
   * @param volume Information about the 24 hour volume on the exchange
   */
  public GeminiTicker(@JsonProperty("bid") BigDecimal bid, @JsonProperty("ask") BigDecimal ask,
                      @JsonProperty("last") BigDecimal last, @JsonProperty("volume") GeminiVolume volume) {

    this.bid = bid;
    this.ask = ask;
    this.last = last;
    this.volume = volume;
  }

  public BigDecimal getBid() {

    return bid;
  }

  public BigDecimal getAsk() {

    return ask;
  }

  public BigDecimal getLast_price() {

    return last;
  }

  public GeminiVolume getVolume() {

    return volume;
  }

  @Override
  public String toString() {
    return "GeminiTicker{" +
            "bid=" + bid +
            ", ask=" + ask +
            ", last=" + last +
            ", volume=" + volume +
            '}';
  }

}
