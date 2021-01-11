package facade;

import dao.abstraction.RateDAO;
import model.Consumer;
import model.Seller;

/**
 * Class SellerFacade
 */
public class SellerFacade {


    private final RateDAO rateDAO = RateDAO.getInstance();


    /**
     * Default constructor
     */
    public SellerFacade() {
    }


    /**
     * This method permits to add a rate for a seller
     *
     * @param Consumer who rates the seller
     * @param rate     an int between 1 and 5
     * @param seller   subject of the rate
     */
    public void AddRate(Consumer Consumer, int rate, String seller) {
        Seller userSeller = new Seller(seller, "r", "r", "d", "@", "streetAddress", "city", "21", "", "seller", "0102301023", "companyName");
        rateDAO.createRateSeller(userSeller, Consumer, rate);
    }

    /**
     * This method permits to get the rate of a seller
     *
     * @param Consumer who rated the seller
     * @param seller   subject of the rates we are looking for
     * @return integer, the rate put by the consumer
     */
    public float getRate(Consumer Consumer, String seller) {
        Seller userSeller = new Seller(seller, "r", "r", "d", "@", "streetAddress", "city", "21", "", "seller", "0102301023", "companyName");
        return rateDAO.rateSeller(userSeller, Consumer);
    }

    /**
     * This method permits to get the average rate of a seller
     *
     * @param seller subject of the rates
     * @return float, the average of all rates of a seller
     */
    public float getSellerAverageRate(Seller seller) {
        return rateDAO.averageRateSeller(seller);
    }


}