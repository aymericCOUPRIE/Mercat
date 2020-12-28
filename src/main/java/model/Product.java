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
    private String category;


    private String description;
    /**
     * Default constructor
     */
    public Product(String nameProduct,String description,float priceProduct,String seller,String category) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.pseudoSeller = seller;
        this.category =category;

    }



    public String getDescription(){
        return this.description;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return
     */
    public int getIdProduct() {
        // TODO implement here
        return 0;
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
        return  this.pictureProduct;
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
        // TODO implement here
        return 0;
    }

}