package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    // Lista para almacenar los productos que se mostrarán en la tabla.
    // Se usa List<Product> para mantener flexibilidad si se desea cambiar la implementación de la lista más tarde.
    private final List<Product> productList;

    // Nombres de las columnas de la tabla, que definen cómo se verá el encabezado. Estos nombres sirven para identificar qué información se muestra en cada columna.
    private final String[] columnNames = {"ID del producto:", "Nombre del producto:", "Precio del producto:", "Cantidad del producto:"};

    // Constructor que inicializa la lista de productos. Aquí se usa un ArrayList para tener una estructura dinámica.
    public ProductTableModel() {
        this.productList = new ArrayList<>();
    }

    // Método que indica la cantidad de filas en la tabla, que está directamente relacionada con el tamaño de la lista de productos. Cada producto representa una fila.
    @Override
    public int getRowCount() {
        return productList.size();
    }

    // Método que devuelve el número de columnas de la tabla, que está determinado por el número de elementos en el array de nombres de columnas.
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // Este método obtiene el valor de una celda específica (fila, columna).
    // Aquí se usa un switch para determinar qué atributo del producto se debe devolver para cada columna.
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtiene el producto correspondiente a la fila indicada por rowIndex.
        Product product = productList.get(rowIndex);
        switch (columnIndex) {
            case 0: return product.getId();         // Retorna el ID del producto
            case 1: return product.getName();       // Retorna el nombre del producto
            case 2: return product.getPrice();      // Retorna el precio del producto
            case 3: return product.getQuantity();   // Retorna la cantidad del producto
            default: return null;                   // Si la columna no coincide con ninguna de las esperadas, devuelve null
        }
    }

    // Este método sobrescribe getColumnName para devolver los nombres de las columnas. Es importante para que el JTable sepa qué mostrar en el encabezado de cada columna.
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Agregar producto. Al llamar a fireTableRowsInserted, notifica a la tabla que se ha agregado una nueva fila, actualizando la vista automáticamente.
    public void addProduct(Product product) {
        productList.add(product);
        // Obtiene el índice de la nueva fila agregada.
        int rowIndex = productList.size() - 1;
        // Notifica al modelo de la tabla que se ha insertado una nueva fila.
        fireTableRowsInserted(rowIndex, rowIndex);
    }
}
