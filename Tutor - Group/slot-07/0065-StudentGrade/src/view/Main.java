/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Main {
    public static void main(String[] args) {
        View_Student view = new View_Student();
        //input data
        view.inputData();
        
        //display student information
        view.displayStudentInformation();
        
        //display classification infomation
        view.displayClassification();
        
    }
}
