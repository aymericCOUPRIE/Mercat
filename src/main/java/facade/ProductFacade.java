package facade;

import dao.AbstractFactoryDAO;
import dao.CommentDAO;
import dao.ProductDAO;
import dao.RateDAO;
import model.Comment;
import model.Consumer;
import model.Product;
import model.Rate;

import java.util.*;

/**
 * 
 */
public class ProductFacade {

    private Product product;
    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private ProductDAO productDAO = af.createProductDAO();

    private static ProductFacade instanceProductFacade;

    /**
     * @return instanceUserFacade
     **/

    public static ProductFacade getInstanceUserFacade() {
        if (instanceProductFacade == null) {
            instanceProductFacade= new ProductFacade();
        }
        return instanceProductFacade;
    }

    /**
     * Default constructor
     */
    public ProductFacade() {
    }



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
    public boolean addRate(Consumer Consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean addComment(Consumer consumer, String comment) {
        // TODO implement here
        return false;
    }

    /**
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean updateComment(Consumer consumer, String comment) {
        // TODO implement here
        return false;
    }

    /**
     * @param consumer 
     * @return
     */
    public boolean deleteComment(Consumer consumer) {
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
     * @param nameCategory
     * @return
     */
    public void createProduct(String nameProduct, String description, float price, String picture, String nameCategory) {
        product = productDAO.createProduct(nameProduct,description,price,nameCategory,picture);
    }

    /**
     * @param nameProduct 
     * @param description 
     * @param price 
     * @param picture 
     * @param idCategory 
     * @return
     */
    public void updateProduct(String nameProduct, String description, float price, String picture, int idCategory) {
        // TODO implement here
    }

    /**
     * @param idProduct 
     * @return
     */
    public void deleteProduct(int idProduct) {
        // TODO implement here
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