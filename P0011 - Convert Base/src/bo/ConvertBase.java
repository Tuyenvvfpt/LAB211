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
                //neu baseInput = 1 : xu li binary
                result = convertBinaryToOther(baseOutput, value);
                break;
            case 2:
                //neu base input = 2 : xu li decimal
//                result = convertBinaryToOther(baseOutput, value);
                break;
            case 3:
                //neu base input = 3 : xu li hexadecimal
                result = convertBinaryToOther(baseOutput, value);
                break;
        }

        System.out.println("Value is: " + result);
    }

    private String convertBinaryToOther(int baseOutput, String value) {
        String result = null;
        switch (baseOutput) {
            case 1:
                //neu baseOutput = 1 : binary => binary ( 2=>2)
                result = value;
                break;
            case 2:
                //neu baseOutput = 2 : binary => decimal ( 2=> 10)
                result = convertOtherToDecimal(2, value);
                break;
            case 3:
                //neu baseOutput = 3 : binary => hexadecimal ( 2 =>16)

                break;
        }
        return result;
    }

    private String convertOtherToDecimal(int baseInput, String value) {
        
        if (value.equals("0")) {
            return "0";
        }

        boolean isNegative = false;
        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1); // Remove the negative sign from the value
        }

        BigInteger baseBigInteger = BigInteger.valueOf(baseInput);
        baseBigInteger = baseBigInteger.divide(baseBigInteger);
        String HEX = "0123456789ABCDEF";

        BigInteger result = new BigInteger("0");

        for (int i = value.length() - 1; i >= 0; i--) {
            BigInteger valueIndex = BigInteger.valueOf(HEX.indexOf(value.charAt(i)));
            BigInteger number = valueIndex.multiply(baseBigInteger);
            result = result.add(number);
            baseBigInteger = baseBigInteger.multiply(BigInteger.valueOf(baseInput));
        }

        if (isNegative) {
            result = result.negate(); // Negate the result if the input was negative
        }

        return result.toString();
    }

}
