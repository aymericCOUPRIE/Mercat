package model;

/**
 *
 */
public class Product {

    private int idCategorie;
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
    private String city;

    /**
     * Default constructor
     */
    public Product(String nameProduct, String description, float priceProduct, String seller, String category) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.pseudoSeller = seller;
        this.category = category;
    }

    public Product(String nameProduct, String description, float priceProduct, String seller, String category, String city) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.pseudoSeller = seller;
        this.category = category;
        this.city = city;
    }

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
     * Default constructor
     */

    public String getDescription() {
        return this.description;
    }


    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCity() {
        return city;
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
    //public String getCategory () {
    //    return this.category;
    //}
    public int getIdCategorie() {
        return this.idCategorie;
    }

    public String getCategory() {
        return category;
    }
}