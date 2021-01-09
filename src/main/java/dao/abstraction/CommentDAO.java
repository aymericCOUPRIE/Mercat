package dao.abstraction;

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

    /**
     * Default constructor
     */
    public CommentDAO(Connection connect) {
        this.connect = connect;
    }

    /**
     * @param consumer
     * @param comment
     * @param id
     * @return
     */
    public abstract void createComment(Consumer consumer, String comment, int id);

    /**
     * @param consumer
     * @param comment
     * @param id
     * @return
     */
    public abstract void updateComment(Consumer consumer, String comment, int id);

    /**
     * @param product
     * @param consumer
     * @return
     */
    public abstract boolean deleteComment(Product product, Consumer consumer);

    /**
     * @param consumer
     * @param id
     * @return String, the comment put by the consumer
     */
    public abstract String getComment(Consumer consumer, int id);

    /**
     * @param product
     * @return
     */
    public abstract Set<Comment> getAllComments(Product product);

}