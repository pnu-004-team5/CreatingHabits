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
@Table(name = "board_comments")
public class BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_comments_id_seq")
    @SequenceGenerator(name = "board_comments_id_seq", sequenceName = "board_comments_id_seq", allocationSize = 1)
    private Integer id;
    private Integer userId;
    private Integer documentId;
    private String content;
    private Date date;

    public BoardComment() {
    }

    public BoardComment(Integer id, Integer userId, String content, Date date) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.date = date;
    }

    public Integer getId() {
            return this.id;
    }

    public void setId(int id) {
    this.id = id;
    }

    public Integer getDocumentId() {
            return this.documentId;
    }

    public void setDocumentId(int documentId) {
    this.documentId = documentId;
    }

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
                this.userId = userId;
	}

	public String getContent() {
		return this.content;
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

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s']", id, content);
    }
}