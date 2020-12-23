package dao;

import model.Product;
import dataBase.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class ProductDAOMySQL extends ProductDAO {

    /**
     * Default constructor
     */
    public ProductDAOMySQL() {
    }

    /**
     * @param idProduct 
     * @return
     */
    public Product getProduct(int idProduct) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @return
     */
    public Set<Product> getProductsByName(String name) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param city 
     * @return
     */
    public Set<Product> getProductsByNameAndCity(String name, String city) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param idCategory 
     * @return
     */
    public Set<Product> getProductsByNameAndCategory(String name, int idCategory) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param city 
     * @param idCategory 
     * @return
     */
    public Set<Product> getProductsByNameAndCityAndCategory(String name, String city, int idCategory) {
        // TODO implement here
        return null;
    }

    @Override
    public Product createProduct(String nameProduct, String description, float price, String nameCategory, String picture) {
        Product product;

        String requete = "INSERT INTO product (name,description,price,seller,category,idProduct) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateProduct(String nameProduct, String description, float price) {
        return false;
    }

    @Override
    public boolean deleteProduct(String nameProduct, String description, float price) {
        return false;
    }

}