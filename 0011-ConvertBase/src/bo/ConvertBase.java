package bo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

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

    // Chuyển đổi từ hệ cơ số khác sang hệ cơ số thập phân
// Chuyển đổi từ hệ cơ số khác sang hệ cơ số thập phân
    public static String convertOtherToDecimal(int baseInput, String value) {
        if (value.equals("0")) {
            return "0";
        }

        boolean isNegative = false;
        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1); // Loại bỏ ký tự âm từ giá trị
        }

        BigInteger baseInt = BigInteger.valueOf(baseInput);
        BigDecimal result = BigDecimal.ZERO;
        String HEX = "0123456789ABCDEF";
        String[] parts = value.split("\\.");

        // Chuyển đổi phần nguyên
        String integerPart = parts[0];
        BigInteger basePower = BigInteger.ONE;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            int valueIndex = HEX.indexOf(integerPart.charAt(i));
            BigDecimal number = new BigDecimal(valueIndex).multiply(new BigDecimal(basePower));
            result = result.add(number);
            basePower = basePower.multiply(baseInt);
        }

        // Chuyển đổi phần thập phân nếu có
        if (parts.length > 1) {
            String fractionalPart = parts[1];
            BigDecimal basePowerDec = BigDecimal.ONE.divide(new BigDecimal(baseInt), fractionalPart.length() * 2, BigDecimal.ROUND_DOWN); // Chia 1 cho cơ số để tính lũy thừa âm
            BigDecimal tempResult = BigDecimal.ZERO;
            for (int i = 0; i < fractionalPart.length(); i++) {
                int valueIndex = HEX.indexOf(fractionalPart.charAt(i));
                BigDecimal number = new BigDecimal(valueIndex).multiply(basePowerDec);
                tempResult = tempResult.add(number);
                basePowerDec = basePowerDec.divide(new BigDecimal(baseInt), fractionalPart.length() * 2, BigDecimal.ROUND_DOWN);
            }
            result = result.add(tempResult);
        }

        if (isNegative) {
            result = result.negate(); // Đảo dấu kết quả nếu đầu vào là số âm
        }
        result = result.setScale(8, RoundingMode.DOWN); // Làm tròn xuống 8 chữ số sau dấu phẩy

        return result.toPlainString();
    }

    public static String convertDecimalToOther(String number, int base) {
        // Kiểm tra nếu giá trị đầu vào là 0
        if (number.equals("0")) {
            return "0"; // Trả về kết quả là 0
        }

        boolean isNegative = false;
        // Kiểm tra nếu số đầu vào là số âm
        if (number.startsWith("-")) {
            isNegative = true;
            number = number.substring(1); // Loại bỏ ký tự âm từ giá trị
        }

        // Chuyển phần nguyên thành giá trị BigDecimal
        BigDecimal decimalValue = new BigDecimal(number);
        BigInteger baseBigInt = BigInteger.valueOf(base);

        // Xây dựng kết quả cho phần nguyên
        StringBuilder integerPartResult = new StringBuilder();
        BigInteger integerPart = decimalValue.toBigInteger();
        BigInteger originalIntegerPart = integerPart;
        while (integerPart.compareTo(BigInteger.ZERO) != 0) {
            // Chia phần nguyên cho cơ số mới và lấy phần dư
            BigInteger[] quotientAndRemainder = integerPart.divideAndRemainder(baseBigInt);
            int remainder = quotientAndRemainder[1].intValue();

            // Chuyển phần dư thành ký tự tương ứng và thêm vào kết quả
            integerPartResult.append(String.valueOf(getCharForDigit(remainder)));

            // Cập nhật phần nguyên để tiếp tục vòng lặp
            integerPart = quotientAndRemainder[0];
        }
        // Xử lý trường hợp phần nguyên là 0
        if (integerPartResult.length() == 0) {
            integerPartResult.append("0"); // Xử lý trường hợp giá trị đầu vào là 0
        }
        integerPartResult.reverse();

        // Chuyển phần thập phân
        BigDecimal fractionalPart = decimalValue.subtract(new BigDecimal(originalIntegerPart));
        StringBuilder fractionalPartResult = new StringBuilder();
        int maxFractionalDigits = 10;
        int currentFractionalDigits = 0;
        while (fractionalPart.compareTo(BigDecimal.ZERO) > 0 && currentFractionalDigits < maxFractionalDigits) {
            // Nhân phần thập phân với cơ số mới để lấy phần nguyên và phần thập phân mới
            fractionalPart = fractionalPart.multiply(new BigDecimal(base));
            int integerPartDigit = fractionalPart.intValue();

            // Chuyển phần nguyên mới thành ký tự tương ứng và thêm vào kết quả
            fractionalPartResult.append(String.valueOf(getCharForDigit(integerPartDigit)));

            // Cập nhật phần thập phân để tiếp tục vòng lặp
            fractionalPart = fractionalPart.subtract(new BigDecimal(integerPartDigit));
            currentFractionalDigits++;
        }

        // Xây dựng kết quả cuối cùng
        StringBuilder result = new StringBuilder();
        result.append(isNegative ? "-" : "");
        result.append(integerPartResult);
        if (fractionalPartResult.length() > 0) {
            result.append(".");
            result.append(fractionalPartResult);
        }

        return result.toString();
    }

    // Hàm này chuyển số thành ký tự tương ứng trong hệ cơ số lớn hơn 10
    private static char getCharForDigit(int digit) {
        if (digit >= 10) {
            return (char) ('A' + (digit - 10)); // Ký tự từ A đến F tương ứng với các số từ 10 đến 15
        } else {
            return (char) ('0' + digit); // Ký tự số từ 0 đến 9
        }
    }

}
