package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final List<Product> productList;
    private final String[] columnNames = {"ID del producto:", "Nombre del producto:", "Precio del producto:", "Cantidad del producto:"};

    public ProductTableModel() {
        this.productList = new ArrayList<>();
    }

    // Implementa los métodos requeridos (getRowCount, getColumnCount, getValueAt)
    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = productList.get(rowIndex);
        switch (columnIndex) {
            case 0: return product.getId();
            case 1: return product.getName();
            case 2: return product.getPrice();
            case 3: return product.getQuantity();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Agrega el método addProduct
    public void addProduct(Product product) {
        productList.add(product);
        int rowIndex = productList.size() - 1;
        fireTableRowsInserted(rowIndex, rowIndex);
    }
}