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


}