package main;

import gui.ProductRegistrationFrame;
import model.ProductTableModel;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ejecuta el código de la interfaz gráfica en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crea una instancia de ProductTableModel, que se utiliza para gestionar los datos de la tabla
            ProductTableModel productTableModel = new ProductTableModel();

            // Crea una instancia de ProductRegistrationFrame, pasando el modelo de productos
            ProductRegistrationFrame frame = new ProductRegistrationFrame(productTableModel);

            // Hace visible la ventana de registro de productos
            frame.setVisible(true);
        });
    }
}
