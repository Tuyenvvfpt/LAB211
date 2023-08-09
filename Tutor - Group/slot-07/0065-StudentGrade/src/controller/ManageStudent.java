/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Student;

/**
 *
 * @author PHAM KHAC VINH
 */
public class ManageStudent {

    List<Student> listStudent = new ArrayList<>();

    public List<Student> getListStudent() {
        return listStudent;
    }

    public Student createStudent(String name, String classes, double math,
            double physical, double chemistry) {
        Student student = new Student(name, classes, math, physical, chemistry);
        return student;
    }

    public void addStudent(Student student) {
        listStudent.add(student);
    }

    public HashMap<String, Double> getPercentTypeStudent() {
        HashMap<String, Double> hashMap = new HashMap<>();
        hashMap.put("A", 0.0);
        hashMap.put("B", 0.0);
        hashMap.put("C", 0.0);
        hashMap.put("D", 0.0);

        //loop from first to last element of listStudent
        for (Student student : listStudent) {
            double value = hashMap.get(student.getType()).doubleValue() + 1;
            hashMap.replace(student.getType(), value);
        }
        return hashMap;
    }

}
