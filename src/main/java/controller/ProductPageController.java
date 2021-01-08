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

    private UserFacade userFacade;
    private ProductFacade productFacade = ProductFacade.getInstance();

    /**
     * Default constructor
     */
    public ProductPageController() {}

    public void initialize() {
        ObservableList<Product> listProduct = FXCollections.observableArrayList(Router.getInstance().getParametre());
        //La colonne nameProduct aura la propriété "nameProduct" de l'objet"
        System.out.println(Router.getInstance().getParametre().get(0).getPseudoSeller());
        nameProduct.setCellValueFactory(new PropertyValueFactory<>("nameProduct"));

        seller.setCellValueFactory(new PropertyValueFactory<>("pseudoSeller"));
        cityProduct.setCellValueFactory(new PropertyValueFactory<>("city"));

        //Chaque ligne est un nouvel object
        nameProduct.setCellFactory(TextFieldTableCell.forTableColumn());
        cityProduct.setCellFactory(TextFieldTableCell.forTableColumn());

        //Remplis le tableau avec ma liste d'objets
        tableViewProduct.setItems(listProduct);
        //Pour chaque produit ajoute un bouton qui va vers ça page avec ses informations

        System.out.println(listProduct.size());
        if(listProduct.size()!=0){
            addGoToButton();
        }

    }

    /**
     * This method is used for adding a button which goes to product's description page
     */
    private void addGoToButton(){

        product.setCellFactory(param -> new TableCell<>(){
            private Button goToButton = new Button("DETAILS");
            {
                ArrayList<Product> p = new ArrayList<Product>();
                System.out.println("Produit "+param.getTableView().getItems());
                //p.add(param.getTableView().getItems().get(getIndex()));
                goToButton.setOnAction(event -> Router.getInstance().activate("DetailsProduct"));
            }

            @Override
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


    @FXML
    private void goHome(ActionEvent e){
        Router.getInstance().activate("AddProduct");
    }


}