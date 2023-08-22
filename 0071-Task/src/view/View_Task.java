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

    void add() {
        //input properties
        System.out.println("------------Add Task---------------");
        String requirement = Utility.getRequirementName();
        int taskType = Utility.getTaskType();
        String date = Utility.getDate();
        double from = Utility.getFrom();
        double to = Utility.getTo(from);
        String assignee = Utility.getAssignee();
        String reviewer = Utility.getReviewer();

        //add Task 
        int result = bo.addTask(requirement, taskType, date, from, to, assignee, reviewer);

        if (result == -1) {
            System.out.println("Overlaps task");
        } else {
            System.out.println("Add successful");
        }
    }

    void delete() {
        int idInput = Utility.getInt("Enter id: ", "Wrong",
                "Wrong", "Wrong", 0, Integer.MAX_VALUE);

        if (bo.deleteTask(idInput) == true) {
            System.out.println("Delete successful!!");
        } else {
            System.out.println("NOT FOUND TASK !!");
        }
    }

    void show() {

        System.out.println("------------Task List---------------");
        System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "id", "requirement", "taskType", "date",
                "time", "assignee", "reviewer");
        for (Task task : bo.getDataTask()) {
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

}
