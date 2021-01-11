package controller.rate_comment;

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
 * Class Comment (comments are only on products)
 */
public class CommentController {

    @FXML
    private Button btnSubmitComment;
    @FXML
    private TextField txtComment;
    @FXML
    private Label errorText;
    @FXML
    private Label nameProduct;

    private boolean vide = true;
    int idProduct;

    private final ProductFacade facadeP = ProductFacade.getInstance();
    private final UserFacade facadeU = UserFacade.getInstanceUserFacade();

    /**
     * Default constructor
     */
    public CommentController() {
    }

    /**
     * Method used by btnSubmitComment from Java FX
     * It permits to add a comment to a product
     */
    @FXML
    public void addComment() {
        String txt = txtComment.getText();
        System.out.println(vide);

        if (vide) {
            facadeP.addComment((Consumer) facadeU.getConnectedUser(), txt, idProduct);
            display("Comment update !");
        } else {
            facadeP.updateComment((Consumer) facadeU.getConnectedUser(), txt, idProduct);
            display("Comment update !");
        }

    }

    /**
     * Method used by btnBack from Java FX
     * It permit to return to the home page
     */
    public void back() {
        Router.getInstance().activate("HistoricOrder");
    }

    /**
     * It allows to display an error message on the user interface
     *
     * @param msg contains the error displayed to the user
     */
    @FXML
    public void display(String msg) {
        errorText.setText(msg);
    }

    /**
     * The first method used on the page
     * It permit to get and set a comment if the consumer had already put it
     */
    @FXML
    public void initialize() {
        idProduct = (Integer) Router.getInstance().getParams()[0];
        String comment = facadeP.getComment((Consumer) facadeU.getConnectedUser(), idProduct);

        if (comment.equals("")) {
            vide = true;
        } else {
            vide = false;
            txtComment.setText(comment);
        }

        errorText.setText("");

    }

}