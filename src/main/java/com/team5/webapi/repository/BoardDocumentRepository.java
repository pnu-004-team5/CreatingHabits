package com.team5.webapi.repository;

import java.util.List;

import com.team5.webapi.model.BoardDocument;
import com.team5.webapi.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardDocumentRepository extends JpaRepository <BoardDocument, Integer>  {
  public List<BoardDocument> findAllByOrderByIdDesc();

  // @Modifying(clearAutomatically = true)
  // @Transactional
  // @Query(value = "UPDATE habits SET complete_date = :completeDate WHERE id = :id", nativeQuery=true)
  // void done(@Param("id") int id, @Param("completeDate") String completeDate);
}