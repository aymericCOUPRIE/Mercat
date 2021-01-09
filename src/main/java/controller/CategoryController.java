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
 * This class handles the category interfaces
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


    private final CategoryFacade categoryFacade = CategoryFacade.getInstance();


    /**
     * Called automatically when the page is loaded
     * This methods fills the list of categories
     */
    public void initialize() {

        //Transforme mon ArrayList d'objet "category" en ObservableList
        ObservableList<Category> listCat = FXCollections.observableArrayList(categoryFacade.getAllCategory());

        //Donne le nom de l'attribut de l'objet que tu veux afficher dans la colonne
        nomCat.setCellValueFactory(new PropertyValueFactory<>("nameCategory"));

        //Dis à ta colonne que chaque ligne c'est un nouvel objet (de ce que j'ai compris)
        nomCat.setCellFactory(TextFieldTableCell.forTableColumn());

        //Remplis ta tableView avec ton Observable list
        tableViewCategory.setItems(listCat);

        //Si tu veu ajouter un bouton pour n'importe quelle action dans ton tableau (pour chaque objet)
        addDeleteButton();


        //Allows the name to be modified directly in the tableView
        nomCat.setOnEditCommit(e -> {
            //Récupère l'objet et l'attribut sur lequel tu as cliqué
            Category category = e.getTableView().getItems().get(e.getTablePosition().getRow());

            //Récupère le nouveau text que tu as saisie
            String oldName = category.getNameCategory();

            //Tu modifies ton objet qui modifie aussi dans le tableau
            category.setNameCategory(e.getNewValue());

            //Mise à jour dans la BDD
            categoryFacade.updateCategory(category.getNameCategory(), category.getIdCategorie());
        });
        //Pour rendre les cases du tableView modiable
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

            /**
             *
             * @param item
             * @param empty
             */
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
     * This method delegate the deletion of the category
     * It also removes the category from the tableView
     *
     * @param event      subject of the action
     * @param idCategory category that will be deleted
     * @param index      row number of the category in the tableView
     */
    private void deleteCategory(ActionEvent event, int idCategory, int index) {
        categoryFacade.deleteCategory(idCategory);
        tableViewCategory.getItems().remove(index);
    }

    /**
     * This method handle the creation of a category
     *
     * @param event subject of the action
     */
    @FXML
    private void createCategory(ActionEvent event) {
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