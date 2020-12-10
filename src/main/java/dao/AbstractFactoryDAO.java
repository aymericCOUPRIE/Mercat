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

   

}