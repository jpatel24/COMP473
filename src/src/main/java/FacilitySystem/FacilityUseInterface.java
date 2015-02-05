package src.main.java.FacilitySystem;
import java.util.*;
/**
 * Created by Ti on 2/5/2015.
 */
public interface FacilityUseInterface {
     public boolean isInUseDuringInterval();
     public void assignFacilityToUse(Facility facility, Use use);
     public void vacateFacility();
     public List listInspections();
     public List listActualUsage();
     public int calcUsageRate();

}
