package controller;

import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import router.Router;

import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class SignUpController {

    /**
     * Default constructor
     */
    public SignUpController() {
    }

    /**
     * 
     */
    private UserFacade userFacade;


    /**
     * @return
     */
    public void signUp() {
        // TODO implement here
    }

    /**
     *  Method used by btnLogin from Java FX
     * It allows to go to the page "login"
     */
    @FXML
    public void backLogin(ActionEvent e) throws IOException {
        Router.getInstance().activate("Login");
    }

    /**
     *  Method used by btnConsummer from Java FX
     * It allows to go to the page "SignUpConsummer"
     */
    @FXML
    public void consummerPage(ActionEvent e) throws IOException {
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

}