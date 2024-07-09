package com.example.jdbc_demo.repositories;

import com.example.jdbc_demo.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private DataSource dataSource;

    //get all categories
    public List<Category> getAllCategories(){
        //write your sql query
        //open a connection to the db
        //prepare the query to be sent to sql
        //execute the query and get back a result set
        //loop through each row in the result set
        //grab data column by column and put it into a new Java object
        //put it in a list
        //at the end of the loop, return the list
        String query = "SELECT * FROM categories";
        List<Category> categories = new ArrayList<>();

        //try-with
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                //grab the data from the columns
                int categoryId = rs.getInt("categoryid");
                String categoryName = rs.getString("categoryname");
                String description = rs.getString("description");
                Category c = new Category(categoryId, categoryName, description);
                categories.add(c);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return categories;
    }

    public Optional<Category> getCategoryById(int id){
        String query = "SELECT * FROM categories WHERE category_id = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return Optional.of(mapRowToCategory(rs));
                }
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    public void deleteCategory(int id){
        String query = "DELETE FROM categories WHERE categoryid = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int createCategory(Category category){
        String query = "INSERT INTO categories (categoryname, description) VALUES(?, ?) RETURNING categoryid";
        int generateId = -1;

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, category.getCategoryName());
            ps.setString(1, category.getDescription());

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    generateId = rs.getInt(1);
                }
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return generateId;
    }

    public void updateCategory(Category category){
        String query = "UPDATE categories SET categoryname = ?, description = ? WHERE categoryid = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, category.getCategoryName());
            ps.setString(1, category.getDescription());
            ps.setInt(3, category.getCategoryId());

            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Category mapRowToCategory(ResultSet rs) throws SQLException {
        int categoryId = rs.getInt("categoryid");
        String categoryName = rs.getString("categoryname");
        String description = rs.getString("description");
        Category c = new Category(categoryId, categoryName, description);
        return c;
    }
}
