package controller;

import facade.BasketFacade;
import facade.ProductFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Product;

import java.text.NumberFormat;
import java.util.*;

/**
 * 
 */
public class ProductController {

    @FXML
    private ChoiceBox txtCategory;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtPrice2;
    @FXML
    private TextField txtNameProduct;
    @FXML
    private Label errorText;

    //Partie recherche
    //Bouton
    @FXML
    private Button btnSearchProduct;
    @FXML
    private Button btnSearchProductCity;
    @FXML
    private Button btnSearchProductCategory;
    @FXML
    private Button btnSearchProductNameCategory;
    //TextField Product
    @FXML
    private TextField txtProduct1;
    @FXML
    private TextField txtProduct2;
    @FXML
    private TextField txtProduct3;
    @FXML
    private TextField txtProduct4;
    //TextField City
    @FXML
    private TextField txtCity1;
    @FXML
    private TextField txtCity2;
    //TextField Category
    @FXML
    private TextField txtCategory1;
    @FXML
    private TextField txtCategory2;


    private String categoryName;
    private String priceEuros;
    private String priceCents;
    private String description;
    private String productName;

    private ProductFacade productFacade = new ProductFacade();

    /**
     * Default constructor
     */
    public ProductController() {
    }

    /**
     * 
     */
    private BasketFacade basketFacade;




    /**
     * @return
     */
    public void addToBasket() {
        // TODO implement here
    }

    /**
     * This method is called when the seller tries to add a new Product.
     * @return
     */
    public void addProduct(ActionEvent e) {
        // TODO implement here
        categoryName = txtCategory.getAccessibleText();
        productName = txtNameProduct.getText();
        description = txtDescription.getText();

        priceEuros = txtPrice.getText();
        priceCents = txtPrice2.getText();


        if(productName.equals("")||description.equals("")||priceEuros.equals("")){
            display("You need to fill every field");
        }else{
            try{
                int i = Integer.parseInt(priceEuros);
                try{
                    String seller = "Anna";
                    int c = Integer.parseInt(priceCents);
                    String price = i+"."+c;
                    Float f = Float.parseFloat(price);
                    System.out.println();
                    Product p = new Product(productName,description,f,seller,categoryName);
                    System.out.println("BOllllOM" + p.getDescription());
                    if(productFacade.createProduct(p)){
                        display("Produit ajouté");
                    }
                }catch (NumberFormatException n){
                    display("The cent field must be an integer");
                }
            }catch (NumberFormatException n){
                display("The price is not an integer");
            }

            //productFacade.createProduct(productName,description,price,);
        }
    }

    /**
     * @return
     */
    public void deleteProduct() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void updateProduct(ActionEvent e) {
        // TODO implement here
    }

    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

    /**
     * Thanks to this method you don't have an error message at the beginning
     */
    public void initialize() {
        // TODO Auto-generated method stub
        errorText.setText("");
    }

    /**
     * This method enables you to research a product by his name
     * @param e
     */
    public void getProductsByName(ActionEvent e){

    }

    /**
     * This method enables you to research a product by his name and the name of a city
     * @param e
     */
    public void getProductsByNameAndCity(ActionEvent e){
    }

    /**
     * This method enables you to research a product by his name and the category
     * @param e
     */
    public void getProductsByNameAndCategory(ActionEvent e){
    }

    /**
     * This method enables you to research a product by name, category and city
     * @param e
     */
    public void getProductsByNameAndCityAndCategory(ActionEvent e){
    }
}