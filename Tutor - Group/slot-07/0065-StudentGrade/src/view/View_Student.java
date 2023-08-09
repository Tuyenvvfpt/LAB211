/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageStudent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;

/**
 *
 * @author PHAM KHAC VINH
 */
public class View_Student {

    ManageStudent manage = new ManageStudent();

    void inputData() {
        while (true) {
            //input data
            String name = Utility.getString("Name: ", "Name must be letters or digits",
                     Utility.REGEX_STRING);
            String classes = Utility.getString("Classes: ", "Classes must be letters or digits",
                     Utility.REGEX_STRING);

            double math = Utility.getDouble("Math: ", "Math is less than equal ten",
                    "Maths is greater than equal zero", "Maths is digit", 0, 10);
            double chemistry = Utility.getDouble("chemistry: ", "chemistry is less than equal ten",
                    "chemistry is greater than equal zero", "chemistry is digit", 0, 10);
            double physical = Utility.getDouble("physical: ", "physical is less than equal ten",
                    "physical is greater than equal zero", "physical is digit", 0, 10);

            //create student
            Student student = manage.createStudent(name, classes, math, physical, chemistry);

            //add to list
            manage.addStudent(student);

            //check continue
            if (checkYesNo() == false) {
                break;
            }
        }

    }

    private boolean checkYesNo() {
        String result = Utility.getString("Do you want to enter more student information?(Y/N):",
                "Must input y or n", Utility.REGEX_YN);
        
        if (result.equalsIgnoreCase("y")) {
            return true;
        }else {
            return false;
        }
    }

    void displayStudentInformation() {
        List<Student> listStudent = manage.getListStudent();
        
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println("------ Student "+ (i+1) +" Info ------");
            listStudent.get(i).display();
        }
    }

    void displayClassification() {
        HashMap<String,Double> hashMap = new HashMap<>();
        hashMap = manage.getPercentTypeStudent();
        double sizeOfList = manage.getListStudent().size();
        
        System.out.println("--------Classification Info -----");
        //loop form first to last element in hashmap
        for (Map.Entry<String, Double> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            double val = entry.getValue().doubleValue();
            double percent = (val / sizeOfList) * 100;

              System.out.format("%s: %.1f", key, percent);
              System.out.println("%");
        }
        
        for (Map.Entry<String, Double> entry : hashMap.entrySet()) {
            
        }
    }

}
