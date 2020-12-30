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
     * @param pseudoConsumer 
     * @return
     */
    public Set<Basket> getAllBasket(String pseudoConsumer) {
        // TODO implement here
        return null;
    }

    /**
     * @param basket 
     * @return
     */
    public boolean createBasket(Basket basket) {
        // TODO implement here
        return false;
    }

    /**
     * @param basket 
     * @return
     */
    public boolean deleteBasket(Basket basket) {
        // TODO implement here
        return false;
    }

    /**
     * @param basket 
     * @return
     */
    public boolean updateBasket(Basket basket) {
        // TODO implement here
        return false;
    }

}