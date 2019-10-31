package com.aib;

import com.aib.enums.BusinessDomain;
import com.aib.enums.TransactionType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investor {

    private String name;
    private Double availableFunds;
    private Set<BusinessDomain> investmentDomainPreferences;
    private Set<StockOwned> stockOwnedSet;
    private Set<AutoTransaction> autoTransactionSet;

    public static void executeTransaction(Investor i, AutoTransaction at) {
        if (at.getTransactionType().equals(TransactionType.BUY)) {
            i.getStockOwnedSet().add(StockOwned.builder()
                    .quantity(at.getNoOfShares())
                    .stockProfile(at.getStockProfile())
                    .pricePaid(at.getStockProfile().getCurrentPrice())
                    .build());
            at.setIsExecuted(true);
        } else if (at.getTransactionType() == TransactionType.SELL) {

        }
    }


}
