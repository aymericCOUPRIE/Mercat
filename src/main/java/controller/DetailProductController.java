package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Product;
import router.Router;

import java.util.ArrayList;

/**
 * Clas DetailProductController
 */
public class DetailProductController {

    private OrderFacade orderFacade = OrderFacade.getInstanceOrderFacade();
    private BasketFacade basketFacade = BasketFacade.getInstanceBasketFacade();

    private UserFacade userFacade = UserFacade.getInstanceUserFacade(); //pour avoir accès à l'user connecté

    private Product curentProduct = new Product(5, "jupe", "dezfd", 25, "none", "ulisses", 3);
    ; //produit qui est affiché sur la page
    //TODO  .........
    //TODO   = new ... pour tester car Anna a pas encore mis de produit sur la page
    //TODO   sinon initialier le produit dans initialise, le récupérer du controler


    @FXML
    private TextField txtQuantity;

    @FXML
    private Label errorLabel;

    @FXML
    private Label nameP;
    @FXML
    private Label descriptionP;
    @FXML
    private Label priceP;

    @FXML
    private Button sellerProductsButton;
    //On stocke le produit de la page
    private ArrayList<Product> productArrayList;

    /**
     * This method permitq to add the product of the curent page in the customer's basket
     */
    public void addToBasket() {
       if(txtQuantity.getText().isEmpty()){
           errorLabel.setText("You must provide the quantity of product you want to add in your basket!");
       }else if(Integer.parseInt(txtQuantity.getText()) > 0){
           if (basketFacade.addToBasket(curentProduct.getIdProduct(), Integer.parseInt(txtQuantity.getText()), userFacade.getConnectedUser().getPseudo())) {
               errorLabel.setText("The product has been added into the basket!");
           } else {
               errorLabel.setText("This product is already in your basket. If you want to update the quantity, please go on 'My basket' page.");
           }
       }else{
           errorLabel.setText("You must provide a positive quantity!");
       }
    }

    /**
     *

        if (txtQuantity.getText().isEmpty()) {
            errorLabel.setText("You must provide the quantity of product you want to add in your basket!");
        } else if (Integer.parseInt(txtQuantity.getText()) > 0) {
            if (basketFacade.addToBasket(curentProduct.getIdProduct(), Integer.parseInt(txtQuantity.getText()), userFacade.getConnectedUser().getPseudo())) {

                errorLabel.setText("The product has been added into the basket!");

            } else {
                errorLabel.setText("This product is already in your basket. If you want to update the quantity, please go on 'My basket' page.");
            }

        } else {
            errorLabel.setText("You must provide a positive quantity!");
        }


    }

    /**
     * This method is called automatically when the user
     * get on the corresponding interface
     * <p>
     * It displayed to the user all the details about a specific product

     */
    public void initialize() {
        errorLabel.setText("");
        ArrayList<Product> product = Router.getInstance().getParametre();
        this.productArrayList = product;
        ObservableList<Product> listProduct = FXCollections.observableArrayList(product);
        nameP.setText(product.get(0).getNameProduct());
        descriptionP.setText(product.get(0).getDescription());
        priceP.setText("" + product.get(0).getPriceProduct());
    }

    /**
     * This method is used to go to the seller's product owner profile page
     */
    public void goToSellerPage() {
        Router.getInstance().activate("ProfileSeller", productArrayList);
    }


}
