package dao;

import model.Category;

import java.sql.Connection;
import java.util.*;

public abstract class CategoryDAO {

    protected Connection connect = null;

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
    public abstract Category getCategory(String nomCat);

    /**
     * @return the list of all existing categories
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