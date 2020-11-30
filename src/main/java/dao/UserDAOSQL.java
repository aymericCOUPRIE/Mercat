package dao;

import model.User;

/**
 * 
 */
public class UserDAOSQL extends UserDAO {

    /**
     * Default constructor
     */
    public UserDAOSQL() {
    }

    /**
     * @param int id 
     * @return
     */
    public User findUser(int id) {
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