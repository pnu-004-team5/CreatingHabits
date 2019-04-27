package com.team5.webapi.repository;

import com.team5.webapi.model.Account_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account_info, Integer> {
}