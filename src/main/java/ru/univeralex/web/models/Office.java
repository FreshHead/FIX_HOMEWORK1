package ru.univeralex.web.models;

/**
 * @author - Alexander Kostarev
 */
public class Office {
    private int id;
    private String name;
    private String address;
    private String phone;


    public Office(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Office(int id, String name, String address, String phone) {
        this(name, address, phone);
        this.id = id;
    }

    public Office() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
