/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageTask;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Task;

/**
 *
 * @author PHAM KHAC VINH
 */
public class View_Task {
    ManageTask manage = new ManageTask();
    
    
    void inputTask() {
        //input properties
        System.out.println("------------Add Task---------------");
        String requirement = getRequirementName();
        int taskType = getTaskType(); 
        String date = getDate();
        double from = getFrom();
        double to = getTo(from);
        String assignee = getAssignee();
        String reviewer = getReviewer();
        
        //add Task 
        int result = manage.addTask(requirement, taskType, date, from, to, assignee, reviewer);
        
        //if result = -1 => overlaps task
        if (result == -1) {
            System.out.println("Overlaps task");
        }
        // not equal -1 => add successfull
        else {
            System.out.println("Add successful");
        }
    }

    private String getRequirementName() {
        String requirement = Utility.getString("Requirement Name: ", "Requirement "
                + "Name must be letters or digits", Utility.REGEX_STRING);
        return requirement;
    }

    private int getTaskType() {
        int result = Utility.getInt("Enter task type: ", "It must be from 1-4",
                "It must be from 1-4", "It must be digits", 1, 4);
        return result;
    }
    
     private String getDate() {
        String date = Utility.getDate("Enter date: ", "date must be format dd-MM-yyyy"
                , "Date does not exist", "Date must be greater or equal to current date");
        return date;
    }

    private double getFrom() {
        double from = Utility.getDouble("Enter from: ","Wrong", "Wrong","Wrong", 8, 17);
        return from;
    }

    private double getTo(double from) {
        double to = Utility.getDouble("Enter to: ","Wrong", "Wrong","Wrong", from + 0.5, 17.5);
        return to;
    }

    private String getAssignee() {
        String assignee = Utility.getString("Enter assignee: ",  "Wrong", Utility.REGEX_STRING);
        return assignee;
    }

    private String getReviewer() {
        String reviewer = Utility.getString("Enter reviewer: ",  "Wrong", Utility.REGEX_STRING);
        return reviewer;
    }

    void deleteTask() {
        int idInput = Utility.getInt("Enter id: ", "Wrong", "Wrong", "Wrong", 0, Integer.MAX_VALUE);
        
        for (Task task : manage.getListTask()) {
            //if task has id equal to idInput => remove
            if (task.getId() == idInput) {
                manage.getListTask().remove(task);
                System.out.println("Delete successfull !!");
                return;
            }
        }
        System.out.println("NOT FOUND TASK !!");
    }
    
     void displayTask() {
        if (manage.getListTask().size() == 0) {
            System.out.println("LIST IS EMPTY");
            return;
        }
        //sort by date
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Collections.sort(manage.getListTask(), new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                Date dateO1 = null;
                Date dateO2 = null;
                try {
                     dateO1 = dateFormat.parse(o1.getDate());
                     dateO2 = dateFormat.parse(o2.getDate());
                } catch (ParseException ex) {
                    Logger.getLogger(View_Task.class.getName()).log(Level.SEVERE, null, ex);
                }
                return (int) (dateO1.getTime() - dateO2.getTime());
            }
        });
        
        //display
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name","TaskType",
                "Date","Time", "Assignee", "Reviewer");
        for (Task task : manage.getListTask()) {
            System.out.println(task);
        }
    }

    
}
