import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceSystem {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public void run() {
        // Sample setup
        products.add(new Product("P001", "Laptop", 1000));
        products.add(new Product("P002", "Mouse", 25));

        Customer customer = new Customer("C001", "Abhishek");
        customers.add(customer);

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, " + customer.getName());
        while (true) {
            System.out.println("1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                for (Product p : products)
                    System.out.println(p.getId() + ": " + p.getname() + " - $" + p.getprice());

            } else if (choice == 2) {
                System.out.print("Enter product ID: ");
                String pid = sc.next();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                for (Product p : products) {
                    if (p.getId().equals(pid)) {
                        customer.getCart().addProduct(p, qty);
                    }
                }

            } else if (choice == 3) {
                customer.getCart().showCart();

            } else if (choice == 4) {
                Order order = new Order(customer, customer.getCart().getItems());
                order.printInvoice();
                orders.add(order);
                break;

            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new EcommerceSystem().run();
    }
}
