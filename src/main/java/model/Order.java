package model;

import javafx.util.Pair;

import java.util.*;

/**
 *
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
     * Default constructor
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

    public int getIdOrder() {
        return idOrder;
    }

    public String getPseudoConsumer() {
        return pseudoConsumer;
    }

    public void setPseudoConsumer(String pseudoConsumer) {
        this.pseudoConsumer = pseudoConsumer;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(String stateOrder) {
        this.stateOrder = stateOrder;
    }

    public List<Pair<Product, Integer>> getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(List<Pair<Product, Integer>> productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
}