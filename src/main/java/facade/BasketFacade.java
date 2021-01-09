package facade;

import dao.AbstractFactoryDAO;
import dao.BasketDAO;
import model.Basket;
import java.util.*;

/**
 * 
 */
public class BasketFacade {

    private final AbstractFactoryDAO af = AbstractFactoryDAO.getFactory();
    private final BasketDAO basketDAO = af.createBasketDAO();
    /**
     * singleton de notre façade
     */
    private  static BasketFacade instanceBasketFacade = getInstanceBasketFacade();

    /**
     * this methode permits to get the instanceBasketFacade and make sure we have only one façade
     * @return instanceBasketFacade
     */
    public static BasketFacade getInstanceBasketFacade() {
        if (instanceBasketFacade == null) {
            instanceBasketFacade = new BasketFacade();
        }
        return instanceBasketFacade;
    }


    /**
     * this method allows to retrieve all the baskets of the connected consumer whose the pseudo is passed in parameter
     * @param pseudo of the the connected consumer
     * @return ArrayList<Basket> that belong to the consumer
     */
    public ArrayList<Basket> getAllBasket(String pseudo) {
        return basketDAO.getAllBasket(pseudo);
    }

    /**
     * This methode permit to update the quantity of a product in the basket
     * @param pseudo of the  logged-in consumer
     * @param idProduct  for which you want to change the quantity
     * @param quantity we want to save
     * @return boolean True si le panier a bien été modifié
     *
     */



    public boolean updateBasket(String pseudo, int idProduct, int quantity) {

       return basketDAO.updateBasket(pseudo,idProduct,quantity);

    }



    /**
     * This methode permit to delete a basket
     * @param idProduct we want to delete from the basket
     * @param pseudo of the  logged-in consumer
     * @return boolean true if it's done
     */

    public boolean deleteBasket(int idProduct, String pseudo) {
        return basketDAO.deleteBasket(idProduct, pseudo);
    }



    /**
     * This methode permit to add the product of the current page in the customer's basket
     * @param idProduct of the product we whant to add in the basket
     * @param pseudo of the logged-in consumer
     * @param quantity of the product
     * @return boolean true if the product has been added into the basket
     */
    public boolean addToBasket(int idProduct, int quantity, String pseudo) {
        return basketDAO.createBasket(idProduct, quantity, pseudo);
    }



}