package dao;

import dao.abstraction.CommentDAO;
import model.Comment;
import model.Consumer;
import model.Product;

import java.sql.*;
import java.util.*;

/**
 *
 */
public class CommentDAOMySQl extends CommentDAO {

    /**
     * this methode permit to connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected CommentDAOMySQl(Connection connect) {
        super(connect);
    }

    /**
     * This method get a comment in the database
     *
     * @param consumer  that add the comment
     * @param idProduct of the product
     * @return a string with the comment
     */
    @Override
    public String getComment(Consumer consumer, int idProduct) {

        String requete = "SELECT ContentComment FROM comment where pseudoConsumer = ? AND idProduct = ?";
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
            String txt = rate.toString();

            //int i = Integer.parseInt(rate);
            return txt;
        } catch (SQLException throwables) {
            return "";
        }
    }

    /**
     * This method add a comment in the database
     *
     * @param consumer that add the comment
     * @param comment  a string with the content of the comment
     * @param id       of the product
     */
    @Override
    public void createComment(Consumer consumer, String comment, int id) {
        String requete = "INSERT INTO comment (ContentComment, pseudoConsumer, idProduct) VALUES (?,?,?)";
        System.out.println(requete);
        //String requete = "INSERT INTO rate VALUES (2, "stephanie", "azer", 0)";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, comment);
            preparedStatement.setString(2, consumer.getPseudo());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException throwables) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This method update a comment in the database
     *
     * @param consumer that add the comment
     * @param comment  a string with the content of the comment
     * @param id       of the product
     */
    @Override
    public void updateComment(Consumer consumer, String comment, int id) {
        String requete = "UPDATE comment SET ContentComment = ? WHERE pseudoConsumer = ? AND idProduct = ?";
        System.out.println(requete);
        //String requete = "INSERT INTO rate VALUES (2, "stephanie", "azer", 0)";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, comment);
            preparedStatement.setString(2, consumer.getPseudo());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException throwables) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This methods gets all the comments from a product
     *
     * @param idProduct the id product we want all comments from
     * @return the list of all the comments of the product
     */
    public ArrayList<String> getAllComments(int idProduct) {

        ArrayList<String> listRes = new ArrayList<>();
        String requete = "SELECT ContentComment FROM comment WHERE idProduct = ? ";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idProduct);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                listRes.add(res.getString("ContentComment"));
            }

            return listRes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}