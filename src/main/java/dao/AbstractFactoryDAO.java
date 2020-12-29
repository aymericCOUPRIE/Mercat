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
     * @return un objet classe interagissant avec la BDD
     */
    public abstract UserDAO createUserDAO();

    /**
     * @return
     */
    public BasketDAO createBasketDAO() {
        // TODO implement here
        return null;
    }


    /**
     * @return
     */
    public abstract RateDAO createRateDAO();

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
        return null;
    }


}