/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.EastAsiaCountry;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Main {

    public static void main(String[] args) {
        View_Country view = new View_Country();
        List<EastAsiaCountry> listCountry = new ArrayList<>();

        while (true) {
            displayMenu();
            int option = Utility.getInt("Option: ", "Wrong", 1, 5);

            switch (option) {
                case 1:
                    //input country information
                    view.inputCountry(listCountry);
                    break;
                case 2:
                    //display country just input
                    view.displayCountryJustInput(listCountry);
                    break;
                case 3:
                    //search country by name
                    view.searchCountry(listCountry);
                    break;
                case 4:
                    //sort country by name
                    view.sortCountry(listCountry);
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
