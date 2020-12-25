package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Consumer;
import router.Router;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class UpdateConsumerProfileController {
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
    private Label errorText;


    private String OldPassword; //pour savoir si je dois crypter le mdp lors de la modification où si il l'est déjà car pas changé
    /**
     * Default constructor
     */
    public UpdateConsumerProfileController() {
    }

    /**
     * 
     */
    private UserFacade userFacade = new UserFacade();

    /**
     * This methode permite to get all the information about a seller.
     * @return Consumer
     *
     */
    public Consumer getConsumerDetails() {
        return (Consumer) userFacade.getConsumerDetails();
    }

    /**
     *  Method used by btnDeleteConsumer from Java FX
     *  It permit to delete the consumer account from the dataBase
     *
     */
    public void deleteConsumer() {
        if(userFacade.getInstanceUserFacade().deleteUser(txtPseudo.getText())){

            display("Your account has been deleted");

            CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS).execute(() -> {
                // Your code here executes after 5 seconds!
                Router.getInstance().activate("Login");
            });

        }else{
            display("Your account hasn't been deleted ..");
        }
    }

    /**
     *  Method used by btnUpdateConsumer from Java FX
     *  It permit to update some information about the consumer in the dataBase
     * @param
     */
    @FXML
    public void updateConsumer() {
        //pas besoin de vérifier si champs vides car remplis par défaut
       if(userFacade.updateUser(txtPseudo.getText(), txtFirstname.getText(), txtLastname.getText(), txtPassword.getText() ,OldPassword, txtEmailAdress.getText(), txtStreetAdress.getText(),txtCity.getText(),txtPostal.getText(),txtPhoneNumber.getText())){
           display("Your profil has been updated !");
       } else {
           display("Error !");
       }
    }

    /**
     * To initialize the variable with the information in the data base
     */
    public void initialize() {
        // TO DO

        Consumer c = getConsumerDetails();
        txtPseudo.setText(c.getPseudo());
        txtFirstname.setText(c.getFirstName());
        txtLastname.setText(c.getLastName());
        txtEmailAdress.setText(c.getEmailAddress());
        txtPassword.setText(c.getPassword());
        OldPassword = c.getPassword();
        txtPhoneNumber.setText(c.getPhoneNumber());
        txtStreetAdress.setText(c.getStreetAddress());
        txtCity.setText(c.getCity());
        txtPostal.setText(c.getPostalCode());
        errorText.setText("");

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