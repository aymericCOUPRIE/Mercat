package dao.abstraction;

import model.Consumer;
import model.Seller;
import model.User;

import java.sql.Connection;
import java.util.*;

public abstract class UserDAO {

    /**
     * connection to the database
     */
    protected Connection connect = null;

    /**
     * this methode permit to  connect the dao with the database
     * @param connect is the connection for the database
     */
    public UserDAO(Connection connect) {
        this.connect = connect;
    }



    public abstract boolean deleteUser(String pseudo);

    /**
     * this method makes it possible to check if a user with this username and password exists in the database, and if this is the case to connect to it
     * @param pseudo of the user
     * @param password of the user
     * @return User who has just connected or null if connection unsuccessful i.e. bad nickname or password
     */
    public abstract User login(String pseudo, String password);

    //TODO javadoc
    /**
     *
     * @param user to create
     * @return True if register successful or false if error
     */
    public abstract boolean createConsumer(Consumer user);

    //TODO javadoc
    /**
     * @param user to crate
     * @return True if register successful or false if error
     */
    public abstract boolean createSeller(Seller user);

    /**
     * this method returns a user whose pseudo is passed in parameter
     * @param pseudo of the user we want to find
     * @return User dont le pseudo est passé en paramètres
     */
    public abstract User findUser(String pseudo);


    /**
     * Update the consumer de
     * @param pseudo of the consumer
     * @param firstName of the consumer
     * @param lastName of the consumer
     * @param password of the consumer
     * @param OldPassword of the consumer
     * @param emailAdress of the consumer
     * @param streetAddress of the consumer
     * @param city of the consumer
     * @param postalCode of the consumer
     * @param phoneNumber of the consumer
     * @return true if the consumer has been modified and false if not.
     */
   public abstract boolean updateConsumer(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber);

   //TODO javadoc
   public abstract boolean updateSeller(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber, String company);


    public abstract ArrayList<String> getAllPseudo(String role);

    /**
     *   this methode permits to know if a consumer exist or not
     * @param pseudo of the user we are looking for
     * @return  pseudo of the searched user or an error message if it does not exist or if he is not a consumer.
     */
    public abstract String searchConsumer(String pseudo);

    //TODO javadoc
    public abstract String searchSeller(String pseudo);

}