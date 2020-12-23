package dao;

import model.Product;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class ProductDAO {

    /**
     * Default constructor
     */
    public ProductDAO() {
    }

    /**
     * 
     */
    public Connection connect;



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

    /**
     * @param p le produit
     * @return boolean
     * Permet de renvoyer true ou false selon si l'on a réussie à insérer le produit dans la base de données
     */
    public abstract boolean createProduct(Product p);

    /**
     * @param nameProduct 
     * @param description 
     * @param price 
     * @return
     */
    public abstract boolean updateProduct(String nameProduct, String description, float price);

    /**
     * @param nameProduct 
     * @param description 
     * @param price 
     * @return
     */
    public abstract boolean deleteProduct(String nameProduct, String description, float price);

    /**
     * @return
     */
    public Set<String> getAllProduct() {
        // TODO implement here
        return null;
    }

}