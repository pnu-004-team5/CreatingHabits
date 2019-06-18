package com.team5.webapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "journals")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journals_id_seq")
    @SequenceGenerator(name = "journals_id_seq", sequenceName = "journals_id_seq", allocationSize = 1)
    private Integer id;
    private Integer userId;
    private String content;
    private Date date;
    private String imageUrl;

    public Journal() {
    }

    public Journal(Integer id, String content, Date date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s']", id, content);
    }
}