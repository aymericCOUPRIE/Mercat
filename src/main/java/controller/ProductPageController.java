package controller;

import facade.CategoryFacade;
import facade.UserFacade;
import facade.ProductFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Product;
import router.Router;

import java.util.*;

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
    private TableColumn<Product, String> product;

    @FXML
    private Button home;

    private UserFacade userFacade;
    private ProductFacade productFacade = ProductFacade.getInstance();

    /**
     * Default constructor
     */
    public ProductPageController() {}

    public void initialize() {
        ObservableList<Product> listProduct = FXCollections.observableArrayList(productFacade.getProducts());
        nameProduct.setCellValueFactory(new PropertyValueFactory<>("nameProduct"));

        nameProduct.setCellFactory(TextFieldTableCell.forTableColumn());
        tableViewProduct.setItems(listProduct);

        addGoToButton();
    }

    /**
     * This method is used for adding a button which goes to product's description page
     */
    private void addGoToButton(){}

    @FXML
    private void goHome(ActionEvent e){
        Router.getInstance().activate("SearchProduct");
    }


}