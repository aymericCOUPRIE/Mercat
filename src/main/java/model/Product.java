package model;

import java.util.*;

/**
 *
 */
public class Product {

    /**
     *
     */
    private int idProduct;

    /**
     *
     */
    private String nameProduct;

    /**
     *
     */
    private float priceProduct;

    /**
     *
     */
    private String pictureProduct;

    /**
     *
     */
    private String pseudoSeller;


    /**
     *
     */
    private int idCategorie;

    /**
     *
     */
    private String description;

    /**
     * Default constructor
     */


    public Product(int idProduct, String nameProduct, String description, float priceProduct, String pictureProduct, String pseudoSeller, int idCategorie) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.pictureProduct = pictureProduct;
        this.pseudoSeller = pseudoSeller;
        this.idCategorie = idCategorie;
    }

    /**
     * @return
     */
    public int getIdProduct() {
        return this.idProduct;
    }

    /**
     * @return
     */
    public String getNameProduct() {
        return this.nameProduct;
    }

    /**
     * @param name
     * @return
     */
    public void setNameProduct(String name) {
        // TODO implement here
    }

    public String getDescription() {
        return this.description;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return priceProduct
     */
    public float getPriceProduct() {
        return this.priceProduct;
    }

    /**
     * @param price
     * @return
     */
    public void setPriceProduct(float price) {
        // TODO implement here
    }

    /**
     * @return pictureProduct
     */
    public String getPictureProduct() {
        return this.pictureProduct;
    }

    /**
     * @param url
     * @return
     */
    public void setPictureProduct(String url) {
        // TODO implement here
    }

    /**
     * @return the name of the seller
     */
    public String getPseudoSeller() {
        return this.pseudoSeller;
    }

    /**
     * @param categ
     * @return
     */
    public void setIdCategorie(int categ) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getIdCategorie() {
        return this.idCategorie;
    }

}