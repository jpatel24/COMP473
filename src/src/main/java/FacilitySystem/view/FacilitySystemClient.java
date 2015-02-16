package src.main.java.FacilitySystem.view;

import src.main.java.FacilitySystem.*;
import src.main.java.FacilitySystem.service.FacilityService;
import src.main.java.FacilitySystem.service.MaintenanceService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Jeel on 2/14/15.
 */
public class FacilitySystemClient {

    public static void main(String[]args) throws Exception{

        FacilityService facilityService = new FacilityService();
        MaintenanceService maintenanceService = new MaintenanceService();
        Person person = new Person();
        person.setAge(23);
        person.setFirstName("Jeel");
        person.setLastName("Patel");

        Facility facility1 = new Facility();
        facility1.setCost(700);
        facility1.setDescription("Admissons and Registras  ");
        facility1.setVacant(false);
        facility1.setOwner(person);
       // facilityService.addFacility(facility1);


        Calendar calendar = new GregorianCalendar();
        Use use = new Use();
        use.setFacility(facility1);
        use.setUseDescription("Filing records");
       // use.setStartDate(calendar.set(2004,5,13));
        use.setId(2);

        List<Maintenance> maintenanceList = new ArrayList<Maintenance>();
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
        maintenanceRequest.setFacility(facility1);
        maintenanceRequest.setCurrent(true);
        maintenanceRequest.setEstCost(50);
        maintenanceRequest.setMaintenances(maintenanceList);

        Maintenance maintenance = new Maintenance();
        maintenance.setDescription("Leaky faucet");
        maintenance.setCost(300);
        maintenance.setMaintenanceRequest(maintenanceRequest);
        //maintenanceService.addMaintenance(maintenance,maintenanceRequest);

        FacilityProblems facilityProblems = new FacilityProblems();
        facilityProblems.setDescription("heater broken");
        facilityProblems.setCurrent(false);
        facilityProblems.setFacility(facility1);


        System.out.println(person);
        System.out.println(facility1);
        System.out.println(maintenance);
        System.out.println(maintenanceRequest);
        System.out.println(use);
        System.out.println(maintenanceRequest);
        System.out.println(facilityProblems);


       // FacilityService facilityService1 = new FacilityService();
        //facilityService1.getFacilities();

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
