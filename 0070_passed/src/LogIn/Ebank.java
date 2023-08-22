package LogIn;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Lớp này đại diện cho ứng dụng Ebank dùng cho xác thực người dùng.
 */
public class Ebank {

    private ResourceBundle rb; // ResourceBundle để đa ngôn ngữ hóa
    public Locale locale; // Locale hiện tại cho cài đặt ngôn ngữ
    public final String valid_accountNum = "[0-9]{10}"; // Biểu thức chính quy cho số tài khoản hợp lệ
    public final String valid_passwordNum = "((?=.*\\d)(?=.*[a-zA-Z])\\S{8,31})"; // Biểu thức chính quy cho mật khẩu hợp lệ

    /**
     * Constructor mặc định cho Ebank.
     */
    public Ebank() {
    }

    /**
     * Constructor cho Ebank với ResourceBundle cụ thể.
     *
     * @param rb ResourceBundle chứa các thông điệp cụ thể cho ngôn ngữ.
     */
    Ebank(ResourceBundle rb) {
        this.rb = rb;
    }

    /**
     * Thiết lập locale cho ứng dụng để cài đặt ngôn ngữ.
     *
     * @param locale Locale mong muốn cho đa ngôn ngữ.
     */
    void setLocale(Locale locale) {
        rb = ResourceBundle.getBundle("Language/" + locale);
    }

    /**
     * Kiểm tra tính hợp lệ của số tài khoản do người dùng cung cấp.
     *
     * @param account Số tài khoản cần kiểm tra.
     * @return Một thông điệp xác thực hoặc null nếu số tài khoản hợp lệ.
     */
    public String checkAccount(String account) {
        // Kiểm tra xem số tài khoản mà người dùng cung cấp có khớp với định dạng số tài khoản hợp lệ hay không
        if (account.matches(valid_accountNum)) {
            return null; // Số tài khoản hợp lệ
        } else {
            return rb.getString("wrongAccount"); // Trả về thông báo lỗi từ ResourceBundle
        }
    }

    /**
     * Kiểm tra tính hợp lệ của mật khẩu do người dùng cung cấp.
     *
     * @param pass Mật khẩu cần kiểm tra.
     * @return Một thông điệp xác thực hoặc null nếu mật khẩu hợp lệ.
     */
    public String checkPassword(String pass) {
        // Kiểm tra xem mật khẩu mà người dùng cung cấp có khớp với định dạng mật khẩu hợp lệ hay không
        if (pass.matches(valid_passwordNum)) {
            return null; // Mật khẩu hợp lệ
        } else {
            return rb.getString("wrongPassword"); // Trả về thông báo lỗi từ ResourceBundle
        }
    }

    /**
     * Tạo ngẫu nhiên một chuỗi Captcha cho việc xác thực người dùng.
     *
     * @return Một chuỗi Captcha được tạo ngẫu nhiên.
     */
    public String randomCaptcha() {
        Random rd = new Random();
        String alphabet = "0123456789"
                + "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = alphabet.length();
        String result = "";
        for (int i = 0; i < 5; i++) {
            int index = rd.nextInt(length);
            result += alphabet.charAt(index);
        }
        return result;
    }

    /**
     * Kiểm tra tính hợp lệ của Captcha do người dùng cung cấp.
     *
     * @param capt Chuỗi Captcha chính xác.
     * @param inputCapt Chuỗi Captcha do người dùng cung cấp để xác thực.
     * @return Một thông điệp xác thực hoặc null nếu Captcha hợp lệ.
     */
    public String checkCaptcha(String capt, String inputCapt) {
        // Kiểm tra xem chuỗi Captcha mà người dùng cung cấp có khớp với chuỗi Captcha đúng và không trống
        if (capt.contains(inputCapt) && !inputCapt.isEmpty()) {
            return null; // Captcha hợp lệ
        } else {
            return rb.getString("wrongCaptcha"); // Trả về thông báo lỗi từ ResourceBundle
        }
    }
}
