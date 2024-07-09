package com.example.jdbc_demo.repositories;

import com.example.jdbc_demo.models.Category;
import com.example.jdbc_demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private DataSource dataSource;

    public List<Product> getAllProducts(){
        String query = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        //try-with
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                //grab the data from the columns
                int productId = rs.getInt("productid");
                String productName = rs.getString("productname");
                double unitPrice = rs.getDouble("price");
                String unitsInStock = rs.getString("unit");
                Product p = new Product(productId, productName, unitPrice, unitsInStock);
                products.add(p);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return products;
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        String query = "SELECT * FROM products WHERE categoryid = ?";
        List<Product> products = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, categoryId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("productid");
                    String productName = rs.getString("productname");
                    double unitPrice = rs.getDouble("price");
                    String unitsInStock = rs.getString("unit");
                    Product p = new Product(productId, productName, unitPrice, unitsInStock);
                    products.add(p);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return products;
    }
}
