package ru.univeralex.web.dao;

import ru.univeralex.web.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kostarev
 */
public class ProductDaoImpl {
    private Connection connection;

    public ProductDaoImpl() {
//        String dbUser = "manager";
//        String dbPassword = "qwerty007";
//        String connectionUrl = "jdbc:postgresql://localhost:5432/fix_course_product_db";
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Product> getProducts() {
//        List<Product> products = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
//            while (resultSet.next()) {
//                String productName = resultSet.getString("name");
//                Double productCost = Double.valueOf(resultSet.getString("cost"));
//                products.add(new Product(productName, productCost));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
//
//    public void addProduct(Product product){
//        try {
//            Statement statement = connection.createStatement();
//
//            statement.executeQuery(
//                    "INSERT INTO product(name, cost) VALUES('" + product.getName() + "', " + product.getCost() + ")"
//            );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
