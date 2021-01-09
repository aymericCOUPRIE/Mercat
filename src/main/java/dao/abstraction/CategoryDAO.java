package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Category;

import java.sql.Connection;
import java.util.*;

public abstract class CategoryDAO {

    protected Connection connect = null;

    private static CategoryDAO instanceCategoryDAO;

    /**
     * Default constructor
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
     * @return the list of all existing categories, ArrayList<Category>
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
     * @param nameCategory    old name of hte category
     */
    public abstract void updateCategory(String newNameCategory, String nameCategory);


    /**
     * This method is used to delete a specific category in the DB
     *
     * @param idCategory id of the category (unique)
     */
    public abstract void deleteCategory(int idCategory);
}