package dao;

import java.util.*;

/**
 * 
 */
public class OrderDAOMySQL extends OrderDAO {

    /**
     * Default constructor
     */
    public OrderDAOMySQL() {
    }

    /**
     * @param state  
     * @return
     */
    public boolean updateOrderState(String state ) {
        // TODO implement here
        return false;
    }

    /**
     * @param order 
     * @return
     */
    public boolean createOrder(void order) {
        // TODO implement here
        return false;
    }

    /**
     * @param pseudoConsumer 
     * @param pseudoSeller 
     * @param dateOrder 
     * @return
     */
    public Order find(String pseudoConsumer, String pseudoSeller, Date dateOrder) {
        // TODO implement here
        return null;
    }

    /**
     * @param date 
     * @return
     */
    public boolean updateOrderDeliveryDate(Date date) {
        // TODO implement here
        return false;
    }

}