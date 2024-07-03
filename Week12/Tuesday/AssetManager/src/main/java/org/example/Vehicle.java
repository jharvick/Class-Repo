package org.example;

import java.time.Year;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;


    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.setMakeModel(makeModel);
        this.setYear(year);
        this.setOdometer(odometer);
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - year;
        double originalCost = getOriginalCost();

        double valueReduction = 0.0;
        switch (age) {
            case 0:
            case 1:
            case 2:
            case 3:
                valueReduction = 0.03 * age;
                break;
            case 4:
            case 5:
            case 6:
                valueReduction = 0.06 * age;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                valueReduction = 0.08 * age;
                break;
            default:
                return 1000.0;
        }

        boolean isHighMileage = odometer > 100000;
        boolean isSpecialMake = makeModel.contains("Honda") || makeModel.contains("Toyota");
        if (isHighMileage && !isSpecialMake) {
            valueReduction += 0.25;
        }

        return originalCost * (1 - valueReduction);
    }
}
