package src.main.java.FacilitySystem.dal;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.*;

/**
 * Created by Jeel on 2/13/15.
 */
public class DBHelper {

    public static Connection getConnection() {

        System.out.println("DBHelper: -------- PostgreSQL " + "JDBC Connection  ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("DBHelper: Check Where  your PostgreSQL JDBC Driver exist and " + "Include in your library path!");
            e.printStackTrace();
            return null;

        }

        System.out.println("DBHelper: PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/");
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

   //private static final SessionFactory sessionFactory;

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();

    }


}
