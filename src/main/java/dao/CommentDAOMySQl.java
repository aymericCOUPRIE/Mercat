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
     * Default constructor
     */
    public CommentDAOMySQl(Connection connect) {
            super(connect);
    }


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

    @Override
    public void createComment(Consumer consumer, String comment, int id){
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

    @Override
    public void updateComment(Consumer consumer, String comment, int id){
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
     * @param product 
     * @param consumer 
     * @return
     */
    public boolean deleteComment(Product product, Consumer consumer) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @return
     */
    public Set<Comment> getAllComments(Product product) {
        // TODO implement here
        return null;
    }

}