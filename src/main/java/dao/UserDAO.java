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
     * @param pseudo
     * @return
     */
    public User find(int pseudo) {
        // TODO implement here
        return null;
    }

    /**
     * @param user
     * @return
     */
    public boolean createUser(User user) {
        // TODO implement here
        return false;
    }

    /**
     * @param user
     * @return
     */
    public boolean deleteUser(User user) {
        // TODO implement here
        return false;
    }

    /**
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        // TODO implement here
        return false;
    }

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
     * @return
     */
    public User find(String pseudo) {
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
     * @return
     */
    public Set<String> getAllConsumer() {
        // TODO implement here
        return null;
    }

}