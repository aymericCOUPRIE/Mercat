package dao;

import dataBase.MySQLConnection;
import facade.PasswordSecured;
import model.Consumer;
import model.Seller;
import model.User;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        //String newPassword = PasswordSecured.hash(password);
        String requete = "SELECT * FROM user WHERE pseudo = ? ";

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {

                if (PasswordSecured.isTheSamePassword(password, res.getString("password"))) {
                    if (res.getString("role").equals("seller")) {
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
                    } else { // admin or consumer -> same
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
                }
            } else {//il n'y a pas de résultat dans ma requête
                return null;
            }
        } catch (SQLException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }
        //je n'ai pas pu executer la requête
        //ou mon mot des passe est faux
        return null;
    }


    public boolean createConsumer(Consumer user) {

        String hashPassword = PasswordSecured.hash(user.getPassword());
        //String requete = "INSERT INTO user VALUES ('" + user.getLogin() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + hashPassword + "','" + user.getEmailAddress() + "','" + user.getStreetAddress() + "','" + user.getCity() + "','" + user.getPostalCode() + "','" + user.getPictureUser() + "','" + user.getRole() + "','" + "" + "')";
        String requete = "INSERT INTO user (pseudo,firstName,lastName, password,emailAddress, streetAddress,city,postalCode, pictureUser,role) VALUES (?,?,?,?,?,?,?,?,?,?)";
        System.out.println(requete);


        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,hashPassword);
            preparedStatement.setString(5,user.getEmailAddress());
            preparedStatement.setString(6,user.getStreetAddress());
            preparedStatement.setString(7,user.getCity());
            preparedStatement.setString(8,user.getPostalCode());
            preparedStatement.setString(9,user.getPictureUser());
            preparedStatement.setString(10,user.getRole());
            int res = preparedStatement.executeUpdate();

            if(res!=0){
                return true;
            }else return false;
            //this.connect.createStatement().executeUpdate(requete);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean createSeller(Seller user) {
        String hashPassword = PasswordSecured.hash(user.getPassword());
        String requete = "INSERT INTO user VALUES ('" + user.getLogin() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + hashPassword + "','" + user.getEmailAddress() + "','" + user.getStreetAddress() + "','" + user.getCity() + "','" + user.getPostalCode() + "','" + user.getPictureUser() + "','" + user.getRole() + "','" + user.getCompanyName() + "')";
        System.out.println(requete);
        try {
            this.connect.createStatement().executeUpdate(requete);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


}

