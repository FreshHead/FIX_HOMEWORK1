package ru.univeralex.web.dao;

import ru.univeralex.web.model.User;

import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public interface UserDao extends CrudDao<User> {
    Optional<User> findByUsername(String username);
}
