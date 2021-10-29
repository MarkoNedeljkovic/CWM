package com.oop;

public class TaxCalculator2021 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculator2021(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax(){
        return taxableIncome * 0.4;
    }
}
