package facade;

import java.util.*;

/**
 * 
 */
public class ProductFacade {

    /**
     * Default constructor
     */
    public ProductFacade() {
    }

    /**
     * 
     */
    private ProductDAO productDAO;

    /**
     * 
     */
    private AbstractFactoryDAO af;

    /**
     * 
     */
    private RateDAO rateDAO;

    /**
     * 
     */
    private CommentDAO commentDAO;






    /**
     * @return
     */
    public Product getProduct() {
        // TODO implement here
        return null;
    }

    /**
     * @param Consumer 
     * @param rate 
     * @return
     */
    public boolean addRate(consumer Consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean addComment(consumer consumer, string comment) {
        // TODO implement here
        return false;
    }

    /**
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean updateComment(consumer consumer, string comment) {
        // TODO implement here
        return false;
    }

    /**
     * @param consumer 
     * @return
     */
    public boolean deleteComment(consumer consumer) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Set<Comment> getAllComments() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Rate> getAllRates() {
        // TODO implement here
        return null;
    }

    /**
     * @param nameProduct 
     * @param description 
     * @param price 
     * @param picture 
     * @param idCategory 
     * @return
     */
    public void createProduct(string nameProduct, String description, float price, String picture, int idCategory) {
        // TODO implement here
        return null;
    }

    /**
     * @param nameProduct 
     * @param description 
     * @param price 
     * @param picture 
     * @param idCategory 
     * @return
     */
    public void updateProduct(string nameProduct, String description, float price, String picture, int idCategory) {
        // TODO implement here
        return null;
    }

    /**
     * @param idProduct 
     * @return
     */
    public void deleteProduct(int idProduct) {
        // TODO implement here
        return null;
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
     * @param city 
     * @return
     */
    public Set<Product> getProductsByNameAndCity(String name, String city) {
        // TODO implement here
        return null;
    }

    /**
     * @param name  
     * @param category  
     * @return
     */
    public Set<Product> getProductsByNameAndCategory(String name , String category ) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param city 
     * @param category 
     * @return
     */
    public Set<Product> getProductByNameAndCityAndCategory(String name, String city, String category) {
        // TODO implement here
        return null;
    }

}