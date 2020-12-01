package com.example.backend.models;

import jdk.jfr.Timestamp;
import org.springframework.data.annotation.CreatedDate;

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
    @CreatedDate
    @Timestamp
    private Date joinedDate;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private int dealCount;

    @Column
    private String status;

    @Column
    private int rating;

    @Column
    private String type;

//    @OneToMany(cascade = CascadeType.ALL, targetEntity = ItemPerson.class)
//    @JoinColumn(name = "personId", referencedColumnName = "id")
//    private List<ItemPerson> itemPersonList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Deals.class)
    @JoinColumn(name = "sellerdeal", referencedColumnName = "id")
    private List<Deals> person1 = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Deals.class)
    @JoinColumn(name = "buyerdeal", referencedColumnName = "id")
    private List<Deals> person2 = new ArrayList<>();

    public Person() {
    }

    public Person(String email, String password, String name) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Person(int id, String name, String mobile1, String mobile2, String landLine, Date joinedDate, String email, String password, String address, int dealCount, String status, int rating, String type, List<Deals> person1, List<Deals> person2) {
        this.id = id;
        this.name = name;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.landLine = landLine;
        this.joinedDate = joinedDate;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dealCount = dealCount;
        this.status = status;
        this.rating = rating;
        this.type = type;
        this.person1 = person1;
        this.person2 = person2;
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

//    public List<ItemPerson> getItemPersonList() {
//        return itemPersonList;
//    }
//
//    public void setItemPersonList(List<ItemPerson> itemPersonList) {
//        this.itemPersonList = itemPersonList;
//    }

    public List<Deals> getPerson1() {
        return person1;
    }

    public void setPerson1(List<Deals> person1) {
        this.person1 = person1;
    }

    public List<Deals> getPerson2() {
        return person2;
    }

    public void setPerson2(List<Deals> person2) {
        this.person2 = person2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDealCount() {
        return dealCount;
    }

    public void setDealCount(int dealCount) {
        this.dealCount = dealCount;
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
