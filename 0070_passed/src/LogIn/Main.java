package LogIn;

import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {

        // Khởi tạo một đối tượng Manager để quản lý việc đăng nhập và thay đổi ngôn ngữ
        Manager manager = new Manager();

        // Vòng lặp chính để duy trì việc đăng nhập và thay đổi ngôn ngữ
        while (true) {
            // Hiển thị menu cho người dùng thông qua phương thức menu() trong đối tượng Manager
            manager.menu();

            // Lấy lựa chọn từ người dùng thông qua phương thức inputChoice() trong đối tượng Manager
            int choice = Manager.inputChoice();

            // Sử dụng câu lệnh switch-case để xử lý lựa chọn của người dùng
            switch (choice) {
                case 1:
                    // Nếu người dùng chọn 1, gọi phương thức changeLanguage(1) để thay đổi ngôn ngữ thành tiếng Anh
                    manager.changeLanguage(1);
                    break;
                case 2:
                    // Nếu người dùng chọn 2, gọi phương thức changeLanguage(2) để thay đổi ngôn ngữ thành tiếng Việt
                    manager.changeLanguage(2);
                    break;
                case 3:
                    // Nếu người dùng chọn 3, thoát khỏi vòng lặp và kết thúc chương trình
                    return;
            }

            // Gọi phương thức login() để thực hiện quá trình đăng nhập
            manager.login();
        }
    }
}
