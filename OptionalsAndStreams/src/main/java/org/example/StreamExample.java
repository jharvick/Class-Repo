package org.example;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product("Phone", 599.99),
                new Product("Tablet", 399.99),
                new Product("Monitor", 299.99),
                new Product("Keyboard", 49.99),
                new Product("Mouse", 25.99),
                new Product("Printer", 149.99),
                new Product("Camera", 699.99),
                new Product("Headphones", 199.99),
                new Product("Smartwatch", 249.99),
                new Product("Speaker", 89.99),
                new Product("Router", 129.99),
                new Product("External Hard Drive", 79.99),
                new Product("Microphone", 99.99)
        );

        products.stream().forEach(x -> System.out.println(x.getName()));

        var productList = products.stream().filter(x -> x.getPrice() > 200).toList();

        var productNameAndPrice = products.stream().filter(x -> x.getName().startsWith("S") && x.getPrice() > 100).toList();

        //method references
        products.stream().map(Product::getName).sorted().toList().forEach(x -> System.out.println(x));

        //aggregate functions min, max, avg, sum, count
        var averagePrice = products.stream().mapToDouble(Product::getPrice).average().orElse(0);
        var mostExpensivest = products.stream().mapToDouble(Product::getPrice).max().orElse(0);

        var numberOfProductsUnder100 = products.stream().filter(x -> x.getPrice() < 100).count();



    }
}
