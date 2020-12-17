package com.example.backend.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String mobile1;

    @Column
    private String mobile2;

    @Column
    private String landLine;

    @Column
    @CreationTimestamp
    private Date joinedDate;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String status;

    @Column
    private int rating;

    @Column
    private String type;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Deals.class)
    @JoinColumn(name = "partnerId", referencedColumnName = "id")
    private List<Deals> deals = new ArrayList<>();


    public Person() {
    }

    public Person(String email, String password, String name) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Person(int id, String name, String mobile1, String mobile2, String landLine, Date joinedDate, String email, String password, String address, String status, int rating, String type, List<Deals> deals) {
        this.id = id;
        this.name = name;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.landLine = landLine;
        this.joinedDate = joinedDate;
        this.email = email;
        this.password = password;
        this.address = address;
        this.status = status;
        this.rating = rating;
        this.type = type;
        this.deals = deals;
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

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getLandline() {
        return landLine;
    }

    public void setLandline(String landline) {
        this.landLine = landline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Deals> getDeals() {
        return deals;
    }

    public void setDeals(List<Deals> deals) {
        this.deals = deals;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
