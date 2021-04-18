package com.lab1;

import java.time.LocalDate;

public class MortgageCustomerInfoApp {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.parse("2021-04-01");
        LocalDate now = LocalDate.parse("2023-08-01");
        LocalDate endDate = LocalDate.parse("2024-08-01");
        Mortgage m =new Mortgage(500000,500000,startDate,endDate,42);
        Payment payment = m.getRequiredPayment(now, 2);
        System.out.println(payment.getInterest());

    }
}
