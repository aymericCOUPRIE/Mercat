package dao;

import dao.abstraction.RateDAO;
import model.Consumer;
import model.Product;
import model.Rate;
import model.Seller;

import java.sql.*;
import java.util.*;

/**
 *
 */
public class RateDAOMySQL extends RateDAO {

    /**
     * this methode permit to  connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected RateDAOMySQL(Connection connect) {
        super(connect);
    }





    /**
     * This method add a rate for a seller in the database
     * @param seller where we add a rate
     * @param consumer that add the rate
     * @param rate an integer between 1 and 5
     */
    @Override
    public void createRateSeller(Seller seller, Consumer consumer, int rate) {

        String requete = "INSERT INTO rate (rate, pseudoConsumer, pseudoSeller, idProduct) VALUES (?,?,?,?)";
        System.out.println(requete);
        //String requete = "INSERT INTO rate VALUES (2, "stephanie", "azer", 0)";
        System.out.println(rate + " " + seller.getPseudo() + " " + consumer.getPseudo());
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, rate);
            preparedStatement.setString(2, consumer.getPseudo());
            preparedStatement.setString(3, seller.getPseudo());
            preparedStatement.setInt(4, 0);

            preparedStatement.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException throwables) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This method add a rate for a product in the database
     * @param consumer that add the rate
     * @param rate an integer between 1 and 5
     * @param idProduct of the product
     */
    @Override
    public void createRateProduct(Consumer consumer, int rate, int idProduct) {

        String requete = "INSERT INTO rate (rate, pseudoConsumer, pseudoSeller, idProduct) VALUES (?,?,?,?)";
        System.out.println(requete);
        //String requete = "INSERT INTO rate VALUES (2, "stephanie", "azer", 0)";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, rate);
            preparedStatement.setString(2, consumer.getPseudo());
            preparedStatement.setString(3, "Admin");
            preparedStatement.setInt(4, idProduct);

            preparedStatement.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException throwables) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This method get a rate of a seller in the database
     * @param seller where we add a rate
     * @param consumer who add the rate
     * @return the rate put by the consumer, if no notation return 0
     */
    @Override
    public float rateSeller(Seller seller, Consumer consumer) {

        String requete = "SELECT rate FROM rate where pseudoConsumer = ? AND pseudoSeller = ?";
        System.out.println(requete);

        try {
            Object rate = new Object();
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, consumer.getPseudo());
            preparedStatement.setString(2, seller.getPseudo());
            ResultSet res = preparedStatement.executeQuery();

            // Recupère résultat et conversion
            res.next();
            rate = res.getObject(1);
            String i = rate.toString();

            //int i = Integer.parseInt(rate);
            return Integer.parseInt(i);
        } catch (SQLException throwables) {
            return 0;
        }
    }

    /**
     * This method get a rate of a product in the database
     * @param consumer who add the rate
     * @param idProduct of the product
     * @return the rate put by the consumer, if no notation return 0
     */
    @Override
    public float rateProduct(Consumer consumer, int idProduct) {

        String requete = "SELECT rate FROM rate where pseudoConsumer = ? AND idProduct = ?";
        System.out.println(requete);

        try {
            Object rate = new Object();
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, consumer.getPseudo());
            preparedStatement.setInt(2, idProduct);
            ResultSet res = preparedStatement.executeQuery();

            // Recupère résultat et conversion
            res.next();
            rate = res.getObject(1);
            String i = rate.toString();

            //int i = Integer.parseInt(rate);
            return Integer.parseInt(i);
        } catch (SQLException throwables) {
            return 0;
        }
    }

    /**
     * This method get the average rate of all rates of a seller in the database
     * @param seller where we add a rate
     * @return the average rate of a seller, if no notation return 0
     */
    @Override
    public float averageRateSeller(Seller seller) {

        String requete = "SELECT AVG(rate) FROM rate where pseudoSeller = ?";
        System.out.println(requete);

        try {
            Object rate = new Object();
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, seller.getPseudo());
            ResultSet res = preparedStatement.executeQuery();

            // Recupère résultat et conversion

            res.next();
            rate = res.getObject(1);
            if(rate != null) {
                String i = rate.toString();
                return Float.parseFloat(i);
            } else {
                return 0;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public Set<Rate> getAllRatesProduct(Product product) {
        // TODO implement here
        return null;
    }


}