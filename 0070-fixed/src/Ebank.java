
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Ebank {

    Utility utility = new Utility();
    ResourceBundle bundle;

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("language/message");
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

    void login(Locale locale) {
        Scanner scanner = new Scanner(System.in);
        setLocale(locale);
        //check account number
        while (true) {
            String accountNumber = Utility.getString(bundle.getString("messageUsername"));
            String result = checkAccountNumber(accountNumber);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        }
        //check password
        while (true) {
            String password = Utility.getString(bundle.getString("messagePassword"));
            String result = checkPassword(password);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        }
        //check captcha
        String captcha = generateCapcha();
        System.out.println("Captcha: " + captcha);
        while (true) {

            String captchaInput = Utility.getString(bundle.getString("inputCaptcha"));
            String error = checkCaptcha(captcha, captchaInput);
            if (error == null) {
                break;
            } else {
                System.out.println(error);
            }
        }
    }

    private String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches("\\d{10}")) {
            return null;
        } else {
            return bundle.getString("inputAccountError");
        }
    }

    private String checkPassword(String password) {
        if (password.matches("(?=.*\\d)(?=.*[a-zA-Z])\\S{8,31}")) {
            return null;
        } else {
            return bundle.getString("inputPasswordError");
        }
    }

    private String checkCaptcha(String captcha, String captchaInput) {
        if (captcha.contains(captchaInput) && !captchaInput.isEmpty()) {
            return null;
        } else {
            return bundle.getString("inputCaptchaError");
        }
    }

}
