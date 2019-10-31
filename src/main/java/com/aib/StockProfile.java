package com.aib;

import com.aib.enums.BusinessDomain;
import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class StockProfile {
    private String name;
    private BusinessDomain domainOfActivity;
    private Double currentOpenPrice;
    private Double currentPrice;

    private Set<StockHistoryRecord> stockHistoryRecordSet;


}
