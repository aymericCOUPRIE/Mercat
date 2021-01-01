package controller;

import facade.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import router.Router;
import javafx.scene.control.MenuItem;

import java.awt.*;
import java.io.IOException;

/**
 *
 */
public class HomePageController {

    /**
     *
     */
    private UserFacade userFacade = UserFacade.getInstanceUserFacade();

    /**
     *
     */
    //private SearchFacade searchFacade;

    @FXML
    private MenuItem handleC, myAccount;


    /**
     * Default constructor
     */
    public HomePageController() {
    }

    /**
     * @return
     */
    public void search() {
        // TODO implement here
    }

/* code branche user
    /**
     * Method used by the menue from Java FX
     * It permits to go to the page to handle a consumer acount

    @FXML
    public void handleUserAcount(ActionEvent e) throws IOException {

        if (userFacade.isSeller()) {
            //flo met là la redirection vers ta page pour modifier un seller
            Router.getInstance().activate("HandleSeller");
        } else { //je suis un consumer
            Router.getInstance().activate("HandleConsumer");

        }

    }

    /**
     * Method used by the menue from Java FX
     * It permits to go in the handle consumers page
     *
     * @param e
     * @throws IOException

    @FXML
    public void handleConsumers(ActionEvent e) throws IOException {

        //pas besoin de tester si bien admin car boutton menu affiché selement pour les admins
        Router.getInstance().activate("HandleConsumerS");
    }
    */

    /**
     *  Method used by the menue from Java FX
     *  It permits to go in the basket page of the consumer logged
     *   @param e
     * @throws IOException
     */
    public void basket(ActionEvent e ) throws IOException{
        Router.getInstance().activate("Basket");
    }

    /**
     * This method allows to manage the display of the menu according to the user's role.
     */
    public void initialize() {
        /** code branche user
        if (!(userFacade.getConnectedUser().getRole().equals("admin"))) {
            handleC.setVisible(false);
        } else { //je suis un admin
            myAccount.setVisible(false); //je modifie pas mes infos quand je suis un admin donc cache cette page
        }
         */

        if(!userFacade.getConnectedUser().getRole().equals("consumer")){ //seul consumer a un panier
            myAccount.setVisible(false);
        }
    }


}
