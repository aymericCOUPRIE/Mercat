package facade;

import dao.UserDAO;

import java.util.*;

/**
 * 
 */
public interface Facade<T> {

    /**
     * @return
     */
    public UserDAO getDAO();

    /**
     * @param info 
     * @return
     */
    public void update(ArrayList<String> info);

    /**
     * @param info 
     * @return
     */
    public void addInfo(ArrayList<String> info);

    /**
     * @param id 
     * @return
     */
    public T find(int id);

}