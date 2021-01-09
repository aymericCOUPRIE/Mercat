package facade;

import dao.abstraction.UserDAO;
import junit.framework.TestCase;
import model.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

public class UserFacadeTest extends TestCase {


    @Mock
    UserDAO mockUserDAO;

    @BeforeEach
    void setUp() {
        UserDAO mockUserDAO = mock(UserDAO.class);
    }

    public void testUpdateConsumer() {
        try (
                MockedStatic<UserDAO> userDAOMockedStatic = mockStatic(UserDAO.class)
        ) {
            User user = new User("Test", "test", "test", "908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==", "test.test@gmail.com", "5 rue", "Montpellier", "44450", null, "consumer", "0202020202");

            when(mockUserDAO.findUser("Test").getPassword()).thenReturn(user.getPassword());
            //when(mockUserDAO.fin)
        }
    }

}