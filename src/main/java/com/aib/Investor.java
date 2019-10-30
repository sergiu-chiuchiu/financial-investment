package com.aib;

import com.aib.Enums.BusinessDomain;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investor {

    private String name;
    private Set<BusinessDomain> investmentDomainPreferences;
    private Set<StockOwned> stockOwnedSet;
    private Set<AutoTransaction> autoBuyOrderSet;

}
