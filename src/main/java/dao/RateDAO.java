package dao;

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
    public boolean createRateProduct(product product, consummer consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @param consumer 
     * @param rate 
     * @return
     */
    public boolean updateRate(product product, consummer consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @param consumer 
     * @return
     */
    public boolean deleteRate(product product, consummer consumer) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @return
     */
    public Set<Rate> getAllRatesProduct(product product) {
        // TODO implement here
        return null;
    }

    /**
     * @param seller 
     * @param consumer 
     * @param rate 
     * @return
     */
    public boolean createRateSeller(seller seller, consummer consumer, int rate) {
        // TODO implement here
        return false;
    }

    /**
     * @param seller 
     * @return
     */
    public Set<Rate> getAllRatesSeller(seller seller) {
        // TODO implement here
        return null;
    }

}