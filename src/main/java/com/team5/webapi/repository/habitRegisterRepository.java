package com.team5.webapi.repository;

import com.team5.webapi.model.habit_register;

import org.springframework.data.jpa.repository.JpaRepository;

public interface habitRegisterRepository extends JpaRepository <habit_register, Integer>  {

}