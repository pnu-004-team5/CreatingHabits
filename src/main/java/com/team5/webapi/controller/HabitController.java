package com.team5.webapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team5.webapi.model.Habit;
import com.team5.webapi.repository.HabitRepository;

@RestController
public class HabitController {
  @Autowired
  private HabitRepository habitRepository;

  @RequestMapping(value = "/habits", method = { RequestMethod.GET }, produces = "application/json")
  public List<Habit> getMyHabits(Habit habit) {
    return habitRepository.findAllByOrderByIdAsc();
  }

  @RequestMapping(value = "/habit", method = { RequestMethod.POST })
  public Habit addHabit(Habit habit) {
    ArrayList<String> colors = new ArrayList<>();
    colors.add("#e57373");
    colors.add("#f06292");
    colors.add("#ba68c8");
    colors.add("#9575cd");
    colors.add("#4dd0e1");
    colors.add("#81c784");
    colors.add("#90a4ae");
    colors.add("#ff8a65");
    int n = new Random().nextInt(colors.size());
    habit.setColor(colors.get(n));
    habit.setCompleteDate("[]");

    return habitRepository.save(habit);
  }

  @RequestMapping(value = "/habit", method = { RequestMethod.PUT })
  public Habit doneHabit(int id, String targetDate) {
    Habit habitData = habitRepository.findById(id).get();
    
    try {
      JSONArray completeDateJsonArr = new JSONArray(habitData.getCompleteDate());
      int found = -1;
      for(int i = 0; i < completeDateJsonArr.length(); i++) {
        if(completeDateJsonArr.getString(i).equals(targetDate)) {
          found = i;
        }
      }
      
      if(found > -1)
        completeDateJsonArr.remove(found);
      else
        completeDateJsonArr.put(targetDate);

      habitRepository.done(id, completeDateJsonArr.toString());
      habitData.setCompleteDate(completeDateJsonArr.toString());
    } catch(Exception e) {
      return habitData;
    }

    return habitData;
  }

  @RequestMapping(value = "/habit", method = { RequestMethod.DELETE })
  public Habit deleteHabit(Habit habit) {
    habitRepository.delete(habit);

    return habit;
  }
}