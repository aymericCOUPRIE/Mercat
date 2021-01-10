package dao.abstraction;

import dao.AbstractFactoryDAO;
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

    private static RateDAO instanceRateDAO;

    /**
     * this methode permit to  connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected RateDAO(Connection connect) {
        this.connect = connect;
    }


    public static RateDAO getInstance() {
        if (instanceRateDAO == null) {
            instanceRateDAO = AbstractFactoryDAO.getFactory().createRateDAO();
        }
        return instanceRateDAO;
    }

    /**
     * This method add a rate for a seller in the database
     * @param seller
     * @param consumer that add the rate
     * @param rate an integer between 1 and 5
     */
    public abstract void createRateSeller(Seller seller, Consumer consumer, int rate);

    /**
     * This method add a rate for a product in the database
     * @param consumer that add the rate
     * @param rate an integer between 1 and 5
     * @param idProduct of the product
     */
    public abstract void createRateProduct(Consumer consumer, int rate, int idProduct);

    /**
     * This method get a rate of a seller in the database
     * @param seller
     * @param consumer who add the rate
     * @return the rate put by the consumer, if no notation return 0
     */
    public abstract float rateSeller(Seller seller, Consumer consumer);

    /**
     * This method get a rate of a product in the database
     * @param consumer who add the rate
     * @param id of the product
     * @return the rate put by the consumer, if no notation return 0
     */
    public abstract float rateProduct(Consumer consumer, int id);

    /**
     * This method get the average rate of all rates of a seller in the database
     * @param seller
     * @return the average rate of a seller, if no notation return 0
     */
    public abstract float averageRateSeller(Seller seller);


    public Set<Rate> getAllRatesProduct(Product product) {
        // TODO implement here
        return null;
    }


}