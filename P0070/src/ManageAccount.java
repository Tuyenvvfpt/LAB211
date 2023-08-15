
import java.util.ArrayList;
import java.util.Locale;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
