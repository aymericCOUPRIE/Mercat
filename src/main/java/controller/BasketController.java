package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import model.Basket;
import model.Product;

import java.util.*;

/**
 * 
 */
public class BasketController {

    /**
     *
     */
    private BasketFacade basketFacade;

    /**
     *
     */
    private OrderFacade orderFacade;

    /**
     * Default constructor
     */
    public BasketController() {
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
    public Product getProductDetails(int idProduct) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public float getPrixTotalBasket() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param baskets 
     * @return
     */
    public void createOrder(Set<Basket> baskets) {
        // TODO implement here
    }

}