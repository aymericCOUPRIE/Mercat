package dataBase;

import java.sql.*;

public class MySQLConnection {

    //Objet Connection
    private static Connection connect;

    //Méthode qui va nous retourner notre singleton de connection et le créer si il n'existe pas

        public static Connection getInstance() {
            if (connect == null) {
                try {

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (Exception ex) {
                       ex.printStackTrace();
                    }
                    //pour autres
                    // Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/mercatdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
                    //pour mac
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:8889/mercatdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "root");

                } catch (SQLException ex) {
                    // handle any errors
                    ex.printStackTrace();
                }
            }
            return connect;
        }
    }




