package dao;

/**
 * 
 */
public abstract class AbstractFactoryDAO {

   private static AbstractFactoryDAO theFactory;
    /**
     * @return la factory
     */
    public static AbstractFactoryDAO getFactory() {

        if(theFactory == null){
            theFactory = new DAOFactoryMySQL();
        }
        return theFactory ;

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
    public abstract CategoryDAO createCategoryDAO();


}