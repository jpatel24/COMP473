package src.main.java.FacilitySystem.service;

import src.main.java.FacilitySystem.dal.FacilityHibernateDAO;
import src.main.java.FacilitySystem.model.Facility;
import src.main.java.FacilitySystem.model.FacilityProblems;
import src.main.java.FacilitySystem.model.MaintenanceRequest;
import src.main.java.FacilitySystem.model.Use;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Jeel on 2/14/15.
 */
public class FacilityService {
    public FacilityService(){
    }

    private FacilityHibernateDAO facilityHibernateDAO;

    public FacilityHibernateDAO getFacilityHibernateDAO(){
        return facilityHibernateDAO;
    }

    public void setFacilityHibernateDAO(FacilityHibernateDAO f){
        this.facilityHibernateDAO = f;
    }

    public Facility getFacilityById(int facilityId){
        try {
            Facility f = facilityHibernateDAO.getFacility(facilityId);
            return f;
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception retrieving facility.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    public void addFacility(Facility facility) {

        try {
            facilityHibernateDAO.addFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception adding facility.");
            System.err.println(se.getMessage());
        }
    }

    public void removeFacility(Facility facility) {

        try {
            facilityHibernateDAO.removeFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception removing facility.");
            System.err.println(se.getMessage());
        }
    }

    public void addUse(Use use, Facility facility) {

        try {
            facility.addUse(use);
            use.setFacility(facility);
            facilityHibernateDAO.updateFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception adding use.");
            System.err.println(se.getMessage());
        }
    }

    public void updateFacility(Facility facility) {

        try {
            facilityHibernateDAO.updateFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception updating facility.");
            System.err.println(se.getMessage());
        }
    }

    public List<Facility> getFacilities(){
        try {
            return facilityHibernateDAO.getFacilities();
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting facility.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    public boolean isFacilityInUse( Facility facility, Calendar startDate, Calendar endDate){
        try {
            return facilityHibernateDAO.isFacilityInUse(facility,startDate, endDate);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting if facility is in Use");
            System.err.println(se.getMessage());
        }
        return false;
    }

    public int getFacilityAvailableCapacity(Facility facility){
        return facility.requestAvailableCapacity();
    }

    public List<Use> getUses(Facility facility){
        try {
            return facilityHibernateDAO.getUses(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting Uses.");
            System.err.println(se.getMessage());
        }
        return null;
    }
    /*
    public List<Use> getInspections(Facility facility){
        try {
            return facilityHibernateDAO.getInspections(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting Inspections.");
            System.err.println(se.getMessage());
        }
        return null;
    }
    */

    public void removeUses(Facility facility) {

        try {
            facility.getFacilityUse().clear();
            facilityHibernateDAO.updateFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception removing Uses.");
            System.err.println(se.getMessage());
        }
    }


    public void addMaintenanceRequest(MaintenanceRequest mr, Facility f) {

        try {
            f.addMaintenanceRequest(mr);
            facilityHibernateDAO.updateFacility(f);
        } catch (Exception se) {
            System.err.println("MaintService: Threw a Exception adding maintenance request.");
            System.err.println(se.getMessage());
        }
    }

    public void addFacilityProblem(Facility f, FacilityProblems prob)
    {
        try{
            f.addFacilityProblem(prob);
            facilityHibernateDAO.updateFacility(f);
        }catch (Exception se)
        {
            System.err.println("MaintService: Threw a Exception adding facility problem.");
            System.err.println(se.getMessage());
        }
    }
}
