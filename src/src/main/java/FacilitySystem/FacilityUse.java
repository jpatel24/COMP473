package src.main.java.FacilitySystem;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Jeel on 2/13/15.
 *
 * need a facility service which has a DAO to retrive info..
 */
public class FacilityUse implements FacilityUseInterface {

    @Override
    public boolean isInUseDuringInterval(Facility facility, Calendar startDate, Calendar endDate) {
        return false;
    }

    @Override
    public void assignFacilityToUse(Facility facility, Use use) {

    }

    @Override
    public void vacateFacility(Facility facility) {

    }

    @Override
    public List<Use> listInspections(Facility facility) {
        return null;
    }

    @Override
    public List<Use> listActualUsage(Facility facility) {
        return null;
    }

    @Override
    public float calcUsageRate(Facility facility) {
        return 0;
    }
}
