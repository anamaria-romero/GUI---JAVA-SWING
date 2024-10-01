package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Product;
import model.ProductTableModel;
public class ProductRegistrationFrame extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JButton saveButton;
    private ProductTableModel productTableModel;

    public ProductRegistrationFrame(ProductTableModel productTableModel) {
        this.productTableModel = productTableModel;
        setTitle("Area para registrar productos");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        // Implementa la inicialización de componentes
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID del producto:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Nombre del producto:");
        nameField = new JTextField();

        JLabel priceLabel = new JLabel("Precio del producto:");
        priceField = new JTextField();

        JLabel quantityLabel = new JLabel("Cantidad del producto:");
        quantityField = new JTextField();

        saveButton = new JButton("Guardar producto.");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(priceLabel);
        add(priceField);
        add(quantityLabel);
        add(quantityField);
        add(new JLabel());
        add(saveButton);
    }

    private void saveProduct() {
        // Implementa la lógica de guardado
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(id, name, price, quantity);
            productTableModel.addProduct(product);

            idField.setText("");
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");

            JOptionPane.showMessageDialog(this, "El producto ha sido guardado.");
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Los datos ingresados no son validos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}