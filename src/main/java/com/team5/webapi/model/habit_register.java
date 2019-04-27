package com.team5.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;

@Entity
@Table(name = "habit_register")
public class habit_register {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="habit_register_habit_num_seq")
    @SequenceGenerator(name="habit_register_habit_num_seq", sequenceName="habit_register_habit_num_seq", allocationSize=1)
    
    private long habit_num;
	private String id;
	private String habit_title;
    private int date_start_year;
    private int date_start_month;
    private int date_start_day;
    private int date_end_year;
    private int date_end_month;
    private int date_end_day;
    private ArrayList<Boolean> check;
    private String habit_contents;
    private boolean push_alarm;
    

    
	public habit_register() {
	}

	public habit_register(long habit_num, String id, String habit_title,
			int date_start_year,int date_start_month,int date_start_day,
			int date_end_year, int date_end_month, int date_end_day, ArrayList<Boolean> check,
			String habit_contents, boolean push_alarm) 
	{
		this.habit_num = habit_num;
		this.id = id;
		this.habit_title = habit_title;
		this.date_start_year = date_start_year;
		this.date_start_month = date_start_month;
		this.date_start_day = date_start_day;
		this.date_end_year = date_end_year;
		this.date_end_month = date_end_month;
		this.date_end_day = date_end_day;
		this.check = check;
		this.habit_contents = habit_contents;
		this.push_alarm = push_alarm;
	}
    
	public ArrayList<Boolean> getCheck() {
		return check;
	}

	public int getDate_start_year() {
		return date_start_year;
	}

	public void setDate_start_year(int date_start_year) {
		this.date_start_year = date_start_year;
	}

	public int getDate_start_month() {
		return date_start_month;
	}

	public void setDate_start_month(int date_start_month) {
		this.date_start_month = date_start_month;
	}

	public int getDate_start_day() {
		return date_start_day;
	}

	public void setDate_start_day(int date_start_day) {
		this.date_start_day = date_start_day;
	}

	public int getDate_end_year() {
		return date_end_year;
	}

	public void setDate_end_year(int date_end_year) {
		this.date_end_year = date_end_year;
	}

	public int getDate_end_month() {
		return date_end_month;
	}

	public void setDate_end_month(int date_end_month) {
		this.date_end_month = date_end_month;
	}

	public int getDate_end_day() {
		return date_end_day;
	}

	public void setDate_end_day(int date_end_day) {
		this.date_end_day = date_end_day;
	}


	public void setCheck(ArrayList<Boolean> check) {
		this.check = check;
	}

	public String getHabit_contents() {
		return habit_contents;
	}

	public void setHabit_contents(String habit_contents) {
		this.habit_contents = habit_contents;
	}

	public boolean isPush_alarm() {
		return push_alarm;
	}

	public void setPush_alarm(boolean push_alarm) {
		this.push_alarm = push_alarm;
	}

	public long getHabit_num() {
		return habit_num;
	}

	public void setHabit_num(long habit_num) {
		this.habit_num = habit_num;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHabit_title() {
		return habit_title;
	}

	public void setHabit_title(String habit_title) {
		this.habit_title = habit_title;
	}

	@Override
	public String toString() {
		return  "habit_register[habit_num=" + habit_num + ", id=" + id + ", habit_title=" 
				+ habit_title + ", date_start_year=" + date_start_year + ", date_start_month=" 
				+ date_start_month + ", date_start_day=" + date_start_day + "date_end_year=" 
				+ date_end_year + ", date_end_month=" + date_end_month + ", date_end_day=" 
				+ date_end_day + ", check=" + check + ", habit_contents=" + habit_contents + ", push_alarm="
				+ push_alarm + "]";
	}
}
