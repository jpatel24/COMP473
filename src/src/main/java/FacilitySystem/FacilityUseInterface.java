package src.main.java.FacilitySystem;
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
     public int calcUsageRate(Facility facility);

}
