package org.example;

public class SemiTruck extends Vehicle{

    private boolean hasCbRadio;
    private boolean isOptimusPrime;

    public SemiTruck(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity, boolean hasCbRadio, boolean isOptimusPrime) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
        this.hasCbRadio = hasCbRadio;
        this.isOptimusPrime = isOptimusPrime;
    }

    public boolean isHasCbRadio() {
        return hasCbRadio;
    }

    public void setHasCbRadio(boolean hasCbRadio) {
        this.hasCbRadio = hasCbRadio;
    }

    public boolean isOptimusPrime() {
        return isOptimusPrime;
    }

    public void setOptimusPrime(boolean optimusPrime) {
        this.isOptimusPrime = optimusPrime;
    }
}
