package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import facade.UserFacade;
import javafx.fxml.FXML;
import model.Basket;
import model.Product;

import java.awt.*;
import java.util.*;

/**
 * 
 */
public class BasketController {

    private BasketFacade basketFacade = BasketFacade.getInstanceBasketFacade();

    private OrderFacade orderFacade;

    private UserFacade userFacade = UserFacade.getInstanceUserFacade(); //pour avoir accès à l'user connecté

    /**
     * Default constructor
     */
    public BasketController() {
    }

    @FXML
    private Label labelNbProducts, labelTotPrice;


    /**
     * this method allows to retrieve all the baskets of the connected consumer
     * @return ArrayList<Basket>
     */
    public ArrayList<Basket> getAllBasket() {
      return basketFacade.getAllBasket(userFacade.getConnectedUser().getPseudo());
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