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
@Table(name = "board_documents")
public class BoardDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_documents_id_seq")
    @SequenceGenerator(name = "board_documents_id_seq", sequenceName = "board_documents_id_seq", allocationSize = 1)
    private Integer id;
    private Integer userId;
    private String videoUrl;
    private String content;
    private Date regdate;

    public BoardDocument() {
    }

    public BoardDocument(Integer id, String videoUrl, String content, Date regdate) {
        this.id = id;
        this.videoUrl = videoUrl;
        this.content = content;
        this.regdate = regdate;
    }

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
        this.userId = userId;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
        this.content = content;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
        this.regdate = regdate;
	}

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s']", id, content);
    }
}