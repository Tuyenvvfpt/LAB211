/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Task {

    private static int auto_Increment = 1;
    private int id;
    private String requirementName;
    private int taskType;
    private String date;
    private double from, to;
    private String assignee, reviewer;

    public Task(String requirementName, int taskType, String date, double from, double to, String assignee, String reviewer) {
        this.id = auto_Increment++;
        this.requirementName = requirementName;
        this.taskType = taskType;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getTaskTypeString() {
        String result = "";
        switch (taskType) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";

                break;
            case 3:
                result = "Design";

                break;
            case 4:
                result = "Review";

                break;

        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s", id, requirementName, getTaskTypeString(),
                date, to - from, assignee, reviewer);
    }
}
