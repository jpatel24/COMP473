package src.main.java.FacilitySystem;

import src.main.java.FacilitySystem.service.FacilityService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jeel on 2/13/15.
 *
 * need a facility service which has a DAO to retrive info..
 */
public class FacilityUse implements FacilityUseInterface {

    public FacilityUse(){
    }
    private FacilityService facilityservice;

    public void setFacilityService(FacilityService fs){
        this.facilityservice = fs;
    }

    public FacilityService getFacilityService(){
        return facilityservice;
    }

    public float calcUsageRate(Facility facility) {
        List<Use> use = facilityservice.getUses(facility);
        Calendar cal = new GregorianCalendar();
        float days = 0f;

        Iterator<Use> i = use.iterator();
        while(i.hasNext())
        {
            Use u = i.next();
            cal.setTimeInMillis(System.currentTimeMillis());
            cal.add(Calendar.YEAR, -1);

            if ((u.getStartDate().getTimeInMillis() - cal.getTimeInMillis())  > 0)
            {
                int diffInDays = (int)(( (u.getEndDate().getTimeInMillis() - u.getStartDate().getTimeInMillis()) / (1000 * 60 * 60 * 24) ) );
                days += diffInDays;
            }
        }

        return days/365;
    }

    public List<Use> listActualUsage(Facility facility) {

        return facilityservice.getUses(facility);
    }

    public boolean isInUseDuringInterval(Facility facility,Calendar startDate, Calendar endDate)
    {

        return facilityservice.isFacilityInUse( startDate, endDate);


    }

    @Override
    public void assignFacilityToUse(Facility facility, Use use) {
        facilityservice.addUse(use,facility);
    }


    public void vacateFacility(Facility facility) {
        facilityservice.removeUses(facility);
        facility.setVacant(true);
    }

    public List<Use> listInspections(Facility facility) {

        return facilityservice.getInspections(facility);
    }


}
