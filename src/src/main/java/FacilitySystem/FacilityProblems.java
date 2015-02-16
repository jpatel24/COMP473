package src.main.java.FacilitySystem;

import java.util.Calendar;


/**
 * Created by Jeel on 2/9/15.
 * Helper class to define a facility problem with a basic description.
 */
public class FacilityProblems {
    private int id;
    private String description;
    private boolean current;
    private Calendar date;
    private Facility facility;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCurrent() {
        return current;
    }
    public void setCurrent(boolean current) {
        this.current = current;
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

    @Override
    public String toString()
    {
        return("Facility Problems - ID: "+ getId() +", Description: " + getDescription()+ ", Is in use: " + current + ", Date: " + getDate() + ", Facility: "+ getFacility());
    }


}
