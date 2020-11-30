package dataBase;

import java.sql.*;

public class MySQLConnection {

    Statement st = null;

   public static void main(String[] args) {
        try {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(Exception ex) {
                System.out.println("MySQL driver couldn't be loaded!");
            }

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/mercatdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
            Statement st = cn.createStatement();
            System.out.println(st.executeUpdate("INSERT INTO user VALUES ('b','a','a','a','a','a','a','1','a','a','a')"));
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
    }



    /*
    public static void main (String [] args ) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&user=root&password=";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mercatdb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
        ResultSet rs = conn.prepareStatement("show tables").executeQuery();

        while(rs.next()){
            String s = rs.getString(1);
            System.out.println(s);
        }
    }
    */
}
