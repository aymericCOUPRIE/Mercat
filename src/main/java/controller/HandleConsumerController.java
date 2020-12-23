package controller;

import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Consumer;
import router.Router;

import java.util.*;

/**
 * 
 */
public class HandleConsumerController {

    /**
     * Default constructor
     */
    public HandleConsumerController() {
    }

    /**
     * 
     */
    private UserFacade userFacade;


    @FXML
    public ListView<String> ListViewConsumers;
    /**
     * @return
     */
    public Set<String> getAllConsumerPseudo() {
        // TODO implement here
        return null;
    }

    /**
     * @param pseudo 
     * @return
     */
    public void updateConsumer(Consumer pseudo) {
        // TODO implement here
    }

    /**
     * @param pseudo 
     * @return
     */
    public void daleteConsumer(String pseudo) {
        // TODO implement here
    }

    /**
     * Method used by btnBack from Java FX
     *  It permit to return to the home page
     */
    public void back(){
        Router.getInstance().activate("HomePage");
    }


}