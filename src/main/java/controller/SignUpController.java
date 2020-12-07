package controller;

import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    private boolean isAConsumer =false;
    /**
     * Default constructor
     */
    public SignUpController() {
    }

    /**
     * 
     */
    private UserFacade userFacade = new UserFacade();


    public void signUpConsumer(ActionEvent e) throws IOException{
        pseudo = txtPseudo.getText();
        password = txtPassword.getText();
        email = txtEmailAdress.getText();
        phoneNumber=txtPhoneNumber.getText();
        street = txtStreetAdress.getText();
        postal = txtPostal.getText();
        city = txtCity.getText();
        firstName = txtFirstname.getText();
        lastName = txtLastname.getText();

        /*while(checkInfosConsumer()==false){
            display(messageAttention);
        }*/
        isAConsumer = true;
            signUp(e);
        }


    public void signUpSeller(ActionEvent e) throws IOException{
        pseudo = txtPseudo.getText();
        password = txtPassword.getText();
        email = txtEmailAdress.getText();
        phoneNumber=txtPhoneNumber.getText();
        street = txtStreetAdress.getText();
        postal = txtPostal.getText();
        city = txtCity.getText();
        companyName = txtCompanyName.getText();
        firstName = txtFirstname.getText();
        lastName = txtLastname.getText();

        /*if(checkInfosSeller()==false){
            display("You need to provide all the information");
            initialize();
        }else {*/
            signUp(e);
        //}
    }


    /**
     * Method used by btnSignUp from Java FX
     * It allows to register into the system
     * @param e
     * @return
     */
    public void signUp(ActionEvent e) throws IOException {
            boolean noError = true;
            if(isAConsumer){
                noError = userFacade.signUpConsumer(pseudo,
                        firstName,
                        lastName,
                        password,
                        email,
                        street,
                        city,
                        postal);
            }else {
                noError = userFacade.signUpSeller(pseudo,
                        firstName,
                        lastName,
                        password,
                        email,
                        street,
                        city,
                        postal,
                        companyName);
            }
        if(noError){
            Router.getInstance().activate("Login");
        }
        else {
            display("Your pseudo already exists");
        }
    }

    /**
     *  Method used by btnLogin from Java FX
     * It allows to go to the page "login"
     */
    @FXML
    public void backLogin(ActionEvent e) throws IOException {
        Router.getInstance().activate("Login");
    }


    private boolean checkInfosConsumer(){
        if((pseudo.equals("")||password.equals("")||phoneNumber.equals("")||street.equals("")||postal.equals("")||city.equals(""))){
            this.messageAttention = "You need to provide every information";
            System.out.println("verif");
            return false;

        }else
            return internVerification();
    }

    private boolean internVerification() {
        if(password.length()<8){
            this.messageAttention = "Your password must have at least 8 characters";
        }else{
            String test = ""+Integer.parseInt(phoneNumber);
            if((phoneNumber.length()==10||phoneNumber.length()==12)&&(test==phoneNumber)){
                return true;
            }else{
                this.messageAttention = "Your phone number is incorrect";
            }
        }
        return false;
    }

    private boolean checkInfosSeller(){
        if((pseudo.equals("")&&password.equals("")||phoneNumber.equals("")&&street.equals("")&&postal.equals("")&&city.equals("")&&companyName.equals(""))){
            this.messageAttention = "You need to provide every information";
            System.out.println("verif");
            return false;

        }else
            return internVerification();
    }

    /**
     *  Method used by btnconsumer from Java FX
     * It allows to go to the page "SignUpconsumer"
     */
    @FXML
    public void consumerPage(ActionEvent e) throws IOException {
        Router.getInstance().activate("SignUpC");
    }

    /**
     *  Method used by btnSeller from Java FX
     * It allows to go to the page "SignUpSeller"
     */
    @FXML
    public void sellerPage(ActionEvent e) throws IOException {
        Router.getInstance().activate("SignUpS");
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
     * This methode allows to don't have error message at the beginning
     */
    public void initialize() {
        // TODO Auto-generated method stub
        errorText.setText("");
    }
}