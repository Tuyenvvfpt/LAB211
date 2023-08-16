
/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        ManageAccount manageAccount = new ManageAccount();

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
