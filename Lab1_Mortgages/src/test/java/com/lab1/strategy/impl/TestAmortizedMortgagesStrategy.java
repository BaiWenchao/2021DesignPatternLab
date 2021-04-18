package com.lab1.strategy.impl;

import com.lab1.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAmortizedMortgagesStrategy {

    @Test
    public void getRequiredPaymentTest(){
        LocalDate startDate = LocalDate.parse("2021-04-01");
        LocalDate now = LocalDate.parse("2023-08-01");
        AmortizedMortgageStrategy amortizedMortgageStrategy = new AmortizedMortgageStrategy(0.0053682,500000,startDate,42);
        Payment payment = amortizedMortgageStrategy.getRequiredPayment(now);
        assertEquals(payment.getInterest(), 2009);
    }


}
