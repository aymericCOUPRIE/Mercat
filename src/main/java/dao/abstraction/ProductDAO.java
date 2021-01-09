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
     * @param connect
     */
    public ProductDAO(Connection connect) {
        this.connect = connect;
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
    public ArrayList<Product> getProductsByName(String name) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param city 
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCity(String name, String city) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param idCategory 
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCategory(String name, String idCategory) {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param city 
     * @param idCategory 
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCityAndCategory(String name, String city, String idCategory) {
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
     * @param p
     * @param newDescription
     * @return boolean
     */
    public abstract boolean updateProduct(Product p, String newDescription);

    /**
     * @param p
     * @return true if the product was deleted
     */
    public abstract boolean deleteProduct(Product p);

    /**
     * @return une arrrayList de tous les produits présents dans la db
     */
    public ArrayList<Product> getAllProduct() {
        return null;
    }

    public abstract int getProductId(Product p);

}