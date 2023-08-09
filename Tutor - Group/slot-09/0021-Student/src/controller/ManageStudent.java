/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Report;
import model.Student;

/**
 *
 * @author PHAM KHAC VINH
 */
public class ManageStudent {

    List<Student> list = new ArrayList<>();
    List<Report> listReport = new ArrayList<>();

    public List<Report> getListReport() {
        return listReport;
    }
    

    public ManageStudent() {
        list.add(new Student("1", "A", 1, 1));
        list.add(new Student("1", "A", 2, 2));
        list.add(new Student("1", "A", 3, 3));
        list.add(new Student("1", "A", 4, 1));
    }
    
    
    public List<Student> getList() {
        return list;
    }

    public boolean checkCreateStudent(String id, String name, int semester, int course) {
        //check duplicate => true:  return false || false: return true
        if (checkDuplicate(id,name ,semester, course)) {
            return false;
        } else {
            Student student = new Student(id, name, semester, course);
            list.add(student);
            return true;
        }
    }

    public boolean checkDuplicate(String id,String name ,int semester, int course) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(id)
                    && student.getSemester() == semester
                    && student.getCourse() == course
                    && student.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;

    }

    public String getStudentNameByID(String id) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student.getName();
            }
        }

        return null;
    }

    public List<Student> getStudentByName(String name) {
        List<Student> listSearch = new ArrayList<>();

        for (Student student : list) {
            if (student.getName().toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }

    public List<Student> getStudentByID(String id) {
        List<Student> listSearch = new ArrayList<>();
        
        //loop from first to last element in list
        for (Student student : list) {
            //if student has id equal to id ( parameter ) => add to listSearch
            if (student.getId().equalsIgnoreCase(id)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }

    public void removeStudent(Student student) {
        list.remove(student);
    }

    public boolean checkNotUpdate(String idUpdate, String nameUpdate, int semesterUpdate,
            int courseUpdate, Student student) {
        
        //check all properties of student equal to parameter 
        if (student.getId().equalsIgnoreCase(idUpdate) && 
                student.getName().equalsIgnoreCase(nameUpdate) &&
                student.getSemester() == semesterUpdate &&
                student.getCourse() == courseUpdate) {
            return true;
        }else {
            return false;
        }
    }

    public void updateAllName(String nameUpdate, String idUpdate) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(idUpdate)) {
                student.setName(nameUpdate);
            }
        }
    }

    public boolean checkExistReport(Student student) {
        for (Report report : listReport) {
            if (report.getId().equalsIgnoreCase(student.getId()) &&
                    report.getCourse() == student.getCourse()) {
                return true;
            }
        }
        return false;
    }

}
