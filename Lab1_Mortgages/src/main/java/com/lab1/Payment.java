package com.lab1;

import java.time.LocalDate;

public class Payment {
    private LocalDate date;
    private Integer redemption;
    private Integer interest;

    public Payment(LocalDate date, Integer redemption, Integer interest) {
        this.date = date;
        this.redemption = redemption;
        this.interest = interest;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getRedemption() {
        return redemption;
    }

    public Integer getInterest() {
        return interest;
    }
}
