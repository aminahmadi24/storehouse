package ir.aminahmadi24.repository;

import ir.aminahmadi24.model.Product;
import ir.aminahmadi24.utility.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductRepository {

    public int add(Product product) throws Exception {
        Connection connection = JdbcConnection.getConnection();
        String query = "INSERT INTO product (name, quantity, category_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getQuantity());
        preparedStatement.setInt(3, product.getCategoryId());
        int result = preparedStatement.executeUpdate();
        JdbcConnection.closeResources(connection, preparedStatement);
        return result;
    }
    public boolean isExistsProductByName(String name) throws Exception {
        Connection connection = JdbcConnection.getConnection();
        String query = "SELECT * FROM product WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = resultSet.next();
        JdbcConnection.closeResources(connection, preparedStatement, resultSet);
        return result;
    }

    public boolean isExistCategory(int categoryId) throws Exception {
        String query = "select name, c.title from product p\n" +
                "join category c on p.category_id = c.id";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = resultSet.next();
        JdbcConnection.closeResources(connection, preparedStatement, resultSet);
        return result;
    }
}
