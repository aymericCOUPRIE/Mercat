package facade;

import java.util.*;

/**
 * 
 */
public class OrderFacade {

    /**
     * Default constructor
     */
    public OrderFacade() {
    }

    /**
     * 
     */
    private void orderDAO;

    /**
     * 
     */
    private AbstractFacotryDAO af;




    /**
     * @return
     */
    public Set<Order> getAllOrders() {
        // TODO implement here
        return null;
    }

    /**
     * @param order 
     * @return
     */
    public void getOrderDetails(void order) {
        // TODO implement here
        return null;
    }

    /**
     * @param baskets 
     * @return
     */
    public Order createOrder(Set<Basket> baskets) {
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

    /**
     * @param state 
     * @return
     */
    public boolean updateOrderState(String state) {
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

}