package src.main.java.FacilitySystem.service;

import src.main.java.FacilitySystem.Facility;
import src.main.java.FacilitySystem.FacilityProblems;
import src.main.java.FacilitySystem.MaintenanceRequest;
import src.main.java.FacilitySystem.Use;
import src.main.java.FacilitySystem.dal.FacilityDAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jeel on 2/14/15.
 */
public class FacilityService {
    public FacilityService(){
    }
    private FacilityDAO facDAO;

    public FacilityDAO getFacDAO(){
        return facDAO;
    }

    public void setFacDAO(FacilityDAO f){
        this.facDAO = f;
    }

    public Facility getFacilityById(int facilityId){
        try {
            Facility f = facDAO.getFacility(facilityId);
            return f;
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception retrieving facility.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    public void addFacility(Facility facility) {

        try {
            facDAO.addFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception adding facility.");
            System.err.println(se.getMessage());
        }
    }

    public void removeFacility(Facility facility) {

        try {
            facDAO.removeFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception removing facility.");
            System.err.println(se.getMessage());
        }
    }

    public void addUse(Use use, Facility facility) {

        try {
            facility.addUse(use);
            use.setFacility(facility);
            facDAO.updateFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception adding use.");
            System.err.println(se.getMessage());
        }
    }

    public void updateFacility(Facility facility) {

        try {
            facDAO.updateFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception updating facility.");
            System.err.println(se.getMessage());
        }
    }

    public List<Facility> getFacilities(){
        try {
            return facDAO.getFacilities();
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting facility.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    public boolean isFacilityInUse( Calendar startDate, Calendar endDate){
        try {
            return facDAO.isFacilityInUse( startDate, endDate);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting if facility is in Use");
            System.err.println(se.getMessage());
        }
        return false;
    }

    public List<Facility> getFacilityAvailableCapacity(Facility facility){
        List<Facility> list = new ArrayList<Facility>();
        List<Facility> temp = getFacilities();
        Iterator<Facility> i = temp.iterator();
        while(i.hasNext()){
            Facility f = i.next();
            java.util.Calendar endDate = java.util.Calendar.getInstance();
            endDate.add(Calendar.DAY_OF_MONTH, 1);
            java.util.Calendar startDate = java.util.Calendar.getInstance();
            if(isFacilityInUse(startDate, endDate)){
                list.add(f);
            }
        }
        return list;
    }

    public List<Use> getUses(Facility facility){
        try {
            return facDAO.getUses(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting Uses.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    public List<Use> getInspections(Facility facility){
        try {
            return facDAO.getInspections(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception getting Inspections.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    public void removeUses(Facility facility) {

        try {
            facility.getFacilityUse().clear();
            facDAO.updateFacility(facility);
        } catch (Exception se) {
            System.err.println("FacilityService: Threw a Exception removing Uses.");
            System.err.println(se.getMessage());
        }
    }


    public void addMaintenanceRequest(MaintenanceRequest mr, Facility f) {

        try {
            f.addMaintenanceRequest(mr);
            facDAO.updateFacility(f);
        } catch (Exception se) {
            System.err.println("MaintService: Threw a Exception adding maintenance request.");
            System.err.println(se.getMessage());
        }
    }

    public void addFacilityProblem(Facility f, FacilityProblems prob)
    {
        try{
            f.addFacilityProblem(prob);
            facDAO.updateFacility(f);
        }catch (Exception se)
        {
            System.err.println("MaintService: Threw a Exception adding facility problem.");
            System.err.println(se.getMessage());
        }
    }
}
