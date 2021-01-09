package controller;

import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import router.Router;
import utils.CheckInfosUser;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class UpdateConsumerProfileController {


    @FXML
    private Label txtPseudo;
    @FXML
    private TextField txtFirstname;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtEmailAdress;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private TextField txtStreetAdress;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtPostal;
    @FXML
    private TextField txtCity;
    @FXML
    private Label errorText;


    private String OldPassword; //pour savoir si je dois crypter le mdp lors de la modification où si il l'est déjà car pas changé

    /**
     * this facade permits to get the informations about the logged-in user
     */
    private final UserFacade userFacade = new UserFacade();

    /**
     * This methode permits to get all the information about a consumer.
     * @return logged-in Consumer
     *
     */
    public User getConsumerDetails() {
        return  userFacade.getConsumerDetails();
    }

    /**
     *  Method used by btnDeleteConsumer from Java FX
     *  It permit to delete the consumer account from the dataBase
     *
     */
    public void deleteConsumer() {
        if(userFacade.deleteUser(txtPseudo.getText())){

            if(!(userFacade.isAdmin())){
                display("Your account has been deleted");

                CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
                    // Your code here executes after 3 seconds!
                    Router.getInstance().activate("Login");
                });
            }else{
                display(Router.getInstance().getParams()[0].toString() + " account has been deleted");
                CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
                    // Your code here executes after 3 seconds!
                    Router.getInstance().activate("HandleSellerS");
                });
            }
        }else{
            display("Your account hasn't been deleted ...");
        }
    }

    /**
     *  Method used by btnUpdateConsumer from Java FX
     *  It permit to update some information about the consumer in the dataBase
     *  the information is entered by the user in the form
     */
    @FXML
    public void updateConsumer() {

        String check = CheckInfosUser.checkInfosConsumer(txtPseudo.getText(),txtEmailAdress.getText(),txtFirstname.getText(),txtLastname.getText(),txtPassword.getText(),txtPhoneNumber.getText(),txtStreetAdress.getText(),txtPostal.getText(),txtCity.getText());

        if(check.equals("OK")){
            if(userFacade.updateUser(txtPseudo.getText(), txtFirstname.getText(), txtLastname.getText(), txtPassword.getText() ,OldPassword, txtEmailAdress.getText(), txtStreetAdress.getText(),txtCity.getText(),txtPostal.getText(),txtPhoneNumber.getText())){
                display("Your profile has been updated !");
            } else {
                display("Error during update !");
            }
        }else{

            display(check);
        }

    }

    /**
     * To initialize the variable with the information in the data base
     */
    public void initialize() {
        //User car ça peut être un admin ou un consumer
        User c = getConsumerDetails();
        txtPseudo.setText(c.getPseudo());
        txtFirstname.setText(c.getFirstName());
        txtLastname.setText(c.getLastName());
        txtEmailAdress.setText(c.getEmailAddress());
        txtPassword.setText(c.getPassword());
        OldPassword = c.getPassword();
        txtPhoneNumber.setText(c.getPhoneNumber());
        txtStreetAdress.setText(c.getStreetAddress());
        txtCity.setText(c.getCity());
        txtPostal.setText(c.getPostalCode());
        errorText.setText("");

    }

    /**
     * Method used by btnBack from Java FX
    *  It permit to return to the home page
     */
    public void back(){
        Router.getInstance().activate("HomePage");
    }

    /**
     * It allows to display an error message on the user interface
     * @param msg to display
     */
    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

}