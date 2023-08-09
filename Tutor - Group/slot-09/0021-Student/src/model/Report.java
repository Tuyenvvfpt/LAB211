/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Report {
    private String id;
    private String name;
    private int course;
    private int totalCourse;
    
    
     /**
     * @return id
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * create a report with parameter
     * @param id
     * @param name
     * @param course
     * @param totalCourse 
     */
    public Report(String id, String name, int course, int totalCourse) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.totalCourse = totalCourse;
    }
/**
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * @return result
     */
    public String getCourseName() {
        String result = null;
        switch (course) {
            case 1:
                result = "Java";
                break;
            case 2:
                result = ".Net";
                break;
            case 3:
                result = "C/C++";
                break;

        }

        return result;
    }

    public void setName(String name) {
        this.name = name;
    }
/**
     * @return course
     */
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
/**
     * @return totalCourse
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-10s | %-10s", name, getCourseName(), totalCourse);
    }
    
}
