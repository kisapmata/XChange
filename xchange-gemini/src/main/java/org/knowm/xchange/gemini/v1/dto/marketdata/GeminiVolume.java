package org.knowm.xchange.gemini.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by joseph on 6/15/17.
 */
public class GeminiVolume {
    private final BigDecimal btc;
    private final BigDecimal usd;
    private final long timestamp;

    /**
     * Constructor
     *
     * @param btc The volume denominated in the quantity currency
     * @param usd The volume denominated in the price currency
     * @param timestamp (milliseconds) The end of the 24-hour period over which volume was measured.
     */
    public GeminiVolume(@JsonProperty("BTC") BigDecimal btc, @JsonProperty("USD") BigDecimal usd,
                        @JsonProperty("timestamp") long timestamp) {

        this.btc = btc;
        this.usd = usd;
        this.timestamp = timestamp;
    }

    public BigDecimal getBtc() {
        return btc;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "GeminiVolume{" +
                "btc=" + btc +
                ", usd=" + usd +
                ", timestamp=" + timestamp +
                '}';
    }
}
