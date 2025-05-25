import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Cartitem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        items.add(new Cartitem(product, quantity));
    }

    public void showCart() {
        for (Cartitem item : items) {
            System.out.println(item.getProduct().getname() + " x " + item.getQuantity()
                + " = $" + item.getTotalPrice());
        }
    }

    public double getTotal() {
        double sum = 0;
        for (Cartitem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public ArrayList<Cartitem> getItems() {
        return items;
    }
}
