package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Basket;
import model.Product;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.awt.*;
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
   // private Label labelNbProducts, labelTotPrice;
    private TableView tableViewBasket;
    public TableColumn<Basket, String> pictureLabel, productNameLabel;
    public TableColumn<Basket, Integer> quantityLabel, priceLabel;;

    /**
     * this method allows to retrieve all the baskets of the connected consumer
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
     * @return int
     */
    public int getNbItemBasket(){
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
     *
     */
    public void initialize(){
        //TODO

        ObservableList<Basket> listBasket = FXCollections.observableArrayList(getAllBasket());

        //rajouter photo si a le temps


        productNameLabel.setCellValueFactory(new PropertyValueFactory<>("nameProduct"));
        //getNameProduct()

        //STRING
        //quantityLabel.setCellFactory(TextFieldTableCell.forTableColumn());

        quantityLabel.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        //rempli la tableView
        tableViewBasket.setItems(listBasket);



        /*Allows the quantity to be modified directly in the tableView
        quantityLabel.setOnEditCommit(e -> {
            Category category = e.getTableView().getItems().get(e.getTablePosition().getRow());
            String oldName = category.getNameCategory();
            category.setNameCategory(e.getNewValue());
            BasketFacade.updateBasket(category.getNameCategory(), oldName);
        });


        tableViewBasket.setEditable(true);
         */
    }

}