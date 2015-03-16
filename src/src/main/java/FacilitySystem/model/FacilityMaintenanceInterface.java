package src.main.java.FacilitySystem.model;
import java.util.List;
/**
 * Created by Jeel on 2/9/15.
 */
public interface FacilityMaintenanceInterface {

    public void makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, Facility facility);

    public List<MaintenanceRequest> listMaintRequests(Facility facility);

    public List<FacilityProblems> listMaintenance(Facility facility);

    public float calcProblemRateForFacility(Facility facility);

    public float calcDownTimeForFacility(Facility facility);

    public void scheduleMaintenance(Maintenance maintenance, MaintenanceRequest maintenanceRequest);
}
