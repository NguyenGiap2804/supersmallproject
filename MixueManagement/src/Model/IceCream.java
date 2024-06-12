package Model;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NguyenGiap
 */
public class IceCream implements Comparable<IceCream>{
    
    private String name;
    private double price;
    private String category;
    //private final List<IceCream> iceCreams = new ArrayList<>();

    
    
    public IceCream() {
    }

    public IceCream(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    

    @Override
    public String toString() {
        return "Name: " + name + "--" +"Price: "  + price;
    }

    @Override
    public int compareTo(IceCream o) {
       return this.name.compareTo(o.name);
    }
    
    
    
    
}
