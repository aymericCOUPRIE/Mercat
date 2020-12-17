package dao;

import model.Order;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class OrderDAO {

    /**
     * Default constructor
     */
    public OrderDAO() {
    }

    /**
     * 
     */
    public Connection connect;


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
    public boolean createOrder(Order order) {
        // TODO implement here
        return false;
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