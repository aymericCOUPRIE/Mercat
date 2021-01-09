package dao.abstraction;

import dao.DAOFactoryMySQL;

/**
 *
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
     * @return un objet classe interagissant avec la BDD au niveau des users
     */
    public abstract UserDAO createUserDAO();

    /**
     * @return un objet classe interagissant avec la BDD au niveau des baskets
     */
    public abstract BasketDAO createBasketDAO();


    /**
     * @return
     */
    public abstract RateDAO createRateDAO();

    /**
     * @return
     */
    public abstract CommentDAO createCommentDAO();

    /**
     * @return
     */
    public abstract OrderDAO createOrderDAO();

    /**
     * @return
     */
    public abstract ProductDAO createProductDAO();

    /**
     * @return
     */
    public abstract CategoryDAO createCategoryDAO();


}