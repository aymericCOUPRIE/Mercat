package model;



public class Basket {

    /**
     * this method allows you to instantiate a basket
     * @param quantity of the product in the basket
     * @param product in the basket
     * @param pseudoConsumer of the person who owns the basket
     */

    public Basket(int quantity, Product product, String pseudoConsumer) {
        this.quantity = quantity;
        this.product = product;
        this.pseudoConsumer = pseudoConsumer;
    }

    /**
     * quantity of the product in the basket
     */
    private int quantity;

    /**
     *product in the basket
     */
    private final Product product;

    /**
     * pseudo of the person who owns the basket
     */
    private final String pseudoConsumer;

    /**
     *
     * @return quantity of the product in the basket
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @return the product in the basket
     */
    public Product getProduct() {
        return product;
    }

    /**
     *
     * @return the owner of the basket
     */
    public String getPseudoConsumer() {
        return pseudoConsumer;
    }

    /**
     *
     * this methode permits to update the quantity in the basket
     *
     * @param quantity of product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}