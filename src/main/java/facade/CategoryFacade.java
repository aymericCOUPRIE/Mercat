package facade;

import dao.AbstractFactoryDAO;
import dao.CategoryDAO;
import model.Category;

import java.util.*;

/**
 *
 */
public class CategoryFacade {

    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private CategoryDAO categoryDAO = af.createCategoryDAO();
    private Category category;

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
    public void createCategory(String nameCategory) {
        // TODO implement here
    }

    /**
     * @param newNameCategory
     * @param nameCategory
     * @return
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



}