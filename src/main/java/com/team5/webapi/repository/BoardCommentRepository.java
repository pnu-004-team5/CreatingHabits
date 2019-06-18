package com.team5.webapi.repository;

import java.util.List;

import com.team5.webapi.model.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCommentRepository extends JpaRepository <BoardComment, Integer>  {
  public List<BoardComment> findAllByOrderByIdDesc();
}