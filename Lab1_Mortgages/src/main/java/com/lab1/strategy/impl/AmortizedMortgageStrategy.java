package com.lab1.strategy.impl;

import com.lab1.Payment;
import com.lab1.strategy.MortgageStrategy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AmortizedMortgageStrategy implements MortgageStrategy {

    private double payment_rateM;
    private Integer InitialLoan;
    private LocalDate startDate;
    private Integer interestPointsM;

    public AmortizedMortgageStrategy(double payment_rateM, Integer initialLoan, LocalDate startDate, Integer interestPointsM) {
        this.payment_rateM = payment_rateM;
        InitialLoan = initialLoan;
        this.startDate = startDate;
        this.interestPointsM = interestPointsM;
    }


    @Override
    public Payment getRequiredPayment(LocalDate date) {
        long deltaM = dateCompare(startDate, date);
        double payment = payment_rateM * InitialLoan;
        double l = InitialLoan;
        double r = 0;
        for (int i = 0; i < deltaM; i++) {
            r = payment - l * ((double)interestPointsM/10000);
            l = l - r;
        }
        double repayment = payment - l * ((double)interestPointsM/10000);
        Integer interest = (int)(((double)interestPointsM/10000)*l);
        Payment p = new Payment(date, (int)repayment, interest);
        return p;
    }

    // This method can calculate the number of months between the two date.
    @Override
    public long dateCompare(LocalDate localDate1, LocalDate localDate2) {
        return localDate1.until(localDate2, ChronoUnit.MONTHS);
    }
}
