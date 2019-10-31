package com.aib;

import com.aib.enums.TransactionType;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoTransaction {

    private StockProfile stockProfile;
    private Integer noOfShares;
    private Double thresholdPrice;
    private Calendar waitUntil;
    private TransactionType transactionType;
    private Boolean isExecuted = false;


}
