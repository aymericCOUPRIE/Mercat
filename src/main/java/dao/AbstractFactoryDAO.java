package dao;

import dao.abstraction.*;

/**
 * Class AbstractFactoryDAO
 */
public abstract class AbstractFactoryDAO {

    private static AbstractFactoryDAO theFactory;

    /**
     * @return la factory
     */
    public static AbstractFactoryDAO getFactory() {

        if (theFactory == null) {
            theFactory = new DAOFactoryMySQL();
        }
        return theFactory;

    }

    /**
     * Retourne un objet classe interagissant avec la BDD des users
     *
     * @return UserDAO
     */
    public abstract UserDAO createUserDAO();

    /**
     * Retourne un objet classe interagissant avec la BDD au niveau des baskets
     *
     * @return BasketDAO
     */
    public abstract BasketDAO createBasketDAO();


    /**
     * Return an object interacting with the DB for the Rates
     *
     * @return RateDAO
     */
    public abstract RateDAO createRateDAO();

    /**
     * Return an object interacting with the DB for the Comments
     *
     * @return CommentDAO
     */
    public abstract CommentDAO createCommentDAO();

    /**
     * Return an object interacting with the DB for the Orders
     *
     * @return OrderDAO
     */
    public abstract OrderDAO createOrderDAO();

    /**
     * Return an object interacting with the DB for the Products
     *
     * @return ProductDAO
     */
    public abstract ProductDAO createProductDAO();

    /**
     * Return an object interacting with the DB for the Categories
     *
     * @return CategoryDAO
     */
    public abstract CategoryDAO createCategoryDAO();


}