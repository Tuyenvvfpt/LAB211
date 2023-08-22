/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bo.TaskBO;
import entity.Task;
import util.Utility;

/**
 *
 * @author ADMIN
 */
class View_Task {

    TaskBO bo = new TaskBO();

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
        int result = bo.addTask(requirement, taskType, date, from, to, assignee, reviewer);

        if (result == -1) {
            System.out.println("Overlaps task");
        } else {
            System.out.println("Add successful");
        }
    }

    void deleteTask() {
        int idInput = Utility.getInt("Enter id: ", "Wrong",
                "Wrong", "Wrong", 0, Integer.MAX_VALUE);

        for (Task task : bo.getList()) {
            //if task has id equal to idInput => remove
            if (task.getId() == idInput) {
                bo.getList().remove(task);
                System.out.println("Delete successfull !!");
                return;
            }
        }
        System.out.println("NOT FOUND TASK !!");
    }

    void displayTask() {

        System.out.println("------------Task List---------------");
        System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "id", "requirement", "taskType", "date",
                "time", "assignee", "reviewer");
        for (Task task : bo.getList()) {
            int id = task.getId();
            String taskType = task.getTaskTypeString();
            String requirement = task.getRequirementName();
            String date = task.getDate();
            double time = task.getPlanTo() - task.getPlanFrom();
            String assignee = task.getAssignee();
            String reviewer = task.getReviewer();

            System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                    id, requirement, taskType, date, time, assignee, reviewer);

//            System.out.println(task);
        }
    }

    private String getRequirementName() {
        String requirement = Utility.getString("Requirement Name: ",
                "Requirement Name must be letters or digits",
                Utility.REGEX_STRING);
        return requirement;
    }

    private int getTaskType() {
        int result = Utility.getInt("Enter task type: ",
                "It must be from 1-4",
                "It must be from 1-4",
                "It must be digits", 1, 4);
        return result;
    }

    private String getDate() {
        String date = Utility.getDate("Enter date: ",
                "date must be format dd-MM-yyyy",
                "Date does not exist");
        return date;
    }

    private double getFrom() {
        double from = Utility.getDouble("Enter from: ", "Wrong",
                "Wrong", "Wrong",
                8, 17);  //de bai co
        return from;
    }

    private double getTo(double from) {
        double to = Utility.getDouble("Enter to: ",
                "Wrong", "Wrong", "Wrong",
                from + 0.5, 17.5);
        return to;
    }

    private String getAssignee() {
        String assignee = Utility.getString("Enter assignee: ",
                "Wrong",
                Utility.REGEX_STRING);
        return assignee;
    }

    private String getReviewer() {
        String reviewer = Utility.getString("Enter reviewer: ",
                "Wrong",
                Utility.REGEX_STRING);
        return reviewer;
    }

}
