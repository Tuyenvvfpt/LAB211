
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author asus
 */
public class ManageAccount {

    ArrayList<Account> listAccount = new ArrayList<>();
    Utility utility = new Utility();

    void mockData() {
        listAccount.add(new Account("1234561111", "abc123456"));
        listAccount.add(new Account("0344559999", "abc123444"));
        listAccount.add(new Account("0344558888", "abc123333"));
        listAccount.add(new Account("0344556666", "abc122222"));
    }

    void loginVietnamese() {

        Locale localeVi = new Locale("vi");
        loginFunction(localeVi);
    }

    void loginEnglish() {

        Locale localeEn = new Locale("en");
        loginFunction(localeEn);

    }

    private void loginFunction(Locale locale) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("language/message", locale);

        String username = utility.getString(resourceBundle.getString("messageUsername"),
                resourceBundle.getString("messageUsernameError"), utility.REGEX_USERNAME);
        String password = utility.getString(resourceBundle.getString("messagePassword"),
                resourceBundle.getString("messagePasswordError"), utility.REGEX_PASSWORD);

        handleCapcha(resourceBundle.getString("messageCapcha"), resourceBundle.getString("messageCapchaInput"),
                resourceBundle.getString("messageCapchaError"));

        //check username and password
        if (!checkAccount(username, password)) {
            System.out.println(resourceBundle.getString("messageAccountError"));
        }
    }

    private void handleCapcha(String messCapcha, String messInput, String error) {
        //generate capcha
        String generateCapcha = generateCapcha();
        System.out.println(messCapcha + generateCapcha);
        while (true) {
            //input capcha
            String inputCapcha = utility.getString(messInput, "Capcha must be alphanumeric", utility.REGEX_CAPCHA);
            //compare capcha generate with input capcha
            if (!generateCapcha.contains(inputCapcha)) {
                System.out.println(error);
            } else {
                break;
            }
        }
    }

    private String generateCapcha() {
        Random random = new Random();

        int number;
        String capcha = "";
        for (int i = 0; i < 6; i++) {
            int base = Math.abs(random.nextInt()) % 62;
            if (base < 26) {
                number = 65 + base;
            } else if (base < 52) {
                number = 97 + (base - 26);
            } else {
                number = base - 4;
            }
            char character = (char) number;
            capcha = capcha + character;
        }
        return capcha;
    }

    private boolean checkAccount(String username, String password) {
        for (Account account : listAccount) {
            if (account.getUsername().equals(username)
                    && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
