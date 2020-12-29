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
    public void AddRate(Consumer Consumer, int rate) {
        Seller userSeller = new Seller("stephanie","r","r","d","@","streetAddress","city","21","","seller", "0102301023", "companyName");

        DAO.createRateSeller(userSeller , Consumer, rate);
    }

}