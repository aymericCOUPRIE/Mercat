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

    private final AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private final OrderDAO orderDAO = af.createOrderDAO();

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
     * @param baskets
     * @return
     */
    public boolean insertOrder(List<Basket> baskets, String pseudoConsumer) {
        return orderDAO.insertOrder(baskets, pseudoConsumer);
    }

    /**
     * @return
     */
    public boolean updateOrderDeliveryDate(Order order) {
        System.out.println("update 1");
        return orderDAO.updateOrderDeliveryDate(order);
    }

    /**
     * @param order
     * @return
     */
    public boolean updateOrderState(Order order) {
        return orderDAO.updateOrderState(order);
    }


    public boolean orderProduct(String c, int idProduct) {
        return orderDAO.orderProduct(c, idProduct);
    }


    /**
     * @param pseudoConsumer
     * @param orderDate
     * @return a specific order
     */
    public Order find(String pseudoConsumer, Date orderDate) {
        return orderDAO.find(pseudoConsumer, orderDate);
    }

}