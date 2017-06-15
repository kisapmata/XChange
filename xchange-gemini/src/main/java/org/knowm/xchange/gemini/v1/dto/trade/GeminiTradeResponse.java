package org.knowm.xchange.gemini.v1.dto.trade;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeminiTradeResponse {

  private final BigDecimal price;
  private final BigDecimal amount;
  private final BigDecimal timestamp;
  private final long timestampms;
  private final String exchange;
  private final String type;
  private final String tradeId;
  private final String orderId;
  private final BigDecimal feeAmount;
  private final String feeCurrency;

  /**
   * Constructor
   *
   * @param price The price that the execution happened at
   * @param amount The quantity that was executed
   * @param timestamp The time that the trade happened in epoch seconds
   * @param timestampms The time that the trade happened in milliseconds
   * @param exchange Will always be "gemini"
   * @param type Will be either "Buy" or "Sell", indicating the side of the original order
   * @param tradeId Unique identifier for the trade
   * @param orderId The order that this trade executed against
   * @param feeAmount The amount charged
   * @param feeCurrency Currency that the fee was paid in
   */
  public GeminiTradeResponse(@JsonProperty("price") final BigDecimal price, @JsonProperty("amount") final BigDecimal amount,
      @JsonProperty("timestamp") final BigDecimal timestamp, @JsonProperty("timestampms") final long timestampms,
      @JsonProperty("exchange") final String exchange, @JsonProperty("type") final String type,
      @JsonProperty("tid") final String tradeId, @JsonProperty("order_id") final String orderId,
      @JsonProperty("fee_amount") final BigDecimal feeAmount, @JsonProperty("fee_currency") String feeCurrency) {

    this.price = price;
    this.amount = amount;
    this.timestamp = timestamp;
    this.timestampms = timestampms;
    this.exchange = exchange;
    this.type = type;
    this.tradeId = tradeId;
    this.orderId = orderId;
    this.feeAmount = feeAmount;
    this.feeCurrency = feeCurrency;
  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getAmount() {

    return amount;
  }

  public BigDecimal getTimestamp() {

    return timestamp;
  }

  public long getTimestampms() {

    return timestampms;
  }

  public String getType() {

    return type;
  }

  public String getOrderId() {

    return orderId;
  }

  public String getTradeId() {

    return tradeId;
  }

  public BigDecimal getFeeAmount() {

    return feeAmount;
  }

  public String getFeeCurrency() {

    return feeCurrency;
  }

  @Override
  public String toString() {

    final StringBuilder builder = new StringBuilder();
    builder.append("GeminiTradeResponse [price=");
    builder.append(price);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append(", timestampms=");
    builder.append(timestampms);
    builder.append(", exchange=");
    builder.append(exchange);
    builder.append(", type=");
    builder.append(type);
    builder.append("]");
    builder.append(", tradeId=");
    builder.append(tradeId);
    builder.append("]");
    builder.append(", orderId=");
    builder.append(orderId);
    builder.append(", fee=");
    builder.append(feeAmount);
    builder.append(" ");
    builder.append(feeCurrency);
    builder.append("]");
    return builder.toString();
  }
}
