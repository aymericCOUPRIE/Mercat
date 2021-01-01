package model;

import java.util.*;

/**
 * 
 */
public class Basket {

    /**
     * Default constructor
     */

    public Basket(int quantity, Product product, String pseudoConsumer) {
        this.quantity = quantity;
        this.product = product;
        this.pseudoConsumer = pseudoConsumer;
    }

    /**
     *
     */
    private int quantity;

    /**
     *
     */
    private Product product;

    /**
     *
     */
    private String pseudoConsumer;

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getPseudoConsumer() {
        return pseudoConsumer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPseudoConsumer(String pseudoConsumer) {
        this.pseudoConsumer = pseudoConsumer;
    }
}