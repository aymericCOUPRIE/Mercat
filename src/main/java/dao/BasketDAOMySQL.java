package dao;

import model.Basket;
import model.Product;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class BasketDAOMySQL extends BasketDAO {

    /**
     * Default constructor
     */
    public BasketDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * this method allows to retrieve all the baskets of the consumer whose the pseudo is passed in parameter
     * @param pseudoConsumer
     * @return ArrayList<Basket>
     */
    public ArrayList<Basket> getAllBasket(String pseudoConsumer) {

        ArrayList<Basket> allBasket = new ArrayList<Basket>();
        String requete = "SELECT * FROM basket JOIN product ON product.idProduct = basket.idProduct WHERE basket.pseudoConsumer = ? ";

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudoConsumer);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()){
                Basket b = new Basket(
                        res.getInt("quantity"),
                        new Product(res.getString("nameProduct"), res.getString("description"), res.getFloat("priceProduct"),res.getString("seller"),res.getInt("category")),
                        res.getString("pseudoConsumer")
                );
                allBasket.add(b);

            }

            return allBasket;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    //je n'ai pas pu executer la requête
        return null;
    }

    /**
     * @param basket 
     * @return
     */
    public boolean createBasket(Basket basket) {
        // TODO implement here
        return false;
    }

    /**
     * @param basket 
     * @return
     */
    public boolean deleteBasket(Basket basket) {
        // TODO implement here
        return false;
    }

    /**
     * @param idProduct,quantity
     * @return boolean true si le panier a été modifié
     */
    public boolean updateBasket(int idProduct, int quantity) {
        //TODO
        String requete = "UPDATE Basket SET quantity = 3  WHERE idProduct = 1 and pseudoConsumer=\"Stephanie\"";
        return true;
    }



}