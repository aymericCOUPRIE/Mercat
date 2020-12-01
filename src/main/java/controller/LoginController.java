package controller;

import facade.UserFacade;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import router.Router;
import javafx.event.ActionEvent;

/**
 * 
 */
public class LoginController {

    // Java FX Implementation
    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtLoginUser;

    @FXML
    private PasswordField txtPassWord;

    @FXML
    private Label errorText;

    // Configuration

    private String login;
    private String passWord;


    /**
     *
     */
    private UserFacade userFacade = new UserFacade();

    /**
     * Default constructor
     */
    public LoginController() {
    }



    /**
     * Method used by btnLogin from Java FX
     * It permite to log in the system
     * @param login,password
     * @throws IOException
     */
    @FXML
    public void login(ActionEvent e) throws IOException {
        login = txtLoginUser.getText();
        passWord = txtPassWord.getText();

        if(login.equals("") || passWord.equals("")){
            display("You need to provide your email or your password.");
        }else{ //les champs ont été remplis
            userFacade.login(login,passWord);

            if(userFacade.isConnected()){ //je suis connecté donc je suis redirigé sur la page d'acceuil
                Router.getInstance().activate("HomePage");
            }else{
                display("You provide a wrong login or password! Try again.");
            }
        }
    }

    /**
     *  Method used by btnLogin from Java FX
     * It permite to go to the page to sign up
     */
    @FXML
    public void signUp(ActionEvent e) throws IOException {
        Router.getInstance().activate("SignUp");
    }

    /**
     * It permite to display an error message on the user interface
     * @param msg
     */
    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

    /**
     * This methode permite to don't have error message at the begining
     */
    public void initialize() {
        // TODO Auto-generated method stub
        errorText.setText("");
    }
}