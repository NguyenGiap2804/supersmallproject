package Model;

public class Invoice implements Comparable<Invoice> {

    private String invoiceName;
    private Customer customer;
    private IceCream iceCream;
    private Employee employee;
    private double totalNumIce;
    private double totalPayment;

    public Invoice() {
    }

    public Invoice(String invoiceName, Customer customer, IceCream iceCream, double totalNumIce, Employee employee) {
        this.invoiceName = invoiceName;
        this.customer = customer;
        this.iceCream = iceCream;
        this.totalNumIce = totalNumIce;
        this.employee = employee;
        this.totalPayment = totalNumIce * iceCream.getPrice();
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
        if (iceCream != null) {
            this.totalPayment = this.totalNumIce * iceCream.getPrice();
        }
    }

    public double getTotalNumIce() {
        return totalNumIce;
    }

    public void setTotalNumIce(double totalNumIce) {
        this.totalNumIce = totalNumIce;
        
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        if (iceCream != null) {
            this.totalPayment = totalNumIce * iceCream.getPrice();
        }
    }

    public double getIceCreamPrice() {
        if (this.iceCream != null) {
            return this.iceCream.getPrice();
        }
        return 0.0;
    }

    public void print() {
        if (this.iceCream != null) {
            System.out.println(this.iceCream.getPrice());
        } else {
            System.out.println("Ice cream is null.");
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    

    @Override
    public String toString() {
        if (iceCream != null && customer != null) {
            return "Hoa don cua " + customer.getName() + "\n" + 
                "Name IceCream: " + iceCream.getName() + " - - " + "Price IceCream " + iceCream.getPrice() 
                + " - - " + "Number of IceCrream: " + totalNumIce + "\n" +
                "Tong hoa don " + totalPayment + "\n"
                +"Nguoi ban: " +employee;
                
        } else {
            return "Invoice details are incomplete.";
        }
    }

    @Override
    public int compareTo(Invoice o) {
        return this.invoiceName.compareTo(o.invoiceName);
    }
}
