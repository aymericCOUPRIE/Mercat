package controller;

import com.sun.management.UnixOperatingSystemMXBean;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Consumer;
import router.Router;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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
    private Label msgText;

    /**
     * @return
     */
    public ArrayList<String> getAllConsumerPseudo() {
        return userFacade.getInstanceUserFacade().getAllConsumerPseudo();

        //afficher un message si vide ???????????
    }

    /** this method redirects the admin to the update consumer page whose pseudo is passed in parameter
     * @param pseudo 

     */
    public void updateConsumer(String pseudo) {
        Object[] params = new Object[1];
        params[0] =  pseudo;
        Router.getInstance().activate("HandleConsumer",params);

    }

    /**
     * @param pseudo 
     * @return
     */
    public void daleteConsumer(String pseudo) {

        if(userFacade.getInstanceUserFacade().deleteUser(pseudo)){

            display(pseudo + " account has been deleted");

        }else{
            display(pseudo + " account hasn't been deleted ..");
        }
    }

    /**
     * Method used by btnBack from Java FX
     *  It permit to return to the home page
     */
    public void back(){
        Router.getInstance().activate("HomePage");
    }
    /**
     * It allows to display a message on the user interface
     * @param msg
     */
    @FXML
    public void display(String msg)
    {
        msgText.setText(msg);
    }


}