package controller.product;

import facade.BasketFacade;
import facade.ProductFacade;
import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Product;
import router.Router;

import java.util.ArrayList;

/**
 * Class DetailProductController
 */
public class DetailProductController {

    private final BasketFacade basketFacade = BasketFacade.getInstanceBasketFacade();

    private final ProductFacade productFacade = ProductFacade.getInstance();

    private final UserFacade userFacade = UserFacade.getInstanceUserFacade(); //pour avoir accès à l'user connecté
    private Product curentProduct;

    @FXML
    private ListView ListComment;

    //private final Product curentProduct = new Product(5, "jupe", "dezfd", 25, "none", "ulisses", 3);
     //produit qui est affiché sur la page
    //TODO  .........
    //TODO   = new ... pour tester car Anna a pas encore mis de produit sur la page
    //TODO   sinon initialier le produit dans initialise, le récupérer du controler


    @FXML
    private TextField txtQuantity;

    @FXML
    private Label errorLabel;

    @FXML
    private Label nameP;
    @FXML
    private Label descriptionP;
    @FXML
    private Label priceP;
    @FXML
    private Label txtAverageRate;

    @FXML
    private Button sellerProductsButton;
    //On stocke le produit de la page
    private ArrayList<Product> productArrayList;

    /**
     * This method permits to add the product of the current page in the customer's basket
     */
    public void addToBasket() {
        if (txtQuantity.getText().isEmpty()) {
            errorLabel.setText("You must provide the quantity of product you want to add in your basket!");
        } else if (Integer.parseInt(txtQuantity.getText()) > 0) {
            if (basketFacade.addToBasket(curentProduct.getIdProduct(), Integer.parseInt(txtQuantity.getText()), userFacade.getConnectedUser().getPseudo())) {
                errorLabel.setText("The product has been added into the basket!");
            } else {
                errorLabel.setText("This product is already in your basket. If you want to update the quantity, please go on 'My basket' page.");
            }
        } else {
            errorLabel.setText("You must provide a positive quantity!");
        }
    }



     /**
     * This method is called automatically when the user
     * get on the corresponding interface
     *
     * It displayed to the user all the details about a specific product
     */
    public void initialize() {
        errorLabel.setText("");
        ArrayList<Product> product = Router.getInstance().getParametre();
        this.productArrayList = product;
        curentProduct = product.get(0);
       // ObservableList<Product> listProduct = FXCollections.observableArrayList(product);
        nameP.setText(product.get(0).getNameProduct());
        descriptionP.setText(product.get(0).getDescription());
        priceP.setText("" + product.get(0).getPriceProduct());

        Float averageRate;
        averageRate = productFacade.getProductAverageRate(productFacade.getIdProduct(product.get(0)));
        System.out.println(averageRate);
        if (averageRate == 0) {
            txtAverageRate.setText("/");
        } else {
            txtAverageRate.setText(averageRate.toString());
        }

        ArrayList<String> comments = productFacade.getAllCommentProduct(productFacade.getIdProduct(product.get(0)));
        ListComment.getItems().addAll(comments);

    }

    /**
     * This method is used to go to the seller's product owner profile page
     */
    public void goToSellerPage() {
        Router.getInstance().activate("ProfileSeller", productArrayList);
    }


    /**
     * This method is used to return to the homePage
     *
     */
    public void homePage() {
        Router.getInstance().activate("HomePage");
    }
}
