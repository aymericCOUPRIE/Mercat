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
    private PasswordField txtCompanyName;
    @FXML
    private TextField txtPseudo;
    @FXML
    private PasswordField txtEmailAdress;
    @FXML
    private PasswordField txtPhoneNumber;
    @FXML
    private PasswordField txtStreetAdress;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtPostal;
    @FXML
    private PasswordField txtCity;
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
    private String companyName;
    private String email;
    private String phoneNumber;
    private String street;
    private String postal;
    private String city;

    private String idSellerButton;
    private String idConsumerButton;

    private boolean isAConsumer =false;
    /**
     * Default constructor
     */
    public SignUpController() {
    }

    /**
     * 
     */
    private UserFacade userFacade;


    public void signUpConsumer(ActionEvent e) throws IOException{
        pseudo = txtPseudo.getText();
        password = txtPassword.getText();
        email = txtEmailAdress.getText();
        phoneNumber=txtPhoneNumber.getText();
        street = txtStreetAdress.getText();
        postal = txtPostal.getText();
        city = txtCity.getText();

        if(checkInfosConsumer()==false){
            display("You need to provide all the information");
        }else {
            isAConsumer = true;
            signUp(e);
        }

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

        if(checkInfosSeller()==false){
            display("You need to provide all the information");
        }else {
            signUp(e);
        }
    }


    /**
     * Method used by btnSignUp from Java FX
     * It allows to register into the system
     * @param e
     * @return
     */
    public void signUp(ActionEvent e) throws IOException {

            if(isAConsumer){
                userFacade.signUpConsumer(pseudo,
                        email,
                        password,
                        phoneNumber,
                        street,
                        city,
                        postal);
            }else{
                userFacade.signUpSeller(pseudo,
                        email,
                        password,
                        phoneNumber,
                        street,
                        city,
                        postal,
                        companyName);
            }
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
    //TODO `how to check if it is a consumer or a seller`


    private boolean checkInfosConsumer(){
        if(pseudo.equals("")||password.equals("")||phoneNumber.equals("")||street.equals("")||postal.equals("")||city.equals("")){
            return false;
        }else return true;
    }

    private boolean checkInfosSeller(){
        if(pseudo.equals("")||password.equals("")||phoneNumber.equals("")||street.equals("")||postal.equals("")||city.equals("")||companyName.equals("")){
            return false;
        }else return true;
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