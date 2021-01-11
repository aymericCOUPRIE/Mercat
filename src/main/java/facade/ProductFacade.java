package facade;

import dao.abstraction.CommentDAO;
import dao.abstraction.ProductDAO;
import dao.abstraction.RateDAO;
import model.Consumer;
import model.Product;

import java.util.ArrayList;


/**
 * 
 */
public class ProductFacade {

    private final ProductDAO productDAO = ProductDAO.getInstance();
    private final RateDAO rateDAO = RateDAO.getInstance();
    private final CommentDAO commentDAO = CommentDAO.getInstance();

    private static ProductFacade instanceProductFacade;

    private final ArrayList<Product> listProduct = new ArrayList<Product>();

    /**
     * @return an instance of the product facade
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
    private ProductFacade() {
    }

    /**
     * @return the list of product
     */
    public ArrayList<Product> getProducts() {
        return listProduct;
    }


    /**
     * This method permits to add a comment for a product
     * @param consumer who add the comment
     * @param comment a string with the content
     * @param idProduct an integer
     */
    public void addComment(Consumer consumer, String comment, int idProduct) {
        commentDAO.createComment(consumer, comment, idProduct);
    }

    /**
     * This method permits to update a comment for a product
     * @param consumer who add the comment
     * @param comment a string with the content
     * @param idProduct an integer
     */
    public void updateComment(Consumer consumer, String comment, int idProduct) {
        commentDAO.updateComment(consumer, comment, idProduct);
    }

    /**
     * This method permits to get a rate for a product
     * @param c consumer who add the rate
     * @param id of the product
     * @return the rate, a float
     */
    public float getRate(Consumer c, int id) {
        return rateDAO.rateProduct(c , id);
    }

    /**
     * This method permits to get a comment for a product
     * @param c consumer who add the comment
     * @param id of the product
     * @return the content of the comment, a String
     */
    public String getComment(Consumer c, int id) {
        return commentDAO.getComment(c , id);
    }

    /**
     * This method permits to add a rate for a product
     * @param consumer who add the rate
     * @param rate an integer between 1 and 5
     * @param idProduct integer
     */
    public void AddRate(Consumer consumer, int rate, int idProduct) {
        rateDAO.createRateProduct(consumer, rate, idProduct);
    }


    /**
     * @param p le Produit
     * @return true if the product was created in the db
     */
    public boolean createProduct(Product p) {
        return productDAO.createProduct(p);
    }

    /**
     * @param product the product we want to update
     * @return true if the product was updated
     */
    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    /**
     * @param p the product we want to delete
     * @return true if the product was deleted
     */
    public boolean deleteProduct(Product p) {
        return productDAO.deleteProduct(p);
    }

    /**
     * This method returns all the products who have the same name
     * @param name , the name of the product we want to find
     * @return a list of all the products who have the same name
     */
    public ArrayList<Product> getProductsByName(String name) {
        return productDAO.getProductsByName(name);
    }

    /**
     * This method returns all the products who have the same city and name
     * @param name of the product we want to find
     * @param city of the product we want to find
     * @return a list of all the products from a city
     */
    public ArrayList<Product> getProductsByNameAndCity(String name, String city) {
        return productDAO.getProductsByNameAndCity(name, city);
    }

    /**
     * This method returns all the products who have the same name and in the same category
     * @param name     of the product we want to find
     * @param category of the product we want to find
     * @return a list of all the products from a specific category
     */
    public ArrayList<Product> getProductsByNameAndCategory(String name , String category ) {
        return productDAO.getProductsByNameAndCategory(name,category);
    }

    /**
     * This method returns all the products who have the same the name, city and category
     * @param name     of the product we want to find
     * @param city     of the product we want to find
     * @param category of the product we want to find
     * @return a list a of product from a specific name, city and category
     */
    public ArrayList<Product> getProductByNameAndCityAndCategory(String name, String city, String category) {
        return productDAO.getProductsByNameAndCityAndCategory(name,city,category);
    }

    /**
     * This method returns all the seller's product
     * @param seller whose products we want to get
     * @return all the products he has
     */
    public ArrayList<Product> getProductsBySeller(String seller){
        return productDAO.getProductsBySeller(seller);
    }

    /**
     * This method returns the id of a product
     * @param p, the product whose id we want
     * @return the id of the product
     */
    public int getIdProduct(Product p){
        return productDAO.getProductId(p);
    }

    /**
     * This method returns the id of category given her libelleCategorie
     * @param libelle of the category
     * @return the id of the category
     */
   public int getCategoryId(String libelle){return productDAO.getCategoryId(libelle);}
}