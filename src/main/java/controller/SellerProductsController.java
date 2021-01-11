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
 * Class SellerProductsController
 */
public class SellerProductsController {

    @FXML
    private TableView<Product> tableViewProductSeller;
    @FXML
    private TableColumn<Product, String> nameProductSeller;
    @FXML
    private TableColumn<Product, String> descriptionProductSeller;
    @FXML
    private TableColumn<Product, Integer> modifyProduct;
    @FXML
    private TableColumn<Product, Integer> deleteProduct;

    private ProductFacade productFacade = ProductFacade.getInstance();
    private final UserFacade userFacade = UserFacade.getInstanceUserFacade(); //pour avoir accès à l'user connecté

    private ArrayList<Product> productArrayList;
    private String seller;

    /**
     * Default constructor
     */
    public SellerProductsController() {
    }


    public void initialize() {
        this.productArrayList = Router.getInstance().getParametre();

        //On crée une observableList qui contient tous les produits d'un vendeur
        System.out.println("SEllerProductsController pseudo seller" + productArrayList.get(0).getPseudoSeller());
        ObservableList<Product> listProduct = FXCollections.observableArrayList(productFacade.getProductsBySeller(productArrayList.get(0).getPseudoSeller()));

        nameProductSeller.setCellValueFactory(new PropertyValueFactory<>("nameProduct"));
        descriptionProductSeller.setCellValueFactory(new PropertyValueFactory<>("description"));

        nameProductSeller.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionProductSeller.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewProductSeller.setItems(listProduct);

        System.out.println(productArrayList.get(0).getPseudoSeller());
        System.out.println(userFacade.getConnectedUser().getPseudo());
        System.out.println(productArrayList.get(0).getPseudoSeller().equals(userFacade.getConnectedUser().getPseudo()));
        if (productArrayList.get(0).getPseudoSeller().equals(userFacade.getConnectedUser().getPseudo())) {//Si l'utilisateur connecté est le vendeur
            addModifyButton();
            addDeleteButton();
        } else {//sinon
            System.out.println("PORUQUOI ???");
            addGoToButton();
        }


    }

    public void goSellerPage(ActionEvent e) {
        System.out.println("goSellerPage " + this.productArrayList.size());
        Router.getInstance().activate("SellerProfileUI", this.productArrayList);
    }

    private void addModifyButton() {
        modifyProduct.setCellFactory(param -> new TableCell<>() {
                    private Button modifyButton = new Button("Modify");

                    {
                        modifyButton.setOnAction(event -> goToModifyProduct(param.getTableView().getItems().get(getIndex())));

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
                            setGraphic(modifyButton);
                        }
                    }
                }

        );
    }

    private void addDeleteButton() {
        deleteProduct.setCellFactory(param -> new TableCell<>() {
                    private Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction(event -> goToDeleteProduct(event, param.getTableView().getItems().get(getIndex()), getIndex()));

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
                            setGraphic(deleteButton);
                        }
                    }
                }

        );
    }

    private void addGoToButton() {
        modifyProduct.setCellFactory(param -> new TableCell<>() {
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

    /**
     * This method is called by modifyButton, it is called when we want to update a product into the database
     *
     * @param id of the product we want to modify
     */
    private void goToModifyProduct(Product id) {
        ArrayList<Product> o = new ArrayList<Product>();
        o.add(id);
        Router.getInstance().activate("ModifyProduct", o);
    }

    /**
     * This method delegates the deletion of the product
     * It also removes the product from the tableView
     *
     * @param e     subject of the action
     * @param p     the product we want to delete
     * @param index row number of the product in the tableView
     */
    private void goToDeleteProduct(ActionEvent e, Product p, int index) {
        System.out.println(productFacade.deleteProduct(p));
        tableViewProductSeller.getItems().remove(index);
    }

    private void goToProduct(Product p) {
        ArrayList<Product> o = new ArrayList<Product>();
        o.add(p);
        Router.getInstance().activate("DetailsProduct", o);
    }
}
