package dao.abstraction;

import model.Consumer;
import model.Product;
import model.Rate;
import model.Seller;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class RateDAO {

    protected Connection connect = null;

    /**
     * Default constructor
     *
     * @param connect
     */
    public RateDAO(Connection connect) {
        this.connect = connect;
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
     */
    public abstract void createRateSeller(Seller seller, Consumer consumer, int rate);

    /**
     * @param consumer
     * @param rate
     * @param idProduct
     */
    public abstract void createRateProduct(Consumer consumer, int rate, int idProduct);

    /**
     * @param seller
     * @param consumer
     * @return the rate put by the consumer
     */
    public abstract float rateSeller(Seller seller, Consumer consumer);

    /**
     * @param consumer
     * @return the rate put by the consumer
     */
    public abstract float rateProduct(Consumer consumer, int i);

    /**
     * @param seller
     * @return the average rate of a seller
     */
    public abstract float averageRateSeller(Seller seller);

    /**
     * @param seller 
     * @return
     */
    public Set<Rate> getAllRatesSeller(Seller seller) {
        // TODO implement here
        return null;
    }

}