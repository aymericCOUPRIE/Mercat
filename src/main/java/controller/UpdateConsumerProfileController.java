package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Consumer;

import java.util.*;

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
    private Button btnUpdateConsumer;
    @FXML
    private Button btnDeleteConsumer;
    @FXML
    private Label errorText;

    //Configuration
    private String pseudo;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String street;
    private String postal;
    private String city;
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
     * @param
     */
    public void deleteAccount() {
        // TODO implement here
    }

    /**
     *  Method used by btnUpdateConsumer from Java FX
     *  It permit to update some information about the consumer in the dataBase
     * @param
     */
    public void updateConsumer() {

        pseudo = txtPseudo.getText();
        password = txtPassword.getText();
        firstName = txtFirstname.getText();
        lastName = txtLastname.getText();
        email = txtEmailAdress.getText();
        phoneNumber = txtPhoneNumber.getText();
        street = txtStreetAdress.getText();
        postal = txtPostal.getText();
        city = txtCity.getText();
        //pas besoin de vérifier si champs vides car remplis par défaut
       if(userFacade.updateUser(pseudo,firstName,lastName,password,OldPassword,email,street,city,postal,phoneNumber)){
           display("Your profil has been updated !");
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
     * It allows to display an error message on the user interface
     * @param msg
     */
    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

}