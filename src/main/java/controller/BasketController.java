package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import facade.UserFacade;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import model.Basket;
import model.Product;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.*;

/**
 *
 */
public class BasketController {

    private BasketFacade basketFacade = BasketFacade.getInstanceBasketFacade();

    private OrderFacade orderFacade;

    private UserFacade userFacade = UserFacade.getInstanceUserFacade(); //pour avoir accès à l'user connecté

    /**
     * Default constructor
     */
    public BasketController() {
    }

    @FXML
    private Label txterror; //labelNbProducts, labelTotPrice;

    @FXML
    private TableView tableViewBasket;

    @FXML
    private TableColumn<Basket, String> pictureLabel, productNameLabel;

    @FXML
    private TableColumn<Basket, Integer> quantityLabel;

    @FXML
    private TableColumn<Basket, Float> priceLabel;

    /**
     * this method allows to retrieve all the baskets of the connected consumer
     *
     * @return ArrayList<Basket>
     */
    public ArrayList<Basket> getAllBasket() {
        return basketFacade.getAllBasket(userFacade.getConnectedUser().getPseudo());
    }

    /**
     * @param idProduct
     * @param quantity
     * @return
     */
    public void updateBasket(int idProduct, int quantity) {
        // TODO implement here
    }

    /**
     * @param idProduct
     * @return
     */
    public void deleteBasket(int idProduct) {
        // TODO implement here
    }


    /**
     * @return
     */
    public float getPrixTotalBasket() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * give the total number of item in the basket
     *
     * @return int
     */
    public int getNbItemBasket() {
        //TODO implement here
        //peut se calculer seulement ic
        return 0;
    }

    /**
     * @param baskets
     * @return
     */
    public void createOrder(Set<Basket> baskets) {
        // TODO implement here
    }


    /**
     * This methode permit to initialize all the informations about the basket of the consumer
     */
    public void initialize() {
        ObservableList<Basket> listBasket = FXCollections.observableArrayList(getAllBasket());


        //rajouter photo si a le temps
        productNameLabel.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProduct().getNameProduct()));

        quantityLabel.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityLabel.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceLabel.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getProduct().getPriceProduct() * data.getValue().getQuantity()));


        //rempli la tableView
        tableViewBasket.setItems(listBasket);


        //vérifier que ce soit positif sinon message d'erreur!!

        quantityLabel.setOnEditCommit(e -> {
            Basket basket = e.getTableView().getItems().get(e.getTablePosition().getRow());
            int oldQuantity = basket.getQuantity();
            if (e.getNewValue() > 0) {
                basket.setQuantity(e.getNewValue());
                //BasketFacade.updateBasket(basket.getquantity(), oldQuantity);
                e.getTableView().getItems().get(e.getTablePosition().getRow());
                //e.getTablePosition().getRow()
                tableViewBasket.refresh();
            } else {
                txterror.setText("You need to provide a positive quantity !");
            }
        });



        tableViewBasket.setEditable(true);

    }

}