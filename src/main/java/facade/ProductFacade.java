package facade;

import dao.abstraction.CommentDAO;
import dao.abstraction.ProductDAO;
import dao.abstraction.RateDAO;
import model.Comment;
import model.Consumer;
import model.Product;
import model.Rate;

import java.util.ArrayList;
import java.util.Set;

/**
 * 
 */
public class ProductFacade {

    private ProductDAO productDAO = ProductDAO.getInstance();
    private RateDAO rateDAO = RateDAO.getInstance();
    private CommentDAO commentDAO = CommentDAO.getInstance();

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
     * @return
     */
    public ArrayList<Product> getProducts() {
        return listProduct;
    }


    /**
     * @param consumer 
     * @param comment
     * @param idProduct
     * @return
     */
    public void addComment(Consumer consumer, String comment, int idProduct) {
        commentDAO.createComment(consumer, comment, idProduct);
    }

    /**
     * @param consumer 
     * @param comment
     * @param idProduct
     * @return
     */
    public void updateComment(Consumer consumer, String comment, int idProduct) {
        commentDAO.updateComment(consumer, comment, idProduct);
    }

    /**
     * @param c
     * @param id
     * @return
     */
    public float getRate(Consumer c, int id) {
        return rateDAO.rateProduct(c , id);
    }

    /**
     * @param c
     * @param id
     * @return
     */
    public String getComment(Consumer c, int id) {
        return commentDAO.getComment(c , id);
    }

    /**
     * @param consumer
     * @param rate
     * @param idProduct
     * @return
     */
    public void AddRate(Consumer consumer, int rate, int idProduct) {
        rateDAO.createRateProduct(consumer, rate, idProduct);
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
    public ArrayList<Product> getProductByNameAndCityAndCategory(String name, String city, String category) {
        return productDAO.getProductsByNameAndCityAndCategory(name,city,category);
    }

    public ArrayList<Product> getProductsBySeller(String seller){
        return productDAO.getProductsBySeller(seller);
    }
    public int getIdProduct(Product p){
        return productDAO.getProductId(p);
    }

}