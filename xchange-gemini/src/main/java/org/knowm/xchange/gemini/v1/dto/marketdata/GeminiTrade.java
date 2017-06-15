package org.knowm.xchange.gemini.v1.dto.marketdata;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeminiTrade {

  private final BigDecimal price;
  private final BigDecimal amount;
  private final long timestamp;
  private final long timestampms;
  private final String exchange;
  private final long tradeId;
  private final String type;

  /**
   * Constructor
   *
   * @param price The price the trade was executed at
   * @param amount The amount that was traded
   * @param timestamp The time that the trade was executed
   * @param timestampms The time that the trade was executed in milliseconds
   * @param exchange Will always be "gemini"
   * @param tradeId The trade ID number
   * @param type buy/sell/auction
   */
  public GeminiTrade(@JsonProperty("price") BigDecimal price, @JsonProperty("amount") BigDecimal amount,
                     @JsonProperty("timestamp") long timestamp, @JsonProperty("timestampms") long timestampms,
                     @JsonProperty("exchange") String exchange, @JsonProperty("tid") long tradeId, @JsonProperty("type") String type) {

    this.price = price;
    this.amount = amount;
    this.timestamp = timestamp;
    this.timestampms = timestampms;
    this.exchange = exchange;
    this.tradeId = tradeId;
    this.type = type;
  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getAmount() {

    return amount;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public long getTimestampms() {

    return timestampms;
  }

  public String getExchange() {

    return exchange;
  }

  public long getTradeId() {

    return tradeId;
  }

  public String getType() {

    return type;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("BitfinexTrade [price=");
    builder.append(price);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append(", timestampms=");
    builder.append(timestampms);
    builder.append(", exchange=");
    builder.append(exchange);
    builder.append(", tradeId=");
    builder.append(tradeId);
    builder.append(", type=");
    builder.append(type);
    builder.append("]");
    return builder.toString();
  }
}
