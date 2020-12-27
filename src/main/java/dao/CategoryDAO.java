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
     * @param id
     * @return
     */
    public abstract Category getCategory(int id);

    /**
     * @return
     */
    public abstract ArrayList<Category> getAllCategory();

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