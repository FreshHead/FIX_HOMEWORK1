package ru.univeralex.web.dao.impl;

import ru.univeralex.web.dao.UserDao;
import ru.univeralex.web.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public class UserDaoJdbcImpl implements UserDao {
    private Connection connection;

    public UserDaoJdbcImpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User model) {
        try {
            String preparedSql = "INSERT INTO security.user(username, password, registration_date) VALUES (?, ?, NOW())";
            PreparedStatement statement = connection.prepareStatement(preparedSql);
            statement.setString(1, model.getName());
            statement.setString(2, model.getPassword());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User model) {
        //Implementation Does not needed
    }

    @Override
    public void delete(Integer id) {
        //Implementation Does not needed
    }

    @Override
    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            ResultSet resultSet = connection.prepareStatement("SELECT * FROM security.user").executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Date registrationDate = resultSet.getDate("registration_date");

                users.add(new User(username, password, registrationDate));
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM security.user WHERE username = ?"
            );
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                Date registrationDate = resultSet.getDate("registration_date");

                return Optional.of(new User(username, password, registrationDate));

            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
