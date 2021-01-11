package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Product;

import java.sql.Connection;
import java.util.*;

/**
 * Class ProductDAO
 */
public abstract class ProductDAO {

    /**
     * connection to the database
     */
    protected Connection connect = null;

    private static ProductDAO instanceProductDAO;

    /**
     * Default constructor
     *
     * @param connect of Connection
     */
    public ProductDAO(Connection connect) {
        this.connect = connect;
    }


    /**
     * This method create only one instance of the class
     *
     * @return the instance of ProductDAO
     */
    public static ProductDAO getInstance() {
        if (instanceProductDAO == null) {
            instanceProductDAO = AbstractFactoryDAO.getFactory().createProductDAO();
        }
        return instanceProductDAO;
    }


    /**
     * This method returns all the products who have the same name
     * @param nameP , the name of the product we want to find
     * @return a list of all the products who have the same name
     */
    public ArrayList<Product> getProductsByName(String nameP) {
        return null;
    }

    /**
     * This method returns all the products who have the same city and name
     * @param name of the product we want to find
     * @param city of the product we want to find
     * @return a list of all the products from a city
     */
    public ArrayList<Product> getProductsByNameAndCity(String name, String city) {
        return null;
    }

    /**
     * This method returns all the products who have the same name and in the same category
     * @param name     of the product we want to find
     * @param category of the product we want to find
     * @return a list of all the products from a specific category
     */
    public ArrayList<Product> getProductsByNameAndCategory(String name, String category) {
        return null;
    }

    /**
     * This method returns all the products who have the same the name, city and category
     * @param name     of the product we want to find
     * @param city     of the product we want to find
     * @param category of the product we want to find
     * @return a list a of product from a specific name, city and category
     */
    public ArrayList<Product> getProductsByNameAndCityAndCategory(String name, String city, String category) {
        return null;
    }

    /**
     * @param product le produit
     * @return true or false
     * Permet de renvoyer true ou false selon si l'on a réussit à insérer le produit dans la base de données
     */
    public abstract boolean createProduct(Product product);


    /**
     * this method updates a given product into the database
     * @param p, the Product we want to update
     * @return true if the product was updated into the database
     */
    public abstract boolean updateProduct(Product p);

    /**
     * This method deletes a given product of the database
     * @param p, the Product that we want to delete
     * @return true if the product was deleted
     */
    public abstract boolean deleteProduct(Product p);

    /**
     * This method gives all the products we have in the db
     * @return une arrrayList de tous les produits présents dans la db
     */
    public ArrayList<Product> getAllProduct() {
        return null;
    }

    /**
     * This method returns the id of a product
     * @param p, the product whose id we want
     * @return the id of the product
     */
    public abstract int getProductId(Product p);

    /**
     * This method returns all the seller's product
     * @param seller whose products we want to get
     * @return all the products he has
     */
    public ArrayList<Product> getProductsBySeller(String seller) {
        return null;
    }

    /**
     * This method returns the id of category given her libelleCategorie
     * @param libelle of the category
     * @return the id of the category
     */
    public int getCategoryId(String libelle) {
        return -1;
    }

    /**
     * @param id of the category
     * @return the libelle of the caegory, which id is in parameterD
     */
    public String getCategoryLibelle(int id){ return ""; }


}