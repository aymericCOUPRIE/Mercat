package dao.abstraction;

import dao.AbstractFactoryDAO;
import model.Comment;
import model.Consumer;
import model.Product;

import java.sql.Connection;
import java.util.*;

/**
 *
 */
public abstract class CommentDAO {

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

    public static CommentDAO getInstance() {
        if (instanceCommentDAO == null) {
            instanceCommentDAO = AbstractFactoryDAO.getFactory().createCommentDAO();
        }
        return instanceCommentDAO;
    }

    
    /**
     * This method add a comment in the database
     * @param consumer that add the comment
     * @param comment a string with the content of the comment
     * @param id of the product
     */
    public abstract void createComment(Consumer consumer, String comment, int id);

    /**
     * This method update a comment in the database
     * @param consumer that add the comment
     * @param comment a string with the content of the comment
     * @param id of the product
     */
    public abstract void updateComment(Consumer consumer, String comment, int id);

    /**
     * This method get a comment in the database
     * @param consumer that add the comment
     * @param id of the product
     * @return a string with the comment
     */
    public abstract String getComment(Consumer consumer, int id);


    public abstract Set<Comment> getAllComments(Product product);

}