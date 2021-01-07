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

public class CommentController {

    @FXML
    private Button btnSubmitComment;
    @FXML
    private TextField txtComment;
    @FXML
    private Label errorText;

    private boolean vide = true;
    String name = "4";

    private ProductFacade facadeP = new ProductFacade();
    private UserFacade facadeU = UserFacade.getInstanceUserFacade();

    /**
     * Default constructor
     */
    public CommentController() {
    }

    /**
     *  Method used by btnSubmitComment from Java FX
     * It permits to add a comment to a product
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
     * The first method used on the page
     * It permit to get and set a comment if the consumer had already put it
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