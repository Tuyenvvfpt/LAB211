/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Student;

/**
 *
 * @author PHAM KHAC VINH
 */
public class ManageStudent {
    private List<Student> listStudent = new ArrayList<>();
    
    //mn mong muon import tat cac thu vien, hay cai gi can toi
    // ctrl + shift + i

    public List<Student> getListStudent() {
        return listStudent;
    }

    public void addStudent(Student student) {
        listStudent.add(student);
    }

    public void sort() {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
    
    
}
