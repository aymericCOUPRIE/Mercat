package dao;

/**
 * 
 */
public abstract class AbstractFactoryDAO {

    /**
     * Default constructor
     */
    public AbstractFactoryDAO() {
    }

    /**
     * @return
     */
    public AbstractFactoryDAO getFactory() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public UserDAO createUserDAO() {
        // TODO implement here
        return null;
    }

}