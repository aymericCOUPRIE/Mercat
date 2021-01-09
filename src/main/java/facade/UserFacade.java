package facade;

import dao.AbstractFactoryDAO;
import dao.UserDAO;
import model.Consumer;
import model.Seller;
import model.User;
import router.Router;

import java.util.*;

public class UserFacade {

    private static User user;

    private final AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private final UserDAO userDAO = af.createUserDAO();



    /**
     * the singleton facade
     */
    private static UserFacade instanceUserFacade = getInstanceUserFacade();


    /**
     * this methode permits to get the instanceUserFacade and make sure we have only one facade
     * @return instanceUserFacade
     **/
    public static UserFacade getInstanceUserFacade() {
        if (instanceUserFacade == null) {
            instanceUserFacade = new UserFacade();
        }
        return instanceUserFacade;
    }

    //TODO javadoc
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
        Consumer userConsumer = new Consumer(pseudo, firstName, lastName, password, emailAdress, streetAddress, city, postalCode, "", "consumer", phoneNumber);
        return userDAO.createConsumer(userConsumer);
    }



    /**
     * this method makes it possible to check if a user with this username and password exists in the database, and if this is the case to connect to it
     * @param pseudo of the user
     * @param password of the user
     * @return User who has just connected or null if connection unsuccessful i.e. bad nickname or password
     */
    public void login(String pseudo, String password) {
        user = userDAO.login(pseudo, password);
        instanceUserFacade.setConnectedUser(user);
    }

    /**
     * @return boolean true if the user is logged-in
     */
    public boolean isConnected() {
        return user != null;
    }

    //TODO java doc
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
        Seller userSeller = new Seller(pseudo, firstName, lastName, password, emailAdress, streetAddress, city, postalCode, "", "seller", phoneNumber, companyName);
        return userDAO.createSeller(userSeller);
    }

    /**
     * this methode permits to update a user with all new information
     * @param pseudo of the user
     * @param firstName of the user
     * @param lastName of the user
     * @param password of the user
     * @param OldPassword of the user
     * @param emailAdress of the user
     * @param streetAddress of the user
     * @param city of the user
     * @param postalCode of the user
     * @param phoneNumber of the user
     * @return true if the user has been updated, else false
     */
    public boolean updateConsumer(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber) {

        return userDAO.updateConsumer(pseudo, firstName, lastName, password, OldPassword, emailAdress, streetAddress, city, postalCode, phoneNumber);
    }

    //TODO java doc
    /**
     * @param
     * @return
     */
    public boolean updateUser(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber, String company) {
        return userDAO.updateSeller(pseudo, firstName, lastName, password, OldPassword, emailAdress, streetAddress, city, postalCode, phoneNumber, company);
    }

    /**
     * assigns to the facade the user who has just logged in
     * @param newUser the user who has just logged in
     */
    public void setConnectedUser(User newUser) {
        user = newUser;
    }

    /**
     * this methode permits to have the user curently logged in
     * @return user curently logged in
     */
    public User getConnectedUser() {
        return user;
    }

    /**
     * this method permits to know if the user logged in is an admin
     * @return boolean true if the current user is an admin, else false
     */
    public boolean isAdmin() {
        return getConnectedUser().getRole().equals("admin");
    }

    /**
     * this method permits to know if the user logged in is a seller
     * @return boolean true if the current user is a seller, else false
     */
    public boolean isSeller() {
        return getConnectedUser().getRole().equals("seller");
    }

    /**
     * this methode permits to delete an user from the database
     * @param pseudo of the user whose account we want to delete
     * @return true if the user has been deleted from the database
     */

    public boolean deleteUser(String pseudo) {
        return userDAO.deleteUser(pseudo);
    }


    /**
     * this method is used to get all the information about a consumer
     *
     * @return User
     */
    public User getConsumerDetails() {
        if (isAdmin()) {
            return userDAO.findUser((String) Router.getInstance().getParams()[0]);
        } else {//je suis un consumer
            return getConnectedUser();
        }
    }


    /**
     * This methode permits to have the pseudo of the consumer
     * @return list of consumer
     */
    public ArrayList<String> getAllConsumerPseudo() {
        return userDAO.getAllPseudo("consumer");
    }

    //TODO java doc
    /**
     * @return
     */
    public ArrayList<String> getAllSellersPseudo() {
        return userDAO.getAllPseudo("seller");
    }

    /**
     *   this methode permits to know if a consumer exist or not
     * @param pseudo of the user we are looking for
     * @return  pseudo of the searched user or an error message if it does not exist or if he is not a consumer.
     */
    public String searchConsumer(String pseudo) {
        return userDAO.searchConsumer(pseudo);
    }

    //TODO java doc
    /**
     * Fonction qui retourne le pseudo de l'user recherché ou un message d'erreur si il n'existe pas ou que ce n'est pas un seller
     *
     * @param pseudo
     * @return String pseudo ou errormsg
     */

    public String searchSeller(String pseudo) {
        return userDAO.searchSeller(pseudo);
    }

    /**
     * @return
     */
    public Seller getSellerDetails() {
        if (isAdmin()) {
            return (Seller) userDAO.findUser((String) Router.getInstance().getParams()[0]);
        } else {
            return (Seller) getConnectedUser();
        }
    }


    /**
     * @param pseudo
     * @return seller
     */
    public Seller getSellerDetails(String pseudo) {
        // METTRE get Params comme au dessus qd les branches seront merge
        return (Seller) userDAO.findUser("s");
    }


}