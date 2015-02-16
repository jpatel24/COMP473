package src.main.java.FacilitySystem.Tests;

import org.junit.Test;
import src.main.java.FacilitySystem.Facility;
import src.main.java.FacilitySystem.Person;
import src.main.java.FacilitySystem.view.FacilitySystemClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ethan on 2/16/2015.
 */
public class PersonTests {

    @Test
    public void testGetFacilitiesRented(){
        Facility facility = new Facility();
        List<Facility> facilitiesRented = new ArrayList<Facility>();
        facilitiesRented.add(facility);

        assertEquals(1, facilitiesRented.size());
    }

    @Test
    public void testGetAge(){
        Person person = new Person();
        person.setAge(21);

        assertEquals(21, person.getAge());
    }

    @Test
    public void testGetFirstName(){
        Person person = new Person();
        person.setFirstName("bob");

        assertEquals("bob", person.getFirstName());
    }

    @Test
    public void testGetLastName(){
        Person person = new Person();
        person.setLastName("bo");

        assertEquals("bo", person.getLastName());
    }

    @Test
    public void testAddRentedFacility(){
        Facility facility = new Facility();
        List<Facility> facilitiesRented = new ArrayList<Facility>();
        facilitiesRented.add(facility);

        assertEquals(1, facilitiesRented.size());
    }

    public void testAddOwnedFacility(){
        Facility facility = new Facility();
        List<Facility> facilitiesOwned = new ArrayList<Facility>();
        Person owner = new Person();
        owner.setFirstName("bob");
        facilitiesOwned.add(facility);

        assertEquals(1, facilitiesOwned.size());
        assertEquals("bob", owner.getFirstName());

    }
}
