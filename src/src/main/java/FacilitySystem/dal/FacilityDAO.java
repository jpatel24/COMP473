package src.main.java.FacilitySystem.dal;

/**
 * Created by Jeel on 2/13/15.
 */


import src.main.java.FacilitySystem.Facility;
import src.main.java.FacilitySystem.Use;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FacilityDAO {
    public FacilityDAO() {}



    public Facility getFacility(int facilityID)
    {

        try {
            //Get Facility
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT Id,Vacant,Description,Cost FROM FacilityTable WHERE id=?");
            statement.setInt(1,facilityID);

            ResultSet set = statement.executeQuery();
            System.out.println("FacilityDAO: *************** Query " + statement);

            //Get Facility;
            Facility facility = new Facility();
            while(set.next())
            {
               facility.setId(set.getInt(1));
                facility.setVacant(set.getBoolean(2));
                facility.setDescription(set.getString(3));
                facility.setCost(set.getFloat(4));
            }

            set.close();
            return facility;
        }
            //close to manage resources

            catch (SQLException se) {
                System.err.println("FacilityDAO: Threw a SQLException retrieving the customer object.");
                System.err.println(se.getMessage());
                se.printStackTrace();
            }
        return null;
    }

    public void removeFacility(Facility facility) {
        System.out.println("*************** Deleteing facility information in DB with ID ...  " + facility.getId());
        try {
            Connection connection = DBHelper.getConnection();
            int removeID = facility.getId();
            PreparedStatement statement = connection.prepareStatement("SELECT Id FROM FacilityTable WHERE id=removeId");

            ResultSet set = statement.executeQuery();
            facility.removeFacility(set.getInt(1));

            set.close();

        }catch (SQLException se){
            System.err.println("FacilityDAO: Threw a SQLException retrieving the customer object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
    }


    public List<Facility> getFacilities(){
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM FacilityTable");

            ResultSet set = statement.executeQuery();
            List list = new ArrayList();
            while (set.next()){
                list.add(set.getString(3));
            }
            return list;


        } catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the customer object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;

    }

    public void addFacility(Facility facility) {
        try {
            Connection connection = DBHelper.getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO FacilityTable(Id,Vacant,Description,Cost) VALUES (?,?,?,?)");
            statement.setInt(1, facility.getId());
            statement.setBoolean(2,facility.isVacant());
            statement.setString(3,facility.getDescription());
            statement.setDouble(4,facility.getCost());
            statement.execute();

            connection.close();
        }
        catch (SQLException se){
            System.err.println("FacilityDAO: Threw a SQLException retrieving the customer object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
    }

    public void updateFacility(Facility facility) {
       try{
           Connection connection = DBHelper.getConnection();
           PreparedStatement statement = connection.prepareStatement("UPDATE FacilityTable SET Vacant=? WHERE Id=?");
           statement.setBoolean(1, facility.isVacant());
           statement.setInt(2,facility.getId());
           statement.executeUpdate();

           connection.close();

       }catch (SQLException se){
           System.err.println("FacilityDAO: Threw a SQLException retrieving the customer object.");
           System.err.println(se.getMessage());
           se.printStackTrace();
       }
    }



    public boolean isFacilityInUse(Calendar startDate, Calendar endDate){
        Calendar sDate = startDate;
        Calendar eDate = endDate;
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement= connection.prepareStatement("SELECT *FROM Use WHERE StartDate>=sDate AND EndDate<=eDate");
            List uses = new ArrayList();

            ResultSet set = statement.executeQuery();
            while(set.next()){
                uses.add(set);
            }

            return uses.size()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public List<Use> getUses(Facility facility){
        try{
                Connection connection = DBHelper.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM Use WHERE Description=?");
            statement.setString(1, facility.getDescription());
            List uses = new ArrayList();
            ResultSet set = statement.executeQuery();
            while (set.next()){
                uses.add(set);
            }
            return uses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }

    public List<Use> getInspections(Facility facility){
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM MaintenanceRequest WHERE Description=?");
            statement.setString(1,facility.getDescription());
            List uses = new ArrayList();

            ResultSet set = statement.executeQuery();

            while (set.next()){
                uses.add(set.getString(4));
            }
            return uses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}

