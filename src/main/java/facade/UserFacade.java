package facade;

import dao.AbstractFactoryDAO;
import dao.UserDAO;
import model.User;

import java.util.*;

/**
 *
 */
public class UserFacade {

    private User user;
    private AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private UserDAO userDAO = af.createUserDAO();


    //notre façade est un singleton
    private static UserFacade instanceUserFacade;

    /**
     * @return instanceUserFacade
     **/

    public static UserFacade getInstanceUserFacade() {
        if (instanceUserFacade == null) {
            instanceUserFacade = new UserFacade();
        }
        return instanceUserFacade;
    }

    /**
     * Default constructor du singleton façade
     */
    public UserFacade() {
    }


    /**
     * @param login
     * @param password
     * @param emailAddress
     * @param phoneNumber
     * @param streetAddress
     * @param city
     * @param postalCode
     * @return
     */
    public void signUpConsumer(String login, String password, String emailAddress, String phoneNumber, String streetAddress, String city, String postalCode) {
        // TODO implement here
    }

    /**
     * @param pseudo
     * @param password
     * @return boolean true si connection réussie, false sinon
     */
    public void login(String pseudo, String password) {
        user = userDAO.login(pseudo, password);
        UserFacade.getInstanceUserFacade().setConnectedUser(user);
    }

    /**
     * @return boolean, true si l'utilisateur est connecté
     */
    public boolean isConnected() {
        return this.user != null;
    }

    /**
     * @param pseudo
     * @param password
     * @param emailAddress
     * @param phoneNumber
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param companyName
     * @return
     */
    public void signUpSeller(String pseudo, String password, String emailAddress, String phoneNumber, String streetAddress, String city, String postalCode, String companyName) {
        // TODO implement here
    }

    /**
     * @param user
     * @return
     */
    public void updateUser(User user) {
        // TODO implement here
    }

    /**
     * @param newUser attribue à la façade le user qui vient de se connecter
     */
    public void setConnectedUser(User newUser) {
        this.user = newUser;
    }

    /**
     * @return User qui est connecté en ce moment
     */
    public User getConnectedUser() {
        return this.user;
    }


}