package com.team5.webapi.repository;

import java.util.List;

import com.team5.webapi.model.Account_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository <Account_info, Integer> {

    @Query(value="SELECT *FROM account_info WHERE last_name=?1", nativeQuery=true)
    List<Account_info> getPersonInfoByLastName(String LastName);

    @Query(value="SELECT *FROM account_info WHERE first_name=?1 AND email=?2", nativeQuery=true)
    List<Account_info> findByFirstNameAndEmail(String firstName, String email);

}