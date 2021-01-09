package dao;

import dao.abstraction.*;
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
    protected DAOFactoryMySQL() {
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
     *
     * @return BasketDAO
     */
    public BasketDAO createBasketDAO() {
        return new BasketDAOMySQL(connect);
    }


    /**
     * @return
     */
    public RateDAO createRateDAO() {
        return new RateDAOMySQL(connect);
    }

    /**
     * @return
     */
    public CommentDAO createCommentDAO() {return new CommentDAOMySQl(connect); }

    /**
     * @return
     */
    public OrderDAO createOrderDAO() {
        return new OrderDAOMySQL(connect);
    }

    /**
     * @return
     */
    public ProductDAO createProductDAO() {
        return new ProductDAOMySQL(connect);
    }

    /**
     * @return
     */
    public CategoryDAO createCategoryDAO() {
        return new CategoryDAOMySQL(connect);
    }

}