package dao;

import model.Consumer;
import model.Product;
import model.Rate;

import java.util.*;

/**
 * 
 */
public class RateDAOMySQl extends RateDAO {

    /**
     * Default constructor
     */
    public RateDAOMySQl() {
    }

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
     * @return
     */
    public Set<Rate> getAllRatesProduct(Product product) {
        // TODO implement here
        return null;
    }

}