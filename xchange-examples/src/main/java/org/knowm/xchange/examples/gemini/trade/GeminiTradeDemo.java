package org.knowm.xchange.examples.gemini.trade;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.examples.gemini.GeminiDemoUtils;
import org.knowm.xchange.gemini.v1.dto.trade.GeminiOrderStatusResponse;
import org.knowm.xchange.gemini.v1.service.GeminiTradeServiceRaw;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by joseph on 6/15/17.
 */
public class GeminiTradeDemo {
    public static void main(String[] args) throws IOException {

        Exchange xchange = GeminiDemoUtils.createExchange();
        TradeService tradeService = xchange.getTradeService();

        generic(tradeService);
    }

    private static void generic(TradeService tradeService) throws IOException {

        // get Trade  history
        Trades trades = tradeService.getTradeHistory(tradeService.createTradeHistoryParams());
        System.out.println(trades);

        printOpenOrders(tradeService);

        // place a limit buy order
        LimitOrder limitOrder = new LimitOrder((Order.OrderType.BID), new BigDecimal(".001"), CurrencyPair.BTC_USD, "", null, new BigDecimal("1000.00"));
        String limitOrderReturnValue = tradeService.placeLimitOrder(limitOrder);
        System.out.println("Limit Order return value: " + limitOrderReturnValue);

        printOrderStatus(tradeService, limitOrderReturnValue);

        printOpenOrders(tradeService);

        // Cancel the added order
        boolean cancelResult = tradeService.cancelOrder(limitOrderReturnValue);
        System.out.println("Canceling returned " + cancelResult);

        printOrderStatus(tradeService, limitOrderReturnValue);

        printOpenOrders(tradeService);


    }

    private static void printOpenOrders(TradeService tradeService) throws IOException {

        OpenOrders openOrders = tradeService.getOpenOrders();
        System.out.println("Open Orders: " + openOrders.toString());
    }


    private static void printOrderStatus(TradeService tradeService, String orderId) throws IOException {

        final GeminiTradeServiceRaw tradeServiceRaw = (GeminiTradeServiceRaw) tradeService;
        final GeminiOrderStatusResponse response = tradeServiceRaw.getGeminiOrderStatus(orderId);
        System.out.println("Order Status: " + response.toString());
    }
}
