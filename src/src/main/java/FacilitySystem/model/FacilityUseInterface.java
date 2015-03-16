package src.main.java.FacilitySystem.model;
import java.util.*;
/**
 * Created by Ti on 2/5/2015.
 */
public interface FacilityUseInterface {

     public boolean isInUseDuringInterval(Facility facility, Calendar startDate, Calendar endDate);
     public void assignFacilityToUse(Facility facility, Use use);
     public void vacateFacility(Facility facility);
     public List<Use> listInspections(Facility facility);
     public List<Use> listActualUsage(Facility facility);
     public float calcUsageRate(Facility facility);

}
