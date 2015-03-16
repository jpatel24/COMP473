package src.main.java.FacilitySystem.model;
import java.util.List;
/**
 * Created by Jeel on 2/4/15.
 */
public interface FacilityInterface {

    public abstract String getFacilityInformation();

    public abstract void addFacilityDetail(boolean vacant, float cost, String use);

    public abstract int requestAvailableCapacity();

    public abstract List<Facility> listFacilities();

    public abstract void removeFacility(int facilityId);

    public abstract void addNewFacility(Facility facility);


}
