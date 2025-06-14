public class Cartitem {
    private Product product;
    private int quantity;

    public Cartitem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() {
        return product.getprice() * quantity;
    }
}
