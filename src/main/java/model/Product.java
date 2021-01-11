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
     * One of the constructor of the product class
     *
     * @param nameProduct the name of the product
     * @param description the description of the product
     * @param priceProduct the price of the product
     * @param category  the category of the product
     * @param seller the pseudo of the seller, selling this product
     *
     */
    public Product(String nameProduct, String description, float priceProduct, String seller, String category) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.pseudoSeller = seller;
        this.category = category;
    }

    /**
     * One of the constructor of the product class
     *
     * @param nameProduct the name of the product
     * @param description the description of the product
     * @param priceProduct the price of the product
     * @param category  the category of the product
     * @param seller the pseudo of the seller, selling this product
     * @param city the city of the seller, selling this product
     */
    public Product(String nameProduct, String description, float priceProduct, String seller, String category, String city) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.pseudoSeller = seller;
        this.category = category;
        this.city = city;
    }

    /**
     * One of the constructor of the product class
     * @param idProduct as we put it into the database
     * @param nameProduct the name of the product
     * @param description the description of the product
     * @param priceProduct the price of the product
     * @param pictureProduct the picture of the product
     * @param pseudoSeller the pseudo of the seller, selling this product
     * @param idCategorie the category's id of the product, as we put into the db
     *
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
     * One of the constructor of the product class
     * @param idProduct as we put it into the database
     * @param nameProduct the name of the product
     * @param description the description of the product
     * @param priceProduct the price of the product
     * @param pictureProduct the picture of the product
     * @param pseudoSeller the pseudo of the seller, selling this product
     * @param citySeller the city of the seller, selling this product
     * @param idCategorie the category's id of the product, as we put into the db
     * @param libelleCategorie the libelle of category, as we put into the db
     */
    public Product(int idProduct, String nameProduct, String description, float priceProduct, String pictureProduct, String pseudoSeller, String citySeller, int idCategorie,String libelleCategorie) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.pictureProduct = pictureProduct;
        this.pseudoSeller = pseudoSeller;
        this.city = citySeller;
        this.idCategorie = idCategorie;
        this.category = libelleCategorie;
    }

    /**
     *Method which return the description of the product
     * @return the description of the product
     */
    public String getDescription() {
        return this.description;
    }


    /**
     *
     * @return where the product is sold
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the id of the product
     */
    public int getIdProduct() {
        return this.idProduct;
    }

    /**
     * @return the name of the product
     */
    public String getNameProduct() {
        return this.nameProduct;
    }


    /**
     * @return the price of the product
     */
    public float getPriceProduct() {
        return this.priceProduct;
    }



    /**
     * @return return the path to the picture of the product
     */
    public String getPictureProduct() {
        return this.pictureProduct;
    }


    /**
     * @return the name of the seller
     */
    public String getPseudoSeller() {
        return this.pseudoSeller;
    }



    /**
     * @return the id of the category, that the product belongs to
     */
    public int getIdCategorie() {
        return this.idCategorie;
    }

    /**
     *
     * @return the name of the category the product belongs to
     */
    public String getCategory() {
        return category;
    }
}