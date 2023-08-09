package view;

import controller.CountManage;
import util.Utility;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PHAM KHAC VINH
 */
public class Main {
    public static void main(String[] args) {
        //input string
        String input = Utility.getString("Enter string: ", "Wrong");
        
        //count word 
        CountManage.countWord(input);
        //count character
        
        CountManage.countCharacter(input);
    }
    
}
