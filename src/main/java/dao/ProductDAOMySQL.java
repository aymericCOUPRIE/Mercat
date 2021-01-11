package dao;

import dao.abstraction.ProductDAO;
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
     * @param connect of Connection
     */
    protected ProductDAOMySQL(Connection connect) {
        super(connect);
    }



    /**
     * @param nameP , the name of the product we want to find
     * @return an ArrayList of products, all of them have the same name
     */
    @Override
    public ArrayList<Product> getProductsByName(String nameP) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product WHERE nameProduct = ? ";
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
     * This method returns all the products who have the same city and name
     * @param name of the product we want to find
     * @param city of the product we want to find
     * @return a list of all the products from a city
     */
    @Override
    public ArrayList<Product> getProductsByNameAndCity(String name, String city) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product as p,user as u WHERE nameProduct=? AND p.pseudoSeller=u.pseudo AND u.city =?";
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
     * This method returns all the products who have the same name and in the same category
     * @param name     of the product we want to find
     * @param category of the product we want to find
     * @return a list of all the products from a specific category
     */
    @Override
    public ArrayList<Product> getProductsByNameAndCategory(String name, String category) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product WHERE nameProduct = ? AND idCategorie=? ORDER BY nameProduct ASC";
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

    /**
     * this method executes the query, and for each result of the query,
     * creates the corresponding product, which is add in the ArrayList of Products
     * @param listProduct, where we add the product found
     * @param preparedStatement the query, created to search the products
     * @return an ArrayList of Product, all the products we found with the query
     *
     */
    private ArrayList<Product> getProductList(ArrayList<Product> listProduct, PreparedStatement preparedStatement) throws SQLException {
        ResultSet res = preparedStatement.executeQuery();
        Product product;
        while (res.next()) {
            String nomSeller = res.getString("pseudoSeller");
            String libCategorie = getCategoryLibelle(res.getInt("idCategorie"));
            product = new Product(
                    res.getInt("idProduct"),
                    res.getString("nameProduct"),
                    res.getString("description"),
                    res.getFloat("priceProduct"),
                    "",
                    nomSeller,
                    getProductCity(res.getString("pseudoSeller")),
                    res.getInt("idCategorie"),
                    libCategorie
            );
            listProduct.add(product);
        }
        return listProduct;
    }

    /**
     * This method returns all the products who have the same the name, city and category
     * @param name     of the product we want to find
     * @param city     of the product we want to find
     * @param idCategory of the product we want to find
     * @return a list a of product from a specific name, city and category
     */
    @Override
    public ArrayList<Product> getProductsByNameAndCityAndCategory(String name, String city, String idCategory) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product as p,user as u WHERE nameProduct = ? AND idCategorie = ? AND p.pseudoSeller=u.pseudo AND u.city =? ";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, name);
            int id = getCategoryId(idCategory);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3,city);
            return getProductList(listProduct, preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    /**
     * This method enables the seller to add a product into the database
     *
     *@param product le produit we want to add
     *@return true if this method succeded to add this product
     */
    @Override
    public boolean createProduct(Product product) {
        String requete = "INSERT INTO product (nameProduct,priceProduct,pictureProduct,pseudoSeller,idCategorie,description) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, "" + product.getPriceProduct());
            preparedStatement.setString(3,"");
            preparedStatement.setString(4, product.getPseudoSeller());
            //TODO voir si on ne change pas l'id pour le nom de la catégorie
            System.out.println(getCategoryId(product.getCategory()));
            preparedStatement.setInt(5, getCategoryId(product.getCategory()));
            preparedStatement.setString(6,product.getDescription());
            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


    /**
     * this method updates a given product into the database
     * @param p, the Product we want to update
     * @return true if the product was updated into the database
     */
    @Override
    public boolean updateProduct(Product p) {
        String requete = "UPDATE product SET nameProduct = ?, priceProduct = ?,idCategorie = ?, description = ? WHERE idProduct = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, p.getNameProduct());
            preparedStatement.setString(2, "" + p.getPriceProduct());
            preparedStatement.setInt(3,p.getIdCategorie());
            preparedStatement.setString(4,p.getDescription());
            preparedStatement.setInt(5,p.getIdProduct());

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }


    /**
     * When called this method returns the id of a given product
     * @param p, the product whose id we want
     * @return the id of the product
     */
    @Override
    public int getProductId(Product p) {
        String requete = "SELECT idProduct FROM product WHERE nameProduct=? AND description=? AND priceProduct=? AND pseudoSeller=?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, p.getNameProduct());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setString(3, "" + p.getPriceProduct());
            preparedStatement.setString(4, p.getPseudoSeller());
            //TODO ERREUR ERROR modif pour passer du nom à un int
            //preparedStatement.setString(5, String.valueOf(p.getIdCategorie()));

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


    /**
     * This method deletes a given product of the database
     * @param p, the Product that we want to delete
     * @return true if the product was deleted
     */
    @Override
    public boolean deleteProduct(Product p) {
        System.out.println("id produit a detruire :"+p.getIdProduct());
        String requete = "DELETE FROM product WHERE idProduct=?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, p.getIdProduct());

            return preparedStatement.executeUpdate() != 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * @param seller, the seller's product name
     * @return the name of the seller
     */
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

    /**
     * @param id of the category
     * @return the libelle of the caegory, which id is in parameterD
     */
    @Override
    public String getCategoryLibelle(int id){
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

    /**
     * This method returns the id of category given her libelleCategorie
     * @param c which reprensents the libelle of the category
     * @return the id of the category
     */
    @Override
    public int getCategoryId(String c) {
        String requete = "SELECT idCategorie FROM category WHERE LibelleCategorie = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, c);
            System.out.println("C : "+c);
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


    /**
     * @return une arrayList de tous les produits présents dans la db
     */
    @Override
    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            return getProductList(listProduct, preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    /**
     * This method returns all the seller's product
     * @param seller whose products we want to get
     * @return all the products he has
     */
    @Override
    public ArrayList<Product> getProductsBySeller(String seller){
        ArrayList<Product> listProduct = new ArrayList<Product>();
        String requete = "SELECT * FROM product WHERE pseudoSeller = ?";
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1,seller);
            return getProductList(listProduct,preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }




}