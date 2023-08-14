/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Rectangle extends Shape {

    private double width, length;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public double getArea() {
        return (width * length);
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.format("Width: %s\n"
                + "Length: %s\n"
                + "Area: %s\n"
                + "Perimeter: %s\n", width, length, getArea(), getPerimeter());
    }

}
