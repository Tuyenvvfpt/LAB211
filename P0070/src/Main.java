
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        ManageAccount manageAccount = new ManageAccount();
        Utility utility = new Utility();

        while (true) {
            displayMenu();
            int option = Utility.getInteger("Pls choose one option: ", "Wrong", 1, 3);
            manageAccount.mockData();

            switch (option) {
                case 1:
                    manageAccount.loginVietnamese();
                    break;
                case 2:
                    manageAccount.loginEnglish();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pls enter from 1 to 3");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. vietnam");
        System.out.println("2. english");
        System.out.println("3. exit");
    }

}

/*
 void setLocale(Locale locale) {
        Locale localeDef = new Locale("en");
        if (locale.getDisplayLanguage().equalsIgnoreCase("vi")) {
            localeDef = locale;
        }

        ResourceBundle bundle = ResourceBundle.getBundle("language/message", localeDef);
    }
public class Main {

    public static void main(String[] args) {
        Ebank m = new Ebank();
        CheckInput c = new CheckInput();
        Locale vi = new Locale("vi");
        Locale en = new Locale("en");

        // Tạo đối tượng Ebank duy nhất
        Ebank ebank = new Ebank();

        while (true) {
            m.menu();
            int choice = c.inputChoice();
            switch (choice) {
                case 1:
                    ebank.setLoc(vi);
                    new Ebank().setLoc(en);
                    ebank.logIn();
//                    ebank.setLoc(en); // Đặt lại ngôn ngữ sau khi xong việc đăng nhập

                    break;
                case 2:
                    ebank.setLoc(en);
                    ebank.logIn();
                    break;
                case 3:
                    return;
            }
        }
    }
}
 */
