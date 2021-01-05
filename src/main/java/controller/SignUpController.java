package controller;

import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import router.Router;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

/**
 *
 */
public class SignUpController {


    //JavaFX implementation
    @FXML
    private TextField txtCompanyName;
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
    private Button btnSeller;
    @FXML
    private Button btnconsumer;
    @FXML
    private Button btnSignIn;
    @FXML
    private Button btnRegisterSeller;
    @FXML
    private Button btnRegisterConsumer;
    @FXML
    private Label errorText;


    //Configuration
    private String pseudo;
    private String password;
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private String phoneNumber;
    private String street;
    private String postal;
    private String city;

    private String idSellerButton;
    private String idConsumerButton;

    private String messageAttention;

    private boolean isAConsumer = true;
    //private boolean isAConsumer = false;

    /**
     * Default constructor
     */
    public SignUpController() {
    }

    /**
     *
     */
    private UserFacade userFacade = UserFacade.getInstanceUserFacade();


    public void signUpConsumer(ActionEvent e) throws IOException {
        pseudo = txtPseudo.getText();
        password = txtPassword.getText();
        email = txtEmailAdress.getText();
        phoneNumber = txtPhoneNumber.getText();
        street = txtStreetAdress.getText();
        postal = txtPostal.getText();
        city = txtCity.getText();
        firstName = txtFirstname.getText();
        lastName = txtLastname.getText();

        if (checkInfosConsumer() != false) {
            System.out.println("Ca marche");
            signUp(e);
        }
    }


    public void signUpSeller(ActionEvent e) throws IOException {
        pseudo = txtPseudo.getText();
        password = txtPassword.getText();
        email = txtEmailAdress.getText();
        phoneNumber = txtPhoneNumber.getText();
        street = txtStreetAdress.getText();
        postal = txtPostal.getText();
        city = txtCity.getText();
        companyName = txtCompanyName.getText();
        firstName = txtFirstname.getText();
        lastName = txtLastname.getText();

        if (checkInfosSeller() != false) {
            signUp(e);
        }
    }


    /**
     * Method used by btnSignUp from Java FX
     * It allows to register into the system
     *
     * @param e
     * @return
     */
    public void signUp(ActionEvent e) throws IOException {
        boolean noError = true;
        if (this.isAConsumer) {
            noError = userFacade.signUpConsumer(pseudo,
                    firstName,
                    lastName,
                    password,
                    email,
                    street,
                    city,
                    postal,
                    phoneNumber);
        } else {
            noError = userFacade.signUpSeller(pseudo,
                    firstName,
                    lastName,
                    password,
                    email,
                    street,
                    city,
                    postal,
                    phoneNumber,
                    companyName);
        }
        if (noError) {
            Router.getInstance().activate("Login");
        }
        if (noError) {
            Router.getInstance().activate("Login");
        } else {
            display("Your pseudo already exists");
        }
    }

    /**
     * Method used by btnLogin from Java FX
     * It allows to go to the page "login"
     */
    @FXML
    public void backLogin(ActionEvent e) throws IOException {
        Router.getInstance().activate("Login");
    }


    private boolean checkInfosConsumer() {
        if ((pseudo.equals("") || password.equals("") || phoneNumber.equals("") || street.equals("") || postal.equals("") || city.equals(""))) {
            this.messageAttention = "You need to provide every information";
            display(messageAttention);
            return false;

        } else
            return internVerification();
    }


    private boolean internVerification() {
        if (password.length() < 8) {
            this.messageAttention = "Your password must have at least 8 characters";
            display(messageAttention);
        } else {
            String test = "0" + Integer.parseInt(phoneNumber);
            System.out.println(phoneNumber.length());
            System.out.println(test == phoneNumber);
            System.out.println(phoneNumber);
            //TODO Ajouter une fonctionalité qui vérifie qu'il y a que des chiffres dans le phonenumber
            if ((phoneNumber.length() == 10 || phoneNumber.length() == 12)) {
                System.out.println("REGEX DU MAIL " + email.matches("/^\\S+@\\S+\\.\\S+$/"));
                //if(email.matches("/^\\S+@\\S+\\.\\S+$/")){
                System.out.println("REGARDE CE VRAI");
                return true;
                //}else{
                //  this.messageAttention = "This email address is incorrect";
                //}
            } else {
                this.messageAttention = "Your phone number is incorrect";
                display(messageAttention);
            }
        }
        return false;
    }

    private boolean checkInfosSeller() {
        if ((pseudo.equals("") && password.equals("") || phoneNumber.equals("") && street.equals("") && postal.equals("") && city.equals("") && companyName.equals(""))) {
            this.messageAttention = "You need to provide every information";
            display(messageAttention);
            return false;

        } else
            return internVerification();
    }

    /**
     * Method used by btnconsumer from Java FX
     * It allows to go to the page "SignUpconsumer"
     */
    @FXML
    public void consumerPage(ActionEvent e) throws IOException {
        this.isAConsumer = true;
        Router.getInstance().activate("SignUpC");
    }

    /**
     * Method used by btnSeller from Java FX
     * It allows to go to the page "SignUpSeller"
     */
    @FXML
    public void sellerPage(ActionEvent e) throws IOException {
        this.isAConsumer = false;
        Router.getInstance().activate("SignUpS");
    }

    /**
     * It allows to display an error message on the user interface
     *
     * @param msg
     */
    @FXML
    public void display(String msg) {
        errorText.setText(msg);
    }

    /**
     * This methode allows to don't have error message at the beginning
     */
    public void initialize() {
        // TODO Auto-generated method stub
        errorText.setText("");
    }
}