package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Consumer;
import model.Seller;
import model.User;

import java.sql.Connection;
import java.util.*;

/**
 * Abstract class for UserDAO
 */
public abstract class UserDAO {

    /**
     * connection to the database
     */
    protected Connection connect = null;

    private static UserDAO instanceUserDAO;


    /**
     * this methode permit to  connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected UserDAO(Connection connect) {
        this.connect = connect;
    }


    /**
     * SINGLETON
     * This method create only one instance of the class
     *
     * @return the instance of UserDAO
     */
    public static UserDAO getInstance() {
        if (instanceUserDAO == null) {
            instanceUserDAO = AbstractFactoryDAO.getFactory().createUserDAO();
        }
        return instanceUserDAO;
    }


    /**
     * This method is used to delete a user
     *
     * @param pseudo pseudo of the user that will be delete
     * @return true if it succeeded, false if it failed
     */
    public abstract boolean deleteUser(String pseudo);

    /**
     * this method makes it possible to check if a user with this username and password exists in the database, and if this is the case to connect to it
     *
     * @param pseudo   of the user
     * @param password of the user
     * @return User who has just connected or null if connection unsuccessful i.e. bad nickname or password
     */
    public abstract User login(String pseudo, String password);

    /**
     * This method create a consumer in the database
     *
     * @param user to create
     * @return True if register successful or false if error
     */
    public abstract boolean createConsumer(Consumer user);

    /**
     * This method create a seller in the database
     *
     * @param user to create
     * @return True if register successful or false if error
     */
    public abstract boolean createSeller(Seller user);

    /**
     * this method returns a user whose pseudo is passed in parameter
     *
     * @param pseudo of the user we want to find
     * @return User dont le pseudo est passé en paramètres
     */
    public abstract User findUser(String pseudo);


    /**
     * Update the consumer de
     *
     * @param pseudo        of the consumer
     * @param firstName     of the consumer
     * @param lastName      of the consumer
     * @param password      of the consumer
     * @param OldPassword   of the consumer
     * @param emailAdress   of the consumer
     * @param streetAddress of the consumer
     * @param city          of the consumer
     * @param postalCode    of the consumer
     * @param phoneNumber   of the consumer
     * @return true if the consumer has been modified and false if not.
     */
    public abstract boolean updateConsumer(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber);

    /**
     * Update a seller in the database
     *
     * @param pseudo        of the seller
     * @param firstName     of the seller
     * @param lastName      of the seller
     * @param password      of the seller
     * @param OldPassword   of the seller
     * @param emailAdress   of the seller
     * @param streetAddress of the seller
     * @param city          of the seller
     * @param postalCode    of the seller
     * @param phoneNumber   of the seller
     * @param company       of the seller
     * @return true if the seller has been modified and false if not.
     */
    public abstract boolean updateSeller(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber, String company);

    /**
     * This method return a list of users with a specific role
     *
     * @param role of the user
     * @return a Array List of String with all pseudos
     */
    public abstract ArrayList<String> getAllPseudo(String role);

    /**
     * this methode permits to know if a consumer exist or not
     *
     * @param pseudo of the user we are looking for
     * @return pseudo of the searched user or an error message if it does not exist or if he is not a consumer.
     */
    public abstract String searchConsumer(String pseudo);

    /**
     * this methode permits to know if a seller exist or not
     *
     * @param pseudo of the user we are looking for
     * @return pseudo of the searched user or an error message if it does not exist or if he is not a seller.
     */
    public abstract String searchSeller(String pseudo);

}