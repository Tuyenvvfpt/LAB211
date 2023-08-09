/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PHAM KHAC VINH
 */
public class EastAsiaCountry extends Country{
    private String terrain;

    public EastAsiaCountry() {
        super();
    }

    public EastAsiaCountry( String code, String name, double area, String terrain) {
        super(code, name, area);
        this.terrain = terrain;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    
    public void display() {
        super.display();
        System.out.printf(" %-10s\n", terrain);
    }
    
    
}
