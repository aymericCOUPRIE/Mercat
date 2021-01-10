package controller;

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

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class HomePageController {

    private Router router = Router.getInstance();
    private UserFacade userFacade = UserFacade.getInstanceUserFacade();
    private ProductFacade productFacade = ProductFacade.getInstance();


    @FXML
    private MenuItem handleC, myAccount, handleS, ConsultHistoricOrder, updateCategories, addProduct, mySellerAccount;
    private ActionEvent e;

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
    private String priceEuros;
    private String priceCents;
    private String description;
    private String productName;
    private String city;


    /**
     * @return
     */
    public void search() {
        // TODO implement here
    }


    /**
     * Method used by the menue from Java FX
     * It permits to go to the page to handle a consumer acount
     *
     * @param e
     * @throws IOException
     */

    @FXML
    public void handleUserAcount(ActionEvent e) throws IOException {
        if (userFacade.isSeller()) {
            Router.getInstance().activate("HandleSeller");
        } else { //je suis un consumer
            Router.getInstance().activate("HandleConsumer");
        }
    }

    @FXML
    public void accountSeller(ActionEvent e) throws IOException {
        Router.getInstance().activate("ProfileSeller");
    }

    /**
     * Method used by the menue from Java FX
     * It permits to go in the handle sellers page
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void handleSellers(ActionEvent e) throws IOException {
        Router.getInstance().activate("HandleSellerS");
    }

    /**
     * This method allows to manage the display of the menu according to the user's role.
     */
    public void initialize() {
        if (!(userFacade.getConnectedUser().getRole().equals("admin"))) {
            handleC.setVisible(false);
            handleS.setVisible(false);
            updateCategories.setVisible(false);

        } else { //je suis un admin
            myAccount.setVisible(false); //je modifie pas mes infos quand je suis un admin donc cache cette page
            ConsultHistoricOrder.setVisible(false);
            mySellerAccount.setVisible(false);
        }

        if(!(userFacade.getConnectedUser().getRole().equals("seller"))){
            addProduct.setVisible(false);
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
     * @param e
     * @throws IOException
     */

    @FXML
    public void handleConsumers(ActionEvent e) throws IOException {

        //pas besoin de tester si bien admin car boutton menu affiché selement pour les admins
        Router.getInstance().activate("HandleConsumerS");
    }


    /**
     * Method used by the menue from Java FX
     * It permits to go in the basket page of the consumer logged
     *
     * @param e
     * @throws IOException
     */
    public void basket(ActionEvent e) throws IOException {
        Router.getInstance().activate("Basket");
    }

    public void consultHistoricOrder(ActionEvent e) {
        router.activate("HistoricOrder");
    }

    /**
     * Goes to UpdateCategories page
     *
     * @param e
     */
    public void updateCategoriesPage(ActionEvent e) {
        router.activate("UpdateCategories");
    }

    /**
     * This method enables you to research a product thanks to his name
     *
     * @param e
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
     * @param e
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
     * @param e
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
     * @param e
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
     * @param msg
     */
    public void display(String msg) {
        errorText.setText(msg);
    }

    public void addProduct() {
        Object[] o = new Object[1];
        o[0] = userFacade.getConnectedUser().getPseudo();
        Router.getInstance().activate("AddProduct", o);

    }
}
