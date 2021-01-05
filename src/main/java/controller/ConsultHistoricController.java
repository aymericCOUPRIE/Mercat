package controller;

import facade.OrderFacade;
import facade.UserFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import javafx.util.converter.DateStringConverter;
import model.Order;
import model.Product;

import java.util.*;

import static javafx.scene.paint.Color.rgb;

/**
 *
 */
public class ConsultHistoricController {

    @FXML
    private TableView<Order> tbv_Order;

    @FXML
    private TableColumn<Order, String> tbv_cl_From, tbv_cl_Status;

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


    private OrderFacade orderFacade = OrderFacade.getInstanceOrderFacade();
    private UserFacade userFacade = UserFacade.getInstanceUserFacade();


    /**
     * Called automatically when the page is loaded
     */
    public void initialize() {

        ObservableList<Order> listOrder = FXCollections.observableArrayList(orderFacade.getAllOrders(userFacade.getConnectedUser().getPseudo()));

        tbv_cl_From.setCellValueFactory(new PropertyValueFactory<>("pseudoSeller"));
        tbv_cl_From.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_cl_OrderDate.setCellValueFactory(new PropertyValueFactory<>("dateOrder"));
        tbv_cl_OrderDate.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));

        tbv_cl_Status.setCellValueFactory(new PropertyValueFactory<>("stateOrder"));
        tbv_cl_Status.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_Order.setItems(listOrder);

        addDetailsButton();

    }

    private void addDetailsButton() {
        tbv_cl_Details.setCellFactory(param -> new TableCell<>() {
            private final Button detailsButton = new Button("More details");

            {
                detailsButton.setOnAction(event -> displayDetails(event, param.getTableView().getItems().get(getIndex()), getIndex()));
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


    private void displayDetails(ActionEvent event, Order order, int index) {

        lbl_deliveryAddress.setText(order.getDeliveryAddress());
        lbl_deliveryDate.setText(String.valueOf(order.getDeliveryDate()));

        float total = 0;

        for (Pair<Product, Integer> o : order.getProductsQuantity()) {
            int tempo = o.getValue().intValue();
            float tempo2 = o.getKey().getPriceProduct();
            total += tempo2 * tempo;
        }

        lbl_Total.setText(total + " €");

        ObservableList<Pair<Product, Integer>> listProduct = FXCollections.observableArrayList(order.getProductsQuantity());

        tbv_cl_img.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKey().getPictureProduct()));
        tbv_cl_img.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_cl_productName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKey().getNameProduct()));
        tbv_cl_productName.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_cl_prix.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getKey().getPriceProduct())));
        tbv_cl_prix.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_cl_quantite.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getValue())));
        tbv_cl_quantite.setCellFactory(TextFieldTableCell.forTableColumn());

        tbv_productDetails.setItems(listProduct);

    }


    /**
     * @param order
     * @return
     */
    public void getOrderDetails(Order order) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Set<Order> getAllOrders() {
        // TODO implement here
        return null;
    }

}