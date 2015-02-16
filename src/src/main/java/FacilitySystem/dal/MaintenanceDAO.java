package src.main.java.FacilitySystem.dal;

import src.main.java.FacilitySystem.Maintenance;
import src.main.java.FacilitySystem.MaintenanceRequest;

import java.sql.*;

/**
 * Created by Jeel on 2/15/15.
 */
public class MaintenanceDAO {

    public MaintenanceDAO() {}


    public MaintenanceRequest getMaintenanceRequest(int maintReqId) {

        try {
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT FROM MaintenanceRequest WHERE Id=?");
            statement.setInt(1,maintReqId);

            ResultSet set = statement.executeQuery();
            MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
            while (set.next()){
                maintenanceRequest.setCurrent(set.getBoolean(3));
                maintenanceRequest.setDescription(set.getString(4));
                maintenanceRequest.setEstCost(set.getDouble(5));

            }
            return maintenanceRequest;
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }


        return null;
    }


    public Maintenance getMaintenance(int maintId) {

        try {

          Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT FROM Maintenance WHERE Id=?");
            statement.setInt(1,maintId);
            ResultSet set = statement.executeQuery();
            Maintenance maintenance = new Maintenance();
            while (set.next()){
                maintenance.setId(set.getInt(2));
                maintenance.setCompleted(set.getBoolean(3));
                maintenance.setDescription(set.getString(4));
            }
            return maintenance;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public void updateMaintenanceRequest(MaintenanceRequest maintenanceRequest)
    {
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE MaintenanceRequest SET Current=?, Description=?, EstimatedCost=? WHERE id=?");
            statement.setBoolean(1,maintenanceRequest.isCurrent());
            statement.setString(2,maintenanceRequest.getDescription());
            statement.setDouble(3,maintenanceRequest.getEstCost());
            statement.setInt(4,maintenanceRequest.getId());

            statement.executeUpdate();

        }
        catch (SQLException se){
            se.printStackTrace();
        }


    }

    public void addMaintenance(Maintenance maintenance) {

        try {
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Maintenance(MaintReqId, Id, Completed, Description, Date) VALUES (?,?,?,?,?)");
            statement.setInt(2,maintenance.getId());
            statement.setBoolean(3,maintenance.isCompleted());
            statement.setString(4,maintenance.getDescription());

            statement.execute();
        }
        catch (SQLException se){
            se.printStackTrace();
        }

    }
}
