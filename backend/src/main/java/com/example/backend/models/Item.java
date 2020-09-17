package com.example.backend.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;


//    @OneToMany (mappedBy = "item",orphanRemoval = true )
//    private List<ItemPerson> itemPersonList = new ArrayList<ItemPerson>();

    public Item() {
    }

    public Item(int id, String name, List<ItemPerson> itemPersonList) {
        this.id = id;
        this.name = name;
//        this.itemPersonList = itemPersonList;
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

//    public List<ItemPerson> getItemPersonList() {
//        return itemPersonList;
//    }
//
//    public void setItemPersonList(List<ItemPerson> itemPersonList) {
//        this.itemPersonList = itemPersonList;
//    }
}
