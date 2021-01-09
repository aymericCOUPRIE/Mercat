package dao.abstraction;

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
    protected Connection connect;

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
     * @return
     */
    public abstract boolean updateOrderState(Order order);

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

    public abstract boolean orderProduct(String c, int idProduct);

    /**
     * @param pseudo
     * @return the the order concerning 1 consumer
     */
    public abstract ArrayList<Order> getAllOrdersConsumer(String pseudo);

}