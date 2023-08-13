/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bo.ConvertBase;
import util.Utility;

/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {

        //choose the base number input
        int baseInput = Utility.getInteger("Enter base number input (1:2 ; 2:10 ; 3:16): ",
                "Wrong", 1, 3);
        //choose the base number output
        int baseOutput = Utility.getInteger("Enter base number output (1:2 ; 2:10 ; 3:16): ",
                "Wrong", 1, 3);
        //enter the input value
        String value = Utility.getValue(baseInput);
        //program process and print output value
        ConvertBase convert = new ConvertBase();
        convert.convertValue(baseInput, baseOutput, value);
    }
}
