package controller;

import facade.UserFacade;
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

    private final UserFacade userFacade = UserFacade.getInstanceUserFacade();

    /**
     * Default constructor
     */
    public LoginController() {
    }


    /**
     * Method used by btnLogin from Java FX
     * It allows to log in the system
     *
     *
     * @throws IOException when there is an error during the login
     */
    @FXML
    public void login() throws IOException {
        String pseudo = txtPseudoUser.getText();
        String passWord = txtPassWord.getText();

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
     *
     */
    @FXML
    public void signUp() {
        Router.getInstance().activate("SignUpC");
    }

    /**
     * It allows to display an error message on the user interface
     *
     * @param msg the message of error, gives indication to the user
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