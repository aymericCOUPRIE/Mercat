package dao;

import dataBase.MySQLConnection;
import model.Consumer;
import model.Seller;
import model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class UserDAOMySQL extends UserDAO {

    /**
     * Default constructor
     */
    public UserDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * @param pseudo
     * @return
     */
    public User findUser(String pseudo) {
        // TODO implement here
        return null;
    }

    /**
     * @param user
     * @return
     */
    public boolean createUser(User user) {
        // TODO implement here
        return false;
    }

    /**
     * @param user
     * @return
     */
    public boolean deleteUser(User user) {
        // TODO implement here
        return false;
    }

    /**
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        // TODO implement here
        return false;
    }

    /**
     * @param pseudo
     * @param password
     * @return
     */
    public User login(String pseudo, String password) {
        User user;
        String requete = "SELECT * FROM User WHERE pseudo = '" + pseudo + "' AND password = '" + password + "'";
        try {

            ResultSet res = this.connect.createStatement().executeQuery(requete);

            if(res.next()){

                if(res.getString("role" ).equals("seller")){
                    user = new Seller(
                            res.getString("pseudo"),
                            res.getString("firstName"),
                            res.getString("lastName"),
                            res.getString("password"),
                            res.getString("emailAddress"),
                            res.getString("streetAddress"),
                            res.getString("city"),
                            res.getString("postalCode"),
                            res.getString("pictureUser"),
                            res.getString("role"),
                            res.getString("companyName")
                    );
                }else{
                    user = new Consumer(
                            res.getString("pseudo"),
                            res.getString("firstName"),
                            res.getString("lastName"),
                            res.getString("password"),
                            res.getString("emailAddress"),
                            res.getString("streetAddress"),
                            res.getString("city"),
                            res.getString("postalCode"),
                            res.getString("pictureUser"),
                            res.getString("role")
                    );
                }
                return user;
            }else{//il n'y a pas de résultat dans ma requête
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //je n'ai pas pu executer la requête
        return null;
    }



}

