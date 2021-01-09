package controller;

import facade.OrderFacade;
import facade.UserFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Pair;
import javafx.util.converter.DateStringConverter;
import model.Order;
import model.Product;
import router.Router;

import java.util.*;


/**
 *
 */
public class ConsultHistoricController {

    @FXML
    private TableView<Order> tbv_Order;

    @FXML
    private TableColumn<Order, String> tbv_cl_Status;

    @FXML
    private TableColumn<Order, Date> tbv_cl_OrderDate;

    @FXML
    private TableColumn<Order, Integer> tbv_cl_Details;

    @FXML
    private Label lbl_deliveryDate, lbl_deliveryAddress, lbl_Total;

    @FXML
    private TableView<Pair<Product, Integer>> tbv_productDetails;

    @FXML
    private TableColumn<Pair<Product, Integer>, String> tbv_cl_img, tbv_cl_productName, tbv_cl_prix, tbv_cl_quantite;

    @FXML
    private TableColumn<Pair<Product, Integer>, Integer> tbv_cl_rate, tbv_cl_comment;

    @FXML
    private Label displayError;

    private final OrderFacade orderFacade = OrderFacade.getInstanceOrderFacade();
    private final UserFacade userFacade = UserFacade.getInstanceUserFacade();


    /**
     * Called automatically when the page is loaded
     * In this initialize all existing orders are displayed
     */
    public void initialize() {

        displayError.setText("");

        List<Order> list = orderFacade.getAllOrders(userFacade.getConnectedUser().getPseudo());
        if (list.isEmpty()) {
            displayError.setText("Vous n'avez aucune commande");
        } else {

            ObservableList<Order> listOrder = FXCollections.observableArrayList(list);

            tbv_cl_OrderDate.setCellValueFactory(new PropertyValueFactory<>("dateOrder"));
            tbv_cl_OrderDate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));

            tbv_cl_Status.setCellValueFactory(new PropertyValueFactory<>("stateOrder"));
            tbv_cl_Status.setCellFactory(TextFieldTableCell.forTableColumn());

            tbv_Order.setItems(listOrder);

            //If the user is a seller then he can change the order state

            if (userFacade.isSeller()) {
                editStateOrder();
                tbv_Order.setEditable(true);
            }

            addDetailsButton();

        }
    }

    private void editStateOrder() {
        tbv_cl_Status.setOnEditCommit(e -> {
            Order order = e.getTableView().getItems().get(e.getTablePosition().getRow());
            String oldState = order.getStateOrder();
            order.setStateOrder(e.getNewValue());

            //En cas d'échec de mise à jour dans la BDD retour en arrière
            if (orderFacade.updateOrderState(order)) {
                order.setStateOrder(oldState);
            }
        });
    }

    /**
     * Adds a button for each order in the tableView
     * This button will allow to display more details for a specific order
     */
    private void addDetailsButton() {
        tbv_cl_Details.setCellFactory(param -> new TableCell<>() {
            private final Button detailsButton = new Button("More details");

            {
                detailsButton.setOnAction(event -> displayDetails(param.getTableView().getItems().get(getIndex())));
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                detailsButton.setStyle("-fx-background-color: rgb(26,82,118)");
                //detailsButton.setTextFill(Color.rgb(255, 255, 255));

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(detailsButton);
                }
            }
        });
    }

    private void addRateButton() {
        tbv_cl_rate.setCellFactory(param -> new TableCell<>() {
            private final Button rateButton = new Button("Rate");

            {
                        rateButton.setOnAction(event -> goToRate(param.getTableView().getItems().get(getIndex()).getKey().getIdProduct()));
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                rateButton.setStyle("-fx-background-color: rgb(26,82,118)");
                //detailsButton.setTextFill(Color.rgb(255, 255, 255));

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(rateButton);
                }
            }
        });
    }

    private void goToRate(int idProduct) {
        Object[] params = new Object[1];
        params[0] = idProduct;
        Router.getInstance().activate("Rate_Product", params);
    }


    private void addCommentButton() {
        tbv_cl_comment.setCellFactory(param -> new TableCell<>() {
            private final Button commentButton = new Button("Comment");

            {
                commentButton.setOnAction(event -> goToComment(param.getTableView().getItems().get(getIndex()).getKey().getIdProduct()));
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                commentButton.setStyle("-fx-background-color: rgb(26,82,118)");
                //detailsButton.setTextFill(Color.rgb(255, 255, 255));

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(commentButton);
                }
            }
        });
    }

    private void goToComment(int idProduct) {
        Object[] params = new Object[1];
        params[0] = idProduct;
        Router.getInstance().activate("Comment_Product", params);
    }

    /**
     * This methods displays more details for a specific order
     * It shows the content (products, prices and more details)
     *
     * @param order The order the user wants to have more details about
     */
    private void displayDetails(Order order) {

        lbl_deliveryAddress.setText(order.getDeliveryAddress());
        lbl_deliveryDate.setText(String.valueOf(order.getDeliveryDate()));

        float total = 0;

        for (Pair<Product, Integer> o : order.getProductsQuantity()) {
            int tempo = o.getValue();
            float tempo2 = o.getKey().getPriceProduct();
            total += tempo2 * tempo;
        }

        lbl_Total.setText(total + " \u20ac");

        ObservableList<Pair<Product, Integer>> listProduct = FXCollections.observableArrayList(order.getProductsQuantity());

        tbv_cl_img.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKey().getPictureProduct()));
        tbv_cl_img.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_cl_productName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKey().getNameProduct()));
        tbv_cl_productName.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_cl_prix.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getKey().getPriceProduct())));
        tbv_cl_prix.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_cl_quantite.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getValue())));
        tbv_cl_quantite.setCellFactory(TextFieldTableCell.forTableColumn());

        if (!userFacade.isSeller()) {
            addRateButton();
            addCommentButton();
        }

        tbv_productDetails.setItems(listProduct);

    }
}