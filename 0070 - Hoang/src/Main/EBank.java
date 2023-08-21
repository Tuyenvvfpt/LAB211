/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Lanh
 */
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 *
 * @author dinhh
 */
public class EBank {

    private ResourceBundle rb;

    public EBank() {
    }

    public EBank(ResourceBundle rb) {
        this.rb = rb;
    }

    //set ngôn ngữ sẽ đucợ sử dụng
    public void setLocale(Locale locale) {
        rb = ResourceBundle.getBundle("Language/" + locale);
    }

    public String checkAccount(String acc) {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        if (acc.isEmpty()) {
            return rb.getString("errAccEmpty");
        }
        if (p.matcher(acc).find()) {
            return null;
        } else {
            return rb.getString("errInputAcc");
        }
    }

    public String checkPassword(String pass) {
       String regex = "^((?=.*\\d)(?=.*[a-zA-Z])\\S{8,31})$";
        if (pass.isEmpty()) {
            return rb.getString("errPasswordEmpty");
        }
        if (pass.matches(regex)) {
            return null;
        } else {
            return rb.getString("errInputPassword");
        }
    }

    public String generateCaptcha() {
        String root = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        String captcha = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(root.length());
            captcha += root.charAt(index);
        }
        return captcha;
    }

    public String checkCaptcha(String captcha, String inputCaptcha) {
        if (inputCaptcha.isEmpty()) {
            return rb.getString("emptyCaptcha");
        } else if (captcha.contains(inputCaptcha)) {
            return null;
        }
        return rb.getString("errCaptcha");

    }

}