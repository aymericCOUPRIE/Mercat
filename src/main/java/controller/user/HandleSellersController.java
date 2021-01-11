package controller.user;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import router.Router;

import java.util.*;

/**
 *
 */
public class HandleSellersController {

    @FXML
    private Label msgText;
    @FXML
    private TextField txtShearchField;
    @FXML
    private ListView ListPseudo;

    String selectedPseudo = "nothing";

    private final UserFacade userFacade = UserFacade.getInstanceUserFacade();

    /**
     * Default constructor
     */
    public HandleSellersController() {
    }

    /**
     * this method redirects the admin to the update consumer page whose pseudo has been selected
     */
    public void updateSeller() {

        if (selectedPseudo.equals("nothing")) {
            display("You must select a seller");
        } else {
            Object[] params = new Object[1];
            params[0] = selectedPseudo;
            Router.getInstance().activate("HandleSeller", params);
        }
    }

    /**
     * delete the seller selected in the listView
     */
    public void deleteSeller() {

        if (selectedPseudo.equals("nothing")) {
            display("You must select a seller");
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
     * @param msg error message
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
     * This method permit to find a seller
     * It will display the pseudo or an error message
     */
    public void searchSeller() {

        if (txtShearchField.getText().equals("")) {
            display("You must enter a seller's pseudo!");
        } else {
            String res = userFacade.getInstanceUserFacade().searchSeller(txtShearchField.getText());
            if (res.equals("User not exist!") || res.equals("This user is not a consumer..")) {
                display(res);
            } else {
                ListPseudo.getItems().clear();
                ListPseudo.getItems().add(res);
            }
        }
    }

    /**
     * initialize the page with the list of all seller
     */
    public void initialize() {

        handleItemClick();
        ArrayList<String> tempo = userFacade.getAllSellersPseudo();
        ListPseudo.getItems().addAll(tempo);

        if (ListPseudo.getItems().size() == 0) {
            display("There is no seller yet..");
        }
    }

}