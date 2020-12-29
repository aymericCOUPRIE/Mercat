package controller;

import facade.ProductFacade;
import facade.SellerFacade;
import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private UserFacade facadeU = new UserFacade();;



    /**
     *  Method used by btnLogin from Java FX
     * It permits to go to the page to sign up
     */
    @FXML
    public void addRate(ActionEvent e) throws IOException {
        facadeS.AddRate((Consumer) facadeU.getConnectedUser(), 3);
        Router.getInstance().activate("Rate_Seller");
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

}