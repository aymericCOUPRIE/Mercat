package controller;

import facade.BasketFacade;
import facade.ProductFacade;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import model.Product;

import java.awt.*;
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
    private TextArea txtDescription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtPrice2;

    @FXML
    private TextField txtName;

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
    public void addProduct() {
        // TODO implement here
        categoryName = txtCategory.getText();
        productName = txtName.getText();
        description = txtDescription.getText();
        priceEuros = txtPrice.getText();
        priceCents = txtPrice2.getText();

        if(productName.equals("")||description.equals("")||priceEuros.equals("")){
            display("You need to fill every field");
        }else{
            try{
                int e = Integer.parseInt(priceEuros);
                try{
                    int c = Integer.parseInt(priceCents);
                    String price = e+"."+c;
                    Float f = Float.parseFloat(price);
                    Product p = new Product(productName,price,categoryName,""+1,categoryName);
                    productFacade.createProduct(p);
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