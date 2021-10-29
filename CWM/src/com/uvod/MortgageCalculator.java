package com.uvod;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTS_IN_YEAR = 12;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ",1000,1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ",1,30);
        byte years = (byte) readNumber("Period (Years): ",1,30);

        printMortgage(principal, annualInterest, years);

        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormat = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthy Payments: " + mortgageFormat);
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        for (short month = 1; month <= years *MONTS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateBalance(int principal,float annualInterest, byte years, short numberOfPaymentsMade){

        short numberOfPayments = (short) (years*MONTS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTS_IN_YEAR;

        double balance = principal *
                (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))/
                (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        return balance;
    }

    public static double calculateMortgage (int principal,float annualInterest, byte years){

        short numberOfPayments = (short) (years*MONTS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                / (Math.pow(1+monthlyInterest,numberOfPayments)-1);

        return mortgage;
    }

    public static double readNumber (String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value>=min && value <=max)
                break;

            System.out.println("Enter a value between "+ min + " and "+ max);
        }

        return value;
    }
}
