package org.knowm.xchange.examples.gemini.marketdata;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.examples.gemini.GeminiDemoUtils;
import org.knowm.xchange.gemini.v1.GeminiUtils;
import org.knowm.xchange.gemini.v1.dto.marketdata.GeminiDepth;
import org.knowm.xchange.gemini.v1.service.GeminiMarketDataServiceRaw;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

/**
 * Created by joseph on 6/15/17.
 */
public class GeminiOrderBookDemo {
    public static void main(String[] args) throws IOException {

        Exchange xchange = GeminiDemoUtils.createExchange();
        MarketDataService marketDataService = xchange.getMarketDataService();

        generic(marketDataService);
        raw((GeminiMarketDataServiceRaw) marketDataService);
    }

    private static void generic(MarketDataService marketDataService) throws IOException {

        OrderBook orderBook = marketDataService.getOrderBook(CurrencyPair.BTC_USD);

        System.out.println(orderBook.toString());
    }

    private static void raw(GeminiMarketDataServiceRaw marketDataService) throws IOException {

        GeminiDepth orderBook = marketDataService.getGeminiOrderBook(GeminiUtils.toPairString(CurrencyPair.BTC_USD), null, null);

        System.out.println(orderBook.toString());
    }
}
