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
     * @return
     */
    public Set<Basket> getAllBasket() {
        // TODO implement here
        return null;
    }

    /**
     * @param idProduct 
     * @param quantity 
     * @return
     */
    public void updateBasket(int idProduct, int quantity) {
        // TODO implement here
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