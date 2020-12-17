package dao;

import model.Comment;
import model.Consumer;
import model.Product;

import java.util.*;

/**
 * 
 */
public class CommentDAOMySQl extends CommentDAO {

    /**
     * Default constructor
     */
    public CommentDAOMySQl() {
    }

    /**
     * @param product 
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean createComment(Product product, Consumer consumer, String comment) {
        // TODO implement here
        return false;
    }

    /**
     * @param product 
     * @param consumer 
     * @param comment 
     * @return
     */
    public boolean updateComment(Product product, Consumer consumer, String comment) {
        // TODO implement here
        return false;
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