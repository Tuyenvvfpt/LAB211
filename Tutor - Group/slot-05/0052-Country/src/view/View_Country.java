/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.EastAsiaCountry;

/**
 *
 * @author PHAM KHAC VINH
 */
public class View_Country {

    ManageEastAsiaCountries manage = new ManageEastAsiaCountries();

    void inputCountry() {
        //input data
        String code = Utility.getString("Enter code: ", "Wrong", Utility.REGEX_STRING);
        String name = Utility.getString("Enter name: ", "Wrong", Utility.REGEX_STRING);
        double area = Utility.getDouble("Enter area: ", "Wrong", 0, Double.MAX_VALUE);
        String terrain = Utility.getString("Enter terrain: ", "Wrong", Utility.REGEX_STRING);

        //check duplicate
        //if duplicate => tell error
        if (manage.checkDuplicate(code, name)) {
            System.out.println("Duplicate country !!!");
            return;
        }

        //create instance 
        EastAsiaCountry country = new EastAsiaCountry(code, name, area, terrain);

        //add to list
        manage.addToList(country);

    }

    void displayCountryJustInput() {
        //check size of list country
        if (manage.getListCountry().size() == 0) {
            System.out.println("List country is empty !!!");
            return;
        }

        System.out.printf("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Total Area", "Terrain");
        EastAsiaCountry country = manage.getListCountry().get(manage.getListCountry().size() - 1);
        country.display();

    }

    void searchCountry() {
        //input name
        String name = Utility.getString("Enter name: ", "Wrong", Utility.REGEX_STRING);

        //search country by name
        List<EastAsiaCountry> listSearch = new ArrayList<>();
        manage.search(name, listSearch);

        //check size of listSearch
        //if size of listsearch = 0 => not found
        //else => found
        if (listSearch.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            displayListCountry(listSearch);
        }

    }

    private void displayListCountry(List<EastAsiaCountry> listSearch) {
        System.out.printf("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountry eastAsiaCountry : listSearch) {
            eastAsiaCountry.display();
        }
    }

    void sortCountry() {
        List<EastAsiaCountry> listCountry = new ArrayList<>();
        listCountry.addAll(manage.getListCountry());
         /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < listCountry.size() ; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last sorted element*/
            for (int j = 0; j < listCountry.size() - i - 1; j++) {
                //compare each pair adjacent elements
                if (listCountry.get(j).getName().compareToIgnoreCase(listCountry.get(j+1).getName()) 
                        > 0) {
                    Collections.swap(listCountry, j, j+1);
                }
                  
            }
        }
        displayListCountry(listCountry);
    }

}
