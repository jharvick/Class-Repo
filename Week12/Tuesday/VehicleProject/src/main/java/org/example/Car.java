package org.example;

public class Car extends Vehicle {

    private String make;
    private String model;
    private String bodyStyle;

    public Car(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity, String make, String model, String bodyStyle) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
        this.make = make;
        this.model = model;
        this.bodyStyle = bodyStyle;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }
}
