package facade;

import dao.AbstractFactoryDAO;
import dao.abstraction.OrderDAO;
import model.Basket;
import model.Order;

import java.util.*;

/**
 *
 */
public class OrderFacade {

    private final OrderDAO orderDAO = OrderDAO.getInstance();

    private static OrderFacade instanceOrderFacade;

    /**
     * Default constructor
     */
    private OrderFacade() {
    }

    /**
     * SINGLETON
     * This method create only one instance of the class
     *
     * @return the instance of OrderFacade
     */
    public static OrderFacade getInstanceOrderFacade() {
        if (instanceOrderFacade == null) {
            instanceOrderFacade = new OrderFacade();
        }
        return instanceOrderFacade;
    }

    /**
     * This method is used to get all the order from a specific User
     *
     * @param pseudo unique key for the user
     * @return the list of all the order
     */
    public List<Order> getAllOrders(String pseudo) {
        return orderDAO.getAllOrders(pseudo);
    }

    /**
     * This method is used to get all the order from a specific Seller
     *
     * @param pseudo unique key for the user
     * @return the list of all the order
     */
    public List<Order> getAllOrdersSeller(String pseudo) {
        return orderDAO.getAllOrdersSeller(pseudo);
    }

    /**
     * This method is used to add an Order to the DB
     *
     * @param baskets         list of all the baskets
     * @param pseudoConsumer  unique key for the consumer
     * @param deliveryAddress the delivery address of the order (either at consumer home or at seller shop)
     * @return true if the order has been inserted in he DB, false if it failed
     */
    public boolean insertOrder(List<Basket> baskets, String pseudoConsumer, String deliveryAddress) {
        return orderDAO.insertOrder(baskets, pseudoConsumer, deliveryAddress);
    }

    /**
     * This method is used to update the deliveryDate of the order
     * (only updated by the seller concerned)
     *
     * @param order the order updated containing the new delivery date
     * @return true id updated succeeded, false if it failed
     */
    public boolean updateOrderDeliveryDate(Order order) {
        System.out.println("update 1");
        return orderDAO.updateOrderDeliveryDate(order);
    }

    /**
     * This method is used to update the deliveryDate of the order
     * (only updated by the seller concerned)
     *
     * @param order the order updated containing the new orderState
     * @return true id updated succeeded, false if it failed
     */
    public boolean updateOrderState(Order order) {
        return orderDAO.updateOrderState(order);
    }

    /**
     * This method is used to know if a product has already been
     * ordered by the consumer
     *
     * @param pseudoConsumer unique key for the consumer
     * @param idProduct      unique key for the product
     * @return true if the consumer has already ordered the product, false if he has not
     */
    public boolean orderProduct(String pseudoConsumer, int idProduct) {
        return orderDAO.orderProduct(pseudoConsumer, idProduct);
    }


    /**
     * This method is used to find a specific Order
     *
     * @param pseudoConsumer first key for the order
     * @param orderDate      second key for the order
     * @param idProduct      id of the product
     * @return the order corresponding to given keys
     */
    public Order find(String pseudoConsumer, Date orderDate, int idProduct) {
        return orderDAO.find(pseudoConsumer, orderDate, idProduct);
    }

}