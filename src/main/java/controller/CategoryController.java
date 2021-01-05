package controller;

import facade.CategoryFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Category;


import javafx.event.ActionEvent;

/**
 *
 */
public class CategoryController {

    @FXML
    private TableView<Category> tableViewCategory;

    @FXML
    private TableColumn<Category, String> nomCat;

    @FXML
    private TableColumn<Category, Integer> deleteCat;

    @FXML
    private TextField newCategoryName;

    @FXML
    private Label creationError;


    //private UserFacade userFacade;
    private CategoryFacade categoryFacade = CategoryFacade.getInstance();


    /**
     * Default constructor
     */
    public CategoryController() {
    }

    /**
     *
     */
    public void initialize() {

        ObservableList<Category> listCat = FXCollections.observableArrayList(categoryFacade.getAllCategory());
        nomCat.setCellValueFactory(new PropertyValueFactory<>("nameCategory"));

        nomCat.setCellFactory(TextFieldTableCell.forTableColumn());
        tableViewCategory.setItems(listCat);

        addDeleteButton();


        //Allows the name to be modified directly in the tableView
        nomCat.setOnEditCommit(e -> {
            Category category = e.getTableView().getItems().get(e.getTablePosition().getRow());
            String oldName = category.getNameCategory();
            category.setNameCategory(e.getNewValue());
            categoryFacade.updateCategory(category.getNameCategory(), oldName);
        });
        tableViewCategory.setEditable(true);
    }

    /**
     * Method for adding delete buttons for each categories in the tableView
     */
    private void addDeleteButton() {
        deleteCat.setCellFactory(param -> new TableCell<>() {
            private final Button deleteSelection = new Button("DELETE");

            {
                deleteSelection.setOnAction(event -> deleteCategory(event, param.getTableView().getItems().get(getIndex()).getIdCategorie(), getIndex()));
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteSelection);
                }
            }
        });
    }

    /**
     * @return
     */
    private void deleteCategory(ActionEvent event, int idCategory, int index) {
        // TODO implement here
        categoryFacade.deleteCategory(idCategory);
        tableViewCategory.getItems().remove(index);
    }

    /**
     * @return
     */
    @FXML
    private void createCategory(ActionEvent event) {
        // TODO implement here
        String categoryName = newCategoryName.getText();
        if (categoryName.isEmpty()) {
            creationError.setText("error");
        } else {
            creationError.setText("Category created");
            Category tempo = categoryFacade.createCategory(categoryName);
            tableViewCategory.getItems().add(tempo);
            tableViewCategory.refresh();
        }
    }
}