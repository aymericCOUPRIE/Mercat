package controller;

import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import router.Router;

import java.awt.*;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class HomePageController {

    /**
     * Default constructor
     */
    public HomePageController() {
    }

    /**
     *
     */
    private UserFacade userFacade;

    @FXML
    MenuItem handleConsumers;
    /**
     *
     */
    //private SearchFacade searchFacade;





    /**
     * @return
     */
    public void search() {
        // TODO implement here
    }



    /**
     *  Method used by the menue from Java FX
     * It permits to go to the page to handle a consumer acount
     */
    @FXML
    public void handleUserAcount(ActionEvent e) throws IOException {
        if(UserFacade.isSeller()){
            //flo met là la redirection vers ta page pour modifier un seller
        }else{ //je suis un consumer ou un admin
            Router.getInstance().activate("HandleConsumer");
        }

    }

    /**
     * Method used by the menue from Java FX
     * It permits to go in the handle consumers page
     * @param e
     * @throws IOException
     */
    @FXML
    public void handleConsumers(ActionEvent e) throws IOException{
        //pas besoin de tester si bien admin car boutton menu affiché selement pour les admins
        Router.getInstance().activate("HandleConsumerS");
    }

    /**
     * This method allows to manage the display of the menu according to the user's role.
     */
    public void initialize(){
        if(! UserFacade.getInstanceUserFacade().getConnectedUser().getRole().equals("admin")){
            handleConsumers.setVisible(false); //??????pourquoi marche pas cette merde???
        }
    }




}