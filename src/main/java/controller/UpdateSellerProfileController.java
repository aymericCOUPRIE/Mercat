package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Seller;
import router.Router;

import java.util.*;
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
    private TextField CompanyName;
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
    private UserFacade userFacade;


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
        /*
        if(userFacade.getInstanceUserFacade().deleteUser(txtPseudo.getText())){

            display("Your account has been deleted");

            CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS).execute(() -> {
                // Your code here executes after 5 seconds!
                Router.getInstance().activate("Login");
            });

        }else{
            display("Your account hasn't been deleted ..");
        }*/
    }

    /**
     *  Method used by btnUpdateSeller from Java FX
     *  It permit to update some information about the seller in the dataBase
     * @param
     */
    @FXML
    public void updateSeller() {
        /*
        //pas besoin de vérifier si champs vides car remplis par défaut
        if(userFacade.updateUser(txtPseudo.getText(), txtFirstname.getText(), txtLastname.getText(), txtPassword.getText() ,OldPassword, txtEmailAdress.getText(), txtStreetAdress.getText(),txtCity.getText(),txtPostal.getText(),txtPhoneNumber.getText())){
            display("Your profil has been updated !");
        } else {
            display("Error !");
        }

         */
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

}