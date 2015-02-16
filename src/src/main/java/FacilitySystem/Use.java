package src.main.java.FacilitySystem;
import java.util.Calendar;
/**
 * Created by Ti on 2/5/2015.
 */
public class Use {
    private Calendar StartDate;
    private Calendar EndDate;
    private String useDescription;
    private int id;
    private Facility facility;

    public Facility getFacility(){
        return facility;
    }

    public void setFacility(Facility facility){
        this.facility=facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getStartDate() {
        return StartDate;
    }

    public void setStartDate(Calendar startDate) {
        StartDate = startDate;
    }

    public Calendar getEndDate() {
        return EndDate;
    }

    public void setEndDate(Calendar endDate) {
        EndDate = endDate;
    }

    public String getUseDescription() {
        return useDescription;
    }

    public void setUseDescription(String useDescription) {
        this.useDescription = useDescription;
    }



    public String toString() {
        return ("Use Information - " + "ID: " + id + ", Facility: " + getFacility() + ", Description: " + getUseDescription() + ", Start Date: "+ getStartDate() + ", End Date: " + getEndDate());
    }
}
