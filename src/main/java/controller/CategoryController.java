package controller;

import facade.CategoryFacade;
import facade.UserFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import model.Category;

import javax.security.auth.Subject;

import javafx.event.ActionEvent;

import java.awt.*;
import java.util.*;

/**
 *
 */
public class CategoryController {

    @FXML
    private TableView<Category> tableViewCategory;

    @FXML
    private TableColumn<Category, Integer> idCat;

    @FXML
    private TableColumn<Category, String> nomCat;

    @FXML
    private TableColumn<Category, Integer> deleteCat;

    @FXML
    private Label labelCategory;

    //private UserFacade userFacade;
    private CategoryFacade categoryFacade = CategoryFacade.getInstance();


    /**
     * Default constructor
     */
    public CategoryController() {
    }


    /**
     * @return
     */
    public void createCategory() {
        // TODO implement here
    }


    /**
     * @return
     */
    public void updateCategory() {
        // TODO implement here
    }

    /**
     *
     */
    public void initialize() {

        ObservableList<Category> listCat = FXCollections.observableArrayList(categoryFacade.getAllCategory());

        for (int i = 0; i < listCat.size(); i++) {

        }

        idCat.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        nomCat.setCellValueFactory(new PropertyValueFactory<>("nameCategory"));

        nomCat.setCellFactory(TextFieldTableCell.forTableColumn());
        tableViewCategory.setItems(listCat);

        nomCat.setOnEditCommit(e -> {
            Category category = e.getTableView().getItems().get(e.getTablePosition().getRow());
            String oldName = category.getNameCategory();
            category.setNameCategory(e.getNewValue());
            categoryFacade.updateCategory(category.getNameCategory(), oldName);
        });

        deleteCat.setCellFactory(param -> new TableCell<>() {
            private final Button deleteSelection = new Button();
            {
                deleteSelection.setOnAction(event -> deleteCategory(event, param.getTableView().getItems().get(getIndex()).getIdCategorie()));
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(deleteSelection);
            }
        });

        tableViewCategory.setEditable(true);
    }

    /**
     * @return
     */
    private void deleteCategory(ActionEvent event, int idCategory) {
        // TODO implement here
        Object tempo = event.getSource();
        System.out.println(tempo.getClass());
    }

}