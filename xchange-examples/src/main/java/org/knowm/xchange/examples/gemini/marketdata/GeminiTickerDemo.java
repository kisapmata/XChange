package org.knowm.xchange.examples.gemini.marketdata;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.gemini.v1.GeminiExchange;
import org.knowm.xchange.gemini.v1.GeminiUtils;
import org.knowm.xchange.gemini.v1.dto.marketdata.GeminiTicker;
import org.knowm.xchange.gemini.v1.service.GeminiMarketDataServiceRaw;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

/**
 * Created by joseph on 6/15/17.
 */
public class GeminiTickerDemo {

    public static void main(String[] args) throws IOException {
        // Use the factory to get Gemini exchange API using default settings
        Exchange xchange = ExchangeFactory.INSTANCE.createExchange(GeminiExchange.class.getName());

        // Interested in the public polling market data feed (no authentication)
        MarketDataService marketDataService = xchange.getMarketDataService();

        generic(marketDataService);
        raw((GeminiMarketDataServiceRaw) marketDataService);
    }

    private static void generic(MarketDataService marketDataService) throws IOException {

        Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);

        System.out.println(ticker.toString());
    }

    private static void raw(GeminiMarketDataServiceRaw marketDataService) throws IOException {

        GeminiTicker ticker = marketDataService.getGeminiTicker(GeminiUtils.toPairString(CurrencyPair.BTC_USD));

        System.out.println(ticker.toString());
    }
}
