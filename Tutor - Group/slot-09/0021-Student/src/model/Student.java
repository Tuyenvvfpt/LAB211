/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Student {

    //id, name, semester, course
    private String id, name;
    private int semester;
    private int course;

    public Student() {
    }

    public Student(String id, String name, int semester, int course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getCourseString() {
        String result = "";
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

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-10s", id,name, semester, getCourseString());
    }
    
    
}
