package model;

import javafx.util.Pair;

import java.util.*;

/**
 * Class Order
 */
public class Order {

    private int idOrder;
    private String pseudoConsumer;
    private Date dateOrder;
    private String deliveryAddress;
    private Date deliveryDate;
    private String stateOrder;
    private List<Pair<Product, Integer>> productsQuantity;

    /**
     * @param idOrder          of the order
     * @param pseudoConsumer   of the order
     * @param dateOrder        of the order
     * @param deliveryAddress  of the order
     * @param deliveryDate     of the order
     * @param stateOrder       of the order
     * @param productsQuantity of the order
     */
    public Order(int idOrder, String pseudoConsumer, Date dateOrder, String deliveryAddress, Date deliveryDate, String stateOrder, List<Pair<Product, Integer>> productsQuantity) {
        this.idOrder = idOrder;
        this.pseudoConsumer = pseudoConsumer;
        this.dateOrder = dateOrder;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
        this.stateOrder = stateOrder;
        this.productsQuantity = productsQuantity;
    }

    /**
     * GETTER
     *
     * @return the id of the order
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * GETTER
     *
     * @return the pseudo of the consumer
     */
    public String getPseudoConsumer() {
        return pseudoConsumer;
    }

    /**
     * SETTER
     *
     * @param pseudoConsumer updates the pseduo of the consumer
     */
    public void setPseudoConsumer(String pseudoConsumer) {
        this.pseudoConsumer = pseudoConsumer;
    }

    /**
     * GETTER
     *
     * @return the date of the order
     */
    public Date getDateOrder() {
        return dateOrder;
    }


    /**
     * GETTER
     *
     * @return the delivery address
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * SETTER
     *
     * @param deliveryAddress updates the delivery address
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * GETTER
     *
     * @return the delivery date
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * SETTER
     *
     * @param deliveryDate update the delivery date
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * GETTER
     *
     * @return the current stateOrder
     */
    public String getStateOrder() {
        return stateOrder;
    }

    /**
     * SETTER
     *
     * @param stateOrder updates the state of the order
     */
    public void setStateOrder(String stateOrder) {
        this.stateOrder = stateOrder;
    }

    /**
     * GETTER
     *
     * @return the list of all Pairs of Product x quantity for the order
     */
    public List<Pair<Product, Integer>> getProductsQuantity() {
        return productsQuantity;
    }

}