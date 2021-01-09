package facade;

import dao.abstraction.BasketDAO;
import junit.framework.TestCase;
import model.Basket;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BasketFacadeTest extends TestCase {

    @Mock
    BasketDAO mockBasketDAO;

    @InjectMocks
    BasketFacade basketFacade;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void test_updateBasket() {

        try (
                MockedStatic<BasketDAO> basketDAOMockedStatic = mockStatic(BasketDAO.class)
        ) {
            Product product = new Product(1, "Chocolat", "Au lait", 10.0f, "NULL", "Seller", 1);
            Basket basket = new Basket(10, product, "Consumer");

            when(mockBasketDAO.updateBasket("Chocolat", 1, 100)).thenReturn(true);
            basketDAOMockedStatic.when(BasketDAO::getInstance).thenReturn(mockBasketDAO);

            basketFacade.updateBasket("Chocolat", 1, 100);

            assertEquals(100, basketFacade.getAllBasket("Chocolat").get(0).getQuantity());
        }
    }
}