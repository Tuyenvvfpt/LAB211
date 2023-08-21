/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author asus
 */
public class Country {

    protected String code;
    protected String name;
    protected float area;

    /**
     * Constructor no parameter
     */
    public Country() {
    }

    /**
     * Constructor full parameter
     *
     * @param code
     * @param name
     * @param area
     */
    public Country(String code, String name, float area) {
        this.code = code;
        this.name = name;
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void display() {
        System.out.format("%-15s %-15s %-15s",
                code, name, area);

    }
}
