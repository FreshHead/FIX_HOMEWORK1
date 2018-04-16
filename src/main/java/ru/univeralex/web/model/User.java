package ru.univeralex.web.model;

import java.sql.Date;

/**
 * @author - Alexander Kostarev
 */
public class User {
    private String name;
    private String password;
    private Date registrationDate;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, Date registrationDate) {
        this.name = name;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
