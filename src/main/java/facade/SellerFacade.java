package facade;

import dao.abstraction.AbstractFactoryDAO;
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

    private RateDAO rateDAO;
    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private RateDAO DAO = af.createRateDAO();

    /**
     * @param Consumer 
     * @param rate
     * @param seller
     * @return
     */
    public void AddRate(Consumer Consumer, int rate, String seller) {
        Seller userSeller = new Seller(seller,"r","r","d","@","streetAddress","city","21","","seller", "0102301023", "companyName");
        DAO.createRateSeller(userSeller , Consumer, rate);
    }

    /**
     * @param Consumer
     * @param seller
     * @return integer, the rate of the consumer
     */
    public float getRate(Consumer Consumer, String seller) {
        Seller userSeller = new Seller(seller,"r","r","d","@","streetAddress","city","21","","seller", "0102301023", "companyName");
        return DAO.rateSeller(userSeller , Consumer);
    }

    /**
     * @param seller
     * @return float, the average of all rates of a seller
     */
    public float getSellerAverageRate(Seller seller) {
        return DAO.averageRateSeller(seller);
    }


}