package com.lab1.strategy;

import com.lab1.Payment;

import java.time.LocalDate;

public interface MortgageStrategy {
    public Payment getRequiredPayment(LocalDate date);

    // This method can calculate the number of months between the two date.
    public long dateCompare(LocalDate localDate1, LocalDate localDate2);
}
