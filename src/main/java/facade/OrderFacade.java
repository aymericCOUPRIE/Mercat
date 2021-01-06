package facade;

import dao.AbstractFactoryDAO;
import dao.OrderDAO;
import model.Basket;
import model.Order;

import java.util.*;

/**
 *
 */
public class OrderFacade {

    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private OrderDAO orderDAO = af.createOrderDAO();

    private static OrderFacade instanceOrderFacade;

    /**
     * Default constructor
     */
    public OrderFacade() {
    }

    public static OrderFacade getInstanceOrderFacade() {
        if (instanceOrderFacade == null) {
            instanceOrderFacade = new OrderFacade();
        }
        return instanceOrderFacade;
    }

    /**
     * @return
     */
    public List<Order> getAllOrders(String pseudo) {
        return orderDAO.getAllOrdersConsumer(pseudo);
    }

    /**
     * @param order
     * @return
     */
    public void getOrderDetails(Order order) {
        //orderDAO.find()
    }

    /**
     * @param baskets
     * @return
     */
    public boolean insertOrder(List<Basket> baskets, String pseudoConsumer) {
        return orderDAO.insertOrder(baskets, pseudoConsumer);
    }

    /**
     * @param date
     * @return
     */
    public boolean updateOrderDeliveryDate(Order order, Date date) {
        return orderDAO.updateOrderDeliveryDate(order, date);
    }

    /**
     * @param state
     * @return
     */
    public boolean updateOrderState(Order order, String state) {
        return orderDAO.updateOrderState(order, state);
    }

    /**
     * @param pseudoConsumer
     * @param pseudoSeller
     * @param orderDate
     * @return a specific order
     */
    public Order find(String pseudoConsumer, String pseudoSeller, Date orderDate) {
        return orderDAO.find(pseudoConsumer, orderDate);
    }

}