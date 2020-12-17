package dao;

import java.util.*;

/**
 * 
 */
public class CommentDAO {

    /**
     * Default constructor
     */
    public CommentDAO() {
    }

    /**
     * 
     */
    public Connection connect;


    /**
     * @param product 
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean createComment(product product, consumer consumer, string comment) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean updateComment(product product, consumer consumer, string comment) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @param consumer 
     * @return
     */
    public boolean deleteComment(product product, consumer consumer) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @return
     */
    public Set<Comment> getAllComments(product product) {
        // TODO implement here
        return null;
    }

}