package com.example.backend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ItemPerson {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String brand;

    @Column
    private String deliverTo;

    @Column
    private int quantity;

    @Column
    private float price;

    @OneToMany(targetEntity = Deals.class)
    @JoinColumn(name = "itemPersonId", referencedColumnName = "id")
    private List<Deals> deals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    public ItemPerson() {
    }

    public ItemPerson(int id, String brand, String deliverTo, int quantity, float price, List<Deals> deals, Item item)
    {
        this.id = id;
        this.brand = brand;
        this.deliverTo = deliverTo;
        this.quantity = quantity;
        this.price = price;
        this.deals = deals;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeliverTo() {
        return deliverTo;
    }

    public void setDeliverTo(String deliverTo) {
        this.deliverTo = deliverTo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Deals> getDeals() {
        return deals;
    }

    public void setDeals(List<Deals> deals) {
        this.deals = deals;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
