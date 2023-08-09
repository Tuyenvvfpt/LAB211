/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Circle;
import model.Rectangle;
import model.Triangle;

/**
 *
 * @author PHAM KHAC VINH
 */
public class View_Shape {

    void calucate(Circle circle, Triangle triangle, Rectangle rectangle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

    void display(Circle circle, Triangle triangle, Rectangle rectangle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void inputData(Circle circle, Triangle triangle, Rectangle rectangle) {
        System.out.println("=====Calculator Shape Program=====");

        //input rectangle 
        //loop until width <= length
        while (true) {
            double width = getDouble("Please input side width of Rectangle: ", "Width must be"
                    + "digits");

            double length = getDouble("Please input length of Rectangle: ", "Length must be"
                    + "digits");
            //if width <= length => break
            //else tell error
            if (width <= length) {
                rectangle.setWidth(width);
                rectangle.setLength(length);
                break;
            } else {
                System.out.println("Width must be less than length !!!");
            }
        }

        //input circle
        double radius = getDouble("radius: ", "Radius must be digit");
        circle.setRadius(radius);
        //input triangle
        //loop until 3 side be corresponding
        while (true) {
            double sideA = getDouble("Side A: ", "Side must be digits");
            double sideB = getDouble("Side B: ", "Side must be digits");
            double sideC = getDouble("Side C: ", "Side must be digits");
            
            //if it correspoding => break
            //else tell error
            if ((sideA + sideB > sideC) &&  (sideC + sideB > sideA) &&  
                    (sideA + sideC > sideB)) {
                triangle.setSideA(sideA);
                triangle.setSideB(sideB);
                triangle.setSideC(sideC);
                break;
            }else {
                System.out.println("3 side is not corresponding");
            }
        }

    }

    public static double getDouble(String message, String error) {
        //loop unti get number double
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                double number1 = scanner.nextDouble();
                //if number in range => return number
                //else => tell error
                if (number1 <= 0) {
                    System.out.println("Number must greater than 0 !!");
                } else {
                    return number1;
                }

            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

}
