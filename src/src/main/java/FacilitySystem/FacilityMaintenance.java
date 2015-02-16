package src.main.java.FacilitySystem;

import src.main.java.FacilitySystem.service.FacilityService;
import src.main.java.FacilitySystem.service.MaintenanceService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jeel on 2/15/15.
 */
public class FacilityMaintenance implements FacilityMaintenanceInterface {

    public FacilityMaintenance(){
    }

    MaintenanceService maintenanceService;
    FacilityService facilityService;

    public void setMaintenanceService(MaintenanceService maintenanceService){
        this.maintenanceService = maintenanceService;
    }

    public MaintenanceService getMaintService(){
        return maintenanceService;
    }

    public void setFacilityService(FacilityService facilityService){
        this.facilityService = facilityService;
    }

    public FacilityService getFacilityService(){
        return facilityService;
    }

    public void makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, Facility facility) {

        facilityService.addMaintenanceRequest(maintenanceRequest, facility);
    }

    public List<MaintenanceRequest> listMaintRequests(Facility facility) {

        return facility.getMaintenanceRequestList();
    }

    public List<FacilityProblems> listMaintenance(Facility facility) {

       return facility.getFacilityProblemsList();
    }


    public float calcProblemRateForFacility(Facility facility) {

        List<MaintenanceRequest> mrList = facility.getMaintenanceRequestList();
        Calendar cal = new GregorianCalendar();

        float problemRate = 0f;

        Iterator<MaintenanceRequest> i = mrList.iterator();
        while(i.hasNext())
        {
            MaintenanceRequest mr = i.next();
            cal.setTimeInMillis(System.currentTimeMillis());
            cal.add(Calendar.YEAR, -1);

            if ((mr.getDate().getTimeInMillis() - cal.getTimeInMillis())  > 0)
            {
                problemRate++;
            }

        }
        return problemRate/365;
    }

    public float calcDownTimeForFacility(Facility facility) {
        List<FacilityProblems> maintenanceList = facility.getFacilityProblemsList();
        Calendar cal = new GregorianCalendar();

        float downTime = 0f;

        Iterator<FacilityProblems> i = maintenanceList.iterator();
        while(i.hasNext())
        {
            FacilityProblems facilityProblems = i.next();
            cal.setTimeInMillis(System.currentTimeMillis());
            cal.add(Calendar.YEAR, -1);

            if(facilityProblems!=null){
                if ((facilityProblems.getDate().getTimeInMillis() - cal.getTimeInMillis())  > 0)
                {
                    downTime++;
                }
            }

        }
        return downTime/365;
    }

    public void scheduleMaintenance(Maintenance maintenance, MaintenanceRequest maintenanceRequest) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(System.currentTimeMillis());

        maintenance.setCost(maintenanceRequest.getEstCost());
        maintenance.setDate(cal);
        maintenanceRequest.setCurrent(false);
        maintenance.setDescription(maintenanceRequest.getDescription());
        maintenanceService.updateMaintenanceRequest(maintenanceRequest);
    }

}
