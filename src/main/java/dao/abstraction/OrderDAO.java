package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Basket;
import model.Order;

import java.sql.Connection;
import java.util.*;

/**
 *
 */
public abstract class OrderDAO {

    protected Connection connect;

    private static OrderDAO instanceOrderDAO;

    /**
     * Default constructor
     */
    protected OrderDAO(Connection connect) {
        this.connect = connect;
    }

    /**
     * SINGLETON
     * This method create only one instance of the class
     *
     * @return the instance of OrderDAO
     */
    public static OrderDAO getInstance() {
        if (instanceOrderDAO == null) {
            instanceOrderDAO = AbstractFactoryDAO.getFactory().createOrderDAO();
        }
        return instanceOrderDAO;
    }

    /**
     * This method is used to find a specific Order from key elements
     *
     * @param pseudoConsumer the pseudo is one elemnt for the primary key in the DB
     * @param dateOrder      the pseudo is one elemnt for the primary key in the DB
     * @return the order Object
     */
    public abstract Order find(String pseudoConsumer, Date dateOrder);

    /**
     * This method is used to update the orderState in the DB
     * for the coresponding object
     *
     * @param order the object order that holds the new orderState
     * @return true if update succeeded, false if it faild
     */
    public abstract boolean updateOrderState(Order order);

    /**
     * This method insert in the DB a new category and also the list of all
     * its product and quantity
     *
     * @param basket          List of all the baskets for a Consumer
     * @param pseudoConsumer  name of the consumer
     * @param deliveryAddress the delivery address of the order (either at consumer home or at seller shop)
     * @return true if the insert order succeeded, false if it failed
     */
    public abstract boolean insertOrder(List<Basket> basket, String pseudoConsumer, String deliveryAddress);

    /**
     * This method updates the order deliveryDate
     *
     * @param order This order object contains the new delivery date
     * @return true if the insertion in DB succeeded, false if ti failed
     */
    public abstract boolean updateOrderDeliveryDate(Order order);

    /**
     * This method is used to know if a specific product has already been
     * ordered by the consumer
     *
     * @param c         the name of the consumer
     * @param idProduct the id of the product added to the order
     * @return
     */
    public abstract boolean orderProduct(String c, int idProduct);

    /**
     * This method is used to get all the orders from a User
     * (either a Seller or a Consumer)
     *
     * @param pseudo name of the User that wants all its order
     * @return the the order concerning 1 consumer
     */
    public abstract ArrayList<Order> getAllOrders(String pseudo);

}