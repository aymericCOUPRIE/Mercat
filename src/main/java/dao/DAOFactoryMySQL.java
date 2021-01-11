package dao;

import dao.abstraction.*;
import dataBase.MySQLConnection;

import java.sql.Connection;

/**
 * Class DAOFactoryMySQL
 */
public class DAOFactoryMySQL extends AbstractFactoryDAO {

    /**
     * on récupère la connection avec la BDD dans cet attribut qui ne sera jamais modifié
     */
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
     * Retourne un objet classe interagissant avec la BDD au niveau des baskets
     *
     * @return BasketDAO
     */
    public BasketDAO createBasketDAO() {
        return new BasketDAOMySQL(connect);
    }


    /**
     * Return an object interacting with the DB for the Rates
     *
     * @return RateDAO
     */
    public RateDAO createRateDAO() {
        return new RateDAOMySQL(connect);
    }

    /**
     * Return an object interacting with the DB for the Comments
     *
     * @return CommentDAO
     */
    public CommentDAO createCommentDAO() {
        return new CommentDAOMySQl(connect);
    }

    /**
     * Return an object interacting with the DB for the Orders
     *
     * @return OrderDAO
     */
    public OrderDAO createOrderDAO() {
        return new OrderDAOMySQL(connect);
    }

    /**
     * Return an object interacting with the DB for the Products
     *
     * @return ProductDAO
     */
    public ProductDAO createProductDAO() {
        return new ProductDAOMySQL(connect);
    }

    /**
     * Return an object interacting with the DB for the Categories
     *
     * @return CategoryDAO
     */
    public CategoryDAO createCategoryDAO() {
        return new CategoryDAOMySQL(connect);
    }

}