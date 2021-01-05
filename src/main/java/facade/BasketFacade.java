package facade;

import dao.AbstractFactoryDAO;
import dao.BasketDAO;
import model.Basket;

import java.util.*;

/**
 * 
 */
public class BasketFacade {

    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private BasketDAO basketDAO = af.createBasketDAO();

    //notre façade est un singleton
    private static BasketFacade instanceBasketFacade = getInstanceBasketFacade();

    /**
     * @return instanceBasketFacade
     */
    public static BasketFacade getInstanceBasketFacade() {
        if (instanceBasketFacade == null) {
            instanceBasketFacade = new BasketFacade();
        }
        return instanceBasketFacade;
    }

    /**
     * Default constructor
     */
    public BasketFacade() {
    }





    /**
     * this method allows to retrieve all the baskets of the connected consumer whose the pseudo is passed in parameter
     * @param pseudo
     * @return ArrayList<Basket>
     */
    public ArrayList<Basket> getAllBasket(String pseudo) {
        return basketDAO.getAllBasket(pseudo);
    }

    /**
     * This methode permit to update the quantity of a product in the basket
     * @param idProduct 
     * @param quantity
     * @param pseudo

     */

    public boolean updateBasket(String pseudo, int idProduct, int quantity) {

       return basketDAO.updateBasket(pseudo,idProduct,quantity);

    }

    /**
     * This methode permit to delete a basket
     *
     * @param idProduct, pseudo
     * @return boolean true if it's done
     */
    public boolean deleteBasket(int idProduct, String pseudo) {
        return basketDAO.deleteBasket(idProduct, pseudo);
    }

    /**
     * This methode permit to add the product of the curent page in the customer's basket
     * @param idProduct, pseudo, quantity
     * @return boolean true if the product has been added into the basket
     */
    public boolean addToBasket(int idProduct, int quantity, String pseudo) {
        return basketDAO.createBasket(idProduct, quantity, pseudo);
    }



}