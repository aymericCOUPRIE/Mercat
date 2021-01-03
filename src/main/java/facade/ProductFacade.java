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

    private boolean product;
    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private ProductDAO productDAO = af.createProductDAO();

    private static ProductFacade instanceProductFacade;

    private ArrayList<Product> listProduct = new ArrayList<Product>();

    /**
     * @return instanceUserFacade
     **/

    public static ProductFacade getInstance() {
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
    public ArrayList<Product> getProducts() {
        return listProduct;
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
     * @param p le Produit
     * @return
     */
    public boolean createProduct(Product p) {
        return productDAO.createProduct(p);
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
     * @param name
     * @return a collection of products
     */
    public ArrayList<Product> getProductsByName(String name) {
        listProduct = productDAO.getProductsByName(name);
        return productDAO.getProductsByName(name);
    }

    /**
     * @param name 
     * @param city 
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCity(String name, String city) {
        return productDAO.getProductsByNameAndCity(name, city);
    }

    /**
     * @param name  
     * @param category  
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCategory(String name , String category ) {
        return productDAO.getProductsByNameAndCategory(name,category);
    }

    /**
     * @param name 
     * @param city 
     * @param category 
     * @return
     */
    public void getProductByNameAndCityAndCategory(String name, String city, String category) {

    }

}