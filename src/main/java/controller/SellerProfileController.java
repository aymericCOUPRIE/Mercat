package controller;

import facade.OrderFacade;
import facade.SellerFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Order;
import model.Product;
import model.Seller;
import router.Router;

import java.util.*;

/**
 * 
 */
public class SellerProfileController {
    @FXML
    private Label txtPseudo;
    @FXML
    private Label txtEmailAdress;
    @FXML
    private Label txtPhoneNumber;
    @FXML
    private Label txtStreetAdress;
    @FXML
    private Label txtPostal;
    @FXML
    private Label txtCity;
    @FXML
    private Label txtCompanyName;
    @FXML
    private Label txtAverageRate;

    /**
     * Default constructor
     */
    public SellerProfileController() {
    }

    /**
     * 
     */
    private UserFacade userFacade = new UserFacade();

    private SellerFacade sellerFacade = new SellerFacade();

    private OrderFacade orderFacade = new OrderFacade();

    private ArrayList<Product> productArrayList;

    /**
     * @param pseudo 
     * @return
     */
    public Seller getSellerDetails(String pseudo)  {
        return  userFacade.getSellerDetails(pseudo);
    }

    /**
     * @param order 
     * @return
     */
    public void updateOrder(Order order) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Set<Order> getAllOrder() {
        // TODO implement here
        return null;
    }

    /**
     * Method used by btnBack from Java FX
     *  It permit to return to the home page
     */
    public void back(){
        Router.getInstance().activate("DetailsProduct", productArrayList);
    }

    /**
     * Method used by btnBack from Java FX
     *  It permit to return to the home page
     */
    public void addRatePage(){
        Object[] params = new Object[1];
        params[0] = txtPseudo.getText();
        Router.getInstance().activate("Rate_Seller", params);
    }


    /**
     * To initialize the variable with the information in the data base
     */
    public void initialize() {
        productArrayList = Router.getInstance().getParametre();
        ObservableList<Product> listProduct = FXCollections.observableArrayList(productArrayList);
        String nameSeller = listProduct.get(0).getPseudoSeller();

        System.out.println(listProduct.get(0).getNameProduct());
        System.out.println(listProduct.get(0).getIdProduct());

        //boolean order = orderFacade.orderProduct(userFacade.getConnectedUser().getPseudo(), listProduct.get(0).getIdProduct());

        Float averageRate;
        Seller s = getSellerDetails(nameSeller);
        txtPseudo.setText(s.getPseudo());
        txtEmailAdress.setText(s.getEmailAddress());
        txtPhoneNumber.setText(s.getPhoneNumber());
        txtStreetAdress.setText(s.getStreetAddress());
        txtCity.setText(s.getCity());
        txtPostal.setText(s.getPostalCode());
        txtCompanyName.setText(s.getCompanyName());

        averageRate = sellerFacade.getSellerAverageRate(s);
        System.out.println(averageRate);
        if(averageRate == 0){
            txtAverageRate.setText("/");
        }
        else {
            txtAverageRate.setText(averageRate.toString());
        }



    }

}