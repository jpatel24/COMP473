package src.main.java.FacilitySystem.Tests;

import junit.framework.Assert;
import org.junit.Test;
import src.main.java.FacilitySystem.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ethan on 2/15/2015.
 */
public class FacilityTests {

    @Test
    public void testAddFacilityDetail() {
        Facility facility = new Facility();
        facility.setCost(100);
        facility.setVacant(true);
        facility.setDescription("blue");

        assertEquals(100, facility.getCost(), 0);
        assertEquals(true, facility.isVacant());
        assertEquals("blue", facility.getDescription());
    }

    @Test
    public void testRemoveFacility(){
        Facility facility = new Facility();
        List<Facility> list = new ArrayList<Facility>();
        facility.setId(1234);
        list.add(facility);
        list.remove(facility);

        assertEquals(0, list.size());
    }

    @Test
    public void testGetId(){
        Facility facility = new Facility();
        facility.setId(1234);

        assertEquals(1234, facility.getId());
    }

    @Test
    public void testGetFacilityUse(){
        Facility facility = new Facility();
        Use use = new Use();
        List<Use> facilityUse = new ArrayList<Use>();
        facility.setFacilityUse(facilityUse);
        facilityUse.add(use);

        assertEquals(1, facilityUse.size());
    }

    @Test
    public void testAddMaintenanceRequest(){
        Facility facility = new Facility();
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
        List<MaintenanceRequest> maintenanceList = new ArrayList<MaintenanceRequest>();
        maintenanceList.add(maintenanceRequest);

        assertEquals(1, maintenanceList.size());
    }

    @Test
    public void testGetCost(){
        Facility facility = new Facility();
        facility.setCost(123);

        assertEquals(123, facility.getCost(), 0);
    }

    @Test
    public void testGetDescription(){
        Facility facility = new Facility();
        facility.setDescription("123");

        assertEquals("123", facility.getDescription());
    }

    @Test
    public void testSetVacant(){
        Facility facility = new Facility();
        facility.setVacant(true);

        assertEquals(true, facility.isVacant());
    }

    @Test
    public void testGetFacilityInformation(){
        Person owner = new Person();
        owner.setFirstName("bob");

        Facility facility = new Facility();
        facility.setId(123);
        facility.setCost(100.0f);
        facility.setVacant(true);
        facility.setDescription("blue");

        assertEquals("Facility Information - " + "ID: " + 123 + ", Cost: " + 100.0f + ", Vacant: " + true + ", Description: "+ "blue" + ", Owner: " + "bob", "Facility Information - " + "ID: " + facility.getId() + ", Cost: " + facility.getCost() + ", Vacant: " + facility.isVacant() + ", Description: "+ facility.getDescription() + ", Owner: " + owner.getFirstName());
    }

    public void testGetFacilityId(){
        Facility facility = new Facility();
        facility.setId(123);

        assertEquals(123, facility.getId());
    }

    public void testAddNewFacility(){
        Facility facility = new Facility();
        List<Facility> list = new ArrayList<Facility>();
        list.add(facility);

        assertEquals(1, list.size());
    }

    public void testGetFacilityProblemsList(){
        FacilityProblems facilityProblems = new FacilityProblems();
        List<FacilityProblems> fproblems = new ArrayList<FacilityProblems>();
        fproblems.add(facilityProblems);

        assertEquals(facilityProblems, fproblems.get(0));
    }

    public void testAddFacilityProblem(){
        FacilityProblems facilityProblems = new FacilityProblems();
        List<FacilityProblems> fproblems = new ArrayList<FacilityProblems>();
        fproblems.add(facilityProblems);

        assertEquals(1, fproblems.size());
    }

    public void testGetOwner(){
        Person owner = new Person();
        owner.setFirstName("bob");
        owner.setLastName("smith");

        assertEquals("bob", owner.getFirstName());
        assertEquals("smith", owner.getLastName());
    }

    public void testGetRenter(){
        Person renter = new Person();
        renter.setFirstName("jane");
        renter.setLastName("doe");

        assertEquals("jane", renter.getFirstName());
        assertEquals("doe", renter.getLastName());
    }

}
