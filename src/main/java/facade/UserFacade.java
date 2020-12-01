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



    /**
     * Default constructor
     */
    public UserFacade() {
    }








    /**
     * @return
     */
    public UserFacade getInstance() {
        // TODO implement here
        return null;
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
     * @param login 
     * @param password 
     * @return
     */
    public boolean login(String login, String password) {
        af = new UserDAO();
        return false;
    }

    /**
     * @return
     */
    public boolean isConnected() {
        // TODO implement here
        return false;
    }

    /**
     * @param login 
     * @param password 
     * @param emailAddress 
     * @param phoneNumber 
     * @param streetAddress 
     * @param city 
     * @param postalCode 
     * @param companyName 
     * @return
     */
    public void signUpSeller(String login, String password, String emailAddress, String phoneNumber, String streetAddress, String city, String postalCode, String companyName) {
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
     * @param User newUser 
     * @return
     */
    public void setConnectedUser(User newUser) {
        // TODO implement here
    }

    /**
     * @return
     */
    public User getConnectedUser() {
        // TODO implement here
        return null;
    }


}