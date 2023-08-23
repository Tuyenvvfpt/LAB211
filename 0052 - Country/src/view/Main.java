package view;

import util.Utility;

/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        ViewCountry view = new ViewCountry();
        while (true) {
            //update them
            displayMenu();
            int option = Utility.getInteger("Enter option:  ", "Wrong", 1, 5);

            switch (option) {
                case 1:
                    //input information of 11 country
                    view.inputCountry();
                    break;
                case 2:
                    //display information country just input
                    view.displayCountryJustInput();
                    break;
                case 3:
                    view.searchCountry();
                    break;
                case 4:
                    view.sortCountries();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }

        }
    }

    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }
}
