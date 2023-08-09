/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Student {
    private String name,classes;
    private double math,physical,chemistry;

    public Student() {
    }

    public Student(String name, String classes, double math, double physical, double chemistry) {
        this.name = name;
        this.classes = classes;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }
    
    public double getAverage() {
        return (math + physical + chemistry) / 3;
    }
    
    public String getType() {
        if (getAverage() > 7.5) {
            return "A";
        }else if( getAverage() >= 6 && getAverage() <= 7.5) {
            return "B";
        }else if (getAverage() >= 4 && getAverage() < 6) {
            return "C";
        }else {
            return "D";
        }
    }
    
    public void display() {
        System.out.format("Name: %s\n"
                + "Classes: %s\n"
                + "AVG: %.2f\n"
                + "Type: %s\n", name, classes, getAverage(), getType());
    }
    
}
