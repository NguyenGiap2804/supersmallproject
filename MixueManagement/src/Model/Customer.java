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
public  class Customer implements Comparable<Customer>{

    public static Customer get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String name;
    private String id;
    private List<IceCream> IceCreamList = new ArrayList<>();


    public Customer() {
    }

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<IceCream> getIceCreamList() {
        return IceCreamList;
    }

    public void setIceCreamList(List<IceCream> IceCreamList) {
        this.IceCreamList = IceCreamList;
    }
    

    @Override
    public String toString() {
        return name + " " + id;
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }
    
    
  
}
