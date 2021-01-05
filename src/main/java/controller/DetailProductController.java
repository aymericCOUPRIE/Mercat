package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Basket;
import model.Product;

import java.util.Set;

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

    /**
     * This methode permit to add the product of the curent page in the customer's basket
     */
    public void addToBasket() {
        if (basketFacade.addToBasket(curentProduct.getIdProduct(), Integer.parseInt(txtQuantity.getText()), userFacade.getConnectedUser().getPseudo())) {

            errorLabel.setText("The product has been added into the basket!");

        } else {
            errorLabel.setText("error: le produit n'a pas été ajouté au panier...");
        }

    }

    public void initialize() {
        errorLabel.setText("");
    }

}
