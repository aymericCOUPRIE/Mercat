package controller.user;

import facade.OrderFacade;
import facade.ProductFacade;
import facade.SellerFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Product;
import model.Seller;
import router.Router;

import java.util.ArrayList;

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
    @FXML
    private Button btnRate;
    @FXML
    private Button sellerProductsButton;


    /**
     * Default constructor
     */
    public SellerProfileController() {
    }

    /**
     *
     */
    private UserFacade userFacade = UserFacade.getInstanceUserFacade();

    private SellerFacade sellerFacade = SellerFacade.getInstance();

    private OrderFacade orderFacade = OrderFacade.getInstanceOrderFacade();

    private ProductFacade productFacade = ProductFacade.getInstance();

    private ArrayList<Product> productArrayList;
    String nameSeller;
    boolean home;

    /**
     * This method return all information of a seller with only his pseudo
     *
     * @param pseudo of the seller
     * @return a seller with all information
     */
    public Seller getSellerDetails(String pseudo) {
        return (Seller) userFacade.getSellerDetails(pseudo);
    }


    /**
     * Method used by btnBack from Java FX
     * It permit to return to the home page
     */
    public void back() {
        if (!home) {
            Router.getInstance().activate("DetailsProduct", productArrayList);
        } else {
            Router.getInstance().activate("HomePage");
        }

    }

    /**
     * Method used by btnBack from Java FX
     * It permit to return to the home page
     *
     */
    public void addRatePage() {
        Object[] params = new Object[1];
        params[0] = txtPseudo.getText();
        Router.getInstance().activate("Rate_Seller", params);
    }


    /**
     * To initialize the variable with the information in the data base
     */
    public void initialize() {
        if (Router.getInstance().getParametre() != null) { // On vient de la page product
            this.productArrayList = Router.getInstance().getParametre();
            ObservableList<Product> listProduct = FXCollections.observableArrayList(productArrayList);
            nameSeller = listProduct.get(0).getPseudoSeller();
            boolean order = orderFacade.orderProduct(userFacade.getConnectedUser().getPseudo(), productFacade.getIdProduct(listProduct.get(0)));
            if (order) {
                btnRate.setDisable(false);
            } else {
                btnRate.setDisable(true);
            }
            home = false;
        } else { // On vient de la page home
            nameSeller = userFacade.getConnectedUser().getPseudo();
            this.productArrayList = productFacade.getProductsBySeller(nameSeller);
            btnRate.setDisable(true);
            home = true;
        }
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
        if (averageRate == 0) {
            txtAverageRate.setText("/");
        } else {
            txtAverageRate.setText(averageRate.toString());
        }
    }

    /**
     * Method used by btnBack from Java FX
     * It permit to go to the Seller products
     *
     * @param e Action Event fxml
     */
    public void goToSellerProducts(ActionEvent e) {
        Router.getInstance().activate("SellerProducts", productArrayList);
    }

    /**
     * It permit to get all products of a seller of the page
     *
     * @return productArrayList a list of all products
     */
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
}