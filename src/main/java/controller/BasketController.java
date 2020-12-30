package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import javafx.fxml.FXML;
import model.Basket;
import model.Product;

import java.awt.*;
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

    @FXML
    private Label labelNbProducts, labelTotPrice;


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
     * @return
     */
    public float getPrixTotalBasket() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * give the total number of item in the basket
     * @return int
     */
    public int getNbItemBasket(){
    //TODO implement here
        //peut se calculer seulement ic
    return 0;
    }

    /**
     * @param baskets 
     * @return
     */
    public void createOrder(Set<Basket> baskets) {
        // TODO implement here
    }

    /**
     *
     */
    public void initialize(){
        //TO DO
    }

}