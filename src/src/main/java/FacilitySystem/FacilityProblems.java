package src.main.java.FacilitySystem;

import java.util.Calendar;


/**
 * Created by Jeel on 2/9/15.
 */
public class FacilityProblems {
    private int id;
    private String description;
    private boolean current;
    private Calendar date;
    private Facility facility;

    @Override
    public String toString()
    {
        return("Information: ID: "+ id +" Description: " + description+ " Is in use: " + current + " Date: " + date.getTimeInMillis() + " Facility: "+ facility);
    }
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


}
