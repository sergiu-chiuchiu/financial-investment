package com.aib;

import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockHistoryRecord {
    private Double openPrice;
    private Double closePrice;
    private Double minPrice;
    private Double maxPrice;
    private Double volume;
    private Calendar recordDate;
}
