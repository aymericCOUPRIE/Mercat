package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Basket;

import java.sql.Connection;
import java.util.*;


public abstract class BasketDAO {

    /**
     * connection to the database
     */
    protected Connection connect = null;

    private static BasketDAO instanceBasketDAO;

    /**
     * this methode permit to connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected BasketDAO(Connection connect) {
        this.connect = connect;
    }


    public static BasketDAO getInstance() {
        if (instanceBasketDAO == null) {
            instanceBasketDAO = AbstractFactoryDAO.getFactory().createBasketDAO();
        }
        return instanceBasketDAO;
    }


    /**
     * this method allows to retrieve all the baskets of the consumer whose the pseudo is passed in parameter
     *
     * @param pseudoConsumer to whom the basket belongs
     * @return the list of all the baskets for a consumer
     */
    public abstract ArrayList<Basket> getAllBasket(String pseudoConsumer);

    /**
     * This methode permit to add the product of the current page in the customer's basket
     *
     * @param idProduct of the product we whant to add in the basket
     * @param pseudo    of the logged-in consumer
     * @param quantity  of the product
     * @return boolean true if the product has been added into the basket
     */
    public abstract boolean createBasket(int idProduct, int quantity, String pseudo);


    /**
     * This methode permit to delete a basket
     *
     * @param idProduct we want to delete from the basket
     * @param pseudo    of the  logged-in consumer
     * @return boolean true if it's done
     */
    public abstract boolean deleteBasket(int idProduct, String pseudo);

    /**
     * This methode permit to update the quantity of a product in the basket
     *
     * @param pseudo    of the  logged-in consumer
     * @param idProduct for which you want to change the quantity
     * @param quantity  we want to save
     * @return boolean True si le panier a bien été modifié
     */

    public abstract boolean updateBasket(String pseudo, int idProduct, int quantity);


}