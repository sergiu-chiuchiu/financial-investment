package com.aib;

import com.aib.enums.BusinessDomain;
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
    private String notification;

    public static void executeBuyTransaction(Investor i, AutoTransaction at) {
        i.getStockOwnedSet().add(StockOwned.builder()
                .quantity(at.getNoOfShares())
                .pricePaid(at.getStockProfile().getCurrentPrice())
                .stockProfile(at.getStockProfile())
                .build());
    }

    public static void executeSellTransaction(Investor i, AutoTransaction at) throws Exception {
        Set<StockOwned> stockOwnedSet = i.getStockOwnedSet();
        Integer noOfSharesToSell = at.getNoOfShares();
        Boolean isStockSold = false;

        for (StockOwned so : stockOwnedSet) {
            Integer ownedQuantity = so.getQuantity();
            if (so.getStockProfile() == at.getStockProfile()) {
                if (ownedQuantity < noOfSharesToSell) {
                    noOfSharesToSell -= ownedQuantity;
                    stockOwnedSet.remove(so);
                } else {
                    so.setQuantity(ownedQuantity - noOfSharesToSell);
                    if (ownedQuantity.equals(noOfSharesToSell)) { stockOwnedSet.remove(so); }
                    isStockSold = true;
                    break;
                }
            }
        }
        if (!isStockSold) {
            throw new Exception();
        }
    }
}
