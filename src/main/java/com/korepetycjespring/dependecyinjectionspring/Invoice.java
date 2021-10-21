package com.korepetycjespring.dependecyinjectionspring;

public class Invoice {

    private double totalPrice;

    public Invoice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
