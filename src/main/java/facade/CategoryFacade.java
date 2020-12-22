package facade;

import dao.AbstractFactoryDAO;
import model.Category;

import javax.sound.sampled.BooleanControl;
import java.util.*;

/**
 * 
 */
public class CategoryFacade {

    private Boolean check;
    /**
     * Default constructor
     */
    public CategoryFacade() {
    }

    /**
     * 
     */
    private Category categoryDAO;

    /**
     * 
     */
    private Category category;

    /**
     * 
     */
    private AbstractFactoryDAO af;




    /**
     * @return
     */
    public CategoryFacade getInstance() {
        // TODO implement here
        return null;
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
        // TODO implement here
    }

    public Boolean isGood(){
        return true;
    }
}