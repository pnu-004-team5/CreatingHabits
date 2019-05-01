package com.team5.webapi.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "habits")
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habits_id_seq")
    @SequenceGenerator(name = "habits_id_seq", sequenceName = "habits_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private String memo;
    private String color;
    private Date fromDate;
    private Date toDate;
    private String completeDate;

    public Habit() {
    }

    public Habit(Integer id, String name, String memo, Date fromDate, Date toDate, String completeDate, String color) {
        this.id = id;
        this.name = name;
        this.memo = memo;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.completeDate = completeDate;
        this.color = color;
    }

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
        this.color = color;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getCompleteDate() {
        return this.completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s']", id, name);
    }
}