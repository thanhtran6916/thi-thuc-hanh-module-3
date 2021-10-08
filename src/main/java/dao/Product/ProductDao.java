package dao.Product;

import dao.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao{
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from view_product_and_category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("productId");
                String name = resultSet.getString("productName");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_Id");
                String categoryName = resultSet.getString("categoryName");
                Product product = new Product(id, name, price, quantity, color, description, categoryId, categoryName);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        boolean isSave = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price, quantity, color, description, category_id) value (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryId());
            isSave = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    @Override
    public boolean edit(int id, Product product) {
        boolean isEdit = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name = ?, price = ?, quantity = ?, description = ?, category_id = ? where id = ?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.setInt(6, id);
            isEdit = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isEdit;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
            preparedStatement.setInt(1, id);
            isDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    @Override
    public Product getById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from product where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                product = new Product(id, name, price, quantity, color, description, categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                Product product = new Product(id, name1, price, quantity, color, description, categoryId);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
