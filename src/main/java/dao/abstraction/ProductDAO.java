package dao.abstraction;

import model.Product;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class ProductDAO {

    protected Connection connect = null;

    /**
     * Default constructor
     * @param connect of Connection
     */
    public ProductDAO(Connection connect) {
        this.connect = connect;
    }




    /**
     * @param nameP , the name of the product we want to find
     * @return
     */
    public ArrayList<Product> getProductsByName(String nameP) {
        // TODO implement here
        return null;
    }

    /**
     * @param name of the product we want to find
     * @param city of the product we want to find
     * @return ArrayList<Product>
     */
    public ArrayList<Product> getProductsByNameAndCity(String name, String city) {
        // TODO implement here
        return null;
    }

    /**
     * @param name of the product we want to find
     * @param category  of the product we want to find
     * @return ArrayList<Product>
     */
    public ArrayList<Product> getProductsByNameAndCategory(String name, String category) {
        // TODO implement here
        return null;
    }

    /**
     * @param name of the product we want to find
     * @param city of the product we want to find
     * @param category of the product we want to find
     * @return ArrayList<Product>
     */
    public ArrayList<Product> getProductsByNameAndCityAndCategory(String name, String city, String category) {
        // TODO implement here
        return null;
    }

    /**
     * @param product le produit
     * @return boolean
     * Permet de renvoyer true ou false selon si l'on a réussit à insérer le produit dans la base de données
     */
    public abstract boolean createProduct(Product product);


    /**
     * @param p, the Product we want to update
     * @param newDescription, the new description of the product
     * @return boolean, true if the product was updated into the database
     */
    public abstract boolean updateProduct(Product p, String newDescription);

    /**
     * @param p, the Product that we want to delete
     * @return boolean, true if the product was deleted
     */
    public abstract boolean deleteProduct(Product p);

    /**
     * @return une arrrayList de tous les produits présents dans la db
     */
    public ArrayList<Product> getAllProduct() {
        return null;
    }

    /**
     * @param p, the product whose id we want
     * @return int, the id of the product
     */
    public abstract int getProductId(Product p);

}