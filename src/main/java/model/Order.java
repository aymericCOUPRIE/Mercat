package model;

import java.util.*;

/**
 *
 */
public class Order {

    /**
     *
     */
    private String pseudoConsumer;

    /**
     *
     */
    private String pseudoSeller;

    /**
     *
     */
    private Date dateOrder;

    /**
     *
     */
    private String deliveryAddress;

    /**
     *
     */
    private Date deliveryDate;

    /**
     *
     */
    private int idProduct;

    /**
     *
     */
    private float quantity;

    /**
     *
     */
    private String stateOrder;


    /**
     * Default constructor
     */
    public Order(String pseudoConsumer, String pseudoSeller, Date dateOrder, String deliveryAddress, Date deliveryDate, int idProduct, float quantity, String stateOrder) {
        this.pseudoConsumer = pseudoConsumer;
        this.pseudoSeller = pseudoSeller;
        this.dateOrder = dateOrder;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.stateOrder = stateOrder;
    }

    /**
     * @return the quantity for a product
     */
    public float getQuantity() {
        return this.quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the date of the order (Default : current date)
     */
    public Date getDateOrder() {
        return this.dateOrder;
    }

    /**
     * @param dateOrder
     */
    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     * @return the delivery date
     */
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    /**
     * @param deliveryDate
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the current state of the order (in preparation, delivering, delivered...)
     */
    public String getStateOrder() {
        return stateOrder;
    }

    /**
     * @param stateDate
     * @return
     */
    public void setStateOrder(Date stateDate) {
        this.stateOrder = stateOrder;
    }

    /**
     * @return the pseudo of the Seller
     */
    public String getPseudoSeller() {
        return this.pseudoSeller;
    }

    /**
     * @return the pseudo of the consumer
     */
    public String getPseudoConsumer() {
        return this.pseudoConsumer;
    }

    /**
     * @return the id of the Product (only 1 possible for each Order)
     */
    public int getIdProduct() {
        return this.idProduct;
    }

}