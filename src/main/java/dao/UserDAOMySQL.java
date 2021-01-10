package dao;

import dao.abstraction.UserDAO;
import utils.PasswordSecured;
import model.Consumer;
import model.Seller;
import model.User;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class UserDAOMySQL
 * interacts with the DB
 */
public class UserDAOMySQL extends UserDAO {

    /**
     * this methode permit to  connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected UserDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * this method returns a user whose pseudo is passed in parameter
     *
     * @param pseudo of the user we want to find
     * @return User dont le pseudo est passé en paramètres
     */
    public User findUser(String pseudo) {
        User user;
        String requete = "SELECT * FROM user WHERE pseudo = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {

                return instantiateUser(res);

            } else {//il n'y a pas de résultat dans ma requête
                return null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //je n'ai pas pu executer la requête
        return null;
    }


    /**
     * this method makes it possible to check if a user with this username and password exists in the database, and if this is the case to connect to it
     *
     * @param pseudo   of the user
     * @param password of the user
     * @return User who has just connected or null if connection unsuccessful i.e. bad nickname or password
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

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //je n'ai pas pu executer la requête
        //ou mon mot des passe est faux
        return null;
    }

    /**
     * this methode permits to create an instance of the consumer class or the seller class
     *
     * @param res is the result of the SQL request
     * @return user instance create with the informations in res
     * @throws SQLException
     */
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

    //TODO java doc
    public boolean createConsumer(Consumer user) {

        String hashPassword = PasswordSecured.hash(user.getPassword());
        String requete = "INSERT INTO user (pseudo,firstName,lastName, password,emailAddress, streetAddress,city,postalCode, pictureUser, role, phoneNumber) VALUES (?,?,?,?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, user.getPseudo());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, hashPassword);
            preparedStatement.setString(5, user.getEmailAddress());
            preparedStatement.setString(6, user.getStreetAddress());
            preparedStatement.setString(7, user.getCity());
            preparedStatement.setString(8, user.getPostalCode());
            preparedStatement.setString(9, user.getPictureUser());
            preparedStatement.setString(10, user.getRole());
            preparedStatement.setString(11, user.getPhoneNumber());

            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    //TODO java doc
    public boolean createSeller(Seller user) {
        String hashPassword = PasswordSecured.hash(user.getPassword());
        String requete = "INSERT INTO user (pseudo, firstName, lastName, password, emailAddress, streetAddress, city, postalCode, pictureUser, role, phoneNumber, companyName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        //String requete = "INSERT INTO user VALUES ('" + user.getLogin() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + hashPassword + "','" + user.getEmailAddress() + "','" + user.getStreetAddress() + "','" + user.getCity() + "','" + user.getPostalCode() + "','" + user.getPictureUser() + "','" + user.getRole() + "','" + user.getCompanyName() + "')";
        System.out.println(requete);
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, user.getPseudo());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, hashPassword);
            preparedStatement.setString(5, user.getEmailAddress());
            preparedStatement.setString(6, user.getStreetAddress());
            preparedStatement.setString(7, user.getCity());
            preparedStatement.setString(8, user.getPostalCode());
            preparedStatement.setString(9, user.getPictureUser());
            preparedStatement.setString(10, user.getRole());
            preparedStatement.setString(11, user.getPhoneNumber());
            preparedStatement.setString(12, user.getCompanyName());

            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Update the consumer with all new information
     *
     * @param pseudo        of the consumer
     * @param firstName     of the consumer
     * @param lastName      of the consumer
     * @param password      of the consumer
     * @param OldPassword   of the consumer
     * @param emailAdress   of the consumer
     * @param streetAddress of the consumer
     * @param city          of the consumer
     * @param postalCode    of the consumer
     * @param phoneNumber   of the consumer
     * @return true if the consumer has been modified and false if not.
     */
    public boolean updateConsumer(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber) {

        if (!OldPassword.equals(password)) { //j'ai changé de mdp
            password = PasswordSecured.hash(password);
        }

        String requete = " UPDATE user SET firstName = ?,lastName = ? ,password = ?,emailAddress = ?,streetAddress = ?,city = ?,postalCode = ? ,phoneNumber = ?  WHERE pseudo = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, emailAdress);
            preparedStatement.setString(5, streetAddress);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, postalCode);
            preparedStatement.setString(8, phoneNumber);
            preparedStatement.setString(9, pseudo);

            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    //TODO javadoc
    public boolean updateSeller(String pseudo, String firstName, String lastName, String password, String OldPassword, String emailAdress, String streetAddress, String city, String postalCode, String phoneNumber, String company) {

        if (!OldPassword.equals(password)) { //j'ai changé de mdp
            password = PasswordSecured.hash(password);
        }

        String requete = " UPDATE user SET firstName = ?,lastName = ? ,password = ?,emailAddress = ?,streetAddress = ?,city = ?,postalCode = ? ,phoneNumber = ?, companyName = ?  WHERE pseudo = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, emailAdress);
            preparedStatement.setString(5, streetAddress);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, postalCode);
            preparedStatement.setString(8, phoneNumber);
            preparedStatement.setString(9, company);
            preparedStatement.setString(10, pseudo);

            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


    /**
     * this methode permits to delete an user from the database
     *
     * @param pseudo of the user whose account we want to delete
     * @return true if the user has been deleted from the database
     */
    public boolean deleteUser(String pseudo) {
        String requete = "DELETE FROM user WHERE pseudo = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            return preparedStatement.executeUpdate() != 0; //cas où aucune ligne a été modifiée
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * This methode permits to have the pseudo of user according to their past role in parameters
     *
     * @param role of users we want (consumer or seller)
     * @return list of users whose role corresponds to the one passed in parameters
     */
    public ArrayList<String> getAllPseudo(String role) {

        ArrayList<String> listRes = new ArrayList<>();
        String requete = "SELECT pseudo FROM user WHERE role = ? ";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, role);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                listRes.add(res.getString("pseudo"));
            }

            return listRes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //je n'ai pas pu executer la requête
            return null;
        }
    }

    /**
     * this methode permits to know if a consumer exist or not
     *
     * @param pseudo of the user we are looking for
     * @return pseudo of the searched user or an error message if it does not exist or if he is not a consumer.
     */
    public String searchConsumer(String pseudo) {
        String requete = "SELECT pseudo,role FROM user WHERE pseudo =?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            ResultSet res = preparedStatement.executeQuery();
            if (!res.next()) {
                return "User not exist!";
            } else if (!res.getString("role").equals("consumer")) {
                return "This user is not a consumer..";
            } else {
                return pseudo;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //je n'ai pas pu executer la requête
            return null;
        }
    }

    //TODO java doc

    /**
     * Fonction qui retourne le pseudo de l'user recherché ou un message d'erreur si il n'existe pas ou que ce n'est pas un consumer
     *
     * @param pseudo
     * @return String pseudo ou errormsg
     */
    public String searchSeller(String pseudo) {
        String requete = "SELECT pseudo,role FROM user WHERE pseudo =?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            ResultSet res = preparedStatement.executeQuery();
            if (!res.next()) {
                return "User not exist!";
            } else if (!res.getString("role").equals("seller")) {
                return "This user is not a seller..";
            } else {
                return pseudo;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


}

