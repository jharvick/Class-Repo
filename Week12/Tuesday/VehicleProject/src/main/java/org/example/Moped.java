package org.example;

public class Moped extends Vehicle{

    private boolean hasBasket;
    private boolean hasTrainingWheels;

    public Moped(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity, boolean hasBasket, boolean hasTrainingWheels) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
        this.hasBasket = hasBasket;
        this.hasTrainingWheels = hasTrainingWheels;
    }

    public boolean isHasBasket() {
        return hasBasket;
    }

    public void setHasBasket(boolean hasBasket) {
        this.hasBasket = hasBasket;
    }

    public boolean isHasTrainingWheels() {
        return hasTrainingWheels;
    }

    public void setHasTrainingWheels(boolean hasTrainingWheels) {
        this.hasTrainingWheels = hasTrainingWheels;
    }
}
