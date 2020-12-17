package dao;

import java.util.*;

/**
 * 
 */
public class BasketDAO {

    /**
     * Default constructor
     */
    public BasketDAO() {
    }

    /**
     * 
     */
    public Connection connect;


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