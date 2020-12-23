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
    public boolean createProduct(Product product) {
        //TODO Demander si cela marche
        String requete = "INSERT INTO product (name,description,price,seller,category,idProduct) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setString(3,""+product.getPriceProduct());
            preparedStatement.setString(4,product.getPseudoSeller());
            //TODO voir si on ne change pas l'id pour le nom de la catégorie
            preparedStatement.setString(5,""+product.getIdCategorie());

            return preparedStatement.executeUpdate()!=0;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;

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