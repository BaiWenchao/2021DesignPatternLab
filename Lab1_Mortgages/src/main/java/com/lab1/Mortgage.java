package com.lab1;

import com.lab1.strategy.MortgageStrategy;
import com.lab1.strategy.impl.AmortizedMortgageStrategy;
import com.lab1.strategy.impl.LinearMortgageStrategy;

import java.time.LocalDate;

public class Mortgage {
    private Integer initialLoan;
    private Integer currentLoan;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer interestPoints;
    private MortgageStrategy mortgageStrategy;

    public Mortgage(Integer initialLoan, Integer currentLoan, LocalDate startDate, LocalDate endDate, Integer interestPoints) {
        this.initialLoan = initialLoan;
        this.currentLoan = currentLoan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interestPoints = interestPoints;
    }

    public void setMortgageStrategy(MortgageStrategy mortgageStrategy) {
        this.mortgageStrategy = mortgageStrategy;
    }

    public Integer getInitialLoan() {
        return initialLoan;
    }

    public Integer getCurrentLoan() {
        return currentLoan;
    }

    Payment getRequiredPayment(LocalDate date, int s){

        // s = 1 -> Linear
        if (s == 1){
            MortgageStrategy mortgageStrategy1 = new LinearMortgageStrategy(500000, startDate, 42,28);
            this.setMortgageStrategy(mortgageStrategy1);
        }
        // s = 2 -> Amoritized
        else {
            MortgageStrategy mortgageStrategy1 = new AmortizedMortgageStrategy(0.0053682,500000,startDate,42);
            this.setMortgageStrategy(mortgageStrategy1);
        }
        Payment payment = mortgageStrategy.getRequiredPayment(date);
        return payment;

    }

    private void makePayment(Payment p){

    }


}
