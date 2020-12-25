package controller;

import com.sun.management.UnixOperatingSystemMXBean;
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
        // TODO implement here -> voir si faut modifier fonction deleteUser et afficher un message sur la page pour confirmer la suppression
        userFacade.getInstanceUserFacade().deleteUser(pseudo);
    }

    /**
     * Method used by btnBack from Java FX
     *  It permit to return to the home page
     */
    public void back(){
        Router.getInstance().activate("HomePage");
    }


}