package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Consumer;
import model.Product;
import model.Rate;
import model.Seller;

import java.sql.Connection;
import java.util.*;

/**
 * Class RateDAO
 */
public abstract class RateDAO {

    /**
     * connection to the database
     */
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


    /**
     * SINGLETON
     * This method create only one instance of the class
     *
     * @return the instance of RateDAO
     */
    public static RateDAO getInstance() {
        if (instanceRateDAO == null) {
            instanceRateDAO = AbstractFactoryDAO.getFactory().createRateDAO();
        }
        return instanceRateDAO;
    }

    /**
     * This method add a rate for a seller in the database
     *
     * @param seller   seller on which the rate is created
     * @param consumer that add the rate
     * @param rate     an integer between 1 and 5
     */
    public abstract void createRateSeller(Seller seller, Consumer consumer, int rate);

    /**
     * This method add a rate for a product in the database
     *
     * @param consumer  that add the rate
     * @param rate      an integer between 1 and 5
     * @param idProduct of the product
     */
    public abstract void createRateProduct(Consumer consumer, int rate, int idProduct);

    /**
     * This method get a rate of a seller in the database
     *
     * @param seller   seller on which the rate is attributed
     * @param consumer who add the rate
     * @return the rate put by the consumer, if no notation return 0
     */
    public abstract float rateSeller(Seller seller, Consumer consumer);

    /**
     * This method get a rate of a product in the database
     *
     * @param consumer who add the rate
     * @param id       of the product
     * @return the rate put by the consumer, if no notation return 0
     */
    public abstract float rateProduct(Consumer consumer, int id);

    /**
     * This method get the average rate of all rates of a seller in the database
     *
     * @param seller seller we want to get the average note
     * @return the average rate of a seller, if no notation return 0
     */
    public abstract float averageRateSeller(Seller seller);


    /**
     * This method returns the average rates of a product
     * @param idProduct, the id of the product
     * @return a float of the average of all rate
     */
    public abstract float getAverageRateProduct(int idProduct);


}