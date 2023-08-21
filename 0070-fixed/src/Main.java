
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        Ebank manageAccount = new Ebank();

        while (true) {
            displayMenu();
            int option = Utility.getInteger("Pls choose one option: ", "Wrong", 1, 3);

            switch (option) {
                case 1:
                    Locale localeVN = new Locale("vi");
                    manageAccount.login(localeVN);
                    break;
                case 2:
                    Locale localeEN = new Locale("en");
                    manageAccount.login(localeEN);
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
