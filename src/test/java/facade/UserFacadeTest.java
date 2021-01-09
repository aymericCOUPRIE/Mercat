package facade;

import dao.abstraction.UserDAO;
import junit.framework.TestCase;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class UserFacadeTest extends TestCase {


    @Mock
    UserDAO mockUserDAO;

    @InjectMocks
    UserFacade userFacade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_validLogin() {

        try (
                MockedStatic<UserDAO> userDAOMockedStatic = mockStatic(UserDAO.class)
        ) {
            User user = new User("test", "test", "test", "908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==", "test.test@gmail.com", "5 rue", "Montpellier", "44450", null, "consumer", "0202020202");
            when(mockUserDAO.login("test", "aaaaaaaa")).thenReturn(user);

            userDAOMockedStatic.when(UserDAO::getInstance).thenReturn(mockUserDAO);

            userFacade.login("test", "aaaaaaaa");

            assertEquals(user.getPseudo(), userFacade.getConnectedUser().getPseudo());
        }
    }

    @Test
    public void test_wrongLogin() {
        try (
                MockedStatic<UserDAO> userDAOMockedStatic = mockStatic(UserDAO.class)
        ) {
            when(mockUserDAO.login("test", "bbbbbbbb")).thenReturn(null);
            userDAOMockedStatic.when(UserDAO::getInstance).thenReturn(mockUserDAO);
            userFacade.login("test", "bbbbbbbb");

            assertNull(userFacade.getConnectedUser());
        }
    }

}