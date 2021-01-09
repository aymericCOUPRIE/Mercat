package facade;

import dao.AbstractFactoryDAO;
import dao.abstraction.RateDAO;
import model.Consumer;
import model.Seller;

/**
 * 
 */
public class SellerFacade {

    /**
     * Default constructor
     */
    public SellerFacade() {
    }

    private RateDAO rateDAO = RateDAO.getInstance();

    /**
     * This method permits to add a rate for a seller
     * @param Consumer 
     * @param rate an int between 1 and 5
     * @param seller
     */
    public void AddRate(Consumer Consumer, int rate, String seller) {
        Seller userSeller = new Seller(seller,"r","r","d","@","streetAddress","city","21","","seller", "0102301023", "companyName");
        rateDAO.createRateSeller(userSeller , Consumer, rate);
    }

    /**
     * This method permits to get the rate of a seller
     * @param Consumer
     * @param seller
     * @return integer, the rate put by the consumer
     */
    public float getRate(Consumer Consumer, String seller) {
        Seller userSeller = new Seller(seller,"r","r","d","@","streetAddress","city","21","","seller", "0102301023", "companyName");
        return rateDAO.rateSeller(userSeller , Consumer);
    }

    /**
     * This method permits to get the average rate of a seller
     * @param seller
     * @return float, the average of all rates of a seller
     */
    public float getSellerAverageRate(Seller seller) {
        return rateDAO.averageRateSeller(seller);
    }


}