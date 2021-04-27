package com.lab1.strategy.impl;

import com.lab1.Payment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TestLInearMortgagesStrategy {
    @Test
    public void dateCompareTest() {

        LocalDate startDate = LocalDate.parse("2021-04-01");
        LocalDate now = LocalDate.parse("2023-08-01");
        LinearMortgageStrategy linearMortgageStrategy = new LinearMortgageStrategy(500000, startDate, 42,28);
        long deltaM = linearMortgageStrategy.dateCompare(startDate, now);
        assertEquals(deltaM, 28);
    }

    @Test
    public void getRequiredPaymentTest(){
        LocalDate startDate = LocalDate.parse("2021-04-01");
        LocalDate now = LocalDate.parse("2023-08-01");
        LinearMortgageStrategy linearMortgageStrategy = new LinearMortgageStrategy(500000, startDate, 42,28);
        Payment payment = linearMortgageStrategy.getRequiredPayment(now);
        assertEquals(payment.getRedemption(), 1400);

    }



}
