package src.main.java.FacilitySystem.view;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import src.main.java.FacilitySystem.Facility;

/**
 * Created by Jeel on 2/14/15.
 */
public class FacilitySystemClient {

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

    public static void main(String[]args){



        //creating session object
        Session session=sessionFactory.openSession();

        //creating transaction object
        Transaction t=session.beginTransaction();

        Facility facility = new Facility();
        facility.setId(1);
        facility.setCost(800);
        facility.setDescription("Admissons");

        session.persist(facility);
        t.commit();
        session.close();
        System.out.println("Successfully saved");

    }
}
