package dao;

import model.User;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class UserDAO {
    /**
     *
     */
    protected Connection connect = null;

    /**
     * Default constructor
     * @param connect
     */
    public UserDAO(Connection connect) {
        this.connect = connect;
    }




    /**
     * @param id 
     * @return
     */
    public User find(int id) {
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
     * @param login 
     * @param password 
     * @return
     */
    public boolean login(String login, String password) {
        // TODO implement here
        return false;
    }

}