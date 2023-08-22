package LogIn;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Lớp quản lý giao diện người dùng cho chương trình đăng nhập.
 */
public class Manager {

    private Locale locate; // Locale để cài đặt ngôn ngữ
    private ResourceBundle rb; // ResourceBundle để đa ngôn ngữ hóa
    Ebank eBank = new Ebank(rb); // Đối tượng Ebank để thực hiện các chức năng liên quan đến xác thực

    static Scanner scanner = new Scanner(System.in);

    /**
     * Hiển thị menu cho người dùng.
     */
    public void menu() {
        System.out.println("-------Chương trình Đăng nhập-------");
        System.out.println("1. Tiếng Việt");
        System.out.println("2. Tiếng Anh");
        System.out.println("3. Thoát");
        System.out.println();
    }

    /**
     * Phương thức để nhập lựa chọn từ người dùng.
     *
     * @return Lựa chọn người dùng nhập.
     */
    static int inputChoice() {
        int num;
        while (true) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                num = Integer.parseInt(scanner.nextLine());
                if (num >= 1 && num <= 3) {
                    return num;
                } else {
                    System.out.println("Lỗi! Lựa chọn của bạn phải trong khoảng [1,3]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Đầu vào không hợp lệ! Đầu vào của bạn phải là một số");
            }
        }
    }

    /**
     * Thay đổi ngôn ngữ theo lựa chọn của người dùng.
     *
     * @param choice Lựa chọn ngôn ngữ từ người dùng.
     */
    void changeLanguage(int choice) {
        if (choice == 1) {
            locate = new Locale("vi");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("Language/" + locate);
        } else if (choice == 2) {
            locate = new Locale("en");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("Language/" + locate);
        }
    }

    /**
     * Phương thức thực hiện quá trình đăng nhập.
     *
     * @throws IOException Nếu có lỗi khi đọc đầu vào.
     */
    void login() throws IOException {
        inputAccount();
        inputPassword();
        inputCaptcha();
    }

    /**
     * Nhập số tài khoản từ người dùng.
     *
     * @return Số tài khoản đã nhập.
     * @throws IOException Nếu có lỗi khi đọc đầu vào.
     */
    private String inputAccount() throws IOException {
        while (true) {
            System.out.print(rb.getString("account")); // Hiển thị thông báo yêu cầu nhập số tài khoản
            String acc = scanner.nextLine(); // Đọc số tài khoản từ người dùng sử dụng Scanner
            String checkAcc = eBank.checkAccount(acc); // Kiểm tra tính hợp lệ của số tài khoản
            if (checkAcc == null && !acc.isEmpty()) {
                return acc; // Trả về số tài khoản nếu hợp lệ và không trống
            } else {
                System.out.println(checkAcc); // Hiển thị thông báo lỗi nếu số tài khoản không hợp lệ hoặc trống
            }
        }
    }

    /**
     * Nhập mật khẩu từ người dùng.
     *
     * @return Mật khẩu đã nhập.
     * @throws IOException Nếu có lỗi khi đọc đầu vào.
     */
    private String inputPassword() throws IOException {
        while (true) {
            System.out.print(rb.getString("password"));
            String pass = scanner.nextLine();
            String checkPass = eBank.checkPassword(pass);
            if (checkPass == null && !pass.isEmpty()) {
                return pass;
            } else {
                System.out.println(checkPass);
            }
        }
    }

    /**
     * Nhập Captcha từ người dùng để xác thực.
     *
     * @return Chuỗi Captcha đã nhập.
     * @throws IOException Nếu có lỗi khi đọc đầu vào.
     */
    private String inputCaptcha() throws IOException {

        String inputCaptcha;
        String login = rb.getString("logIn");
        String capt = eBank.randomCaptcha();
        System.out.println("Captcha: " + capt);

        while (true) {
            System.out.print(rb.getString("inputCaptcha"));
            inputCaptcha = scanner.nextLine();

            if (eBank.checkCaptcha(capt, inputCaptcha) == null) {
                System.out.println(login);
                return inputCaptcha;
            } else {
                System.out.println(eBank.checkCaptcha(capt, inputCaptcha));
            }
        }
    }
}
