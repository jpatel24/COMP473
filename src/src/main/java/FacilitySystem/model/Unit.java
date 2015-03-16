package src.main.java.FacilitySystem.model;

/**
 * Created by Jeel on 3/15/15.
 */
public class Unit {
    String unitName;
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getId() {
        return id;
    }

    public String getUnitName() {
        return unitName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
