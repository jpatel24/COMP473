package src.main.java.FacilitySystem.dal;

import org.hibernate.Query;
import org.hibernate.Session;
import src.main.java.FacilitySystem.model.Facility;
import src.main.java.FacilitySystem.model.Maintenance;
import src.main.java.FacilitySystem.model.MaintenanceRequest;

import java.util.List;

/**
 * Created by Jeel on 3/15/15.
 */
public class MaintenanceHibernateDAO {

    public MaintenanceHibernateDAO(){}

    public MaintenanceRequest getMaintenanceRequest(int maintReqId) {

        try {

            System.out.println("*************** Searching for Maintenance information with ID ...  " + maintReqId);
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query getMaintQuery = session.createQuery("From MaintenanceRequest where id=:maintReqId");
            getMaintQuery.setParameter("maintReqId",maintReqId);

            System.out.println("*************** Retrieve Query is ....>>\n" + getMaintQuery.toString());
            List maintReq = getMaintQuery.list();
            System.out.println("Getting details using HQL. \n");

            session.getTransaction().commit();
            return (MaintenanceRequest) maintReq.get(0);

        } catch (Exception e)
        {
            e.printStackTrace();
        }


        return null;
    }


    public void updateMaintenanceRequest(MaintenanceRequest maintenanceRequest, boolean current)
    {
        try{

            System.out.println("*************** Updating Maintenance Request information in DB with ID ...  " + maintenanceRequest.getId());
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(maintenanceRequest);
            session.getTransaction().commit();

        } catch(Exception e )
        {
            e.printStackTrace();
        }
    }


    public List<MaintenanceRequest> showMaintenanceRequests(Facility facility, boolean current)
    {
        try{
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query getMaintReqQuery;

            getMaintReqQuery = session.createQuery("From MaintenanceRequest where current=:current");
            getMaintReqQuery.setBoolean("current", true);

            System.out.println("*************** Retrieve Query is ....>>\n" + getMaintReqQuery.toString());

            List<MaintenanceRequest> maintreqs = getMaintReqQuery.list();

            System.out.println("Getting details using HQL. \n" + maintreqs);

            session.getTransaction().commit();

            return maintreqs;


        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally{
            System.out.println("just checking");
        }
        return null;
    }

    public Maintenance getMaintenance(int maintId) {

        try {

            System.out.println("*************** Searcing for maintenance information with ID ...  " + maintId);
            Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query getMaintQuery = session.createQuery("From Maintenance where id=:maintId");

            getMaintQuery.setParameter("maintId", maintId);
            System.out.println("*************** Retrieve Query is ....>>\n" + getMaintQuery.toString());
            List maint = getMaintQuery.list();

            System.out.println("Getting details using HQL. \n" + maint);

            session.getTransaction().commit();
            return (Maintenance) maint.get(0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



        return null;
    }

    public void updateMaintenanceRequest(MaintenanceRequest mr)
    {

        Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(mr);
        session.getTransaction().commit();

    }

    public void addMaintenance(Maintenance m) {

        Session session = HibernateSQLHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(m);
        session.getTransaction().commit();

    }

}
