package src.main.java.FacilitySystem.view;

import src.main.java.FacilitySystem.Facility;
import src.main.java.FacilitySystem.Person;
import src.main.java.FacilitySystem.service.FacilityService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Jeel on 2/14/15.
 */
public class FacilitySystemClient {

    public static void main(String[]args) throws Exception{

        Person person = new Person();
        person.setAge(23);
        person.setFirstName("Jeel");
        person.setLastName("Patel");

        Facility facility1 = new Facility();
        facility1.setCost(700);
        facility1.setDescription("Recreation");
        facility1.setVacant(false);
        facility1.setOwner(person);

        System.out.println(person);
        System.out.println(facility1);

        FacilityService facilityService = new FacilityService();
        facilityService.getFacilities();

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FacilitySystem","root","jeelpatel");
        PreparedStatement statement = connection.prepareStatement("SELECT * from person");

        ResultSet set = statement.executeQuery();

        while(set.next())
        {
            System.out.println(set.getString(4)+ " "+ set.getString(5)+ " "+set.getString(6));
        }
    }
}
