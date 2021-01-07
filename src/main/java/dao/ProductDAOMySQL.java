package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class ProductDAOMySQL extends ProductDAO {

    /**
     * Default constructor
     */
    public ProductDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * @param idProduct
     * @return
     */
    public Product getProduct(int idProduct) {
        // TODO implement here
        return null;
    }

    /**
     * @param nameP
     * @return an ArrayList of products, all of them have the same name
     */
    public ArrayList<Product> getProductsByName(String nameP) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product WHERE nameProduct = ? ORDER BY nameProduct ASC";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, nameP);
            return getProductList(listProduct, preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * @param name
     * @param city
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCity(String name, String city) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product WHERE nameProduct = ? AND city = ? ORDER BY nameProduct ASC";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, city);
            return getProductList(listProduct, preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * @param name
     * @param category
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCategory(String name, String category) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product WHERE nameProduct = ? AND idCategorie = ? ORDER BY nameProduct ASC";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, name);
            int id = getCategoryId(category);
            preparedStatement.setInt(2, id);
            return getProductList(listProduct, preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private ArrayList<Product> getProductList(ArrayList<Product> listProduct, PreparedStatement preparedStatement) throws SQLException {
        ResultSet res = preparedStatement.executeQuery();
        Product product;
        while (res.next()) {
            String nomSeller = res.getString("pseudoSeller");
            String libCategorie = getCategoryLibelle(res.getInt("idCategorie"));
            product = new Product(
                    res.getString("nameProduct"),
                    res.getString("description"),
                    res.getFloat("priceProduct"),
                    nomSeller,
                    getProductCity("pseudoSeller"),
                    libCategorie
            );
            System.out.println(product.getNameProduct());
            listProduct.add(product);
        }
        return listProduct;
    }

    /**
     * @param name
     * @param city
     * @param idCategory
     * @return
     */
    public ArrayList<Product> getProductsByNameAndCityAndCategory(String name, String city, String idCategory) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product WHERE nameProduct = ? AND idCategorie = ? ORDER BY nameProduct ASC";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, name);
            int id = getCategoryId(idCategory);
            preparedStatement.setInt(2, id);
            return getProductList(listProduct, preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createProduct(Product product) {
        //TODO Demander si cela marche
        //System.out.println("FIRST "+product.getDescription());
        String requete = "INSERT INTO product (nameProduct,priceProduct,pictureProduct,pseudoSeller,idCategorie,description) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, "" + product.getPriceProduct());
            preparedStatement.setString(3,"");
            //System.out.println(product.getNameProduct());
            preparedStatement.setString(4, product.getPseudoSeller());
            //TODO voir si on ne change pas l'id pour le nom de la catégorie
            preparedStatement.setInt(5, product.getIdCategorie());
            preparedStatement.setString(6,product.getDescription());
            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product p, String newDescription) {
        int id = getProductId(p);
        String requete = "UPDATE product SET description = ? WHERE idProduct = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, newDescription);
            preparedStatement.setString(2, "" + id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    @Override
    public int getProductId(Product p) {
        String requete = "SELECT idProduct FROM product WHERE nameProduct=? AND description=? AND price=? AND seller=? AND category=?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, p.getNameProduct());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setString(3, "" + p.getPriceProduct());
            preparedStatement.setString(4, p.getPseudoSeller());
            //TODO ERREUR ERROR modif pour passer du nom à un int
            preparedStatement.setString(5, String.valueOf(p.getIdCategorie()));

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idProduct");
            }
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteProduct(Product p) {
        int id = getProductId(p);
        String requete = "DELETE FROM product WHERE idProduct=?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, "" + id);

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    private String getProductCity(String seller) {
        String requete = "SELECT city FROM user WHERE pseudo = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, seller);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("city");
            }
            return "-1";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "-1";
        }
    }

    private String getCategoryLibelle(int id){
        String requete = "SELECT LibelleCategorie FROM category WHERE idCategorie = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("LibelleCategorie");
            }
            return "-1";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "-1";
        }
    }

    private int getCategoryId(String c) {
        String requete = "SELECT idCategorie FROM categorie WHERE LibelleCategorie = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, c);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt("idCategorie");
            }
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

}