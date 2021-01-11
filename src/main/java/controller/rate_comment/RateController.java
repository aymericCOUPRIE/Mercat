package controller.rate_comment;

import facade.ProductFacade;
import facade.SellerFacade;
import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Consumer;
import model.Product;
import router.Router;

/**
 * Class RrateController
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

    private String page = "";
    private String nameSeller;
    private int idProduct;

    private final ProductFacade facade = ProductFacade.getInstance();
    private final SellerFacade facadeS = SellerFacade.getInstance();
    private final UserFacade facadeU = UserFacade.getInstanceUserFacade();

    /**
     * Default constructor
     */
    public RateController() {
    }

    /**
     * Method used by btnSubmitRate from Java FX
     * It permits to add a rate to a seller or a product
     */
    @FXML
    public void addRate() {
        if (btnSubmitRate.getOpacity() > 0.5) {
            String rate = txtRate.getText();
            if (rate.equals("1") || rate.equals("2") || rate.equals("3") || rate.equals("4") || rate.equals("5")) {
                int i = Integer.parseInt(rate);
                // Page seller
                if (page.equals("seller")) {

                    facadeS.AddRate((Consumer) facadeU.getConnectedUser(), i, nameSeller);
                    System.out.println("OUI");
                    Object[] params = new Object[1];
                    params[0] = nameSeller;
                    Router.getInstance().activate("Rate_Seller", params);
                    //Router.getInstance().activate("Rate_Seller");
                } else {
                    facade.AddRate((Consumer) facadeU.getConnectedUser(), i, idProduct);
                    System.out.println("OUI");
                    Object[] params = new Object[1];
                    params[0] = idProduct;
                    Router.getInstance().activate("Rate_Product", params);
                    //Router.getInstance().activate("Rate_Seller");
                }
            } else {
                errorText.setText("Choose a rate between 1 and 5");
            }
        }
    }

    /**
     * Method for the deactivation of the button submit rate
     */
    private void desactivateSubmitRate() {
        // Cas page Seller
        if (page.equals("seller")) {
            Float rate = facadeS.getRate((Consumer) facadeU.getConnectedUser(), nameSeller);
            if (rate != 0) {
                btnSubmitRate.setOpacity(0.4);
                txtRate.setText(rate.toString());
                txtRate.setEditable(false);
            }
        }
        // Cas page Product
        if (page.equals("product")) {
            Float rate = facade.getRate((Consumer) facadeU.getConnectedUser(), idProduct);
            if (rate != 0) {
                btnSubmitRate.setOpacity(0.4);
                txtRate.setText(rate.toString());
                txtRate.setEditable(false);
            }
        }
    }

    /**
     * Method used by btnBack from Java FX
     * It permit to return to the seller page
     */
    public void back() {
        if (page.equals("product")) {
            Router.getInstance().activate("HistoricOrder");
        } else {
            // Quel seller ?
            Router.getInstance().activate("ProfileSeller");
        }
    }

    /**
     * The first method used on the page
     * It permit to get and set a rate if the consumer had already put it
     */
    public void initialize() {

        errorText.setText("");

        if (section.getText().equals("Seller")) {
            page = "seller";
            nameSeller = (String) Router.getInstance().getParams()[0];
        } else {
            page = "product";
            idProduct = (Integer) Router.getInstance().getParams()[0];
        }

        //nameSeller = "s";
        desactivateSubmitRate();

    }

}