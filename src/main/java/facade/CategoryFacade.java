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
     * @return instance of CategoryFacade
     */
    public static CategoryFacade getInstance() {
        if (instanceFacade == null) {
            instanceFacade = new CategoryFacade();
        }
        return instanceFacade;
    }

    /**
     * @param nameCategory
     * @return
     */
    public Category createCategory(String nameCategory) {
        return categoryDAO.createCategory(nameCategory);
    }

    /**
     * @param newNameCategory
     * @param nameCategory
     */
    public void updateCategory(String newNameCategory, String nameCategory) {
        categoryDAO.updateCategory(newNameCategory, nameCategory);
    }


    /**
     * @return All categories in database
     */
    public ArrayList<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }


    /**
     * @param idCategory
     */
    public void deleteCategory(int idCategory) {
        categoryDAO.deleteCategory(idCategory);
    }


}