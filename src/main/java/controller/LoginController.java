package controller;

import facade.UserFacade;

import java.util.*;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.Router;
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

    // Config

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
     * @return
     */
    @FXML
    public void login() {
        // TODO implement here
    }

    /**
     * @return
     */
    @FXML
    public void signUp() {
        // TODO implement here
    }

    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

    public void initialize() {
        // TODO Auto-generated method stub
        errorText.setText("");
    }
}