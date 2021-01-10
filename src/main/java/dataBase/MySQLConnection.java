package dataBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * This class handles the connection to the DB
 * with the parameters given in database.properties
 */
public class MySQLConnection {

    //Objet Connection
    private static Connection connect;

    /**
     * Méthode qui va nous retourner notre singleton connection et le créer si il n'existe pas
     **/
    public static Connection getInstance() {
        if (connect == null) {
            Properties p = getDatabaseProperties();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //pour autres
                String url = p.getProperty("url");
                String user = p.getProperty("user");
                //Si pas spécifié pour le mdp, renvoie vide
                String password = p.getProperty("password", "");
                connect = DriverManager.getConnection(url, user, password);

            } catch (SQLException | ClassNotFoundException ex) {
                // handle any errors
                ex.printStackTrace();
            }
        }
        return connect;
    }

    private static Properties getDatabaseProperties() {
        Properties p = new Properties();
        try (InputStream in = MySQLConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (in == null) {
                throw new NullPointerException("You must specify a database.properties file");
            }
            p.load(new InputStreamReader(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}




