package dao;

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
     * Default constructor
     */
    public RateDAOMySQL(Connection connect) {
        super(connect);
    }


    /**
     * @param product
     * @return
     */
    public Set<Rate> getAllRatesProduct(Product product) {
        // TODO implement here
        return null;
    }

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

    @Override
    public void createRateProduct(Consumer consumer, int rate, int idProduct) {

        String requete = "INSERT INTO rate (rate, pseudoConsumer, pseudoSeller, idProduct) VALUES (?,?,?,?)";
        System.out.println(requete);
        //String requete = "INSERT INTO rate VALUES (2, "stephanie", "azer", 0)";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, rate);
            preparedStatement.setString(2, consumer.getPseudo());
            preparedStatement.setString(3, "s");
            preparedStatement.setInt(4, idProduct);

            preparedStatement.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException throwables) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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


}