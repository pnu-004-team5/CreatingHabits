package com.team5.webapi.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team5.webapi.model.BoardComment;
import com.team5.webapi.model.BoardDocument;
import com.team5.webapi.repository.BoardCommentRepository;
import com.team5.webapi.repository.BoardDocumentRepository;

@RestController
public class BoardController {
  @Autowired
  private BoardDocumentRepository boardDocumentRepository;
  @Autowired
  private BoardCommentRepository boardCommentRepository;

  @RequestMapping(value = "/board/documents", method = { RequestMethod.GET }, produces = "application/json")
  public List<BoardDocument> getBoardDocuments(BoardDocument boardDocument) {
    List<BoardDocument> boardDocuments;
    
    if(boardDocument.getBoard().equals("total"))
      boardDocuments = boardDocumentRepository.findAllByOrderByIdDesc();
    else 
      boardDocuments = boardDocumentRepository.findByBoardQueryNative(boardDocument.getBoard());

    return boardDocuments;
  }


  @RequestMapping(value = "/board/document", method = { RequestMethod.POST }, produces = "application/json")
  public BoardDocument createBoardDocument(BoardDocument boardDocument) {
    

    BoardDocument boardDocumentData = boardDocumentRepository.save(boardDocument);

    return boardDocumentData;
  }

  @RequestMapping(value = "/board/document", method = { RequestMethod.PUT })
  public BoardDocument update(BoardDocument boardDocument) {
    String videoUrl;
    BoardDocument boardDocumentData;

    if(boardDocument.getVideoUrl() == null) {
      boardDocumentData = boardDocumentRepository.findById(boardDocument.getId()).get();
      videoUrl = boardDocumentData.getVideoUrl();
    } else {
      videoUrl = boardDocument.getVideoUrl();
    }
    System.out.println(boardDocument.getId());
    System.out.println(boardDocument.getContent());
    boardDocumentRepository.updateBoardDocument(boardDocument.getId(), boardDocument.getContent(), videoUrl);
    
    boardDocumentData = boardDocumentRepository.findById(boardDocument.getId()).get();
    
    return boardDocumentData;
  }

  @RequestMapping(value = "/board/document", method = { RequestMethod.DELETE })
  public BoardDocument deleteHabit(BoardDocument boardDocument) {
    boardDocumentRepository.delete(boardDocument);

    return boardDocument;
  }





  @RequestMapping(value = "/board/comments", method = { RequestMethod.GET }, produces = "application/json")
  public List<BoardComment> getBoardComments(BoardComment boardComment) {
    List<BoardComment> boardComments = boardCommentRepository.findAllByOrderByIdDesc();
    System.out.println("--------------------------------");
    System.out.println(boardComments.get(0).getContent());
    return boardComments;
  }


  @RequestMapping(value = "/board/comment", method = { RequestMethod.POST }, produces = "application/json")
  public BoardComment createBoardDocument(BoardComment boardComment) {
    

    return boardCommentRepository.save(boardComment);
  }



}