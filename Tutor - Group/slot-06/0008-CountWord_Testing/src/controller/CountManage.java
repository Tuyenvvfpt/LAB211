/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author PHAM KHAC VINH
 */
public class CountManage {
    
    
    public static void countWord(String input) {
        if (input.trim().isEmpty()) {
            System.out.println("Input is empty !!!");
            return;
        }
        
        Hashtable<String, Integer> wordHashtable = new Hashtable<>();
        
        //tokenize string
        StringTokenizer tokenizer = new StringTokenizer(input);
        
        //loop from first to last token in tokenizer
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            
            //if token not exist in hashtable => put new value
            if (wordHashtable.containsKey(token) == false) {
                wordHashtable.put(token, 1);
            }
            
            //else renew value
            else {
                //lay ra gia tri cua key => word.get() => replace
                int newValue = wordHashtable.get(token) + 1;
                wordHashtable.replace(token, newValue);
            }
            


        }
        System.out.println(wordHashtable);
        
    }

    public static void countCharacter(String input) {
        Hashtable<Character, Integer> characterHashtable = new Hashtable<>();
        
        //tokenizer all character
        char[] charArray = input.toCharArray();
        
        //loop from first to last element in charArray
        for (int i = 0; i < charArray.length; i++) {
            char charAtIndex = charArray[i];
            //check character is whitespace
            if (Character.isWhitespace(charAtIndex)) {
                continue;
            }
            //if character at index i not exist in hashtable => put new 
            else if(characterHashtable.containsKey(charAtIndex) == false) {
                characterHashtable.put(charAtIndex, 1);
            }
            //else renew value
            else {
                int newValue = characterHashtable.get(charAtIndex) + 1;
                characterHashtable.replace(charAtIndex, newValue);
            }
        }
        System.out.println(characterHashtable);
        
    }
    
}
