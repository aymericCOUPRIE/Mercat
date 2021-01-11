package dao;

import dao.abstraction.OrderDAO;
import javafx.util.Pair;
import model.Basket;
import model.Order;
import model.Product;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Class OrderDAOMySQL
 */
public class OrderDAOMySQL extends OrderDAO {

    /**
     * this methode permit to connect the dao with the database
     *
     * @param connect is the connection for the database
     */
    protected OrderDAOMySQL(Connection connect) {
        super(connect);
    }

    /**
     * This method insert in the DB a new category and also the list of all
     * its product and quantity
     *
     * @param baskets         List of all the baskets for a Consumer
     * @param pseudoConsumer  name of the consumer
     * @param deliveryAddress the delivery address of the order (either at consumer home or at seller shop)
     * @return true if the insert order succeeded, false if it failed
     */
    public boolean insertOrder(List<Basket> baskets, String pseudoConsumer, String deliveryAddress) {


        List<Pair<Integer, Integer>> listsIdProduct = new ArrayList<>();

        for (Basket b : baskets) {
            System.out.println("EACH BASKET" + b.getProduct());
            listsIdProduct.add(new Pair<>(b.getProduct().getIdProduct(), b.getQuantity()));
        }

        String requete = "INSERT INTO orderdb (dateOrder, deliveryDate, deliveryAddress, stateOrder, pseudoConsumer) VALUES (?,?,?,?,?)";

        Timestamp date = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 7);

        try {

            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setTimestamp(1, date);
            preparedStatement.setTimestamp(2, new Timestamp(cal.getTime().getTime()));
            preparedStatement.setString(3, deliveryAddress);
            preparedStatement.setString(4, "start");
            preparedStatement.setString(5, pseudoConsumer);

            int res = preparedStatement.executeUpdate();

            if (res != 0) { //Vérifie que le INSERT order s'est bien passé
                System.out.println("INSERT LIST PRODUCT");

                Order tempo = find(pseudoConsumer, date);

                System.out.println("ID ORDER" + tempo.getIdOrder());
                insertAllProducts(tempo.getIdOrder(), listsIdProduct);

                deleteAlBasketAfterInsert(baskets);
            }

            return res != 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    /**
     * This method is used to update the orderState in the DB
     * for the coresponding object
     *
     * @param order the object order that holds the new orderState
     * @return true if update succeeded, false if it faild
     */
    public boolean updateOrderState(Order order) {
        String requete = "UPDATE orderdb SET stateOrder = ? WHERE idOrder = ?";

        System.out.println("UPDATE ORDER");

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, order.getStateOrder());
            preparedStatement.setInt(2, order.getIdOrder());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    /**
     * This method is used to find a specific Order from key elements
     *
     * @param pseudoConsumer the pseudo is one elemnt for the primary key in the DB
     * @param dateOrder      the pseudo is one elemnt for the primary key in the DB
     * @return the order Object
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
     * This method updates the order deliveryDate
     *
     * @param order This order object contains the new delivery date
     * @return true if the insertion in DB succeeded, false if ti failed
     */
    public boolean updateOrderDeliveryDate(Order order) {
        String requete = "UPDATE orderdb SET deliveryDate = ? WHERE idOrder = ?";

        System.out.println("DELIVERY DATE2" + order.getDeliveryDate());
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setDate(1, (java.sql.Date) order.getDeliveryDate());
            preparedStatement.setInt(2, order.getIdOrder());

            return preparedStatement.executeUpdate() > 0; //At east one line affected

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * This method is used to get all the orders from a User
     * (either a Seller or a Consumer)
     *
     * @param pseudo name of the User that wants all its order
     * @return the the order concerning 1 consumer
     */
    @Override
    public ArrayList<Order> getAllOrders(String pseudo) {
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
     * This method is used in order to have a single method that create an Object "Order"
     * from a query
     *
     * @param res the result of the query
     * @return the object Order
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
     * This method is used whe creating an order,
     * it insert into the DB all the products and their quantities for the order
     *
     * @param idOrder    used in order to add product for a spectific Order
     * @param idProducts the id of the product added to the order
     */
    private void insertAllProducts(int idOrder, List<Pair<Integer, Integer>> idProducts) {
        String requete = "INSERT INTO orderlistproduct (idOrder, idProduct, quantity) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setInt(1, idOrder);


            for (Pair<Integer, Integer> i : idProducts) {
                preparedStatement.setInt(2, i.getKey());
                preparedStatement.setInt(3, i.getValue());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * This method is used to get all the products and its quantity in order to create
     * the order object
     *
     * @param idOrder id of the order
     * @return the list of Pairs of the product and it quantity
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
     * This method is used to delete a Basket after it has been inserted in the DB
     *
     * @param baskets list of all the baskets to delete
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

    /**
     * This method is used to know if a specific product has already been
     * ordered by the consumer
     *
     * @param nameConsumer the name of the consumer
     * @param idProduct    the id of the product added to the order
     * @return true if the query succeeded, false if it failed
     */
    @Override
    public boolean orderProduct(String nameConsumer, int idProduct) {
        String requete = "SELECT * FROM orderdb, orderlistproduct WHERE orderdb.idOrder = orderlistproduct.idOrder AND orderdb.pseudoConsumer = ? AND orderlistproduct.idProduct=?";
        System.out.println(nameConsumer + " " + idProduct);
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement(requete);
            preparedStatement.setString(1, nameConsumer);
            preparedStatement.setInt(2, idProduct);
            ResultSet res = preparedStatement.executeQuery();

            // Tente récupérer résultat
            return res.next();

        } catch (SQLException throwables) {
            return false;
        }
    }


}