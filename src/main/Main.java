package main;

import gui.ProductRegistrationFrame;
import model.ProductTableModel;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductTableModel productTableModel = new ProductTableModel();

            ProductRegistrationFrame frame = new ProductRegistrationFrame(productTableModel);
            frame.setVisible(true);
        });
    }
}
