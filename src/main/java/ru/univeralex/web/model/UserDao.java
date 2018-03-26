package ru.univeralex.web.model;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * @author - Alexander Kostarev
 */
public class UserDao {
    private Connection connection;

    public UserDao() {
        String dbUser = "security_manager";
        String dbPassword = "qwerty_sec";
        String connectionUrl = "jdbc:postgresql://localhost:5432/fix_course_product_db";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM security.user");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Date registrationDate = resultSet.getDate("registration_date");

                LocalDate registrationLocaleDate = registrationDate.toLocalDate();
                users.add(new User(username, password, registrationLocaleDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        try {
            Statement statement = connection.createStatement();

            statement.executeQuery(
                    "INSERT INTO security.user(username, password, registration_date) " +
                            "VALUES('" + user.getName() + "', '" + user.getPassword() + "', NOW())"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserExists(String name, String password) {
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT EXISTS(SELECT 1 FROM security.user " +
                            "WHERE username = '" + name + "' AND password = '" + password + "')"
            );
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
