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
        StringTokenizer tokenizer = new StringTokenizer(input, ",.[]{}<>#@$%^&*!/|() ");

        //loop from first to last token in tokenizer
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            String key = checkWordExist(token, wordHashtable);

            //check token exist in hashtable: exist => renew value
            //else => put new 
            if (key != null) {
                int newValue = wordHashtable.get(key) + 1;
                wordHashtable.replace(key, newValue);
            } else {
                wordHashtable.put(token, 1);
            }
        }
        System.out.println(wordHashtable);
    }

    private static String checkWordExist(String token, Hashtable<String, Integer> wordHashtable) {
        for (Map.Entry<String, Integer> entry : wordHashtable.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase(token)) {
                return key;
            }
        }
        
        
        return null;
    }

    public static void countCharacter(String input) {
        Hashtable<Character, Integer> characterHashtable = new Hashtable<>();

        //tokenizer all character
        char[] charArray = input.toCharArray();

        //loop from first to last element in charArray
        for (int i = 0; i < charArray.length; i++) {
            char charAtIndex = charArray[i];
            //check character is whitespace and special character
            if (!Character.isLetter(charAtIndex) && !Character.isDigit(charAtIndex)) {
                continue;
            } //if character at index i not exist in hashtable => put new 
            else {
                char key = checkCharacterExist(charAtIndex, characterHashtable);
                //if key = 0 => not exist => put new
                //else renew value
                if (key == 0) {
                    characterHashtable.put(charAtIndex, 1);
                } else {
                    int newValue = characterHashtable.get(key) + 1;
                    characterHashtable.replace(key, newValue);
                }
            }
        }
        System.out.println(characterHashtable);

    }

    private static char checkCharacterExist(char token,
            Hashtable<Character, Integer> characterHashtable) {
        for (Map.Entry<Character, Integer> entry : characterHashtable.entrySet()) {
            char key = entry.getKey();
            if (Character.toUpperCase(key) == Character.toUpperCase(token)) {
                return key;
            }
        }
        return 0;
    }

}
