package com.aib;

import com.aib.Enums.TransactionType;
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
    private Calendar waitForTransactionUntil;
    private TransactionType transactionType;


}
