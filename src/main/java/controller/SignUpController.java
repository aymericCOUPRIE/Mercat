package controller;

import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import router.Router;
import utils.CheckInfosUser;

import java.io.IOException;

/**
 *
 */
public class SignUpController {

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

    //TODO supprimer si vous vous en servez pas..
    private String idSellerButton;
    private String idConsumerButton;

    private String messageAttention;

    private boolean isAConsumer;
    private UserFacade userFacade = UserFacade.getInstanceUserFacade();

    /**
     * Default constructor
     */
    public SignUpController() {
    }

    /**
     * Method used by btnRegisterConsumer from Java FX
     * It register a Consumer
     * @param e Action Event fxml
     */
    public void signUpConsumer(ActionEvent e) {

        pseudo = txtPseudo.getText();
        password = txtPassword.getText();
        email = txtEmailAdress.getText();
        phoneNumber = txtPhoneNumber.getText();
        street = txtStreetAdress.getText();
        postal = txtPostal.getText();
        city = txtCity.getText();
        firstName = txtFirstname.getText();
        lastName = txtLastname.getText();

        String check = CheckInfosUser.checkInfosConsumer(pseudo, email, firstName, lastName, password, phoneNumber, street, postal, city);

        if (check.equals("OK")) {
            this.isAConsumer = true;
            signUp(e);
        } else {

            display(check);
        }

    }

    /**
     * Method used by btnRegisterSeller from Java FX
     * It register a Seller
     * @param e Action Event fxml
     */
    public void signUpSeller(ActionEvent e) {
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

        String check = CheckInfosUser.checkInfosSeller(pseudo, email, firstName, lastName, password, phoneNumber, street, postal, city, companyName);

        if (check.equals("OK")) {
            this.isAConsumer = false;
            signUp(e);
        } else {
            display(check);
        }

    }


    /**
     * Method used by btnSignUp from Java FX
     * It allows to register into the system
     * @param e Action Event fxml
     */
    public void signUp(ActionEvent e) {
        boolean noError = true;
        if (this.isAConsumer) {
            System.out.println("CREATE CONSUMER");
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
            System.out.println("CREATE SELLER");
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
        } else {
            display("This pseudo already exists, choose an another one!");
        }
    }

    /**
     * Method used by btnLogin from Java FX
     * It allows to go to the page "login"
     * @param e Action Event fxml
     */
    @FXML
    public void backLogin(ActionEvent e) {
        Router.getInstance().activate("Login");
    }

    private boolean passwordNotNull(String p) {
        return p.indexOf(" ") == -1; //-1 signifie qu'il y a pas d'espace dans la chaîne de caractères
    }

    /**
     * Method used by btnconsumer from Java FX
     * It allows to go to the page "SignUpconsumer"
     * @param e Action Event fxml
     */
    @FXML
    public void consumerPage(ActionEvent e) {
        this.isAConsumer = true;
        Router.getInstance().activate("SignUpC");
    }

    /**
     * Method used by btnSeller from Java FX
     * It allows to go to the page "SignUpSeller"
     * @param e Action Event fxml
     */
    @FXML
    public void sellerPage(ActionEvent e) {
        this.isAConsumer = false;
        Router.getInstance().activate("SignUpS");
    }

    /**
     * It allows to display an error message on the user interface
     *
     * @param msg the message we want to display
     */
    public void display(String msg) {
        errorText.setText(msg);
    }

    /**
     * This methode allows to don't have error message at the beginning
     */
    public void initialize() {
        errorText.setText("");
    }


}