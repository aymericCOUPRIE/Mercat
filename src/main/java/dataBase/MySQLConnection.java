package dataBase;

import java.sql.*;

public class MySQLConnection {

    //Objet Connection
    private static Connection connect;

    /**
     * Méthode qui va nous retourner notre singleton connection et le créer si il n'existe pas
     **/
    public static Connection getInstance() {
        if (connect == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //pour autres
                 connect = DriverManager.getConnection("jdbc:mysql://localhost/mercatdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
                //pour mac
                //connect = DriverManager.getConnection("jdbc:mysql://localhost:8889/mercatdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "root");

            } catch (SQLException | ClassNotFoundException ex) {
                // handle any errors
                ex.printStackTrace();
            }
        }
        return connect;
    }

    /*
    Test pour vérifier qu'on est bien connecté

    public static void main (String [] args ) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/mercatdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","root");
        ResultSet rs = conn.prepareStatement("show tables").executeQuery();
        while(rs.next()){
            String s = rs.getString(1);
            System.out.println(s);
        }
    }
    */
}




