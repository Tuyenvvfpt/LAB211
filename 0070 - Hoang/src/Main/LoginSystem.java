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

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author dinhh
 */
public class LoginSystem {

    private Locale locate;
    private ResourceBundle rb;
    Scanner scanner = new Scanner(System.in);
    EBank eBank = new EBank(rb);

    public String inputAccount() {

        while (true) {
            System.out.print(rb.getString("enterAcc"));
            String acc = scanner.nextLine();
            if (eBank.checkAccount(acc) == null) {
                return acc;
            } else {
                System.out.println(eBank.checkAccount(acc));
            }
        }
    }

    public String inputPassword() {

        while (true) {
            System.out.print(rb.getString("enterPassword"));
            String pass = scanner.nextLine();
            if (pass.isEmpty()) {
                System.err.println(rb.getString("errPasswordEmpty"));
            } else if (eBank.checkPassword(pass) == null) {
                return pass;
            } else {
                System.err.println(rb.getString("errInputPassword"));
            }
        }
    }

    public String inputCaptcha() {

        String inputCapcha;

        while (true) {
            String captcha = eBank.generateCaptcha();
            System.out.print("Captcha: " + captcha + "\t");
            System.out.print(rb.getString("enterCaptcha"));
            inputCapcha = scanner.nextLine();
            if (inputCapcha.isEmpty()) {
                System.err.println(rb.getString("emptyCaptcha"));
            } else if (captcha.contains(inputCapcha)) {
                return rb.getString("loginSuccess");
            } else {
                System.err.println(rb.getString("errCaptcha"));
            }
        }

    }

    public void changeLanguage(int choice) {
        if (choice == 1) {
            locate = new Locale("vi");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("language/" + locate);
        } else if (choice == 2) {
            locate = new Locale("en");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("language/" + locate);
        }
    }

    public void login() {

        while (true) {
//            String acc = inputAccount();
            String pass = inputPassword();
            while (true) {
                String captcha = eBank.generateCaptcha();
                System.out.println("Captcha: " + captcha);
                System.out.print(rb.getString("enterCaptcha"));
                String inputCaptha = scanner.nextLine().trim();
                if (eBank.checkCaptcha(captcha, inputCaptha) == null) {
                    break;
                } else {
                    System.err.println(eBank.checkCaptcha(captcha, inputCaptha));
                }

            }
            System.out.println(rb.getString("loginSuccess"));
            System.out.println("");
            return;
        }
    }
}