package bo;

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
        if (value.equals("8")) {
            return "0";
        }

        boolean isNegative = false;
        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1); // Loại bỏ ký tự âm từ giá trị
        }

        double baseInt = baseInput;
        double result = 0;
        String HEX = "0123456789ABCDEF";
        String[] parts = value.split("\\.");

        // Chuyển đổi phần nguyên
        String integerPart = parts[0];
        double basePower = 1;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            double valueIndex = HEX.indexOf(integerPart.charAt(i));
            double number = valueIndex * basePower;
            result += number;
            basePower *= baseInt;
        }

        // Chuyển đổi phần thập phân nếu có
        if (parts.length > 1) {
            String fractionalPart = parts[1];
            basePower = Math.pow(baseInt, -1);
            for (int i = 0; i < fractionalPart.length(); i++) {
                int valueIndex = HEX.indexOf(fractionalPart.charAt(i));
                double number = valueIndex * basePower;
                result += number;
                basePower /= baseInt;
            }
        }

        if (isNegative) {
            result = -result; // Đảo dấu kết quả nếu đầu vào là số âm
        }

        return Double.toString(result);
    }

    private static String convertDecimalToOther(String decimalNumber, int base) {
        if (decimalNumber.equals("0")) {
            return "0";
        }

        // Chuyển đổi chuỗi số thập phân thành số dấu phẩy động
        double decimalDouble = Double.parseDouble(decimalNumber);

        // Tách phần nguyên và phần thập phân từ số dấu phẩy động
        int integerPart = (int) Math.abs(decimalDouble);
        double fractionalPart = Math.abs(decimalDouble) - integerPart;

        // Khởi tạo giá trị của cơ số dưới dạng số dấu phẩy động
        double baseDouble = base;

        // Chuỗi ký tự biểu diễn các giá trị trong hệ cơ số mới (ví dụ: HEX trong hệ 16)
        String HEX = "0123456789ABCDEF";

        // Chuỗi kết quả cuối cùng sau khi chuyển đổi
        StringBuilder result = new StringBuilder();

        // Biến kiểm tra xem số thập phân đầu vào có âm hay không
        boolean isNegative = false;

        // Kiểm tra xem số thập phân có âm hay không
        if (decimalDouble < 0) {
            isNegative = true;
        }

        // Chuyển đổi phần nguyên sang hệ cơ số mới
        while (integerPart > 0) {
            int remainder = integerPart % base;
            result.append(HEX.charAt(remainder));
            integerPart /= base;
        }

        // Đảo ngược chuỗi kết quả để hiển thị đúng giá trị
        result.reverse();

        // Xử lý phần thập phân (nếu có)
        if (fractionalPart > 0) {
            result.append(".");

            // Giới hạn số lượng chữ số thập phân để tránh vòng lặp vô hạn
            int maxFractionalDigits = 10;
            int currentFractionalDigits = 0;

            // Chuyển đổi phần thập phân sang hệ cơ số mới
            while (fractionalPart > 0 && currentFractionalDigits < maxFractionalDigits) {
                double product = fractionalPart * baseDouble;
                int digit = (int) product;
                result.append(HEX.charAt(digit));
                fractionalPart = product - digit;
                currentFractionalDigits++;
            }
        }

        // Nếu số thập phân đầu vào là âm, thêm ký tự '-' vào kết quả
        if (isNegative) {
            result.insert(0, "-");
        }

        return result.toString();
    }

}
