package controller;

import facade.BasketFacade;
import facade.ProductFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Product;

import java.text.NumberFormat;
import java.util.*;

/**
 * 
 */
public class ProductController {

    //@FXML
    //private Button btnProduct;

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
    public void updateProduct() {
        // TODO implement here
    }

    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

    /**
     * This methode allows to don't have error message at the begining
     */
    public void initialize() {
        // TODO Auto-generated method stub
        errorText.setText("");
    }

}