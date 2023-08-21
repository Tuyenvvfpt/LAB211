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
public class Main {

    /**
     * @param args the command line arguments
     */
    // bài này chủ yếu dùng hàm check ko hiểu thì meet t giải thich cho
    public static void main(String[] args) {
        DataInput in = new DataInput();
        LoginSystem ls = new LoginSystem();
        while (true) {
            //show menu
            System.out.println("1. Vietnamese\n"
                             + "2. English\n"
                             + "3. Exit");
            int choice = in.checkInt("Your choice:", 1, 3);
            switch (choice) {
                case 1: {
                    //Change language Vietnamese
                    ls.changeLanguage(1);
                    break;
                }
                case 2: {
                    //Change language English
                    ls.changeLanguage(2);
                    break;
                }
                case 3: {
                    //exit
                    return;
                }

            }
            ls.login();
        }

    }

}