package com.example.ShopAnime.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="name", nullable = false, unique = false, length = 100)
    private String name;

    @Lob
    @Column(name = "description",nullable = true, unique = false)
    private String description;

    @Column(name ="stock", nullable = false)
    private int stock;

    @Column(name ="price", nullable = false)
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
