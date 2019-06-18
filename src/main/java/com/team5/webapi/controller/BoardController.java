package com.team5.webapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team5.webapi.model.BoardComment;
import com.team5.webapi.model.BoardDocument;
import com.team5.webapi.model.Habit;
import com.team5.webapi.repository.BoardCommentRepository;
import com.team5.webapi.repository.BoardDocumentRepository;
import com.team5.webapi.repository.HabitRepository;;

@RestController
public class BoardController {
  @Autowired
  private BoardDocumentRepository boardDocumentRepository;
  @Autowired
  private BoardCommentRepository boardCommentRepository;

  @RequestMapping(value = "/board/documents", method = { RequestMethod.GET }, produces = "application/json")
  public List<BoardDocument> getBoardDocuments(BoardDocument boardDocument) {
    List<BoardDocument> boardDocuments;
    System.out.println("-----------------------");
    System.out.println(boardDocument.getBoard());
    if(boardDocument.getBoard().equals("total"))
      boardDocuments = boardDocumentRepository.findAllByOrderByIdDesc();
    else 
      boardDocuments = boardDocumentRepository.findByBoardQueryNative(boardDocument.getBoard());

    return boardDocuments;
  }


  @RequestMapping(value = "/board/document", method = { RequestMethod.POST }, produces = "application/json")
  public BoardDocument createBoardDocument(BoardDocument boardDocument) {
    // boardDocument.setContent("안녕하세요");
    // boardDocument.setVideoUrl();

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
    // boardDocument.setContent("안녕하세요");
    // boardDocument.setVideoUrl();

    BoardComment boardCommentData = boardCommentRepository.save(boardComment);

    return boardCommentData;
  }





  // @RequestMapping(value = "/habit", method = { RequestMethod.POST })
  // public Habit addHabit(Habit habit) {
  //   ArrayList<String> colors = new ArrayList<>();
  //   colors.add("#e57373");
  //   colors.add("#f06292");
  //   colors.add("#ba68c8");
  //   colors.add("#9575cd");
  //   colors.add("#4dd0e1");
  //   colors.add("#81c784");
  //   colors.add("#90a4ae");
  //   colors.add("#ff8a65");
  //   Random rand = new Random();
  //   int n = rand.nextInt(colors.size());
  //   habit.setColor(colors.get(n));
  //   habit.setCompleteDate("[]");

  //   Habit habitData = habitRepository.save(habit);

  //   return habitData;
  // } 

  // @RequestMapping(value = "/habit", method = { RequestMethod.PUT })
  // public Habit doneHabit(int id, String targetDate) {
  //   Habit habitData = habitRepository.findById(id).get();
    
  //   try {
  //     JSONArray completeDateJsonArr = new JSONArray(habitData.getCompleteDate());
  //     int found = -1;
  //     for(int i = 0; i < completeDateJsonArr.length(); i++) {
  //       if(completeDateJsonArr.getString(i).equals(targetDate)) {
  //         found = i;
  //       }
  //     }
      
  //     if(found > -1)
  //       completeDateJsonArr.remove(found);
  //     else
  //       completeDateJsonArr.put(targetDate);

  //     habitRepository.done(id, completeDateJsonArr.toString());
  //     habitData.setCompleteDate(completeDateJsonArr.toString());
  //   } catch(Exception e) {
  //     e.printStackTrace();
  //   }

  //   return habitData;
  // }

}