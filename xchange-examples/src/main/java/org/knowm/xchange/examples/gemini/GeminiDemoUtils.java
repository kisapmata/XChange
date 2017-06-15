package org.knowm.xchange.examples.gemini;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.gemini.v1.GeminiExchange;

/**
 * Created by joseph on 6/15/17.
 */
public class GeminiDemoUtils {
    public static Exchange createExchange() {

        ExchangeSpecification exSpec = new GeminiExchange().getDefaultExchangeSpecification();
        exSpec.setApiKey("");
        exSpec.setSecretKey("");
        return ExchangeFactory.INSTANCE.createExchange(exSpec);
    }
}
