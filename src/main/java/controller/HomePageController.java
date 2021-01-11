package controller;

import controller.product.ProductController;
import facade.ProductFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import model.Category;
import model.Product;
import router.Router;

import java.util.ArrayList;

/**
 * Class HomePageController
 */
public class HomePageController {

    private final Router router = Router.getInstance();
    private final UserFacade userFacade = UserFacade.getInstanceUserFacade();
    private final ProductFacade productFacade = ProductFacade.getInstance();


    @FXML
    private MenuItem handleC, myAccount, handleS, ConsultHistoricOrder, updateCategories, addProduct, mySellerAccount, basket;

    private ProductController productController = new ProductController();

    @FXML
    private Label errorText;

    @FXML
    private TextField txtProduct1;
    @FXML
    private TextField txtProduct2;
    @FXML
    private TextField txtProduct3;
    @FXML
    private TextField txtProduct4;
    @FXML
    private TextField txtCity1;
    @FXML
    private TextField txtCity2;
    @FXML
    private TextField txtCategory1;
    @FXML
    private TextField txtCategory2;


    private String categoryName;
    private String productName;
    private String city;

    /**
     * Default constructor
     */
    public HomePageController() {
    }


    /**
     * Method used by the menue from Java FX
     * It permits to go to the page to handle a consumer acount
     *
     * @param e Subject of the action
     */
    @FXML
    public void handleUserAcount(ActionEvent e) {
        if (userFacade.isSeller()) {
            Router.getInstance().activate("HandleSeller");
        } else { //je suis un consumer
            Router.getInstance().activate("HandleConsumer");
        }
    }

    /**
     * This method is used to consult the seller page
     *
     * @param e subject of the action
     */
    @FXML
    public void accountSeller(ActionEvent e) {
        Router.getInstance().activate("ProfileSeller");
    }

    /**
     * Method used by the menue from Java FX
     * It permits to go in the handle sellers page
     *
     * @param e subject of the action
     */
    @FXML
    public void handleSellers(ActionEvent e) {
        Router.getInstance().activate("HandleSellerS");
    }

    /**
     * This method allows to manage the display of the menu according to the user's role.
     */
    public void initialize() {
        if (!(userFacade.getConnectedUser().getRole().equals("admin"))) { //consumer ou seller
            handleC.setVisible(false);
            handleS.setVisible(false);
            updateCategories.setVisible(false);

            if (userFacade.getConnectedUser().getRole().equals("seller")) {
                basket.setVisible(false);
            }

        } else { //je suis un admin
            myAccount.setVisible(false); //je modifie pas mes infos quand je suis un admin donc cache cette page
            ConsultHistoricOrder.setVisible(false);
            mySellerAccount.setVisible(false);
            basket.setVisible(false);

        }


        if (!(userFacade.getConnectedUser().getRole().equals("seller"))) { //admin ou consumer
            addProduct.setVisible(false);
            mySellerAccount.setVisible(false);
        }

        errorText.setText("");
        ArrayList<Category> listCategory = Router.getInstance().getParametreC();
        ArrayList<String> listNomCategory = new ArrayList<String>();
        for (Category c : listCategory) {
            listNomCategory.add(c.getNameCategory());
        }
        ObservableList<String> listObservableCategory = FXCollections.observableArrayList(listNomCategory);
    }

    /**
     * Method used by the menue from Java FX
     * It permits to go in the handle consumers page
     *
     * @param e subject of the action
     */

    @FXML
    public void handleConsumers(ActionEvent e) {

        //pas besoin de tester si bien admin car boutton menu affiché selement pour les admins
        Router.getInstance().activate("HandleConsumerS");
    }


    /**
     * Method used by the menue from Java FX
     * It permits to go in the basket page of the consumer logged
     *
     * @param e subject of the action
     */
    public void basket(ActionEvent e) {
        Router.getInstance().activate("Basket");
    }

    /**
     * this emthod is used to go on the consult historic order page
     *
     * @param e subject of the action
     */
    public void consultHistoricOrder(ActionEvent e) {
        router.activate("HistoricOrder");
    }

    /**
     * Goes to UpdateCategories page
     *
     * @param e subject of the action
     */
    public void updateCategoriesPage(ActionEvent e) {
        router.activate("UpdateCategories");
    }

    /**
     * This method enables you to research a product thanks to his name
     *
     * @param e subject of the action
     */
    public void getProductsByName(ActionEvent e) {
        productName = txtProduct1.getText();
        if (productName.equals("")) {
            display("You need to fill the field");
        } else {
            ArrayList<Product> p = productFacade.getProductsByName(productName);
            System.out.println("HomePageController getProductsByName");
            Router.getInstance().activate("ProductUI", p);
        }
    }

    /**
     * This method enables you to research a product by his name and the name of a city
     *
     * @param e subject of the action
     */
    public void getProductsByNameAndCity(ActionEvent e) {
        productName = txtProduct2.getText();
        city = txtCity1.getText();
        if (productName.equals("") || city.equals("")) {
            display("You need to fill every field");
        } else {
            ArrayList<Product> p = productFacade.getProductsByNameAndCity(productName, city);
            Router.getInstance().activate("ProductUI", p);
        }
    }

    /**
     * This method enables you to research a product by his name and the category
     *
     * @param e subject of the action
     */
    public void getProductsByNameAndCategory(ActionEvent e) {
        productName = txtProduct3.getText();
        categoryName = txtCategory1.getText();
        if (productName.equals("") || categoryName.equals("")) {
            display("You need to fill every field");
        } else {
            ArrayList<Product> p = productFacade.getProductsByNameAndCategory(productName, categoryName);
            Router.getInstance().activate("ProductUI", p);
        }
    }

    /**
     * This method enables you to research a product by name, category and city
     *
     * @param e subject of the action
     */
    public void getProductsByNameAndCityAndCategory(ActionEvent e) {
        productName = txtProduct4.getText();
        categoryName = txtCategory2.getText();
        city = txtCity2.getText();
        if (productName.equals("") || city.equals("") || categoryName.equals("")) {
            display("You need to fill every field");
        } else {
            ArrayList<Product> p = productFacade.getProductByNameAndCityAndCategory(productName, city, categoryName);
            Router.getInstance().activate("ProductUI", p);
        }
    }

    /**
     * Show on an error message on the page, it informs the user of his mistakes
     *
     * @param msg contins the error message
     */
    public void display(String msg) {
        errorText.setText(msg);
    }

    /**
     * This method is used for a seller to add a product
     */
    public void addProduct() {
        Object[] o = new Object[1];
        o[0] = userFacade.getConnectedUser().getPseudo();
        Router.getInstance().activate("AddProduct", o);

    }

    /**
     * This method is used to disconnect the user from the application
     *
     * @param actionEvent subject of the action
     */
    public void disconnectUser(ActionEvent actionEvent) {
        router.activate("Login");
    }
}
