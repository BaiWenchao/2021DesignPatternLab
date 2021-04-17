package com.lab1.strategy;

import com.lab1.Payment;

import java.time.LocalDate;

public interface MortgageStrategy {
    public Payment getRequiredPayment(LocalDate date);
}
