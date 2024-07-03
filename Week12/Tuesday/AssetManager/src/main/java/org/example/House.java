package org.example;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.setAddress(address);
        this.setCondition(condition);
        this.setSquareFoot(squareFoot);
        this.setLotSize(lotSize);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public double getValue() {
        double pricePerSqFoot;
        double lotPricePerSqFoot = .25;

        if (condition == 1) {
            pricePerSqFoot = 180.00;
        } else if (condition == 2) {
            pricePerSqFoot = 130.00;
        } else if (condition == 3) {
            pricePerSqFoot = 90.00;
        } else if (condition == 4) {
            pricePerSqFoot = 80;
        } else {
            throw new IllegalArgumentException("Condition must be between 1-4");
        }

        double lotValue = (squareFoot * pricePerSqFoot) + (lotSize * lotPricePerSqFoot);
        return lotValue;
    }

}
