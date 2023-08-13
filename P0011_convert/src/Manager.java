/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
public class Manager {

    public static String convertBase(int baseIn, int baseOut, String inputNum) {
        int num = otherToDec(getBase(baseIn), inputNum);
        return decToOther(getBase(baseOut), num);
    }

    public static int getBase(int n) {
        int[] array = {2, 10, 16};
        return array[n - 1];
    }

    public static int otherToDec(int base, String num) {
        if (base == 10) {
            return Integer.parseInt(num);
        }
        int result = 0;
        int pow = 1;
        String index = "0123456789abcdef";
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = index.indexOf(num.charAt(i));
            result += n * pow;
            pow *= base;
        }
        return result;
    }

    public static String decToOther(int base, int num) {
        String result = "";
        String index = "0123456789abcdef";
        while (num != 0) {
            int n = num % base;
            result = index.charAt(n) + result;
            num /= base;
        }
        return result;
    }
}
