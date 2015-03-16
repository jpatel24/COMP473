package src.main.java.FacilitySystem.view;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import src.main.java.FacilitySystem.*;
import src.main.java.FacilitySystem.service.FacilityService;
import src.main.java.FacilitySystem.service.MaintenanceService;
import sun.applet.Main;

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

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //FacilityService facilityService = new FacilityService();
        FacilityService facilityService = (FacilityService) context.getBean("facilityService");
        //MaintenanceService maintenanceService = new MaintenanceService();
        MaintenanceService maintenanceService = (MaintenanceService) context.getBean("maintenanceService");


        //Person person = new Person();
        Person person = (Person) context.getBean("person");
        person.setAge(23);
        person.setFirstName("Jeel");
        person.setLastName("Patel");


        //Facility facility1 = new Facility();
        Facility facility1 = (Facility) context.getBean("facility");
        facility1.setCost(700);
        facility1.setDescription("Admissons and Registras  ");
        facility1.setVacant(false);
        //facility1.setOwner(person);
       // facilityService.addFacility(facility1);


        Calendar calendar = new GregorianCalendar();


        //Use use = new Use();
        Use use = (Use) context.getBean("use");
        //use.setFacility(facility1);
        use.setUseDescription("Filing records");
        use.setId(2);
      //use.setStartDate(calendar.set(2004,5,13));



        //List<Maintenance> maintenanceList = new ArrayList<Maintenance>();
        List<Maintenance> maintenanceList = (ArrayList) context.getBean("maintenanceList");
        //MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
        MaintenanceRequest maintenanceRequest = (MaintenanceRequest) context.getBean("maintenanceRequest");
        maintenanceRequest.setFacility(facility1);
        maintenanceRequest.setCurrent(true);
        maintenanceRequest.setEstCost(50);
        maintenanceRequest.setMaintenances(maintenanceList);

        //Maintenance maintenance = new Maintenance();
        Maintenance maintenance = (Maintenance) context.getBean("maintenance");
        maintenance.setDescription("Leaky faucet");
        maintenance.setCost(300);
        maintenance.setMaintenanceRequest(maintenanceRequest);
        //maintenanceService.addMaintenance(maintenance,maintenanceRequest);

        //FacilityProblems facilityProblems = new FacilityProblems();
        FacilityProblems facilityProblems = (FacilityProblems) context.getBean("facilityProblems");
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
