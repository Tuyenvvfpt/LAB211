/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p0008;

import java.util.HashMap;

/**
 *
 * @author asus
 */
public class P0008 {

    public HashMap<String, Integer> countWord(String n) {
        HashMap<String, Integer> count = new HashMap<>();
        //tach chuoi thanh cac tu
        String[] w = n.split("[!@#$%^&*()-_=+,./< >?]");
        //duyet mang cac tu da duoc tach
        for (String p : w) {
            //neu tu da ton tai trong count => tang gia tri dem them 1
            if (count.containsKey(p)) {
                count.put(p, count.get(p) + 1);
                //neu chua ton tai, them tu vao count voi gia tri dem la 1
            } else {
                count.put(p, 1);
            }
        }
        return count;
    }

    public HashMap<Character, Integer> countChar(String n) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            //duyet qua tung ky tu trong chuoi, xem co phai SO hay CHU khong
            if (Character.isDigit(n.charAt(i)) || Character.isLetter(n.charAt(i))) {
                //neu chu cai hoac so ton tai trong count thi tang gia tri dem them 1
                if (count.containsKey(n.charAt(i))) {
                    count.put(n.charAt(i), count.get(n.charAt(i)) + 1);
                    //neu chua ton tai, them ky tu vao count voi gia tri dem la 1
                } else {
                    count.put(n.charAt(i), 1);
                }
            }
        }
        return count;
    }

    /**
     * nhan vao doi tuong HashMap du la countW hay countC
     * @param count 
     */
    public void print(HashMap<?, ?> count) {
        StringBuilder st = new StringBuilder("{");
        count.forEach((key, value) -> {
            //neu st khong rong thi them ", "
            if (st.length() > 1) {
                st.append(", ");
            }
            //noi key va value vao chuoi voi "="
            st.append(key).append("=").append(value);
        });
        //cuoi chuoi
        st.append("}");
        System.out.print(st.toString());
        System.out.println("");
    }

    public static void main(String[] args) {
        P0008 p = new P0008();
        String n = Utility.inputString();
        HashMap<String, Integer> countW = p.countWord(n);
        p.print(countW);
        HashMap<Character, Integer> countC = p.countChar(n);
        p.print(countC);
    }

}
