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
public class RateDAOMySQl extends RateDAO {

    /**
     * Default constructor
     */
    public RateDAOMySQl(Connection connect) {
        super(connect);
    }

    /**
     * @param product 
     * @param consumer 
     * @param rate 
     * @return
     */
    public boolean createRateProduct(Product product, Consumer consumer, int rate) {
        // TODO implement here
        return false;
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
        System.out.println(rate + " " + seller.getLogin() + " " + consumer.getLogin());
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1,rate);
            preparedStatement.setString(2,consumer.getLogin());
            preparedStatement.setString(3,seller.getLogin());
            preparedStatement.setInt(4,0);

            preparedStatement.executeUpdate();


        }catch (SQLIntegrityConstraintViolationException throwables) {
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int rateSeller(Seller seller, Consumer consumer) {

        String requete = "SELECT rate FROM rate where pseudoConsumer = ? AND pseudoSeller = ?";
        System.out.println(requete);

        try {
            Object rate= new Object();
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, consumer.getLogin());
            preparedStatement.setString(2, seller.getLogin());
            ResultSet res = preparedStatement.executeQuery();

            // Recupère résultat et conversion
            res.next();
            rate = res.getObject(1);
            String i = rate.toString();

            //int i = Integer.parseInt(rate);
            return Integer.parseInt(i);
        }
        catch (SQLException throwables) {
            return 0;
        }
    }


}