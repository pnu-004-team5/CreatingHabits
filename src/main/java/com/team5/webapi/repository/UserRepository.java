package com.team5.webapi.repository;

import javax.transaction.Transactional;

import com.team5.webapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

  public User findByEmail(String email);

  public User findByEmailAndPassword(String email, String password);

  public User findByAuthKey(String authKey);

  @Transactional
  public int deleteByEmail(String email);

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query(value = "UPDATE users SET auth = :auth WHERE id = :id", nativeQuery = true)
  void authEmail(@Param("id") int id, @Param("auth") boolean auth);

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query(value = "UPDATE users SET name = :name, email = :email, password = :password, phone = :phone, introduce = :introduce WHERE id = :id", nativeQuery = true)
  void updateUser(@Param("id") int id, @Param("name") String name, @Param("email") String email,
      @Param("password") String password, @Param("phone") String phone, @Param("introduce") String introduce);
}