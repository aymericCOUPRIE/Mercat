package dao;

import dao.abstraction.BasketDAO;
import model.Basket;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Class BasetDAOMySQL
 * This class interacts with the database
 */
public class BasketDAOMySQL extends BasketDAO {

    /**
     * this methode permit to connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected BasketDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * this method allows to retrieve all the baskets of the consumer whose the pseudo is passed in parameter
     *
     * @param pseudoConsumer to whom the basket belongs
     * @return the list of all the basket of the consumer
     */
    public ArrayList<Basket> getAllBasket(String pseudoConsumer) {

        ArrayList<Basket> allBasket = new ArrayList<Basket>();
        String requete = "SELECT * FROM basket JOIN product ON product.idProduct = basket.idProduct WHERE basket.pseudoConsumer = ? ";

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudoConsumer);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                Basket b = new Basket(
                        res.getInt("quantity"),
                        new Product(res.getInt("idProduct"), res.getString("nameProduct"), res.getString("description"), res.getFloat("priceProduct"), res.getString("pictureProduct"), res.getString("pseudoSeller"), res.getInt("idCategorie")),
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
     * This methode permit to add the product of the current page in the customer's basket
     *
     * @param idProduct of the product we whant to add in the basket
     * @param pseudo    of the logged-in consumer
     * @param quantity  of the product
     * @return boolean true if the product has been added into the basket
     */
    public boolean createBasket(int idProduct, int quantity, String pseudo) {
        // TODO implement here
        String requete = "INSERT INTO basket (quantity, idProduct, pseudoConsumer) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, idProduct);
            preparedStatement.setString(3, pseudo);
            System.out.println("preparestat" + preparedStatement.toString());
            System.out.println("prod" + idProduct + " pseudo " + pseudo + " quantity: " + quantity);

            return preparedStatement.executeUpdate() != 0; //savoir si création a été faite
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    /**
     * This methode permit to delete a basket
     *
     * @param idProduct we want to delete from the basket
     * @param pseudo    of the  logged-in consumer
     * @return boolean true if it's done
     */
    public boolean deleteBasket(int idProduct, String pseudo) {

        String requete = "DELETE FROM basket WHERE idProduct = ? AND pseudoConsumer = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idProduct);
            preparedStatement.setString(2, pseudo);

            return preparedStatement.executeUpdate() != 0; //savoir si suppression a été faite
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * This methode permit to update the quantity of a product in the basket
     *
     * @param pseudo    of the  logged-in consumer
     * @param idProduct for which you want to change the quantity
     * @param quantity  we want to save
     * @return boolean True si le panier a bien été modifié
     */
    public boolean updateBasket(String pseudo, int idProduct, int quantity) {

        String requete = "UPDATE basket SET quantity = ?  WHERE idProduct = ? and pseudoConsumer= ?";

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, idProduct);
            preparedStatement.setString(3, pseudo);

            return preparedStatement.executeUpdate() != 0; //savoir si modif a été faite
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
