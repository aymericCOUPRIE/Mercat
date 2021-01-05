package dao;

import model.Consumer;
import model.Seller;
import model.User;

import java.sql.Connection;
import java.util.*;

/**
 *
 */
public abstract class UserDAO {
    /**
     *
     */
    protected Connection connect = null;

    /**
     * Default constructor
     *
     * @param connect
     */
    public UserDAO(Connection connect) {
        this.connect = connect;
    }



    /**
     * this methode permite to delete an user from the database
     * @param pseudo
     * @return true if the user has been deleted from the database
     */
    public abstract boolean deleteUser(String pseudo);



    /**
     * @param pseudo
     * @param password
     * @return User qui vient de se connecter ou null si connection non réussi cad mauvais pseudo ou mdp
     */
    public abstract User login(String pseudo, String password);

    /**
     * @param user
     * @return True si register réussi ou false si erreur
     */
    public abstract boolean createConsumer(Consumer user);


    /**
     * @param user
     * @return True si register réussi ou false si erreur
     */
    public abstract boolean createSeller(Seller user);

    /**
     * @param pseudo
     * @return User dont le pseudo est passé en paramètres
     */
    public abstract User findUser(String pseudo);

    /**
     *
     */
   public abstract boolean updateConsumer(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber);

   public abstract boolean updateSeller(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber, String company);

    /**
     * This methode permite to have the pseudo of user according to their past role in parameters
     * @param role
     * @return ArrayList<String>
     */
    public abstract ArrayList<String> getAllPseudo(String role);
    /**
     * Fonction qui retourne le pseudo de l'user recherché ou un message d'erreur si il n'existe pas ou que ce n'est pas un consumer
     * @param pseudo
     * @return String pseudo ou errormsg
     */
    public abstract String searchConsumer(String pseudo);
    public abstract String searchSeller(String pseudo);

}