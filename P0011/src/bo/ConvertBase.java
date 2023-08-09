/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.math.BigInteger;

/**
 *
 * @author asus
 */
public class ConvertBase {

    public void convertValue(int baseInput, int baseOutput, String value) {
        String result = null;
        switch (baseInput) {
            case 1:
                //base = 1: xu ly birnary
                result = convertBirnaryToOther(baseOutput, value);
                break;
            case 2:
//base = 2: xu ly decimal           
                result = convertDecimalToOther(baseOutput, value);
                break;
            case 3:
                //base = 3: xu ly hexa
                result = convertHexaToOther(baseOutput, value);
                break;
        }
        System.out.println("Value is " + result);
    }

    private String convertBirnaryToOther(int baseOutput, String value) {
        String result = null;
        switch (baseOutput) {
            case 1:
                //base = 1: xu ly birnary
                result = value;
                break;
            case 2:
//base = 2: xu ly decimal           
                result = convertOtherToDecimal(2, value);
                break;
            case 3:
                //base = 3: xu ly hexa
                result = convertHexaToOther(baseOutput, value);
                break;
        }
        return result;
    }

    private String convertDecimalToOther(int baseOutput, String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String convertHexaToOther(int baseOutput, String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String convertOtherToDecimal(int baseInput, String value) {
        if (value.compareTo("0") == 0) {
            return "0";
        }

        //convert base ( int ) => biginteger
        BigInteger baseBigInteger = BigInteger.valueOf(baseInput);

        baseBigInteger = baseBigInteger.divide(baseBigInteger);
        String HEX = "0123456789ABCDEF";

        BigInteger result = new BigInteger("0");
        //loop length of number times
        for (int i = value.length() - 1; i >= 0; i--) {
            BigInteger valueIndex = BigInteger.valueOf(HEX.indexOf(value.charAt(i)));
            BigInteger number = valueIndex.multiply(baseBigInteger);
            result = result.add(number);
            baseBigInteger = baseBigInteger.multiply(BigInteger.valueOf(baseInput));
        }
        String resultString = result.toString();
        return resultString;
    }

}
