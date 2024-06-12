/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author NguyenGiap
 */
public  class Employee implements Comparable<Employee>{
    public String employeeID;
    public String name;
    private IceCream iceCream;
    Customer cus = new Customer();
    public Employee() {
    }

    public Employee(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
       return this.employeeID.compareTo(o.employeeID);
    }

    @Override
    public String toString() {
        return name + " "  +employeeID;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    
    
    public void saleIceCream(Customer customer)
    {
        while (true) {            
            if (customer.getName().equalsIgnoreCase(cus.getName())) {
                customer.setIceCreamList(customer.getIceCreamList());
            }
        }
    }
    

   
    
    
    
}
