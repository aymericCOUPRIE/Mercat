package dao;

import dao.abstraction.CategoryDAO;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Class CategoryDAOMySQL
 */
public class CategoryDAOMySQL extends CategoryDAO {

    /**
     * Default constructor
     *
     * @param connect the connection to the database
     */
    protected CategoryDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * This method is used to find a specific category
     *
     * @param nomCat the name of the category
     * @return the category, null if their is no category for the given name
     */
    public Category getCategory(String nomCat) {
        Category category = null;

        String requete = "SELECT * FROM category WHERE libelleCategorie = ?";

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, nomCat);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                category = new Category(
                        res.getInt("idCategorie"),
                        res.getString("libelleCategorie")
                );
            }
            return category;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * This method gathers all the categories existing in the DB
     *
     * @return the list of all existing categories
     * null if their is no category for the given name
     */
    @Override
    public ArrayList<Category> getAllCategory() {

        ArrayList<Category> listCategory;
        String requete = "SELECT * FROM category ORDER BY libelleCategorie ";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            ResultSet res = preparedStatement.executeQuery();

            listCategory = new ArrayList<>();
            Category category;
            while (res.next()) {
                category = new Category(
                        res.getInt("idCategorie"),
                        res.getString("libelleCategorie")
                );
                listCategory.add(category);
            }

            return listCategory;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * This method create an Object category from a given name
     * by gathering the data in the DB
     *
     * @param nomCategory name of the category
     * @return the category corresponding to the given name,
     * null if the insertion failed
     */
    @Override
    public Category createCategory(String nomCategory) {
        String requete = "INSERT INTO category (idCategorie, libelleCategorie) VALUES (NULL, ?);";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, nomCategory);
            int res = preparedStatement.executeUpdate();

            if (res == 0) {
                return null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return getCategory(nomCategory);
    }

    /**
     * This method is used to update the name of a specific category
     *
     * @param newNameCategory new name the category
     * @param idCategory      old name of hte category
     */
    @Override
    public void updateCategory(String newNameCategory, int idCategory) {
        String requete = "UPDATE category SET libelleCategorie = ? WHERE idCategorie = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, newNameCategory);
            preparedStatement.setInt(2, idCategory);
            int res = preparedStatement.executeUpdate();

            //TODO
            if (res == 0) throw new SQLException("No field where updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * This method is used to delete a specific category in the DB
     *
     * @param idCategory id of the category (unique)
     */
    @Override
    public void deleteCategory(int idCategory) {
        String requete = "DELETE FROM category WHERE idCategorie = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idCategory);
            int res = preparedStatement.executeUpdate();

            //TODO
            if (res == 0) throw new SQLException("No ligne deleted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}