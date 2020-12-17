package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Consumer;

import java.util.*;

/**
 * 
 */
public class UpdateConsumerProfileController {
    @FXML
    private TextField txtPseudo;
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
    public void updateInformation() {
        // TODO implement here
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
        //on affiche pas le mdp du moment
        txtPhoneNumber.setText(c.getPhoneNumber());
        txtStreetAdress.setText(c.getStreetAddress());
        txtCity.setText(c.getCity());
        txtPostal.setText(c.getPostalCode());

    }

}