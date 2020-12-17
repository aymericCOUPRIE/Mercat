package facade;

import dao.AbstractFactoryDAO;
import dao.RateDAO;
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

    /**
     * 
     */
    private AbstractFactoryDAO af;




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
    public boolean AddRate(Consumer Consumer, int rate) {
        // TODO implement here
        return false;
    }

}