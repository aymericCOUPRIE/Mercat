package facade;

import dao.AbstractFactoryDAO;
import dao.RateDAO;
import dao.UserDAO;
import model.Consumer;
import model.Seller;

import java.util.*;

/**
 * 
 */
public class SellerFacade {

    /**
     * Default constructor
     */
    public SellerFacade() {
    }

    /**
     * 
     */
    private RateDAO rateDAO;

    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private RateDAO DAO = af.createRateDAO();



    /**
     * @return
     */
    public Seller getSeller() {
        // TODO implement here
        return null;
    }

    /**
     * @param Consumer 
     * @param rate 
     * @return
     */
    public void AddRate(Consumer Consumer, int rate, String seller) {
        Seller userSeller = new Seller(seller,"r","r","d","@","streetAddress","city","21","","seller", "0102301023", "companyName");
        DAO.createRateSeller(userSeller , Consumer, rate);
    }

    /**
     * @param Consumer
     * @return integer the rate of the consumer
     */
    public float getRate(Consumer Consumer, String seller) {
        Seller userSeller = new Seller(seller,"r","r","d","@","streetAddress","city","21","","seller", "0102301023", "companyName");

        return DAO.rateSeller(userSeller , Consumer);
    }

    /**
     * @return
     */
    public float getSellerAverageRate(Seller seller) {
        return DAO.averageRateSeller(seller);
    }


}