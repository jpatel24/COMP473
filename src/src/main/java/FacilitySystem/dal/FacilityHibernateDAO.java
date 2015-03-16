package src.main.java.FacilitySystem.dal;

import org.hibernate.Query;
import org.hibernate.Session;
import src.main.java.FacilitySystem.model.Facility;
import src.main.java.FacilitySystem.model.Use;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Jeel on 3/15/15.
 */
public class FacilityHibernateDAO {
    public FacilityHibernateDAO(){}

    public Facility getFacility(int facilityID) {
        try {
            System.out.println("*************** Searcing for facility information with ID ...  " + facilityID);
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();

            session.beginTransaction();

            Query getFacilityQuery = session.createQuery("From Facility where id=:facilityId");
            getFacilityQuery.setInteger("id", facilityID);
            System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString());
            List facilities = getFacilityQuery.list();
            System.out.println("Getting Facilities. \n" + facilities);

            session.getTransaction().commit();

            return (Facility)facilities.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void removeFacility(Facility facility) {
        System.out.println("*************** Deleting facility information in DB with ID ...  " + facility.getId());
        Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(facility);
        session.getTransaction().commit();
    }


    public List<Facility> getFacilities(){
        try{
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query getFacilityQuery = session.createQuery("From Facility");


            System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString());

            List<Facility> facilities = getFacilityQuery.list();
            System.out.println("Getting List of Facilities. \n" + facilities);

            session.getTransaction().commit();
            return facilities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public void addFacility(Facility facility) {
        System.out.println("*************** Adding facility in DB with ID ...  " + facility.getId());
        Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(facility);
        session.getTransaction().commit();
        System.out.println(facility.getId());
    }

    public void updateFacility(Facility facility) {
        System.out.println("*************** Updating facility information in DB with ID ...  " + facility.getId());
        Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(facility);
        session.getTransaction().commit();
        System.out.println(facility.getId());
    }



    public boolean isFacilityInUse(Facility facility, Calendar startDate, Calendar endDate){

        try{
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query getFacilityQuery = session.createQuery("From Use where facility=:facility and StartDate>=:StartDate and EndDate<=:EndDate");
            getFacilityQuery.setParameter("facility",facility);
            getFacilityQuery.setParameter("StartDate", startDate);
            getFacilityQuery.setParameter("EndDate", endDate);
            List uses = getFacilityQuery.list();
            System.out.println("Getting Facility Use. \n" + uses);

            session.getTransaction().commit();
            return uses.size()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public List<Use> getUses(Facility facility){
        try{
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query getFacilityQuery;

                getFacilityQuery = session.createQuery("From Use where facility=facility");
                getFacilityQuery.setParameter("facility", facility);

            System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString());

            List<Use> uses = getFacilityQuery.list();
            System.out.println("Getting Use Details using HQL. \n" + uses);

            session.getTransaction().commit();
            return uses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }
}
