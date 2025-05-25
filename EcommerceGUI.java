import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EcommerceGUI extends JFrame {
    private DefaultListModel<String> productListModel;
    private JList<String> productList;
    private DefaultListModel<String> cartListModel;
    private JList<String> cartList;
    private JButton addToCartButton, checkoutButton;

    public EcommerceGUI() {
        setTitle("E-Commerce System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Product List
        productListModel = new DefaultListModel<>();
        productListModel.addElement("Laptop - 80000");
        productListModel.addElement("Smartphone - 15000");
        productListModel.addElement("Headphones - 1000");
        
        productList = new JList<>(productListModel);

        // Cart List
        cartListModel = new DefaultListModel<>();
        cartList = new JList<>(cartListModel);

        // Buttons
        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");

        addToCartButton.addActionListener(e -> {
            String selected = productList.getSelectedValue();
            if (selected != null) {
                cartListModel.addElement(selected);
            }
        });

        checkoutButton.addActionListener(e -> {
            if (cartListModel.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cart is empty!");
            } else {
                JOptionPane.showMessageDialog(this, "Checkout successful!");
                cartListModel.clear();
            }
        });

        // Layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        productPanel.add(new JScrollPane(productList), BorderLayout.CENTER);
        productPanel.add(addToCartButton, BorderLayout.SOUTH);

        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createTitledBorder("Cart"));
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
        cartPanel.add(checkoutButton, BorderLayout.SOUTH);

        mainPanel.add(productPanel);
        mainPanel.add(cartPanel);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EcommerceGUI().setVisible(true);
        });
    }
}