package com.example.backend.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ItemPerson {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @CreationTimestamp
    private Date date;

    @Column
    private String brand;

    @Column
    private String deliverTo;

    @Column
    private int quantity;

    @Column
    private float price;

    @Column
    private int rating;

    @OneToMany(targetEntity = Deals.class)
    @JoinColumn(name = "itemPersonId", referencedColumnName = "id")
    private List<Deals> deals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    public ItemPerson() {
    }

    public ItemPerson(int id, String brand, String deliverTo, int quantity, float price, List<Deals> deals, Item item, Person person, Date date, int rating)
    {
        this.id = id;
        this.brand = brand;
        this.deliverTo = deliverTo;
        this.quantity = quantity;
        this.price = price;
        this.deals = deals;
        this.item = item;
        this.person = person;
        this.date = date;
        this.rating = rating;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
