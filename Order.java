import java.util.Date;
import java.util.ArrayList;


public class Order {
    
    private Customer customer;
    private ArrayList<Cartitem> items;
    private Date orderDate;

    public Order(Customer customer, ArrayList<Cartitem> items) {
        this.customer = customer;
        this.items = items;
        this.orderDate = new Date();
    }
    public static void main(String[] args) {
        // You can add test code here if needed
    }

    public void printInvoice() {
        System.out.println("Order for " + customer.getName() + " on " + orderDate);
        double total = 0;
        for (Cartitem item : items) {
            System.out.println(item.getProduct().getname() + " x " + item.getQuantity() +
                               " = $" + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total: $" + total);
    }
}
