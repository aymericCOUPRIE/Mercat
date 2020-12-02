package dao;

import dataBase.MySQLConnection;

import java.sql.Connection;

/**
 * 
 */
public class DAOFactoryMySQL extends AbstractFactoryDAO {

    //on récupère la connection avec la BDD dans cet attribut qui ne sera jamais modifié
    protected static final Connection connect = MySQLConnection.getInstance();

    /**
     * Default constructor
     */
    public DAOFactoryMySQL() {
    }





    /**
     * Retourne un objet classe interagissant avec la BDD
     * @return UserDAO
     */
    public UserDAO createUserDAO() {
        return new UserDAOMySQL(connect);
    }

}