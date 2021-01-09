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
     * @param nomCat
     * @return
     */
    protected abstract Category getCategory(String nomCat);


    public static CategoryDAO getInstance() {
        if (instanceCategoryDAO == null) {
            instanceCategoryDAO = AbstractFactoryDAO.getFactory().createCategoryDAO();
        }
        return instanceCategoryDAO;
    }

    /**
     * @return the list of all existing categories, ArrayList<Category>
     */
    public abstract ArrayList<Category> getAllCategory();


    /**
     * @param nomCategory
     */
    public abstract Category createCategory(String nomCategory);


    /**
     * @param newNameCategory
     * @param nameCategory
     */
    public abstract void updateCategory(String newNameCategory, String nameCategory);


    /**
     * @param idCategory
     */
    public abstract void deleteCategory(int idCategory);
}