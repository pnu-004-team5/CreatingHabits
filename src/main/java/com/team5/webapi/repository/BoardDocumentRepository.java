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
  
  // public List<BoardDocument> findByBoardByOrderByIdDesc(String board);
  @Query(value = "select * from board_documents where board = :board", nativeQuery = true)
  List<BoardDocument> findByBoardQueryNative(@Param("board") String board);

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query(value = "UPDATE board_documents SET content = :content, video_url = :video_url WHERE id = :id", nativeQuery=true)
  void updateBoardDocument(@Param("id") int id, @Param("content") String content, @Param("video_url") String videoUrl);
}