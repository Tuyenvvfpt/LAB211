/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bo.ConvertBase;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            //1.	Required user choose the base number input ( example 1 is binary, 2 is decimal,  3 is hexadecimal)
            int baseInput = Utility.getInteger("Enter base number input(1: binary ;"
                    + " 2: decimal; 3: hexa): ",
                    "Wrong", 1, 3);
            //2.	Required user choose the base number out ( example 1 is binary, 2 is decimal,  3 is hexadecimal)
            int baseOutput = Utility.getInteger("Enter base number output(1:"
                    + " binary ; 2: decimal; 3: hexa): ",
                    "Wrong", 1, 3);
            //3.	Required user enter the input value;
            String value = Utility.getValue(baseInput);
            //4.	Program process and print output value;
            ConvertBase convert = new ConvertBase();
            convert.convertValue(baseInput, baseOutput, value);
        }
    }
}
