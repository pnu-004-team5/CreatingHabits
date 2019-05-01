package com.team5.webapi.repository;

import com.team5.webapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer>  {
  
}