package dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 */
public class CategoryDAOMySQL extends CategoryDAO {

    /**
     * Default constructor
     */
    public CategoryDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * @param idCat
     * @return
     */
    public Category getCategory(int idCat) {
        Category category = null;

        String requete = "SELECT libelleCategory FROM category WHERE idCategory = ?";

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, String.valueOf(idCat));
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
     * @return
     */
    public ArrayList<Category> getAllCategory() {
        // TODO implement here
        ArrayList<Category> listCategory;
        String requete = "SELECT * FROM category";

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

    @Override
    public void updateCategory(String newNameCategory, String nameCategory) {
        String requete = "UPDATE category SET libelleCategorie = ? WHERE libelleCategorie = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, newNameCategory);
            preparedStatement.setString(2, nameCategory);
            int res = preparedStatement.executeUpdate();

            //TODO
            if (res == 0) throw new SQLException("No field where updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void deleteCategory(int idCategory) {
        String requete = "DELETE FROM category WHERE idCategorie = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idCategory);
            int res = preparedStatement.executeUpdate();

            //TODO
            if (res == 0 ) throw new SQLException("No ligne deleted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}