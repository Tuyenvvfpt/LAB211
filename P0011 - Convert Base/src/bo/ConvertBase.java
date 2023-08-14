package bo;

import java.math.BigInteger;

/**
 *
 * @author ADMIN
 */
public class ConvertBase {

    public void convertValue(int baseInput, int baseOutput, String value) {
        String result = null;

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
                result = convertDecimalToOther(convertOtherToDecimal(2, value), baseOutput);
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

    // Chuyển đổi một số ở hệ cơ số khác thành số thập phân
    private String convertOtherToDecimal(int baseInput, String value) {
        if (value.equals("0")) {
            return "0";
        }

        boolean isNegative = false;
        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1); // Loại bỏ ký tự âm từ giá trị
        }

        // Khởi tạo số BigInteger từ cơ số đầu vào
        BigInteger baseBigInteger = BigInteger.valueOf(baseInput);
        baseBigInteger = baseBigInteger.divide(baseBigInteger); // Không làm gì cả, chỉ để khởi tạo
        String HEX = "0123456789ABCDEF";

        BigInteger result = new BigInteger("0");

        // Vòng lặp chuyển đổi từng chữ số ở hệ cơ số khác sang thập phân
        for (int i = value.length() - 1; i >= 0; i--) {
            // Lấy chỉ số của ký tự hiện tại trong chuỗi HEX để xác định giá trị tương ứng
            BigInteger valueIndex = BigInteger.valueOf(HEX.indexOf(value.charAt(i)));

            // Nhân giá trị của ký tự với cơ số đầu vào để tính giá trị tương ứng ở thập phân
            BigInteger number = valueIndex.multiply(baseBigInteger);

            // Cộng giá trị tương ứng vào kết quả tổng
            result = result.add(number);

            // Tăng cơ số đầu vào lên baseInput lần tiếp theo để tính toán cho chữ số tiếp theo
            baseBigInteger = baseBigInteger.multiply(BigInteger.valueOf(baseInput));
        }

        if (isNegative) {
            result = result.negate(); // Đảo dấu kết quả nếu đầu vào là số âm
        }

        return result.toString();
    }

    // Chuyển đổi một số thập phân thành hệ cơ số khác
    private static String convertDecimalToOther(String decimalNumber, int base) {
        if (decimalNumber.equals("0")) {
            return "0";
        }

        // Khởi tạo một đối tượng BigInteger từ chuỗi số thập phân đầu vào
        BigInteger decimalBigInteger = new BigInteger(decimalNumber);

// Khởi tạo đối tượnsg BigInteger từ cơ số đầu vào
        BigInteger baseBigInteger = BigInteger.valueOf(base);

// Chuỗi ký tự biểu diễn các giá trị trong hệ cơ số mới (ví dụ: HEX trong hệ 16)
        String HEX = "0123456789ABCDEF";

// Chuỗi kết quả cuối cùng sau khi chuyển đổi
        StringBuilder result = new StringBuilder();

// Biến kiểm tra xem số thập phân đầu vào có âm hay không
        boolean isNegative = false;

// Kiểm tra xem số thập phân có âm hay không
        if (decimalBigInteger.compareTo(BigInteger.ZERO) < 0) {
            isNegative = true;

            // Lấy giá trị tuyệt đối để xử lý chuyển đổi
            decimalBigInteger = decimalBigInteger.abs();
        }

// Vòng lặp chuyển đổi từ số thập phân sang hệ cơ số khác
        while (decimalBigInteger.compareTo(BigInteger.ZERO) > 0) {
            // Tính phần dư khi chia số thập phân cho cơ số mới
            int remainder = decimalBigInteger.mod(baseBigInteger).intValue();

            // Lấy ký tự tương ứng với phần dư từ chuỗi HEX
            result.append(HEX.charAt(remainder));

            // Chia số thập phân cho cơ số mới để tiếp tục chuyển đổi các chữ số khác
            decimalBigInteger = decimalBigInteger.divide(baseBigInteger);
        }

        if (isNegative) {
            result.append("-");
        }

        return result.reverse().toString();
    }

}
