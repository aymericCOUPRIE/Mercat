package controller;

import facade.ProductFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Product;
import router.Router;

import java.util.ArrayList;

/**
 * 
 */
public class ProductPageController {

    @FXML
    private TableView<Product> tableViewProduct;
    @FXML
    private TableColumn<Product, String> nameProduct;
    @FXML
    private TableColumn<Product, String> cityProduct;
    @FXML
    private TableColumn<Product, String> seller;
    @FXML
    private TableColumn<Product, Integer> product;

    @FXML
    private Button home;
    @FXML
    private Button sellerPageButton;

    private ProductFacade productFacade = ProductFacade.getInstance();
    private final UserFacade userFacade = UserFacade.getInstanceUserFacade(); //pour avoir accès à l'user connecté

    /**
     * Default constructor
     */
    public ProductPageController() {}

    /**
     * Shows the result of a request (gettProductByName...)
     * Show all the products and their buttons, which enable us to go to the product page
     */
    public void initialize() {
        System.out.println("Initialize ProductPageController");
        ObservableList<Product> listProduct = FXCollections.observableArrayList(Router.getInstance().getParametre());
        //La colonne nameProduct aura la propriété "nameProduct" de l'objet"
        nameProduct.setCellValueFactory(new PropertyValueFactory<>("nameProduct"));

        seller.setCellValueFactory(new PropertyValueFactory<>("pseudoSeller"));
        cityProduct.setCellValueFactory(new PropertyValueFactory<>("city"));

        //Chaque ligne est un nouvel object
        nameProduct.setCellFactory(TextFieldTableCell.forTableColumn());
        cityProduct.setCellFactory(TextFieldTableCell.forTableColumn());

        //Remplis le tableau avec ma liste d'objets
        tableViewProduct.setItems(listProduct);
        //Pour chaque produit ajoute un bouton qui va vers ça page avec ses informations

        System.out.println("Initialize nombre produits "+ listProduct.size());
        if(listProduct.size()!=0){
            addGoToButton();
        }

    }

    /**
     * This method is used for adding a button which goes to product's description page
     */
    private void addGoToButton(){
        System.out.println("add go to button PRoductPageControlelr");
        product.setCellFactory(param -> new TableCell<>(){
            private Button goToButton = new Button("DETAILS");
            {
                goToButton.setOnAction(event -> goToProduct(param.getTableView().getItems().get(getIndex())));
            }

            @Override
            /**
             * Shows the button
             */
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(goToButton);
                }
            }
        });
    }

    private void goToProduct(Product idProduct){
        ArrayList<Product> o = new ArrayList<Product>();
        o.add(idProduct);
        Router.getInstance().activate("DetailsProduct",o);
    }

    @FXML
    private void goHome(ActionEvent e){
        Router.getInstance().activate("HomePage");
    }



}