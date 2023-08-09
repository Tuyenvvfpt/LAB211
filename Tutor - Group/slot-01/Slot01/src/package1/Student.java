/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package1;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Student {
    //attribute - properties
    //id tu dong tang
    public static int auto_Increment = 1;
    static int id;
    static String name;

    public Student(String name) {
        this.id = auto_Increment++;
        this.name = name;
    }
    
    
    public static void display() {
        System.out.println(id + "\t" + name);
        
    }
    
}
