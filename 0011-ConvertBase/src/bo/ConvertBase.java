package bo;

import java.math.BigInteger;

/**
 *
 * @author ADMIN
 */
public class ConvertBase {

    public void convertValue(int baseInput, int baseOutput, String value) {
        String result = null;
        boolean isNegative = false;

        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1); // Loại bỏ ký tự âm từ giá trị
        }

        switch (baseInput) {
            case 1:
                //neu baseInput = 1 : xu li binary
                result = convertBinary(baseOutput, value);
                break;
            case 2:
                //neu base input = 2 : xu li decimal
                result = convertDecimal(baseOutput, value);
                break;
            case 3:
                //neu base input = 3 : xu li hexadecimal
                result = convertHexadecimal(baseOutput, value);
                break;
        }
        if (isNegative) {
            result = "-" + result;
        }

        System.out.println("Value is: " + result);
    }

    private String convertBinary(int baseOutput, String value) {
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
                result = convertDecimalToOther(convertOtherToDecimal(2, value), 16);
                break;
        }
        return result;
    }

    private String convertHexadecimal(int baseOutput, String value) {
        String result = null;
        switch (baseOutput) {
            case 1:
                //neu baseOutput = 1 : hexa => binary ( 16=>2)
                result = convertDecimalToOther(convertOtherToDecimal(16, value), 2);
                break;
            case 2:
                //neu baseOutput = 2 : hexa => decimal ( 16=> 10)
                result = convertOtherToDecimal(16, value);
                break;
            case 3:
                //neu baseOutput = 3 : hexa => hexadecimal ( 16 =>16)
                result = value;
                break;
        }
        return result;
    }

    private String convertDecimal(int baseOutput, String value) {
        String result = null;
        switch (baseOutput) {
            case 1:
                //neu baseOutput = 1 : decimal => binary ( 2=>10)
                result = convertDecimalToOther(value, 2);
                break;
            case 2:
                //neu baseOutput = 2 : decimal => decimal ( 10=> 10)
                result = value;
                break;
            case 3:
                //neu baseOutput = 3 : decimal => hexadecimal ( 10 =>16)
                result = convertDecimalToOther(value, 16);
                break;
        }
        return result;
    }

    public static String convertOtherToDecimal(int baseInput, String value) {
        if (value.equals("0")) {
            return "0";
        }

        boolean isNegative = false;
        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1);
        }

        BigInteger result = BigInteger.ZERO;
        String HEX = "0123456789ABCDEF";
        String[] parts = value.split("\\.");

        // Convert integer part
        String integerPart = parts[0];
        BigInteger basePower = BigInteger.ONE;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            BigInteger valueIndex = BigInteger.valueOf(HEX.indexOf(integerPart.charAt(i)));
            BigInteger number = valueIndex.multiply(basePower);
            result = result.add(number);
            basePower = basePower.multiply(BigInteger.valueOf(baseInput));
        }

        // Convert fractional part if present
        if (parts.length > 1) {
            String fractionalPart = parts[1];
            basePower = BigInteger.ONE.divide(BigInteger.valueOf(baseInput));
            for (int i = 0; i < fractionalPart.length(); i++) {
                int valueIndex = HEX.indexOf(fractionalPart.charAt(i));
                BigInteger number = BigInteger.valueOf(valueIndex).multiply(basePower);
                result = result.add(number);
                basePower = basePower.divide(BigInteger.valueOf(baseInput));
            }
        }

        if (isNegative) {
            result = result.negate();
        }

        return result.toString();
    }

    private static String convertDecimalToOther(String decimalNumber, int base) {
        if (decimalNumber.equals("0")) {
            return "0";
        }
        String HEX = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        BigInteger decimalValue = new BigInteger(decimalNumber);
        boolean isNegative = decimalValue.compareTo(BigInteger.ZERO) < 0;

        if (isNegative) {
            decimalValue = decimalValue.negate();
        }

        while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] quotientAndRemainder = decimalValue.divideAndRemainder(BigInteger.valueOf(base));
            result.append(HEX.charAt(quotientAndRemainder[1].intValue()));
            decimalValue = quotientAndRemainder[0];
        }

        result.reverse();

        return isNegative ? "-" + result.toString() : result.toString();
    }
}
