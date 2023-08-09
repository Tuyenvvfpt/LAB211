/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageStudent;
import model.Student;

/**
 *
 * @author PHAM KHAC VINH
 */
public class View_Student {

    ManageStudent manage = new ManageStudent();

    /**
     * This function use to input Student information
     */
    void inputStudent() {
        System.out.println("====== Collection Sort Program ======");
        while (true) {
            System.out.println("Please input student information ");
            //input information
            String name = Utility.getString("Name: ", "Name must be letter", Utility.REGEX_NAME);
            String classes = Utility.getString("Classes: ", "Classes must be letter or digit",
                    Utility.REGEX_CLASSES);
            float mark = Utility.getFloat("Mark: ", "Mark must be real number", 0, Float.MAX_VALUE);

            //create instance
            Student student = new Student(name, mark, classes);

            //add to list
            manage.addStudent(student);
            
            //continue ? 
            //if checkYesNo = false => user don't want continue => break
            if (!checkYesNo()) {
                break;
            }
        }

    }

    void sortStudent() {
        manage.sort();
    }

    void displayStudent() {
        for (int i = 0; i < manage.getListStudent().size(); i++) {
            System.out.println("-------------Student"+(i+1)+"-------------");
            System.out.println(manage.getListStudent().get(i));
        }
    }

    private boolean checkYesNo() {
        String result = Utility.getString("Do you want to enter more student information?(Y/N):"
                , "Must be Y or N", Utility.REGEX_YN);
        
        //if result = "y" ( case sensitive ) => return true;
        //else return false;
//        if (result.equalsIgnoreCase("y")) {
//            return true;
//        }else {
//            return false;
//        }
        return result.equalsIgnoreCase("y");
        
    }

}
