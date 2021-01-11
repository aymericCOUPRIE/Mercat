package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Comment;
import model.Consumer;
import model.Product;

import java.sql.Connection;
import java.util.*;

/**
 * Class CommentDAO
 */
public abstract class CommentDAO {

    /**
     * connection to the database
     */
    protected Connection connect = null;

    private static CommentDAO instanceCommentDAO;

    /**
     * this methode permit to  connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected CommentDAO(Connection connect) {
        this.connect = connect;
    }


    /**
     * SINGLETON
     * This method create only one instance of the class
     *
     * @return the instance of CommentDAO
     */
    public static CommentDAO getInstance() {
        if (instanceCommentDAO == null) {
            instanceCommentDAO = AbstractFactoryDAO.getFactory().createCommentDAO();
        }
        return instanceCommentDAO;
    }


    /**
     * This method add a comment in the database
     *
     * @param consumer that add the comment
     * @param comment  a string with the content of the comment
     * @param id       of the product
     */
    public abstract void createComment(Consumer consumer, String comment, int id);

    /**
     * This method update a comment in the database
     *
     * @param consumer that add the comment
     * @param comment  a string with the content of the comment
     * @param id       of the product
     */
    public abstract void updateComment(Consumer consumer, String comment, int id);

    /**
     * This method get a comment in the database
     *
     * @param consumer that add the comment
     * @param id       of the product
     * @return a string with the comment
     */
    public abstract String getComment(Consumer consumer, int id);


    /**
     * This methods gets all the comments from a product
     *
     * @param idProduct the product we want all comments from
     * @return the list of all the comments of the product
     */
    public abstract ArrayList<String> getAllComments(int idProduct);

}