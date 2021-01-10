package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Category;

import java.sql.Connection;
import java.util.*;

/**
 * Abstract class CategoryDAO
 */
public abstract class CategoryDAO {

    /**
     * connection to the database
     */
    protected Connection connect = null;

    private static CategoryDAO instanceCategoryDAO;

    /**
     * Contructor with the connection to the DB
     *
     * @param connect connection to the DB
     */
    public CategoryDAO(Connection connect) {
        this.connect = connect;
    }


    /**
     * SINGLETON
     * This method create only one instance of the class
     *
     * @return the instance of CategoryDAO
     */
    public static CategoryDAO getInstance() {
        if (instanceCategoryDAO == null) {
            instanceCategoryDAO = AbstractFactoryDAO.getFactory().createCategoryDAO();
        }
        return instanceCategoryDAO;
    }


    /**
     * This method is used to find a specific category
     *
     * @param nomCat the name of the category
     * @return the category, null if their is no category for the given name
     */
    protected abstract Category getCategory(String nomCat);


    /**
     * This method gathers all the categories existing in the DB
     *
     * @return the list of all existing categories
     * null if their is no category for the given name
     */
    public abstract ArrayList<Category> getAllCategory();


    /**
     * This method create an Object category from a given name
     * by gathering the data in the DB
     *
     * @param nomCategory name of the category
     * @return the category corresponding to the given name,
     * null if the insertion failed
     */
    public abstract Category createCategory(String nomCategory);


    /**
     * This method is used to update the name of a specific category
     *
     * @param newNameCategory new name the category
     * @param idCategory      id of the category
     */
    public abstract void updateCategory(String newNameCategory, int idCategory);


    /**
     * This method is used to delete a specific category in the DB
     *
     * @param idCategory id of the category (unique)
     */
    public abstract void deleteCategory(int idCategory);
}