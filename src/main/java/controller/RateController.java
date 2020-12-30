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
    private ProductFacade facade = new ProductFacade();;
    private SellerFacade facadeS  = new SellerFacade();
    private UserFacade facadeU = UserFacade.getInstanceUserFacade();;



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
                    facadeS.AddRate((Consumer) facadeU.getConnectedUser(), i);
                    Router.getInstance().activate("Rate_Seller");
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
            Integer rate = facadeS.getRate((Consumer) facadeU.getConnectedUser());
            if (rate != 0) {
                btnSubmitRate.setOpacity(0.4);
                txtRate.setText(rate.toString());
                txtRate.setEditable(false);
            }
        }
        // Cas page Product
        if(page == "product") {
            // Recuperer code Anna Product
        }
    }


    /**
     */
    public void initialize() {

        errorText.setText("");

        if(section.getText().equals("Seller")){
            page = "seller";
        } else{
            page = "product";
        }

        desactivateSubmitRate();

    }

}