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

public class SellerProductsController {

    @FXML
    private TableView<Product> tableViewProductSeller;
    @FXML
    private TableColumn<Product,String> nameProductSeller;
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

    public SellerProductsController(){}

    public void initialize(){
        this.productArrayList = Router.getInstance().getParametre();

        //On crée une observableList qui contient tous les produits d'un vendeur
        System.out.println("SEllerProductsController pseudo seller" +productArrayList.get(0).getPseudoSeller());
        ObservableList<Product> listProduct = FXCollections.observableArrayList(productFacade.getProductsBySeller(productArrayList.get(0).getPseudoSeller()));

        nameProductSeller.setCellValueFactory(new PropertyValueFactory<>("nameProduct"));
        descriptionProductSeller.setCellValueFactory(new PropertyValueFactory<>("description"));

        nameProductSeller.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionProductSeller.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewProductSeller.setItems(listProduct);

        addModifyButton();


    }

    public void goSellerPage(ActionEvent e){
        System.out.println("goSellerPage "+ this.productArrayList.size());
        Router.getInstance().activate("SellerProfileUI",this.productArrayList);
    }

    private void addModifyButton(){
        modifyProduct.setCellFactory(param -> new TableCell<>(){
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
    private void addDeleteButton(){

    }
    private void goToModifyProduct(Product id){
        ArrayList<Product> o = new ArrayList<Product>();
        o.add(id);
        Router.getInstance().activate("ModifyProduct",o);
    }
}
