package dao;

import java.util.*;

/**
 * 
 */
public class ProductDAO extends ProductDAOMySQL {

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
     * @param nameProduct 
     * @param description 
     * @param price 
     * @return
     */
    public boolean createProduct(String nameProduct, String description, float price) {
        // TODO implement here
        return false;
    }

    /**
     * @param nameProduct 
     * @param description 
     * @param price 
     * @return
     */
    public boolean updateProduct(String nameProduct, String description, float price) {
        // TODO implement here
        return false;
    }

    /**
     * @param nameProduct 
     * @param description 
     * @param price 
     * @return
     */
    public boolean deleteProduct(String nameProduct, String description, float price) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Set<String> getAllProduct() {
        // TODO implement here
        return null;
    }

}