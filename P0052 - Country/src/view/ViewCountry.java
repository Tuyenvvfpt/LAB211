/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import util.Utility;
import bo.ManageEastAsiaCountry;
import constant.CountryConstant;
import entity.EastAsiaCountry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author asus
 */
public class ViewCountry {

    ManageEastAsiaCountry bo = new ManageEastAsiaCountry();

    void inputCountry() {
        //require input information
        String code, name, terrain;
        float area;
        //code
        while (true) {
            code = Utility.getString("Enter code of country: ",
                    "Wrong", CountryConstant.REGEX_CODE);
            //check code is duplicate
            //true => duplicate
            if (bo.isDuplicateCode(code)) {
                System.out.println("Duplicate code");
            } else {
                break;
            }
        }

        //name
        while (true) {
            name = Utility.getString("Enter name  of country: ",
                    "Wrong", CountryConstant.REGEX_NAME);
            //check name is duplicate
            //true => duplicate
            if (bo.isDuplicateName(name)) {
                System.out.println("Duplicate name");
            } else {
                break;
            }
        }
        //area
        area = Utility.getFloat("Enter area of country", "Wrong", 1, Float.MAX_VALUE);
        //terrain
        terrain = Utility.getString("Enter terrain of country: ", "Wrong", CountryConstant.REGEX_TERRAIN);

        //check valid data
        //create instance
        EastAsiaCountry country = new EastAsiaCountry(code, name, area, terrain);

        //add to collections
        bo.addCountry(country);
    }

    void displayCountryJustInput() {
        //lay ve list
        List<EastAsiaCountry> list = bo.getListCountry();
        //kiem tra xem collections co rong khong
        //rong => hien thi list empty
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        //khong rong => hien thi quoc gia vua nhap
        //lay ve quoc gia nam o vi tri cuoi cung (quoc gia vua moi nhap)
        EastAsiaCountry country = list.get(list.size() - 1);
        System.out.format("%-15s %-15s %-15s %-15s\n", "Code", "Name", "Area", "Terrain");
        country.display();
    }

    void searchCountry() {
        //input name want to search
        String name = Utility.getString("Enter name  of country: ",
                "Wrong", CountryConstant.REGEX_NAME);

        //search
        List<EastAsiaCountry> list = bo.findCountryByName(name);

        //list empty: not found
        if (list.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.format("%-15s %-15s %-15s %-15s\n", "Code", "Name", "Area", "Terrain");
            for (EastAsiaCountry eastAsiaCountry : list) {
                eastAsiaCountry.display();
            }
        }
    }



    void sortCountries() {
        //list sort
        List<EastAsiaCountry> listSort = new ArrayList<>();
        listSort.addAll(bo.getListCountry());
        /**
         * Collections.sort(listSort(), new Comparator<EastAsiaCountry>(); for
         * (EastAsiaCountry eastAsiaCountry : bo.getListCountry()) {
         * eastAsiaCountry.display(); }
         */

        //sort before
        Collections.sort(bo.getListCountry(), new Comparator<EastAsiaCountry>() {
            @Override
            public int compare(EastAsiaCountry o1, EastAsiaCountry o2
            ) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        }
        );
        //display
        for (EastAsiaCountry eastAsiaCountry
                : bo.getListCountry()) {
            eastAsiaCountry.display();
        }
    }

}
