package dao;

import facade.PasswordSecured;
import model.Consumer;
import model.Seller;
import model.User;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

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
        User user;
        String requete = "SELECT * FROM user WHERE pseudo = ?";
        // TODO implement here
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            ResultSet res = preparedStatement.executeQuery();

            if(res!= null){
                return instantiateUser(res);

            }else {//il n'y a pas de résultat dans ma requête
                return null;
            }

        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
        //je n'ai pas pu executer la requête
        return null;
    }



    /**
     * @param pseudo
     * @param password
     * @return
     */
    public User login(String pseudo, String password) {
        User user;
        //String newPassword = PasswordSecured.hash(password);
        String requete = "SELECT * FROM user WHERE pseudo = ?";
        //String requete = "SELECT * FROM user WHERE pseudo = '" + pseudo + "'";

        try {

            //ResultSet res = this.connect.createStatement().executeQuery(requete);

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                if (PasswordSecured.isTheSamePassword(password, res.getString("password"))) {
                    return instantiateUser(res);
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

    private User instantiateUser(ResultSet res) throws SQLException {
        User user;
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
                    res.getString("phoneNumber"),
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
                    res.getString("role"),
                    res.getString("phoneNumber")
            );
        }
        return user;
    }


    public boolean createConsumer(Consumer user) {

        String hashPassword = PasswordSecured.hash(user.getPassword());
        //String requete = "INSERT INTO user VALUES ('" + user.getLogin() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + hashPassword + "','" + user.getEmailAddress() + "','" + user.getStreetAddress() + "','" + user.getCity() + "','" + user.getPostalCode() + "','" + user.getPictureUser() + "','" + user.getRole() + "','" + "" + "')";
        String requete = "INSERT INTO user (pseudo,firstName,lastName, password,emailAddress, streetAddress,city,postalCode, pictureUser, role, phoneNumber) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        //System.out.println(requete);


        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1,user.getPseudo());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,hashPassword);
            preparedStatement.setString(5,user.getEmailAddress());
            preparedStatement.setString(6,user.getStreetAddress());
            preparedStatement.setString(7,user.getCity());
            preparedStatement.setString(8,user.getPostalCode());
            preparedStatement.setString(9,user.getPictureUser());
            preparedStatement.setString(10,user.getRole());
            preparedStatement.setString(11, user.getPhoneNumber());

            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean createSeller(Seller user) {
        String hashPassword = PasswordSecured.hash(user.getPassword());
        String requete = "INSERT INTO user (pseudo, firstName, lastName, password, emailAddress, streetAddress, city, postalCode, pictureUser, role, phoneNumber, companyName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        //String requete = "INSERT INTO user VALUES ('" + user.getLogin() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + hashPassword + "','" + user.getEmailAddress() + "','" + user.getStreetAddress() + "','" + user.getCity() + "','" + user.getPostalCode() + "','" + user.getPictureUser() + "','" + user.getRole() + "','" + user.getCompanyName() + "')";
        //System.out.println(requete);
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1,user.getPseudo());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,hashPassword);
            preparedStatement.setString(5,user.getEmailAddress());
            preparedStatement.setString(6,user.getStreetAddress());
            preparedStatement.setString(7,user.getCity());
            preparedStatement.setString(8,user.getPostalCode());
            preparedStatement.setString(9,user.getPictureUser());
            preparedStatement.setString(10,user.getRole());
            preparedStatement.setString(11, user.getPhoneNumber());
            preparedStatement.setString(12, user.getCompanyName());

            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    /**
     * Update information in the database about a consumer
     * @param pseudo,firstName,lastName,password,OldPassword,emailAdress,streetAddress,city,postalCode,phoneNumber
     * @return
     */
    public boolean updateConsumer(String pseudo,String firstName, String lastName, String password,String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber){

        if(!OldPassword.equals(password)) { //j'ai changé de mdp
            password = PasswordSecured.hash(password);
        }

        String requete =" UPDATE User SET firstName = ?,lastName = ? ,password = ?,emailAddress = ?,streetAddress = ?,city = ?,postalCode = ? ,phoneNumber = ?  WHERE pseudo = ?";
         try{
             PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
             preparedStatement.setString(1,firstName);
             preparedStatement.setString(2,lastName);
             preparedStatement.setString(3,password);
             preparedStatement.setString(4,emailAdress);
             preparedStatement.setString(5,streetAddress);
             preparedStatement.setString(6,city);
             preparedStatement.setString(7,postalCode);
             preparedStatement.setString(8,phoneNumber);
             preparedStatement.setString(9,pseudo);

             return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
         }catch (SQLException throwables) {
             throwables.printStackTrace();
             return false;
         }
    }

    /**
     * @param pseudo
     * @return true if the user has been deleted successfully
     */
    public boolean deleteUser(String pseudo) {
        String requete = "DELETE FROM User WHERE pseudo = ?";

        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1,pseudo);
            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * @return
     */
    public Set<String> getAllSellersPseudo() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<String> getAllConsumer() {
        // TODO implement here
        return null;
    }

}

