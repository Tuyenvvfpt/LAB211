/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.EastAsiaCountry;

/**
 *
 * @author PHAM KHAC VINH
 */
public class ManageEastAsiaCountries {


    public boolean checkDuplicate(String code, String name, List<EastAsiaCountry> listCountry) {
        //loop form first to last elements to check country have code and name
        //equal to code, name parameter
        
        for (EastAsiaCountry country : listCountry) {
            //if equal => return true
            if(country.getCode().equalsIgnoreCase(code) &&
                    country.getName().equalsIgnoreCase(name))
                    return true;
        }
        return false;
        
    }

    

    public void search(String name, List<EastAsiaCountry> listSearch, List<EastAsiaCountry> listCountry) {
        for (EastAsiaCountry country : listCountry) {
            //if country have name contains name parameter => add to listSearch
            if (country.getName().toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(country);
            }
        }
    }
    
    
    
    
}
