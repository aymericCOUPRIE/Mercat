package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Seller;
import model.User;
import router.Router;

import java.util.*;
import utils.CheckInfosUser;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class UpdateSellerProfileController {
    @FXML
    private Label txtPseudo;
    @FXML
    private TextField txtFirstname;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtEmailAdress;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private TextField txtStreetAdress;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtPostal;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtCompanyName;
    @FXML
    private Label errorText;
    /**
     * Default constructor
     */
    public UpdateSellerProfileController() {
    }

    /**
     * 
     */
    private UserFacade userFacade = new UserFacade();
    private String OldPassword; //pour savoir si je dois crypter le mdp lors de la modification où si il l'est déjà car pas changé


    /**
     * This methode permite to get all the information about a seller.
     * @return seller
     *
     */
    public User getConsumerDetails() {
        return  userFacade.getConsumerDetails();
    }
    /**
     * @return
     */
    public Seller getSellerDetails() {
        // TODO implement here
        return null;
    }

    /**
     *  Method used by btnDeleteSeller from Java FX
     *  It permit to delete the seller account from the dataBase
     *
     */
    public void deleteSeller() {
        if(userFacade.getInstanceUserFacade().deleteUser(txtPseudo.getText())){

            if(!(userFacade.getInstanceUserFacade().isAdmin())){
                display("Your account has been deleted");

                CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
                    // Your code here executes after 3 seconds!
                    Router.getInstance().activate("Login");
                });
            }else{
                display(Router.getInstance().getParams()[0].toString() + " account has been deleted");
                CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
                    // Your code here executes after 3 seconds!
                    Router.getInstance().activate("HandleConsumerS");
                });
            }
        }else{
            display("Your account hasn't been deleted ...");
        }
    }

    /**
     *  Method used by btnUpdateSeller from Java FX
     *  It permit to update some information about the seller in the dataBase
     * @param
     */
    @FXML
    public void updateSeller() {

        String check = CheckInfosUser.checkInfosSeller(txtPseudo.getText(),txtEmailAdress.getText(),txtFirstname.getText(),txtLastname.getText(),txtPassword.getText(),txtPhoneNumber.getText(),txtStreetAdress.getText(),txtPostal.getText(),txtCity.getText(),txtCompanyName.getText());

        if(check.equals("OK")){
        if(userFacade.updateUser(txtPseudo.getText(), txtFirstname.getText(), txtLastname.getText(), txtPassword.getText() ,OldPassword, txtEmailAdress.getText(), txtStreetAdress.getText(),txtCity.getText(),txtPostal.getText(),txtPhoneNumber.getText(),txtCompanyName.getText())){
            display("Your profil has been updated !");
        } else {
            display("Error during update !");
        }
        }else{

        display(check);
    }
    }


    /**
     * Method used by btnBack from Java FX
     *  It permit to return to the home page
     */
    public void back(){
        Router.getInstance().activate("HomePage");
    }

    /**
     * It allows to display an error message on the user interface
     * @param msg
     */
    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

    /**
     * To initialize the variable with the information in the data base
     */
    @FXML
    public void initialize() {
        //User car ça peut être un admin ou un consumer
        Seller c = (Seller) getConsumerDetails();
        txtPseudo.setText(c.getPseudo());
        System.out.println(c.getFirstName());
        txtFirstname.setText(c.getFirstName());
        txtLastname.setText(c.getLastName());
        txtEmailAdress.setText(c.getEmailAddress());
        txtPassword.setText(c.getPassword());
        OldPassword = c.getPassword();
        txtPhoneNumber.setText(c.getPhoneNumber());
        txtStreetAdress.setText(c.getStreetAddress());
        txtCity.setText(c.getCity());
        txtPostal.setText(c.getPostalCode());
        txtCompanyName.setText(c.getCompanyName());
        errorText.setText("");

    }


}