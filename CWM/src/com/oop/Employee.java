package com.oop;

public class Employee {
    private int baseSalary;
    private int hourlyRate;
    private String name;
    private static int number;

    public Employee(int baseSalary, int hourlyRate, String name) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        this.name = name;
        number++;
    }

    public Employee(int baseSalary, String name) {
        this(baseSalary,0, name);
    }

    public int calculateWage(int extraHours){
        return baseSalary + (extraHours * hourlyRate);
    }

    private void setBaseSalary (int baseSalary){
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary cannot be 0 or less!");
        this.baseSalary=baseSalary;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate cannot be less then 0!");
        this.hourlyRate = hourlyRate;
    }

    private int getBaseSalary() {
        return baseSalary;
    }
    private int getHourlyRate() {
        return hourlyRate;
    }

    public static int getNumber(){
        return number;
    }

    public static void reduceNumber(){
        number--;
    }

    public static void deleteEmployee(Employee employee){
        employee = null;
        reduceNumber();
    }

}
