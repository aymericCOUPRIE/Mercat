package dao;

import javafx.util.Pair;
import model.Basket;
import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
     * @param baskets
     * @return
     */
    public boolean insertOrder(List<Basket> baskets) {


        List<Pair<Integer, Integer>> listsIdProduct = new ArrayList<>();
        for (Basket b : baskets) {
            listsIdProduct.add(new Pair(b.getProduct().getIdProduct(), b.getQuantity()));
        }

        String requete = "INSERT INTO order_ok (pseudoConsumer, pseudoSeller, dateOrder, deliveryAddress, deliveryDate, quantity, stateOrder) VALUES (?,?,?,?,NOW(),?,?)";

        String pseudoConsumer = baskets.get(0).getPseudoConsumer();
        String pseudoSeller = "JE SAIS PAS COMMENT L'AVOIR";
        float quantity = baskets.get(0).getQuantity();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());


        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudoConsumer);
            preparedStatement.setString(2, pseudoSeller);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, "inutileCarOnADejaIDConsumer");
            preparedStatement.setString(6, "Beginning");

            int res = preparedStatement.executeUpdate();

            if (res != 0) { //Vérifie que le INSERT order c'est bien passé
                Order tempo = find(pseudoConsumer, pseudoSeller, date);
                insertAllProducts(tempo.getIdOrder(), listsIdProduct);
            }

            return res == 0 ? false : true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    /**
     * @param order, state
     * @return
     */
    public boolean updateOrderState(Order order, String state) {
        String requete = "UPDATE order SET stateOrder = ? WHERE pseudoConsumer = ? AND pseudoSeller = ? AND dateOrder = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, state);
            preparedStatement.setString(2, order.getPseudoConsumer());
            preparedStatement.setString(3, order.getPseudoSeller());
            preparedStatement.setDate(4, (java.sql.Date) order.getDateOrder());
            int res = preparedStatement.executeUpdate();

            return res == 0 ? false : true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    /**
     * @param pseudoConsumer
     * @param pseudoSeller
     * @param dateOrder
     * @return an Order
     */
    public Order find(String pseudoConsumer, String pseudoSeller, Date dateOrder) {

        String requete = "SELECT * FROM order WHERE pseudoConsumer = ? AND pseudoSeller = ? AND dateOrder = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, pseudoConsumer);
            preparedStatement.setString(2, pseudoSeller);
            preparedStatement.setDate(3, (java.sql.Date) dateOrder);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                Order order = createOrderObject(res);
                return order;
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
        String requete = "UPDATE order SET deliveryDate = ? WHERE pseudoConsumer = ? AND pseudoSeller = ? AND dateOrder = ?";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, order.getPseudoConsumer());
            preparedStatement.setString(2, order.getPseudoSeller());
            preparedStatement.setDate(3, (java.sql.Date) order.getDateOrder());

            int res = preparedStatement.executeUpdate();

            return res == 0 ? false : true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Order> getAllOrdersConsumer(String pseudo) {
        String requete = "SELECT * FROM order WHERE pseudoConsumer = ?";
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


    private Order createOrderObject(ResultSet res) throws SQLException {
        Order order = new Order(
                res.getInt("idOrder"),
                res.getString("pseudoConsumer"),
                res.getString("pseudoSeller"),
                res.getDate("dateOrder"),
                res.getString("deliveryAddress"),
                res.getDate("deliveryDate"),
                //res.getFloat("quantity"),
                res.getString("stateOrder"),
                getAllProductsFromOrder(res.getInt("idOrder"))
        );
        return order;
    }

    private boolean insertAllProducts(int idOrder, List<Pair<Integer, Integer>> idProducts) {
        String requete = "INSERT INTO orderlistproduct (idOrder, idProduct, quantity) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idOrder);

            boolean res = true;
            for (Pair<Integer, Integer> i : idProducts) {
                preparedStatement.setInt(2, i.getKey());
                preparedStatement.setInt(3, i.getValue());

                if (preparedStatement.executeUpdate() == 0) {
                    res = false;
                }
            }
            return res;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


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
                products.add(new Pair(product, res.getFloat("quantity")));
            }

            return products;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}