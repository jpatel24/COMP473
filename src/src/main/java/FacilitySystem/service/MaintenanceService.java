package src.main.java.FacilitySystem.service;

import src.main.java.FacilitySystem.Maintenance;
import src.main.java.FacilitySystem.MaintenanceRequest;
import src.main.java.FacilitySystem.dal.MaintenanceDAO;

/**
 * Created by Jeel on 2/15/15.
 */
public class MaintenanceService {
    public MaintenanceService(){
    }
    private MaintenanceDAO mDAO;

    public void setMDAO(MaintenanceDAO m){
        this.mDAO = m;
    }

    public MaintenanceDAO getMDAO(){
        return mDAO;
    }

    public Maintenance getMaintenanceById(int maintId){
        try {
            Maintenance m = mDAO.getMaintenance(maintId);
            return m;
        } catch (Exception se) {
            System.err.println("MaintService: Threw a Exception retrieving maintenance.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    public void addMaintenance(Maintenance m, MaintenanceRequest mr) {

        try {
           mDAO.addMaintenance(m);
            mDAO.updateMaintenanceRequest(mr);
        } catch (Exception se) {
            System.err.println("MaintService: Threw a Exception adding maintenance.");
            System.err.println(se.getMessage());
        }
    }



    public MaintenanceRequest getMaintenanceRequestById(int facilityId){
        try {
            MaintenanceRequest m = mDAO.getMaintenanceRequest(facilityId);
            return m;
        } catch (Exception se) {
            System.err.println("MaintService: Threw a Exception retrieving maintenance request.");
            System.err.println(se.getMessage());
        }
        return null;
    }


    public void updateMaintenanceRequest(MaintenanceRequest mr) {

        try {
            mDAO.updateMaintenanceRequest(mr);
        } catch (Exception se) {
            System.err.println("MaintService: Threw a Exception updating maintenance request.");
            se.printStackTrace();
        }
    }



}
