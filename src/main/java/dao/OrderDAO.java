package dao;

import model.Basket;
import model.Order;

import java.sql.Connection;
import java.util.*;

/**
 *
 */
public abstract class OrderDAO {

    /**
     *
     */
    protected Connection connect = null;

    /**
     * Default constructor
     */
    public OrderDAO(Connection connect) {
        this.connect = connect;
    }

    /**
     * @param pseudoConsumer
     * @param dateOrder
     * @return
     */
    public abstract Order find(String pseudoConsumer, Date dateOrder);

    /**
     * @param state
     * @return
     */
    public abstract boolean updateOrderState(Order order, String state);

    /**
     * @param basket
     * @return
     */
    public abstract boolean insertOrder(List<Basket> basket, String pseudoConsumer);

    /**
     * @param order, date
     * @return
     */
    public abstract boolean updateOrderDeliveryDate(Order order, Date date);

    /**
     * @param pseudo
     * @return the the order concerning 1 consumer
     */
    public abstract ArrayList<Order> getAllOrdersConsumer(String pseudo);

}