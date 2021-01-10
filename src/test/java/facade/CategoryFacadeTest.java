package facade;

import dao.abstraction.CategoryDAO;

import junit.framework.TestCase;
import model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class CategoryFacadeTest extends TestCase {

    @Mock //pour simuler la création des trucs qu'on test pas
    CategoryDAO mockCategoryDao;

    @BeforeEach
    public void setUp() {
        this.mockCategoryDao = mock(CategoryDAO.class);
    }

    @Test
    public void deleteCategory_idCategoryDoesntExist_throwObjectNotFoundException() {
        try(MockedStatic<CategoryDAO> categoryDAOMockedStatic = mockStatic(CategoryDAO.class)) {

            Category category = new Category(100,"Chocolat");


        }
    }



}