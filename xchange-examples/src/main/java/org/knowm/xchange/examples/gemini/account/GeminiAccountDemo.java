package org.knowm.xchange.examples.gemini.account;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.examples.gemini.GeminiDemoUtils;
import org.knowm.xchange.examples.util.AccountServiceTestUtil;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;

/**
 * Created by joseph on 6/15/17.
 */
public class GeminiAccountDemo {
    public static void main(String[] args) throws IOException {

        Exchange xchange = GeminiDemoUtils.createExchange();
        AccountService accountService = xchange.getAccountService();

        generic(accountService);

    }

    private static void generic(AccountService accountService) throws IOException {
        AccountServiceTestUtil.accountInfo(accountService);
    }
}
