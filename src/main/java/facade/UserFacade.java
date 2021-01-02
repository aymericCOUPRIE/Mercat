package facade;

import dao.AbstractFactoryDAO;
import dao.UserDAO;
import model.Consumer;
import model.Seller;
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
    private static UserFacade instanceUserFacade = getInstanceUserFacade();

    /**
     * Default constructor du singleton façade
     */
    public UserFacade() {
    }

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
     * @param pseudo
     * @param firstName
     * @param lastName
     * @param password
     * @param emailAdress
     * @param streetAddress
     * @param city
     * @param postalCode
     * @return
     */
    public boolean signUpConsumer(String pseudo, String firstName, String lastName, String password, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber) {
        Consumer userConsumer = new Consumer(pseudo,firstName,lastName,password,emailAdress,streetAddress,city,postalCode,"","", phoneNumber);
        return userDAO.createConsumer(userConsumer);
    }

    /**
     * @param pseudo
     * @param password
     * @return boolean true si connection réussie, false sinon
     */
    public void login(String pseudo, String password) {
        user = userDAO.login(pseudo, password);
        instanceUserFacade.setConnectedUser(user);
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
     * @param emailAdress
     * @param streetAddress
     * @param city
     * @param postalCode
     * @param phoneNumber
     * @param companyName
     * @return
     */
    public boolean signUpSeller(String pseudo, String firstName, String lastName, String password, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber, String companyName) {
        Seller userSeller = new Seller(pseudo,firstName,lastName,password,emailAdress,streetAddress,city,postalCode,"","", phoneNumber, companyName);
        return userDAO.createSeller(userSeller);
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

    /**
     * @return
     */
    public boolean isAdmin() {
        // TODO implement here
        return false;
    }

    /**
     * @param pseudo
     * @return
     */
    public Seller getSellerDetails(String pseudo) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<String> getAllSellersPseudo() {
        // TODO implement here
        return null;
    }

    /**
     * @param pseudo
     * @return
     */
    public void deleteSeller(String pseudo) {
        // TODO implement here
    }

    /**
     * @param pseudo
     * @return
     */
    public Consumer getConsumerDetails(Consumer pseudo ) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<String> getAllConsumerPseudo() {
        // TODO implement here
        return null;
    }

    /**
     * @param consumer
     * @return
     */
    public void deleteConsumer(Consumer consumer) {
        // TODO implement here
    }


}