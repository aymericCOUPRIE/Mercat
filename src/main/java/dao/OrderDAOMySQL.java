package dao;

import dao.abstraction.OrderDAO;
import dataBase.listOrderStates;
import javafx.util.Pair;
import model.Basket;
import model.Order;
import model.Product;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 *
 */
public class OrderDAOMySQL extends OrderDAO {

    /**
     * Default constructor
     */
    public OrderDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * @param baskets lists of all the baskets to insert for a specific order
     * @return true if the INSERT is done, false if it failed
     */
    public boolean insertOrder(List<Basket> baskets, String pseudoConsumer) {


        List<Pair<Integer, Integer>> listsIdProduct = new ArrayList<>();
        for (Basket b : baskets) {
            listsIdProduct.add(new Pair<>(b.getProduct().getIdProduct(), b.getQuantity()));
        }

        String requete = "INSERT INTO orderdb (dateOrder, deliveryDate, deliveryAddress, stateOrder, pseudoConsumer) VALUES (?,?,?,?,?)";

        Timestamp date = new Timestamp(System.currentTimeMillis());

        System.out.println("DATE" + date);
        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setTimestamp(1, date);
            preparedStatement.setTimestamp(2, date);
            preparedStatement.setString(3, "seller ou consumer address");
            preparedStatement.setString(4, String.valueOf(listOrderStates.ORDER_CREATED));
            preparedStatement.setString(5, pseudoConsumer);

            int res = preparedStatement.executeUpdate();

            if (res != 0) { //Vérifie que le INSERT order c'est bien passé
                Order tempo = find(pseudoConsumer, date);
                insertAllProducts(tempo.getIdOrder(), listsIdProduct);
                deleteAlBasketAfterInsert(baskets);
            }

            return res == 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    /**
     * @param order The order that will be updated
     * @return true if the update is done, false, if it failed
     */
    public boolean updateOrderState(Order order) {
        String requete = "UPDATE orderdb SET stateOrder = ? WHERE idOrder = ?";

        System.out.println("UPDATE ORDER");

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, order.getStateOrder());
            preparedStatement.setInt(2, order.getIdOrder());
            int res = preparedStatement.executeUpdate();

            System.out.println(res);

            return res == 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    /**
     * @param pseudoConsumer
     * @param dateOrder
     * @return the order
     */
    public Order find(String pseudoConsumer, Date dateOrder) {

        String requete = "SELECT * FROM orderdb WHERE pseudoConsumer = ? AND dateOrder = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudoConsumer);
            preparedStatement.setTimestamp(2, (Timestamp) dateOrder);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                return createOrderObject(res);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    /**
     * @param date
     * @return
     */
    public boolean updateOrderDeliveryDate(Order order, Date date) {
        String requete = "UPDATE orderdb SET deliveryDate = ? WHERE pseudoConsumer = ? AND dateOrder = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setDate(1, (java.sql.Date) order.getDateOrder());
            preparedStatement.setString(2, order.getPseudoConsumer());
            preparedStatement.setDate(3, (java.sql.Date) order.getDateOrder());

            int res = preparedStatement.executeUpdate();

            return res == 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * @param pseudo
     * @return
     */
    @Override
    public ArrayList<Order> getAllOrdersConsumer(String pseudo) {
        String requete = "SELECT * FROM orderdb WHERE pseudoConsumer = ?";


        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudo);
            ResultSet res = preparedStatement.executeQuery();

            ArrayList<Order> listOrders = new ArrayList<>();
            while (res.next()) {
                listOrders.add(createOrderObject(res));
            }

            return listOrders;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    /**
     * @param res
     * @return
     * @throws SQLException
     */
    private Order createOrderObject(ResultSet res) throws SQLException {
        return new Order(
                res.getInt("idOrder"),
                res.getString("pseudoConsumer"),
                res.getDate("dateOrder"),
                res.getString("deliveryAddress"),
                res.getDate("deliveryDate"),
                res.getString("stateOrder"),
                getAllProductsFromOrder(res.getInt("idOrder"))
        );
    }

    /**
     * @param idOrder
     * @param idProducts
     */
    private void insertAllProducts(int idOrder, List<Pair<Integer, Integer>> idProducts) {
        String requete = "INSERT INTO orderlistproduct (idOrder, idProduct, quantity) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idOrder);

            for (Pair<Integer, Integer> i : idProducts) {
                preparedStatement.setInt(2, i.getKey());
                preparedStatement.setInt(3, i.getValue());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * @param idOrder
     * @return
     */
    private List<Pair<Product, Integer>> getAllProductsFromOrder(int idOrder) {
        String requete = "SELECT * FROM orderlistproduct INNER JOIN product ON orderlistproduct.idProduct = product.idProduct WHERE idOrder = ?";

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idOrder);
            ResultSet res = preparedStatement.executeQuery();

            List<Pair<Product, Integer>> products = new ArrayList<>();

            while (res.next()) {
                Product product = new Product(
                        res.getInt("idProduct"),
                        res.getString("nameProduct"),
                        res.getString("description"),
                        res.getFloat("priceProduct"),
                        res.getString("pictureProduct"),
                        res.getString("pseudoSeller"),
                        res.getInt("idCategorie")
                );

                products.add(new Pair<>(product, res.getInt("quantity")));
            }

            return products;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * @param baskets
     */
    private void deleteAlBasketAfterInsert(List<Basket> baskets) {
        String requete = "DELETE FROM basket WHERE idProduct = ? AND pseudoConsumer = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);

            for (Basket basket : baskets) {
                preparedStatement.setInt(1, basket.getProduct().getIdProduct());
                preparedStatement.setString(2, basket.getPseudoConsumer());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}