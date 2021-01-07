package controller;

import facade.ProductFacade;
import facade.SellerFacade;
import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Consumer;
import router.Router;

import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class RateController {

    @FXML
    private Button btnSubmitRate;

    @FXML
    private TextField txtRate;
    @FXML
    private Label errorText;
    @FXML
    private Label section;

    private String rate;
    private String page = "";


    /**
     * Default constructor
     */
    public RateController() {
    }

    /**
     * 
     */
    private ProductFacade facade = new ProductFacade();
    private SellerFacade facadeS  = new SellerFacade();
    private UserFacade facadeU = UserFacade.getInstanceUserFacade();

    private String name;

    /**
     *  Method used by btnLogin from Java FX
     * It permits to go to the page to sign up
     */
    @FXML
    public void addRate(ActionEvent e) throws IOException {
        if(btnSubmitRate.getOpacity()>0.5) {
            rate = txtRate.getText();
            if (rate.equals("1") || rate.equals("2") || rate.equals("3") || rate.equals("4") || rate.equals("5")) {
                int i = Integer.parseInt(rate);
                // Page seller
                if(page == "seller") {

                    facadeS.AddRate((Consumer) facadeU.getConnectedUser(), i, name);
                    System.out.println("OUI");
                    Object[] params = new Object[1];
                    params[0] = name;
                    Router.getInstance().activate("Rate_Seller", params);
                    //Router.getInstance().activate("Rate_Seller");
                }
                else {
                    int x = Integer.parseInt(name);
                    facade.AddRate((Consumer) facadeU.getConnectedUser(), i, x);
                    System.out.println("OUI");
                    Object[] params = new Object[1];
                    params[0] = name;
                    Router.getInstance().activate("Rate_Product", params);
                    //Router.getInstance().activate("Rate_Seller");
                }
            } else {
                errorText.setText("Choose a rate between 1 and 5");
            }
        }
        //Router.getInstance().activate("Rate_Seller");
    }

    /**
     * @return
     */
    public float getAverageRateSeller() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public float getAverageRateProduct() {
        // TODO implement here
        return 0.0f;
    }

    private void desactivateSubmitRate(){
        // Cas page Seller
        if(page == "seller") {
            Float rate = facadeS.getRate((Consumer) facadeU.getConnectedUser(), name);
            if (rate != 0) {
                btnSubmitRate.setOpacity(0.4);
                txtRate.setText(rate.toString());
                txtRate.setEditable(false);
            }
        }
        // Cas page Product
        if(page == "product") {
            int i = Integer.parseInt(name);
            Float rate = facade.getRate((Consumer) facadeU.getConnectedUser(), i);
            if (rate != 0) {
                btnSubmitRate.setOpacity(0.4);
                txtRate.setText(rate.toString());
                txtRate.setEditable(false);
            }
        }
    }
    /**
     *
     * Method used by btnBack from Java FX
     * It permit to return to the seller page
     */
    public void back() {
        Router.getInstance().activate("ProfileSeller");
    }

    /**
     */
    public void initialize() {

        errorText.setText("");

        if(section.getText().equals("Seller")){
            page = "seller";
            name = "s";
        } else{
            page = "product";
            name = "4";
        }
        //name = (String) Router.getInstance().getParams()[0];
        name = "4";
        desactivateSubmitRate();

    }

}