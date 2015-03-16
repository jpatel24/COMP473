package src.main.java.FacilitySystem.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import src.main.java.FacilitySystem.dal.MaintenanceHibernateDAO;
import src.main.java.FacilitySystem.model.Maintenance;
import src.main.java.FacilitySystem.model.MaintenanceRequest;

/**
 * Created by Jeel on 2/15/15.
 */
public class MaintenanceService {
    public MaintenanceService(){
    }

    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    private MaintenanceHibernateDAO mDAO = (MaintenanceHibernateDAO) context.getBean("maintenanceHibernateDAO");

    public void setMDAO(MaintenanceHibernateDAO m){
        this.mDAO = m;
    }

    public MaintenanceHibernateDAO getMDAO(){
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

    public void addMaintenance(Maintenance m) {

        try {
           mDAO.addMaintenance(m);
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
