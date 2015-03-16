package src.main.java.FacilitySystem.Tests;

import org.junit.Test;
import src.main.java.FacilitySystem.model.Facility;
import src.main.java.FacilitySystem.model.FacilityMaintenance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ethan on 2/16/2015.
 */

public class FacilityMaintenanceTests {

    @Test
    public void testListMaintRequests(){
        Facility facility = new Facility();
        FacilityMaintenance fMaint = new FacilityMaintenance();
        List<FacilityMaintenance> list = new ArrayList<FacilityMaintenance>();
        list.add(fMaint);

        assertEquals(1, list.size());
    }
}
