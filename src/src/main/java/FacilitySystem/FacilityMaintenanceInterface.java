package src.main.java.FacilitySystem;
import java.util.List;
import java.util.*;
/**
 * Created by Jeel on 2/9/15.
 */
public interface FacilityMaintenanceInterface {

    public void makeFacilityMaintRequest(MaintenanceRequest mr, Facility f);

    public List<MaintenanceRequest> listMaintRequests(Facility facility);

    public List<Maintenance> listMaintenance(Facility facility);

    public List<MaintenanceRequest> listCurrentRequests(Facility facility);

    public Map<Facility,List<String>> listFacilityProblems();

    public float calcProblemRateForFacility(Facility facility);

    public float calcDownTimeForFacility(Facility facility);

    public void scheduleMaintenance(Maintenance m, MaintenanceRequest mr);
}
