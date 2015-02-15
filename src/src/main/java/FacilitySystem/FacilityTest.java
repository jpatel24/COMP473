package src.main.java.FacilitySystem;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Ti on 2/15/2015.
 */
public class FacilityTest {
    @Test
    public void testRequestAvailableCapacity() {
        Facility test = new Facility();
        int output = test.requestAvailableCapacity();
        assertNotEquals(0, output);

    }

    @Test
    public void testGetMaintenanceRequestList(){

    }

}
