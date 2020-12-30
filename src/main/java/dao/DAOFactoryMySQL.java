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
     * Retourne un objet classe interagissant avec la BDD des users
     *
     * @return UserDAO
     */
    public UserDAO createUserDAO() {
        return new UserDAOMySQL(connect);
    }

    /**
     * * Retourne un objet classe interagissant avec la BDD au niveau des baskets
     * @return BasketDAO
     */
    public BasketDAO createBasketDAO() {
       return new BasketDAOMySQL(connect);
    }


    /**
     * @return
     */
    public RateDAO createRateDAO() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public CommentDAO createCommentDAO() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public OrderDAO createOrderDAO() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ProductDAO createProductDAO() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public CategoryDAO createCategoryDAO() {
        // TODO implement here
        return new CategoryDAOMySQL(connect);
    }

}