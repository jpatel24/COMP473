package src.main.java.FacilitySystem.dal;

/**
 * Created by Jeel on 2/13/15.
 */


import org.hibernate.Session;
import src.main.java.FacilitySystem.Facility;
import src.main.java.FacilitySystem.Use;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

public class FacilityDAO {
    public FacilityDAO() {}



    public Facility getFacility(int facilityID)
    {

        try {
            //Get Customer
            Statement st = DBHelper.getConnection().createStatement();
            String selectCustomerQuery = "SELECT id, cost, vacant, description FROM facilitytable WHERE id = '" + facilityID + "'";

            ResultSet custRS = st.executeQuery(selectCustomerQuery);
            System.out.println("CustomerDAO: *************** Query " + selectCustomerQuery);

            //Get Customer
            Facility facility = new Facility();
            while (custRS.next()) {
                facility.setDescription(custRS.getString("description"));
                facility.setCost((float) custRS.getDouble("cost"));
                facility.setVacant(custRS.getBoolean("vacant"));
            }
            custRS.close();
            return facility;
        }
            //close to manage resources

            catch (SQLException se) {
                System.err.println("CustomerDAO: Threw a SQLException retrieving the customer object.");
                System.err.println(se.getMessage());
                se.printStackTrace();
            }
        return null;
    }

    public void removeFacility(Facility facility) {
        System.out.println("*************** Deleteing facility information in DB with ID ...  " + facility.getId());
        Session session = DBHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(facility);
        session.getTransaction().commit();
    }


    public List<Facility> getFacilities(Facility facility){
        return null;
    }


    public void addFacility(Facility facility) {

    }

    public void updateFacility(Facility facility) {

    }



    public boolean isFacilityInUse(Facility facility, Calendar startDate, Calendar endDate){


        return false;

    }

    public List<Use> getUses(Facility facility){

        return null;


    }



    public List<Use> getInspections(Facility facility){

        return null;

    }
}
