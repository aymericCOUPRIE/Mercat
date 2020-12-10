package dao;

/**
 * 
 */
public abstract class AbstractFactoryDAO {


    /**
     * @return un objet classe interagissant avec la BDD
     */
    public abstract UserDAO createUserDAO();

    /**
     * @return la factory
     */
    public static AbstractFactoryDAO getFactory() {
        return new DAOFactoryMySQL();
    }

}