package dao;

import model.Basket;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class BasketDAOMySQL extends BasketDAO {

    /**
     * Default constructor
     */
    public BasketDAOMySQL(Connection connect) {
        super(connect);
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