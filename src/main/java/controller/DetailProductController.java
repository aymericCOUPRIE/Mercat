package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Product;
import router.Router;


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

    /**
     * This methode permit to add the product of the curent page in the customer's basket
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

    public void initialize() {
        errorLabel.setText("");
        ObservableList<Product> listProduct = FXCollections.observableArrayList(Router.getInstance().getParametre());

        nameP.setText(listProduct.get(0).getNameProduct());
        descriptionP.setText(listProduct.get(0).getDescription());
        priceP.setText(""+listProduct.get(0).getPriceProduct());
    }

}
