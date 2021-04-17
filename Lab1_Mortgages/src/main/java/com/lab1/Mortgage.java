package com.lab1;

import com.lab1.strategy.MortgageStrategy;
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

    private Payment getRequiredPayment(LocalDate date){
        return null;
    }

    private void makePayment(Payment p){

    }


}
