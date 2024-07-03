package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create an ArrayList of Asset objects
        ArrayList<Asset> assets = new ArrayList<>();

        // Adding House objects
        assets.add(new House("Mojo Dojo Casa House", "2020-01-01", 350000.00, "123 Main St", 1, 2500, 10000));
        assets.add(new House("Vacation Home", "2022-06-15", 500000.00, "456 Beach Rd", 2, 1800, 5000));

        // Adding Vehicle objects
        assets.add(new Vehicle("Jared's Truck", "2018-05-10", 30000.00, "Ford F-150", 2015, 80000));
        assets.add(new Vehicle("KITT", "1982-11-20", 250000.00, "Pontiac Trans Am", 1982, 1200000));

        // Loop through the Asset collection and display information
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: " + asset.getOriginalCost());
            System.out.println("Current Value: " + asset.getValue());

            // Check if the asset is a House
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            }
            // Check if the asset is a Vehicle
            else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make and Model: " + vehicle.getMakeModel());
            }

            System.out.println();
        }
    }
}
