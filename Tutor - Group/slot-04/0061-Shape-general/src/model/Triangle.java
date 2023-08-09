/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Triangle extends Shape {

    private double sideA, sideB, sideC;

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    
    
    
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double halfOfPerimeter = getPerimeter() / 2;
        double first = halfOfPerimeter - sideA;
        double second = halfOfPerimeter - sideB;
        double third = halfOfPerimeter - sideC;
        return Math.sqrt(halfOfPerimeter * first * second * third);
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.printf("Side A: %s\n"
                + "Side B: %s\n"
                + "Side C: %s\n"
                + "Area:%s\n"
                + "Perimeter:%s\n", sideA, sideB, sideC, getArea(), getPerimeter());
    }

}
