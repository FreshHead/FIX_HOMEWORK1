package ru.univeralex.web.model;

public class Product {
    private Integer id;
    private String name;
    private Double cost;


    public Product(String name, Double cost) {
        this.id = null;
        this.name = name;
        this.cost = cost;
    }

    public Product(Integer id, String name, Double cost) {
        this(name, cost);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }
}
