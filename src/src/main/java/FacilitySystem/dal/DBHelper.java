package src.main.java.FacilitySystem.dal;

import java.sql.*;

/**
 * Created by Jeel on 2/13/15.
 */
public class DBHelper {

    public static Connection getConnection() {

        System.out.println("DBHelper: -------- PostgreSQL " + "JDBC Connection  ------------");

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("DBHelper: Check Where  your PostgreSQL JDBC Driver exist and " + "Include in your library path!");
            e.printStackTrace();
            return null;

        }

        System.out.println("DBHelper: PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FacilitySystem","root","jeelpatel");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println("DBHelper: The Database Version is " + rs.getString(1));
            }

        } catch (SQLException e) {

            System.out.println("DBHelper: Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }

        if (connection != null) {
            System.out.println("DBHelper: You have a database connection!");
        } else {
            System.out.println("DBHelper: Failed to make connection!");
        }

        return connection;
    }

}
