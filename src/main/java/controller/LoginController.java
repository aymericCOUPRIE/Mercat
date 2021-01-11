package controller;

import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import router.Router;

import java.io.IOException;

/**
 * Class LoginController
 */
public class LoginController {

    // Java FX Implementation

    @FXML
    private TextField txtPseudoUser;

    @FXML
    private PasswordField txtPassWord;

    @FXML
    private Label errorText;

    // Configuration

    private String pseudo, passWord;

    private UserFacade userFacade = new UserFacade();

    /**
     * Default constructor
     */
    public LoginController() {
    }


    /**
     * Method used by btnLogin from Java FX
     * It allows to log in the system
     *
     * @param e subject of the action
     * @throws IOException
     */
    @FXML
    public void login(ActionEvent e) throws IOException {
        pseudo = txtPseudoUser.getText();
        passWord = txtPassWord.getText();

        if (pseudo.equals("") || passWord.equals("")) {
            display("You need to provide your email or your password.");
        } else { //les champs ont été remplis
            userFacade.login(pseudo, passWord);
            if (userFacade.isConnected()) { //je suis connecté donc je suis redirigé sur la page d'acceuil
                Router.getInstance().activate("HomePage");

            } else {
                display("You provide a wrong pseudo or password! Try again.");
            }
        }
    }

    /**
     * Method used by btnLogin from Java FX
     * It permits to go to the page to sign up
     */
    @FXML
    public void signUp(ActionEvent e) throws IOException {
        Router.getInstance().activate("SignUpC");
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

        errorText.setText("");

    }
}