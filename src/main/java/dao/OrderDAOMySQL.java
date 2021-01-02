package dao;

import model.Basket;
import model.Order;

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
     * @param basket
     * @return
     */

    public boolean insertOrder(Basket basket) {
        String requete = "INSERT INTO order_ok (pseudoConsumer, pseudoSeller, dateOrder, deliveryAddress, deliveryDate, idProduct, quantity, stateOrder) VALUES (?,?,NOW(),?,NOW(),?,?,?)";

        /*
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, basket.getPseudoConsumer());
            preparedStatement.setString(2, "inutileCarOnStockIDProduct???");
            preparedStatement.setString(3, "inutileCarOnADejaIDConsumer");
            preparedStatement.setInt(4, basket.getIdProduct());
            preparedStatement.setFloat(5, basket.getQuantity());
            preparedStatement.setString(6, "Beginning");
            int res = preparedStatement.executeUpdate();

            return res == 0 ? false : true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        */

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
     * @return
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
                res.getString("pseudoConsumer"),
                res.getString("pseudoSeller"),
                res.getDate("dateOrder"),
                res.getString("deliveryAddress"),
                res.getDate("deliveryDate"),
                res.getInt("idProduct"),
                res.getFloat("quantity"),
                res.getString("stateOrder")
        );
        return order;
    }


}