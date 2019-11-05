package com.aib;

import com.aib.enums.BusinessDomain;
import com.aib.enums.TransactionState;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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
    @Builder.Default
    private List<String> notification = new ArrayList<>();

    public void addNotification(String newNotification) {
        notification.add(newNotification);
    }

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
            System.out.println("Stock could not be sold. Not enough shares!");
            at.setTransactionState(TransactionState.NOT_ENOUGH_SHARES);
        }
    }
}
