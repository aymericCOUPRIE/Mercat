package dao;

import model.Basket;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class BasketDAO {

    /**
     *
     */
    protected Connection connect = null;

    /**
     * Default constructor
     * @param connect
     */
    public BasketDAO(Connection connect) {
        this.connect = connect;
    }




    /**
     * this method allows to retrieve all the baskets of the consumer whose the pseudo is passed in parameter
     * @param pseudoConsumer
     * @return ArrayList<Basket>
     */
    public abstract ArrayList<Basket> getAllBasket(String pseudoConsumer);

    /**
     * @param basket 
     * @return
     */
    public boolean createBasket(Basket basket) {
        // TODO implement here
        return false;
    }


    /**
     * This methode permit to delete a basket
     * @param idProduct, pseudo
     * @return boolean true if it's done
     */
    public abstract boolean deleteBasket(int idProduct, String pseudo);

    /**
     * This methode permit to update the quantity of an order
     * @param pseudo,idProduct,quantity
     * @return boolean True si le panier a bien été modifié
     */

    public abstract boolean updateBasket(String pseudo,int idProduct, int quantity);



}