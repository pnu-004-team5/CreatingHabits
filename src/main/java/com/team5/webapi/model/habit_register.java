package com.team5.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "habit_register")
public class habit_register {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="habit_register_habit_num_seq")
    @SequenceGenerator(name="habit_register_habit_num_seq", sequenceName="habit_register_habit_num_seq", allocationSize=1)
    
	private String id;
	private String habit_title;


	public habit_register() {
	}

	public habit_register(String id, String habit_title) {
		this.id = id;
		this.habit_title = habit_title;
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
		return String.format("habit_register[id='%s', habit_title='%s']", id, habit_title);
	}
}
