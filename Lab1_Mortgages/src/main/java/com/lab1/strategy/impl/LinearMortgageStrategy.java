package com.lab1.strategy.impl;

import com.lab1.Payment;
import com.lab1.strategy.MortgageStrategy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LinearMortgageStrategy implements MortgageStrategy {
    private Integer InitialLoan;
    private LocalDate startDate;
    private Integer interestPointsM;
    private Integer linearPointsM;
    private double repayment;

    public LinearMortgageStrategy(Integer initialLoan, LocalDate startDate, Integer interestPointsM, Integer linearPointsM) {
        InitialLoan = initialLoan;
        this.startDate = startDate;
        this.interestPointsM = interestPointsM;
        this.linearPointsM = linearPointsM;
        this.repayment = initialLoan*((double) linearPointsM/10000);
    }

    @Override
    public Payment getRequiredPayment(LocalDate date) {
        long deltaM = dateCompare(startDate, date);
        Integer interest = (int)(((double)interestPointsM/10000)*(InitialLoan - deltaM * repayment));
        Payment p = new Payment(date, (int)repayment, interest);
        return p;
    }

    // This method can calculate the number of months between the two date.
    @Override
    public long dateCompare(LocalDate localDate1, LocalDate localDate2) {
        return localDate1.until(localDate2, ChronoUnit.MONTHS);
    }
}
