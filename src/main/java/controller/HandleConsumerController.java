package controller;

import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private UserFacade userFacade = UserFacade.getInstanceUserFacade();

    @FXML
    private Label msgText;

    @FXML
    private TextField txtShearchField;

    @FXML
    private ListView ListPseudo;

    String selectedPseudo = "nothing";


    /**
     * this method redirects the admin to the update consumer page whose pseudo has been selected
     */
    public void updateConsumer() {

        if (selectedPseudo.equals("nothing")) {
            display("You must select a consumer");
        } else {
            Object[] params = new Object[1];
            params[0] = selectedPseudo;
            Router.getInstance().activate("HandleConsumer", params);
        }
    }

    /**
     * delete the consumer selected in the listView
     */
    public void deleteConsumer() {

        if (selectedPseudo.equals("nothing")) {
            display("You must select a consumer");
        } else if (userFacade.getInstanceUserFacade().deleteUser(selectedPseudo)) {

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
     * This method permit to find a consumer
     * It will display the pseudo or an error message
     */
    public void searchConsumer() {

        if (txtShearchField.getText().equals("")) {
            display("You must enter a consumer's pseudo!");
        } else {
            String res = userFacade.getInstanceUserFacade().searchConsumer(txtShearchField.getText());
            if (res.equals("User not exist!") || res.equals("This user is not a consumer..")) {
                display(res);
            } else {
                ListPseudo.getItems().clear();
                ListPseudo.getItems().add(res);
            }
        }


    }

    /**
     * initialize the page with the list of all consumers
     */
    public void initialize() {

        handleItemClick();
        ArrayList<String> tempo = userFacade.getAllConsumerPseudo();
        ListPseudo.getItems().addAll(tempo);

        if (ListPseudo.getItems().size() == 0) {
            display("There is no consumer yet..");
        }
    }
}

