package src.main.java.FacilitySystem;

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


    @Override
    public String toString()
    {
        return("Information:  cost: " + cost +" Date: " + date.getTimeInMillis() + " Description: " + description + " Is finished: " + completed + " ID: " + maintenanceRequest);
    }

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
}
