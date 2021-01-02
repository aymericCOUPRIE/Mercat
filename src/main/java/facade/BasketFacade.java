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

    public void updateBasket(String pseudo, int idProduct, int quantity) {
        //vérifier si true que ça c'est bien fait..
        basketDAO.updateBasket(pseudo,idProduct,quantity);

    }

    /**
     * @param idProduct 
     * @return
     */
    public void deleteBasket(int idProduct) {
        // TODO implement here
    }

    /**
     * @param idProduct 
     * @return
     */
    public void addToBasket(int idProduct) {
        // TODO implement here
    }



}