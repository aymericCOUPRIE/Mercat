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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

//TODO supprimer si vous vous en servez pas..
    private String idSellerButton;
    private String idConsumerButton;

    private String messageAttention;

    //TODO delete ça flo quand t'aura utilisé la fonction dans utils -> checkinfoUser pour éviter dupliquer code de base d'anna
    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    private boolean isAConsumer = true;


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

       String check = CheckInfosUser.checkInfosConsumer(pseudo,email,firstName, lastName,password,phoneNumber,street,postal,city);

       if(check.equals("OK")){
           signUp(e);
       }else{

           display(check);
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
        } else {
            display("This pseudo already exists, choose an another one!");
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

    //TODO fonction à supprimer Flo quand t'aura utilisé la fonction dans utils -> checkinfoUser pour éviter dupliquer code de base d'anna

    private boolean checkInfosConsumer() {
        if ((pseudo.equals("") || password.equals("") || phoneNumber.equals("") || street.equals("") || postal.equals("") || city.equals(""))) {
            this.messageAttention = "You need to provide every information";
            display(messageAttention);
            return false;

        } else
            return internVerification();
    }

//TODO fonction à supprimer Flo quand t'aura utilisé la fonction dans utils -> checkinfoUser pour éviter dupliquer code de base d'anna

    private boolean internVerification() {
        if (password.length() < 8) {
            this.messageAttention = "Your password must have at least 8 characters";
            display(messageAttention);
        } else {
            if(passwordNotNull(password)) {
                if (phoneNumber.matches("[0-9]+") && (phoneNumber.length() == 10 || phoneNumber.length() == 12)) {
                    Matcher matcher = pattern.matcher(email);
                    if (matcher.matches()) {
                        if(postal.matches("[0-9]+")&&(postal.length()==5)){
                            return true;
                        }else{
                            this.messageAttention = "Your postal code is invalid";
                            display(messageAttention);
                        }
                    } else {
                        this.messageAttention = "Your email is incorrect";
                        display(messageAttention);
                    }
                } else {
                    this.messageAttention = "Your phone number is incorrect";
                    display(messageAttention);
                }
            }else{
                this.messageAttention = "You cannot have a space in the password" ;
                display(messageAttention);
            }
        }
        return false;
    }

    //TODO à modifier flo -> inspire toi de consumer, vérifie que ton param en plus est pas vide et après utilise ma fonction :)
    private boolean checkInfosSeller() {
        if ((pseudo.equals("") && password.equals("") || phoneNumber.equals("") && street.equals("") && postal.equals("") && city.equals("") && companyName.equals(""))) {
            this.messageAttention = "You need to provide every information";
            display(messageAttention);
            return false;

        } else
            return internVerification();
    }

    private boolean passwordNotNull(String p){
        return p.indexOf(" ")==-1; //-1 signifie qu'il y a pas d'espace dans la chaîne de caractères
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