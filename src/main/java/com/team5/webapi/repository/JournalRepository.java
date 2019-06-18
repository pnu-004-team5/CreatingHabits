package com.team5.webapi.repository;

import java.util.Date;
import java.util.List;

import com.team5.webapi.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JournalRepository extends JpaRepository <Journal, Integer>  {
  public List<Journal> findAllByOrderByDateDesc();

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query(value = "UPDATE journals SET content = :content, image_url = :image_url, date = :date WHERE id = :id", nativeQuery=true)
  void updateJournal(@Param("id") int id, @Param("content") String content, @Param("image_url") String imageUrl, @Param("date") Date date);
}