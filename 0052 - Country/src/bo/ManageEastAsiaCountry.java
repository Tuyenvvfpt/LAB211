/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.EastAsiaCountry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ManageEastAsiaCountry {

    //lam the nao de tao doi tuong ArrayList
    List<EastAsiaCountry> listCountry;

    /**
     * mỗi lần tạo ManageEastAsiaCountry ở chỗ này thì sẽ tạo ra listCountry ở
     * chỗ khác
     */
    public ManageEastAsiaCountry() {
        listCountry = new ArrayList<>();
    }

    public List<EastAsiaCountry> getListCountry() {
        return listCountry;
    }

    public boolean isDuplicateCode(String code) {
        //loop from first element to last element
        for (EastAsiaCountry eastAsiaCountry : listCountry) {
            //if code of country equal to code parameter => duplicate => return true
            if (eastAsiaCountry.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateName(String name) {
        //loop from first element to last element
        for (EastAsiaCountry eastAsiaCountry : listCountry) {
            //if name of country equal to name parameter => duplicate => return true
            if (eastAsiaCountry.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    //add 11 country
    public void addCountry(EastAsiaCountry country) {
        if (listCountry.size() < 11) {
            listCountry.add(country);
        } else {
            System.out.println("You can only add up to 11 countries.");
        }
    }

    public List<EastAsiaCountry> findCountryByName(String name) {
        name = name.toUpperCase();
        List<EastAsiaCountry> listFound = new ArrayList<>();
        for (EastAsiaCountry eastAsiaCountry : listCountry) {
            if (eastAsiaCountry.getName().toUpperCase().contains(name)) {
                listFound.add(eastAsiaCountry);
            }
        }
        return listFound;
    }
}
