package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Product;
import model.ProductTableModel;

public class ProductRegistrationFrame extends JFrame {
    // Declaración de componentes de la interfaz de usuario (UI)
    private JTextField idField;          // Campo de texto para el ID del producto
    private JTextField nameField;        // Campo de texto para el nombre del producto
    private JTextField priceField;       // Campo de texto para el precio del producto
    private JTextField quantityField;    // Campo de texto para la cantidad del producto
    private JButton saveButton;          // Botón para guardar el producto
    private ProductTableModel productTableModel; // Modelo para la tabla de productos
    private JTable productTable;         // Tabla que muestra la lista de productos

    // Constructor que recibe el modelo de la tabla de productos
    public ProductRegistrationFrame(ProductTableModel productTableModel) {
        this.productTableModel = productTableModel; // Asigna el modelo de la tabla
        setTitle("Registro de Productos");          // Título de la ventana
        setSize(600, 400);                          // Dimensiones de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
        setLocationRelativeTo(null);                // Centra la ventana en la pantalla

        initComponents(); // Inicializa los componentes de la interfaz de usuario
    }

    // Método que inicializa los componentes de la interfaz
    private void initComponents() {

        // Establece el diseño de la ventana como BorderLayout
        setLayout(new BorderLayout());

        // Panel de entrada con GridLayout de 5 filas y 2 columnas, y un espaciado de 10px
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Creación de etiquetas y campos de texto para los datos del producto
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        JLabel nameLabel = new JLabel("Nombre:");
        nameField = new JTextField();

        JLabel priceLabel = new JLabel("Precio:");
        priceField = new JTextField();

        JLabel quantityLabel = new JLabel("Cantidad:");
        quantityField = new JTextField();

        // Inicialización del botón de guardar
        saveButton = new JButton("Guardar");
        // Añade un ActionListener para escuchar cuando se haga clic en el botón
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct(); // Llama al método saveProduct() al hacer clic
            }
        });

        // Añade los componentes al panel de entrada en el orden correspondiente
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel()); // Añade una celda vacía para el espaciado
        inputPanel.add(saveButton);   // Añade el botón de guardar al final del panel

        // Inicializa la tabla de productos con el modelo dado
        productTable = new JTable(productTableModel);
        productTable.setFillsViewportHeight(true);              // Hace que la tabla llene el área visible
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite seleccionar solo una fila

        // Añade un panel de desplazamiento para la tabla, lo que permite desplazarse si hay muchos productos
        JScrollPane tableScrollPane = new JScrollPane(productTable);

        // Añade el panel de entrada en la parte superior (NORTH) y la tabla en el centro (CENTER) del diseño BorderLayout
        add(inputPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
    }

    // Método para guardar el producto
    private void saveProduct() {
        try {

            // Obtiene y convierte los valores ingresados por el usuario en los campos de texto
            int id = Integer.parseInt(idField.getText());        // Convierte el ID de String a int
            String name = nameField.getText();                   // Obtiene el nombre como String
            double price = Double.parseDouble(priceField.getText()); // Convierte el precio a double
            int quantity = Integer.parseInt(quantityField.getText()); // Convierte la cantidad a int

            // Crea una instancia de Producto con los valores ingresados
            Product product = new Product(id, name, price, quantity);
            // Añade el producto al modelo de la tabla
            productTableModel.addProduct(product);

            // Limpia los campos de entrada después de guardar
            idField.setText("");
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");

            // Muestra un mensaje emergente indicando que el producto se guardó correctamente
            JOptionPane.showMessageDialog(this, "Producto guardado exitosamente!");

        } catch (NumberFormatException e) {
            // Si los datos ingresados no son válidos (ej. texto en lugar de número), muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
