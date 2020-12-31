package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.*;

/**
 * 
 */
public class HandleSellersController {

    /**
     * Default constructor
     */
    public HandleSellersController() {
    }

    private UserFacade userFacade = UserFacade.getInstanceUserFacade();

    @FXML
    private Label msgText;

    @FXML
    private TextField txtShearchField;

    @FXML
    private ListView ListPseudo;


    /**
     * @return
     */
    public Set<String> getAllSellersPseudo() {
        // TODO implement here
        return null;
    }

    /**
     * @param pseudo 
     * @return
     */
    public void updateSeller(String pseudo) {
        // TODO implement here
    }

    /**
     * @param pseudo 
     * @return
     */
    public void deleteSeller(String pseudo) {
        // TODO implement here
    }

}