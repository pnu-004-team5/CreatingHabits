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

import com.team5.webapi.model.Journal;
import com.team5.webapi.repository.JournalRepository;;

@RestController
public class JournalController {
  @Autowired
  private JournalRepository journalRepository;

  @RequestMapping(value = "/journals", method = { RequestMethod.GET }, produces = "application/json")
  public List<Journal> getMyJournals(Journal journal) {
    List<Journal> journalList = journalRepository.findAllByOrderByDateDesc();

    return journalList;
  }

  @RequestMapping(value = "/journal", method = { RequestMethod.POST })
  public Journal createJournal(Journal journal) {
    Journal journalData = journalRepository.save(journal);

    return journalData;
  }

  @RequestMapping(value = "/journal", method = { RequestMethod.PUT })
  public Journal updateJournal(Journal journal) {
    System.out.println("----------------");
    System.out.println(journal.getId());
    System.out.println(journal.getContent());
    System.out.println(journal.getImageUrl());
    System.out.println(journal.getDate());
    System.out.println("----------------");
    

    journalRepository.updateJournal(journal.getId(), journal.getContent(), journal.getImageUrl(), journal.getDate());
    Journal journalData = journalRepository.findById(journal.getId()).get();
    // try {
    //   JSONArray completeDateJsonArr = new JSONArray(habitData.getCompleteDate());
    //   int found = -1;
    //   for(int i = 0; i < completeDateJsonArr.length(); i++) {
    //     if(completeDateJsonArr.getString(i).equals(targetDate)) {
    //       found = i;
    //     }
    //   }
      
    //   if(found > -1)
    //     completeDateJsonArr.remove(found);
    //   else
    //     completeDateJsonArr.put(targetDate);

    //     journalRepository.done(id, completeDateJsonArr.toString());
    //   habitData.setCompleteDate(completeDateJsonArr.toString());
    // } catch(Exception e) {
    //   e.printStackTrace();
    // }

    return journalData;
  }

  @RequestMapping(value = "/journal", method = { RequestMethod.DELETE })
  public Journal deleteHabit(Journal journal) {
    journalRepository.delete(journal);

    return journal;
  }
}