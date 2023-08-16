
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
        listAccount.add(new Account("0123456789", "abcd1234"));
        listAccount.add(new Account("0123456788", "abcd1233"));
        listAccount.add(new Account("0344558888", "abcd1222"));
        listAccount.add(new Account("0344556666", "abcd1111"));
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

        String username = Utility.getString(resourceBundle.getString("messageUsername"),
                resourceBundle.getString("messageUsernameError"), Utility.REGEX_USERNAME);
        String password = Utility.getString(resourceBundle.getString("messagePassword"),
                resourceBundle.getString("messagePasswordError"), Utility.REGEX_PASSWORD);

        //handel capcha
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
            String inputCapcha = Utility.getString(messInput,
                    "Capcha must be alphanumeric", Utility.REGEX_CAPCHA);
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
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = alphabet.length();
        String result = "";
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(length);
            result += alphabet.charAt(index);
        }
        return result;
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
