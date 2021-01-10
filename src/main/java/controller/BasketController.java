package controller;

import facade.BasketFacade;
import facade.OrderFacade;
import facade.UserFacade;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import model.Basket;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import router.Router;

import java.util.*;

/**
 *
 */
public class BasketController {

    private final BasketFacade basketFacade = BasketFacade.getInstanceBasketFacade();
    private final UserFacade userFacade = UserFacade.getInstanceUserFacade(); //pour avoir accès à l'user connecté
    private final OrderFacade orderFacade = OrderFacade.getInstanceOrderFacade();

    @FXML
    private Label txterror, labelNbProducts, labelTotPrice;

    @FXML
    private TableView tableViewBasket;

    @FXML
    private TableColumn<Basket, String> pictureLabel, productNameLabel;

    @FXML
    private TableColumn<Basket, Integer> quantityLabel, deleteCol;

    @FXML
    private TableColumn<Basket, Float> priceLabel;

    @FXML
    private ToggleGroup selectedAddress;

    /**
     * this method allows to retrieve all the baskets of the connected consumer
     *
     * @return this list of althe baskets from a consumer
     */
    public ArrayList<Basket> getAllBasket() {
        return basketFacade.getAllBasket(userFacade.getConnectedUser().getPseudo());
    }


    /**
     * This methode permit to delete a basket from the dataBase
     * and update the UI : delete the row
     * update the total quantity of product
     * update the total price
     *
     * @param b,index
     */
    private void deleteBasket(Basket b, int index) {
        if (!basketFacade.deleteBasket(b.getProduct().getIdProduct(), userFacade.getConnectedUser().getPseudo())) {
            System.out.println("error delete basket");
        } else {
            tableViewBasket.getItems().remove(index);

            //mettre à jour le nb de produits dans le panier

            int newQtity = Integer.parseInt(labelNbProducts.getText()) - b.getQuantity();
            labelNbProducts.setText(String.valueOf(newQtity));

            //mettre à jour le prix total

            float newTOTprice = Float.parseFloat(labelTotPrice.getText()) - (b.getQuantity() * b.getProduct().getPriceProduct());
            labelTotPrice.setText(String.valueOf(newTOTprice));
        }
    }

    /**
     *
     */
    public void createOrder() {
        String deliveryAddress = ((RadioButton) selectedAddress.getSelectedToggle()).getText();
        System.out.println(deliveryAddress);
        boolean res = orderFacade.insertOrder(getAllBasket(), userFacade.getConnectedUser().getPseudo(), deliveryAddress);
        if (res) {
            Router.getInstance().activate("HomePage");
        } else {
            txterror.setText("Il y a eu une erreur lors de la creation de votre panier");
        }
    }

    /**
     * This metho calculate the total price of all the baskets
     *
     * @return the price (float)
     */
    public float getPrixTotalBasket(ObservableList<Basket> listBasket) {
        float priceTOT = 0;
        for (Basket b : listBasket) {
            priceTOT += b.getQuantity() * b.getProduct().getPriceProduct();
        }
        return priceTOT;
    }


    /**
     * This method to get the number of item in all baskets combined
     *
     * @param listBasket list of all the baskets for a consumer
     * @return the number of product (int)
     */
    public int getNbItemBasket(ObservableList<Basket> listBasket) {
        int cpt = 0;
        for (Basket b : listBasket) {
            cpt += b.getQuantity();
        }
        return cpt;
    }


    /**
     * Add a button delete in the tableView
     */
    private void addButton() {
        deleteCol.setCellFactory(param -> new TableCell<>() {

            private final Button deleteButton = new Button("Delete from basket");

            {
                deleteButton.setOnAction(event -> deleteBasket(param.getTableView().getItems().get(getIndex()), getIndex()));
            }

            //supprimer la ligne du tableau qui correspond au produit qu'on a enlevé du panier
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }

        });
    }

    /**
     * This methode permit to initialize all the informations about the basket of the consumer
     */
    public void initialize() {


        txterror.setText("");
        ObservableList<Basket> listBasket = FXCollections.observableArrayList(getAllBasket());


        //rajouter photo si a le temps
        productNameLabel.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProduct().getNameProduct()));

        quantityLabel.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityLabel.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        priceLabel.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getProduct().getPriceProduct() * data.getValue().getQuantity()));


        //rempli la tableView
        tableViewBasket.setItems(listBasket);


        quantityLabel.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //afficher bouttons delete dans la tableView
        addButton();

        //Allows the quantity to be modified directly in the tableView

        quantityLabel.setOnEditCommit(e -> {
            Basket basket = e.getTableView().getItems().get(e.getTablePosition().getRow());


            if (e.getNewValue() > 0) {
                int oldValue = basket.getQuantity();

                if (!basketFacade.updateBasket(userFacade.getConnectedUser().getPseudo(), basket.getProduct().getIdProduct(), basket.getQuantity())) {
                    System.out.println("error during the update of the quantity..");
                } else {

                    tableViewBasket.refresh();
                    int diff = oldValue - e.getNewValue();

                    //mettre à jour le nb d'item tot dans panier
                    int newQtity = Integer.parseInt(labelNbProducts.getText()) - diff;
                    labelNbProducts.setText(String.valueOf(newQtity));
                    //mettre à jour le prix tot
                    float newTotPrice = Float.parseFloat(labelTotPrice.getText()) - (diff * basket.getProduct().getPriceProduct());
                    labelTotPrice.setText(String.valueOf(newTotPrice));

                    //mettre à jour la ligne dans la tableView
                    basket.setQuantity(e.getNewValue());
                }
            } else {
                txterror.setText("You need to provide a positive quantity !");
            }
        });

        tableViewBasket.setEditable(true);

        labelNbProducts.setText(String.valueOf(getNbItemBasket(listBasket)));

        labelTotPrice.setText(String.valueOf(getPrixTotalBasket(listBasket)));

    }

    /**
     * This method is used to go on the homePage
     */
    public void homePage() {
        Router.getInstance().activate("HomePage");
    }

}