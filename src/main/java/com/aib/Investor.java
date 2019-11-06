package com.aib;
import com.aib.enums.BusinessDomain;
import com.aib.enums.InvestorType;
import lombok.*;
import java.time.LocalDate;
import java.time.Period;

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

    private Integer investorID;
    private LocalDate birthDate;
    private String name;
    private Double availableFunds;
    private Set<BusinessDomain> investmentDomainPreferences;
    private Set<StockOwned> stockOwnedSet;
    private Set<AutoTransaction> autoTransactionSet;

    private InvestorType investorType = InvestorType.STARTER;

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

    public Investor setInvestorType(Double value) {
        if(value >= 130000){
            this.investorType = InvestorType.GOLDEN;
        }else
        if(value < 130000 && value >= 110000){
            this.investorType = InvestorType.SILVER;
        }else
        if(value < 110000 && value > 90000){
            this.investorType = InvestorType.BRONZE;
        }else{
            this.investorType = InvestorType.STARTER;
        }
        return this;
    }

    public Investor setInvestorType(InvestorType type) {
        this.investorType = type;
        return this;
    }

    public Investor setInvestorType(Boolean val, Double value) {
        Period diff = Period.between(LocalDate.now(), this.getBirthDate());
        if(val){
            if(value >= 130000){
                this.investorType = InvestorType.GOLDEN;
            }else
            if(value < 130000 && value >= 110000){
                this.investorType = InvestorType.SILVER;
            }else
            if(value < 110000 && value > 90000){
                this.investorType = InvestorType.BRONZE;
            }else{
                this.investorType = InvestorType.STARTER;
            }
        }else{
            this.investorType = InvestorType.BLOCKED;
        }
        return this;
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
