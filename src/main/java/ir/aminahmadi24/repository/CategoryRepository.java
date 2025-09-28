package ir.aminahmadi24.repository;


import ir.aminahmadi24.model.Category;
import ir.aminahmadi24.utility.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CategoryRepository {


    public int add(String title) throws Exception {
        Connection connection = JdbcConnection.getConnection();
        String insert = "INSERT INTO category (title) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, title);
        int result = ps.executeUpdate();
        JdbcConnection.closeResources(connection, ps);
        return result;
    }

    public Category findCategoryByTitle(String title) throws Exception {
        Connection connection = JdbcConnection.getConnection();
        String selectQuery = "SELECT * FROM category WHERE title = ?";
        PreparedStatement ps = connection.prepareStatement(selectQuery);
        ps.setString(1, title);
        ResultSet resultSet = ps.executeQuery();
        Category category = null;
        if (resultSet.next())
            category =  new Category(
                    resultSet.getInt("id"),
                    resultSet.getString("title"));
        JdbcConnection.closeResources(connection, ps, resultSet);
        return category;
    }

    public boolean isExistsCategoryByTitle(String title) throws Exception {
        Connection connection = JdbcConnection.getConnection();
        String selectQuery = "SELECT * FROM category WHERE title = ?";
        PreparedStatement ps = connection.prepareStatement(selectQuery);
        ps.setString(1, title);
        ResultSet resultSet = ps.executeQuery();
        boolean result = resultSet.next();
        JdbcConnection.closeResources(connection, ps, resultSet);
        return result;
    }

}
