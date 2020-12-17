package dao;

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

}