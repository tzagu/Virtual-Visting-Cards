package com.example.backend.models;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @UpdateTimestamp
    private Date date;

    @Column
    private int personId;

    @Column
    private String email;

    @Column
    private String activity;

    public Activity() {
    }

    public Activity(int id, Date date, int personId, String activity, String email) {
        this.id = id;
        this.date = date;
        this.personId = personId;
        this.activity = activity;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
