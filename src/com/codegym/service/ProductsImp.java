package com.codegym.service;

import com.codegym.Database;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsImp extends Database implements IProduct {
    String selectAllClothing = "select * from product;";
    String updateProduct = "update product set name = ?, price = ?, number = ?, color = ?, description = ?, category = ? where id = ?";
    String insertProduct = "insert into product (name, price, number ,color,description,category) values (?, ?, ?, ?, ?, ?)";
    String deleteProduct = "delete from product where id = ?";
    String findPriceStatement = "select * from product pr where pr.price = ?";
    String seclectByID = "select * from product where id = ?";
    private static final String SELECT_BY_NAME = "select id,name,price, number , color,description,category from product where name=?";


    @Override
    public void insert(Product product) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(insertProduct)
        ) {

            statement.setString(1, product.getName());
            statement.setString(2, product.getPrice());
            statement.setString(3, product.getNumber());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getCategory());

//            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Product product) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(updateProduct)
        ) {

            statement.setString(1, product.getName());
            statement.setString(2, product.getPrice());
            statement.setString(3, product.getNumber());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getCategory());
            statement.setInt(7, product.getId());

            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(seclectByID)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String price = resultSet.getString(3);
                String number = resultSet.getString(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                String category = resultSet.getString(7);

                product=new Product(id,name,price,number,color,description,category);

                break;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> product = new ArrayList<>();

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(selectAllClothing)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String number = resultSet.getString("number");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");

                product.add(new Product(id, name, price, number,color,description, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void remove(int id) {
        boolean rowDeleted;

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(deleteProduct);
        ) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Product> findByPrice(String price) {
//        List<Product> productList = new ArrayList<>();
//
//        try (
//                Connection connection = getConnection();
//                PreparedStatement statement = connection.prepareStatement(findPriceStatement);
//        ) {
//
//            statement.setString(1, price);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String number = resultSet.getString("number");
//                String color = resultSet.getString("color");
//                String discerption = resultSet.getString("discerption");
//
//                Product product = new Product(id , name, number, color, discerption);
//                productList.add(product);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return productList;
        return null;
    }

    @Override
    public List<Product> searchByName(String searchName) {
        List<Product> products = new ArrayList<>();
        // thiết lập kết nối
        try(Connection connection = getConnection();
            //tạo 1 câu lệnh bằng cách sử dụng kết nối
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME)){
            preparedStatement.setString(1,searchName);
            System.out.println(preparedStatement);
            // thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            // xử lý đối tượng resultSet
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price =rs.getString("price");
                String number = rs.getString("number");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                products.add(new Product(id, name, price, number,color,description,category));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
