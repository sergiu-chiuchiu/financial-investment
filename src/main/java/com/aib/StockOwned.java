package com.aib;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// could be named portfolioRecord
public class StockOwned {
    private Integer investorID;
    private StockProfile stockProfile;
    private Integer quantity;
    private Double pricePaid;

}
