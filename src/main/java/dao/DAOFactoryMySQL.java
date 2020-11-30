package dao;

import dao.AbstractFactoryDAO;

import java.sql.Connection;

/**
 * 
 */
public class DAOFactoryMySQL extends AbstractFactoryDAO {

    /**
     * Default constructor
     */
    public DAOFactoryMySQL() {
    }

    /**
     * 
     */
    public Connection connect;



    /**
     * @return
     */
    public UserDAO createUserDAO() {
        // TODO implement here
        return null;
    }

}