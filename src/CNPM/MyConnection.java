
package CNPM;

import java.sql.DriverManager;


public class MyConnection {
    public static java.sql.Connection getConnection() {
        java.sql.Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/khachsan";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "Thang";
            String password = "password";
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        return conn;
    }

    public static void closeConnection(java.sql.Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    
}
