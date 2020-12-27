package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import router.Router;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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

    @FXML
    private ListView ListPseudo;

    String selectedPseudo = "nothing";
    /**
     * @return
     */
    public ArrayList<String> getAllConsumerPseudo() {
        return userFacade.getInstanceUserFacade().getAllConsumerPseudo();

        //afficher un message si vide ???????????
    }

    /**
     * this method redirects the admin to the update consumer page whose pseudo is passed in parameter
     *
     * @param pseudo
     */
    public void updateConsumer(String pseudo) {
        Object[] params = new Object[1];
        params[0] = pseudo;
        Router.getInstance().activate("HandleConsumer", params);

    }

    /**
     * delete the consumer selected in the listView
     * @return
     */
    public void deleteConsumer() {

        if(selectedPseudo.equals("nothing")){
            display("You must select a consumer");
        }
        else if (userFacade.getInstanceUserFacade().deleteUser(selectedPseudo)) {

            display(selectedPseudo + " account has been deleted");

            //remet à jour la liste
            ListPseudo.getItems().remove(selectedPseudo);
            selectedPseudo = "nothing";

        } else {
            display(selectedPseudo + " account hasn't been deleted ..");
        }

    }

    /**
     * Method used by btnBack from Java FX
     * It permit to return to the home page
     */
    public void back() {
        Router.getInstance().activate("HomePage");
    }

    /**
     * It allows to display a message on the user interface
     *
     * @param msg
     */
    @FXML
    public void display(String msg) {
        msgText.setText(msg);
    }

    /**
     * handle the selected pseudo in the list
     */
    public void handleItemClick() {

        ListPseudo.setOnMouseClicked(event -> {
            selectedPseudo = ListPseudo.getSelectionModel().getSelectedItem().toString();
        });


    }

    /**
     * initialize the page with the list of all consumers
     */
    public void initialize() {
       handleItemClick();
        ListPseudo.getItems().addAll(userFacade.getInstanceUserFacade().getAllConsumerPseudo());
    }
}

