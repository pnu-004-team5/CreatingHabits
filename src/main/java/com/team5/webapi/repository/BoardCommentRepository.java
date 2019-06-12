package com.team5.webapi.repository;

import java.util.List;

import com.team5.webapi.model.BoardComment;
import com.team5.webapi.model.BoardDocument;
import com.team5.webapi.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardCommentRepository extends JpaRepository <BoardComment, Integer>  {
  public List<BoardComment> findAllByOrderByIdDesc();

  // @Modifying(clearAutomatically = true)
  // @Transactional
  // @Query(value = "UPDATE board_documents SET content = :content, video_url = :video_url WHERE id = :id", nativeQuery=true)
  // void updateBoardComment(@Param("id") int id, @Param("content") String content, @Param("video_url") String videoUrl);
}