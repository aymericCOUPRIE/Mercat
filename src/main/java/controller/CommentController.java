package controller;

import facade.ProductFacade;
import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Consumer;
import model.Seller;
import model.User;
import router.Router;
import utils.CheckInfosUser;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class CommentController {

    @FXML
    private Button btnSubmitComment;
    @FXML
    private TextField txtComment;
    @FXML
    private Label errorText;

    private boolean vide = true;
    String name = "4";

    /**
     * Default constructor
     */
    public CommentController() {
    }

    /**
     * 
     */
    private ProductFacade facadeP = new ProductFacade();
    private UserFacade facadeU = UserFacade.getInstanceUserFacade();


    /**
     * @return
     */
    @FXML
    public void addComment() {
        String txt = txtComment.getText();
        System.out.println(vide);
        int i = Integer.parseInt(name);

        if(vide){
            facadeP.addComment((Consumer) facadeU.getConnectedUser(), txt, i);
            display("Comment update !");
        } else {
            facadeP.updateComment((Consumer) facadeU.getConnectedUser(), txt, i);
            display("Comment update !");
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
     * It allows to display an error message on the user interface
     * @param msg
     */
    @FXML
    public void display(String msg)
    {
        errorText.setText(msg);
    }

    /**
     * To initialize the variable with the information in the data base
     */
    @FXML
    public void initialize() {

        int i = Integer.parseInt(name);
        String comment = facadeP.getComment((Consumer) facadeU.getConnectedUser(), i);

        if(comment.equals("")){
           vide = true;
        } else{
            vide = false;
            txtComment.setText(comment);
        }

        errorText.setText("");

    }

}