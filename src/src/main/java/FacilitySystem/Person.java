package src.main.java.FacilitySystem;
import java.util.*;
/**
 * Created by Ti on 2/5/2015.
 *
 * Helper class to define a person. list of facilities owned or rented.
 */
public class Person {

    public Person(){}


    private int id;
    private List<Facility>facilitiesOwned;
    private List<Facility>facilitiesRented;
    private int age;
    private String firstName;
    private String lastName;

    public List<Facility> getFacilitiesOwned() {
        return facilitiesOwned;
    }
    public void setFacilitiesOwned(List<Facility> facilitiesOwned) {
        this.facilitiesOwned = facilitiesOwned;
    }

    public List<Facility> getFacilitiesRented() {
        return facilitiesRented;
    }

    public void setFacilitiesRented(List<Facility> facilitiesRented) {
        this.facilitiesRented = facilitiesRented;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addRentedFacility(Facility f){
        facilitiesRented.add(f);
        f.setRenter(this);
    }

    public void addOwnedFacility(Facility f){
        facilitiesOwned.add(f);
        f.setOwner(this);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ("Person Information - FirstName: " + getFirstName() +", " + "LastName: " + getLastName() + ", "+ "Age: " + getAge() );
    }

}
