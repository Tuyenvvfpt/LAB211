/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Circle;
import model.Rectangle;
import model.Triangle;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        
        View_Shape view = new View_Shape();
        //input data
        view.inputData(circle, triangle, rectangle);
        
        //calculate and display
        view.calucate(circle, triangle, rectangle);
        
    }
}
