package dao;

import model.Consumer;
import model.Product;
import model.Rate;
import model.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String requete = "INSERT INTO rate (rate, Seller, idProduct, Consumer) VALUES (?,?,?,?)";
        System.out.println(requete);
        //String requete = "INSERT INTO user VALUES ('" + user.getLogin() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + hashPassword + "','" + user.getEmailAddress() + "','" + user.getStreetAddress() + "','" + user.getCity() + "','" + user.getPostalCode() + "','" + user.getPictureUser() + "','" + user.getRole() + "','" + user.getCompanyName() + "')";
        //System.out.println(requete);
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1,rate);
            preparedStatement.setString(2,seller.getLogin());
            preparedStatement.setInt(3,0);
            preparedStatement.setString(4,consumer.getLogin());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}