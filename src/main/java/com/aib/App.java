package com.aib;

import com.aib.enums.BusinessDomain;
import com.aib.enums.TransactionType;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        KieServices kService=KieServices.Factory.get();
        KieContainer kContainer=kService.getKieClasspathContainer();
        KieSession kSession=kContainer.newKieSession("ksession-rules");

        StockHistoryRecord shr11 = StockHistoryRecord.builder()
                .closePrice(12.0)
                .openPrice(11.75)
                .maxPrice(13.5)
                .minPrice(11.0)
                .recordDate(new GregorianCalendar(2019, Calendar.NOVEMBER, 1))
                .build();

        StockHistoryRecord shr12 = StockHistoryRecord.builder()
                .closePrice(11.0)
                .openPrice(12.75)
                .maxPrice(14.5)
                .minPrice(12.0)
                .recordDate(new GregorianCalendar(2019, Calendar.NOVEMBER, 2))
                .build();

        StockHistoryRecord shr21 = StockHistoryRecord.builder()
                .closePrice(21.0)
                .openPrice(22.75)
                .maxPrice(24.5)
                .minPrice(22.0)
                .recordDate(new GregorianCalendar(2019, Calendar.NOVEMBER, 1))
                .build();

        StockHistoryRecord shr22 = StockHistoryRecord.builder()
                .closePrice(22.0)
                .openPrice(23.75)
                .maxPrice(26.5)
                .minPrice(21.0)
                .recordDate(new GregorianCalendar(2019, Calendar.NOVEMBER, 2))
                .build();

        Set<StockHistoryRecord> stockHistoryRecordSet1 = new HashSet<>();
        stockHistoryRecordSet1.add(shr11);
        stockHistoryRecordSet1.add(shr12);
        Set<StockHistoryRecord> stockHistoryRecordSet2 = new HashSet<>();
        stockHistoryRecordSet2.add(shr21);
        stockHistoryRecordSet2.add(shr22);

        StockProfile spFORD = StockProfile.builder()
                .name("Ford")
                .currentOpenPrice(13.0)
                .currentPrice(14.0)
                .stockHistoryRecordSet(stockHistoryRecordSet1)
                .domainOfActivity(BusinessDomain.AUTOMOTIVE)
                .build();

        StockProfile spAMZN = StockProfile.builder()
                .name("Amazon")
                .currentOpenPrice(23.0)
                .currentPrice(25.0)
                .stockHistoryRecordSet(stockHistoryRecordSet2)
                .domainOfActivity(BusinessDomain.TECH)
                .build();

        StockOwned so1 = StockOwned.builder()
                .investorID(1)
                .stockProfile(spFORD)
                .pricePaid(10.45)
                .quantity(5000)
                .build();

        StockOwned so2 = StockOwned.builder()
                .investorID(1)
                .stockProfile(spAMZN)
                .pricePaid(20.55)
                .quantity(3000)
                .build();

        StockOwned so3 = StockOwned.builder()
                .investorID(2)
                .stockProfile(spAMZN)
                .pricePaid(19.18)
                .quantity(7000)
                .build();

        Set<StockOwned> stockOwnedSet1 = new HashSet<>();
        stockOwnedSet1.add(so1);
        stockOwnedSet1.add(so2);
        Set<StockOwned> stockOwnedSet2 = new HashSet<>();
        stockOwnedSet2.add(so3);

        AutoTransaction at1 = AutoTransaction.builder()
                .id(110L)
                .noOfShares(10000)
                .thresholdPrice(15.)
                .stockProfile(spFORD)
                .waitUntil(new GregorianCalendar(2019, Calendar.SEPTEMBER, 28))
                .transactionType(TransactionType.BUY)
                .build();

        AutoTransaction at2 = AutoTransaction.builder()
                .id(111L)
                .noOfShares(2000)
                .thresholdPrice(23.)
                .stockProfile(spAMZN)
                .waitUntil(new GregorianCalendar(2019, Calendar.DECEMBER, 28))
                .transactionType(TransactionType.SELL)
                .build();

        AutoTransaction at21 = AutoTransaction.builder()
                .id(1121L)
                .noOfShares(22000)
                .thresholdPrice(22.)
                .stockProfile(spAMZN)
                .waitUntil(new GregorianCalendar(2019, Calendar.DECEMBER, 14))
                .transactionType(TransactionType.SELL)
                .build();

        AutoTransaction at3 = AutoTransaction.builder()
                .id(112L)
                .noOfShares(4000)
                .thresholdPrice(26.)
                .stockProfile(spAMZN)
                .waitUntil(new GregorianCalendar(2019, Calendar.NOVEMBER, 28))
                .transactionType(TransactionType.BUY)
                .build();

        AutoTransaction at31 = AutoTransaction.builder()
                .id(1131L)
                .noOfShares(17000)
                .thresholdPrice(27.)
                .stockProfile(spAMZN)
                .waitUntil(new GregorianCalendar(2019, Calendar.NOVEMBER, 24))
                .transactionType(TransactionType.BUY)
                .build();

        AutoTransaction at4 = AutoTransaction.builder()
                .id(113L)
                .noOfShares(3000)
                .thresholdPrice(21.)
                .stockProfile(spAMZN)
                .waitUntil(new GregorianCalendar(2019, Calendar.OCTOBER, 25))
                .transactionType(TransactionType.SELL)
                .build();

        AutoTransaction at5 = AutoTransaction.builder()
                .id(114L)
                .noOfShares(3000)
                .thresholdPrice(21.)
                .stockProfile(spAMZN)
                .waitUntil(new GregorianCalendar(2019, Calendar.OCTOBER, 25))
                .transactionType(TransactionType.BUY)
                .build();

        AutoTransaction at6 = AutoTransaction.builder()
                .id(115L)
                .noOfShares(6000)
                .thresholdPrice(18.)
                .stockProfile(spFORD)
                .waitUntil(new GregorianCalendar(2018, Calendar.OCTOBER, 25))
                .transactionType(TransactionType.SELL)
                .build();

        AutoTransaction at7 = AutoTransaction.builder()
                .id(116L)
                .noOfShares(3000)
                .thresholdPrice(15.)
                .stockProfile(spAMZN)
                .waitUntil(new GregorianCalendar(2017, Calendar.OCTOBER, 25))
                .transactionType(TransactionType.SELL)
                .build();

        Set<AutoTransaction> atSet1 = new HashSet<>();
        atSet1.add(at1);
        atSet1.add(at2);
        atSet1.add(at5);
        atSet1.add(at6);
        atSet1.add(at21);

        Set<AutoTransaction> atSet2 = new HashSet<>();
        atSet2.add(at3);
        atSet2.add(at4);
        atSet2.add(at7);
        atSet2.add(at31);

        Set<BusinessDomain> businessDomainPreferencesSet1 = new HashSet<>();
        businessDomainPreferencesSet1.add(BusinessDomain.AEROSPACE);
        businessDomainPreferencesSet1.add(BusinessDomain.AUTOMOTIVE);

        Set<BusinessDomain> businessDomainPreferencesSet2 = new HashSet<>();
        businessDomainPreferencesSet2.add(BusinessDomain.TECH);
        businessDomainPreferencesSet2.add(BusinessDomain.AUTOMOTIVE);

        Investor i1 = Investor.builder()
                .investorID(1)
                .birthDate(LocalDate.of(1999, Month.MARCH, 19))
                .name("Bob")
                .autoTransactionSet(atSet1)
                .availableFunds(3000.)
                .investmentDomainPreferences(businessDomainPreferencesSet1)
                .stockOwnedSet(stockOwnedSet1)
                .build();

        Investor i2 = Investor.builder()
                .birthDate(LocalDate.of(2002, Month.MARCH, 19))
                .investorID(2)
                .name("Sarah")
                .availableFunds(120000.)
                .autoTransactionSet(atSet2)
                .investmentDomainPreferences(businessDomainPreferencesSet2)
                .stockOwnedSet(stockOwnedSet2)
                .build();

        kSession.insert(shr11);
        kSession.insert(shr12);
        kSession.insert(shr21);
        kSession.insert(shr22);

        kSession.insert(spFORD);
        kSession.insert(spAMZN);

        kSession.insert(so1);
        kSession.insert(so2);
        kSession.insert(so3);

        kSession.insert(at1);
        kSession.insert(at2);
        kSession.insert(at3);
        kSession.insert(at4);
        kSession.insert(at5);
        kSession.insert(at6);
        kSession.insert(at7);
        kSession.insert(at31);
        kSession.insert(at21);

        kSession.insert(i1);
        kSession.insert(i2);
        kSession.fireAllRules();
    }
}
