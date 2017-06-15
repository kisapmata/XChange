package org.knowm.xchange.examples.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.service.account.AccountService;

/**
 * Created by joseph on 3/20/17.
 */
public class AccountServiceTestUtil {
  public static void printFundingHistory(List<FundingRecord> fundingRecords) throws IOException {

    if (fundingRecords != null) {
      for (final FundingRecord fundingRecord : fundingRecords) {
        System.out.println(fundingRecord);
      }
    } else {
      System.out.println("No Funding History Found.");
    }
  }

  public static void accountInfo(AccountService accountService) throws IOException {

    AccountInfo accountInfo =  accountService.getAccountInfo();

    if (accountInfo != null && accountInfo.getWallets() != null){
      for (Map.Entry<String, Wallet> walletEntry : accountInfo.getWallets().entrySet()){
        System.out.println("Key : " + walletEntry.getKey());
        final Wallet wallet = walletEntry.getValue();
        if (wallet != null && wallet.getBalances()!=null){
          System.out.println("Wallet Id : " + wallet.getId() + ", Name: " + wallet.getName());
          for (Map.Entry<Currency, Balance> balanceEntry : wallet.getBalances().entrySet()){
            final Balance balance = balanceEntry.getValue();
            if (balance != null){
              System.out.println("  Currency : " + balanceEntry.getKey() + ", Balance : " + balance.getAvailable());
            }
          }
        }
      }
    }
  }
}
