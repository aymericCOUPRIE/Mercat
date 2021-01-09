package facade;

import dao.AbstractFactoryDAO;
import dao.abstraction.CategoryDAO;
import model.Category;

import java.util.*;

/**
 *
 */
public class CategoryFacade {

    private final CategoryDAO categoryDAO = CategoryDAO.getInstance();

    private static CategoryFacade instanceFacade;

    /**
     * Default constructor
     */
    private CategoryFacade() {
    }


    /**
     * SINGLETON
     * This method create only one instance of the class
     *
     * @return the instance of CategoryFacade
     */
    public static CategoryFacade getInstance() {
        if (instanceFacade == null) {
            instanceFacade = new CategoryFacade();
        }
        return instanceFacade;
    }

    /**
     * This method is used to insert a Category into the DB
     *
     * @param nameCategory name of the category inserted
     * @return the obect category that has been inserted in the DB
     */
    public Category createCategory(String nameCategory) {
        return categoryDAO.createCategory(nameCategory);
    }

    /**
     * This method is used to update the name of the category
     *
     * @param newNameCategory the new name of the category
     * @param idCategory      the id of updated category in order to find it in the DB
     */
    public void updateCategory(String newNameCategory, int idCategory) {
        categoryDAO.updateCategory(newNameCategory, idCategory);
    }


    /**
     * This method is used to get all the existing categories
     *
     * @return the list of the categories
     */
    public ArrayList<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }


    /**
     * This method is used to delete a given category
     *
     * @param idCategory id in the DB of category that will be deleted
     */
    public void deleteCategory(int idCategory) {
        categoryDAO.deleteCategory(idCategory);
    }


}