package src.main.java.FacilitySystem.model;

import java.util.Calendar;

/**
 * Created by Jeel on 2/9/15.
 */
public class Maintenance {
    private int id;
    private MaintenanceRequest maintenanceRequest;
    private boolean completed = false;
    private double cost;
    private String description;
    private Calendar date;

    public MaintenanceRequest getMaintenanceRequest() {
        return maintenanceRequest;
    }

    public void setMaintenanceRequest(MaintenanceRequest mr) {
        this.maintenanceRequest = mr;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int maintreqId) {
        this.id = maintreqId;
    }


    @Override
    public String toString()
    {
        return("Maintenance Information - Cost: " + getCost() +", Date: " + getDate() + ", Description: " + getDescription() + ", Is finished: " + completed + ", ID: " + getId());
    }
}
