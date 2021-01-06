package dao;

import model.Comment;
import model.Consumer;
import model.Product;

import java.sql.Connection;
import java.util.*;

/**
 *
 */
public abstract class CommentDAO {

    protected Connection connect;


    /**
     * Default constructor
     */
    public CommentDAO() {
    }

    /**
     * @param product
     * @param consumer
     * @param comment
     * @return
     */
    public abstract boolean createComment(Product product, Consumer consumer, String comment);

    /**
     * @param product
     * @param consumer
     * @param comment
     * @return
     */
    public abstract boolean updateComment(Product product, Consumer consumer, String comment);

    /**
     * @param product
     * @param consumer
     * @return
     */
    public abstract boolean deleteComment(Product product, Consumer consumer);

    /**
     * @param product
     * @return
     */
    public abstract Set<Comment> getAllComments(Product product);

}