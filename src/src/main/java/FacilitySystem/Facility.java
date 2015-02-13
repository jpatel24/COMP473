package src.main.java.FacilitySystem;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Jeel on 2/4/15.
 *
 * This class implements the interface methods given to us. In general, it has basic methods and variables that can be assigned
 * to a facility. We have a list of facilityUse, maintenanaceRequestList, list of different facilities, and the problems.
 * Also, we have people who either own the facility or rented it.
 */
public class Facility implements FacilityInterface {
    private int id;
    private int capacity;
    private List<Use> facilityUse;
    private String description;
    private List<MaintenanceRequest> maintenanceRequestList;
    private boolean vacant;
    private float cost;
    private Facility facilityId;
    private List<Facility> list;
    private List<FacilityProblems> facilityProblemsList;
    private Person owner;
    private Person renter;

    public Facility()
    {
    }


    public void addFacilityDetail(boolean vacant, float cost, String description) {
        this.vacant = vacant;
        this.cost = cost;
        this.description = description;

    }

    public int requestAvailableCapacity() {
        return capacity;

    }

    public List<MaintenanceRequest> getMaintenanceRequestList(){
        return maintenanceRequestList;
    }

    public void setMaintenanceRequestList(List<MaintenanceRequest> fmr){
        this.maintenanceRequestList = fmr;
    }

    public List<Facility> listFacilities() {

        return list;
    }

    public List<Facility> getList(){
        return list;
    }

    public void setList(List<Facility>list){
        this.list=list;
    }

    public void removeFacility(int facilityId) {
        Iterator<Facility>i = list.iterator();
        while (i.hasNext()){
            Facility f = i.next();
            if(f.getId() == facilityId){
                list.remove(f);
            }

        }

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Use> getFacilityUse() {
        return facilityUse;
    }

    public void setFacilityUse(List<Use> facilityUse){
        this.facilityUse=facilityUse;
    }

    public void addUse(Use use){
        facilityUse.add(use);
        use.setFacility(this);
    }

    public void addMaintenanceRequest(MaintenanceRequest maintenanceRequest){
        maintenanceRequestList.add(maintenanceRequest);
    }



    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    @Override
    public String getFacilityInformation() {
        return ("Facility Information - " + "ID: " + id + " Facility ID: " + facilityId + " Cost: " + cost + " Vacant: " + vacant + " Description: "+ description + " Owner: " + owner.getFirstName());
    }

    @Override
    public String toString() {
        return ("Facility Information - " + "ID: " + id + " Cost: " + cost + " Vacant: " + vacant + " Description: "+ description + " Owner: " + owner.getFirstName());
    }



    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public void addNewFacility(Facility facility)
    {
        list.add(facility);
    }

    public List<FacilityProblems> getFacilityProblemsList() {
        return facilityProblemsList;
    }

    public void setFacilityProblemsList(List<FacilityProblems> facilityProblemsList) {
        this.facilityProblemsList = facilityProblemsList;
    }

    public void addFacilityProblem(FacilityProblems facilityProblems){
        facilityProblemsList.add(facilityProblems);
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getRenter() {
        return renter;
    }

    public void setRenter(Person renter) {
        this.renter = renter;
    }
}
