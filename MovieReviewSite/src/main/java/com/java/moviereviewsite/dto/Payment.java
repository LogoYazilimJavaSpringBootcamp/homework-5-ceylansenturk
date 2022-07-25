package com.java.moviereviewsite.dto;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class Payment {
    private LocalDateTime paymentDate;
    private CurrencyType currencyType;
    private BigDecimal amount;

    private Month month;


    public Payment(LocalDateTime paymentDate, CurrencyType currencyType, BigDecimal amount, Month month) {
        super();
        this.paymentDate = paymentDate;
        this.currencyType = currencyType;
        this.amount = amount;
        this.month = month;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentDate=" + paymentDate +
                ", currencyType=" + currencyType +
                ", amount=" + amount +
                ", month=" + month +
                '}';
    }
}
