package src.main.java.FacilitySystem;

import java.util.Calendar;
import java.util.Random;
import java.util.List;

/**
 * Created by Jeel on 2/9/15.
 */
public class MaintenanceRequest {
    private int id;

    private String description;

    private Calendar date;

    private Facility facility;

    private boolean current = true;

    private double estCost;

    private List<Maintenance> maintenances;

    @Override
    public String toString()
    {
        return("Information: Calc estimated cost: " + estCost + " Date: " + date.getTimeInMillis() + " Description: " + description + " Is finished: " + current + " ID: " + id);
    }

    public double calMaintenanceCostForFacility() {
        int max = 1500;
        int min = 50;

        Random r = new Random();
        estCost = min + (max - min) * r.nextDouble();

        return estCost;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEstCost() {
        return estCost;
    }

    public void setEstCost(double estCost) {
        this.estCost = estCost;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public void addMaintenance(Maintenance m){
        maintenances.add(m);
        m.setMaintenanceRequest(this);
    }

}
