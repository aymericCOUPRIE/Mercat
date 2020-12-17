package dao;

import model.Consumer;
import model.Product;
import model.Rate;
import model.Seller;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class RateDAO {

    /**
     * Default constructor
     */
    public RateDAO() {
    }

    /**
     * 
     */
    public Connection connect;


    /**
     * @param product 
     * @param consumer 
     * @param rate 
     * @return
     */
    public boolean createRateProduct(Product product, Consumer consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @param consumer 
     * @param rate 
     * @return
     */
    public boolean updateRate(Product product, Consumer consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @param consumer 
     * @return
     */
    public boolean deleteRate(Product product, Consumer consumer) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @return
     */
    public Set<Rate> getAllRatesProduct(Product product) {
        // TODO implement here
        return null;
    }

    /**
     * @param seller 
     * @param consumer 
     * @param rate 
     * @return
     */
    public boolean createRateSeller(Seller seller, Consumer consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param seller 
     * @return
     */
    public Set<Rate> getAllRatesSeller(Seller seller) {
        // TODO implement here
        return null;
    }

}