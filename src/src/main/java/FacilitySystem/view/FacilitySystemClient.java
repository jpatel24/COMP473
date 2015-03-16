package src.main.java.FacilitySystem.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import src.main.java.FacilitySystem.*;
import src.main.java.FacilitySystem.model.*;
import src.main.java.FacilitySystem.service.FacilityService;
import src.main.java.FacilitySystem.service.MaintenanceService;
import src.main.java.FacilitySystem.dal.FacilityHibernateDAO;
import sun.applet.Main;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Jeel and Ethan on 2/14/15.
 */
public class FacilitySystemClient {

    public static void main(String[]args) throws Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        FacilityService facilityService = (FacilityService) context.getBean("facilityService");
        MaintenanceService maintenanceService = (MaintenanceService) context.getBean("maintenanceService");
        Person person = (Person) context.getBean("owner");

        person.setAge(23);
        person.setFirstName("Jeel");
        person.setLastName("Patel");

        Facility facility1 = (Facility) context.getBean("facility");
        facility1.setId(2);
        facility1.setCost(700);
        facility1.setDescription("Admissons and Registras  ");
        facility1.setVacant(false);
        facility1.setOwner(person);

        Use use = (Use) context.getBean("use");
        use.setFacility(facility1);
        use.setUseDescription("Filing records");
        use.setUseId(2);

        List<Maintenance> maintenanceList = (ArrayList<Maintenance>) context.getBean("maintenanceList");
        MaintenanceRequest maintenanceRequest = (MaintenanceRequest) context.getBean("maintenanceRequest");
        maintenanceRequest.setFacility(facility1);
        maintenanceRequest.setCurrent(true);
        maintenanceRequest.setEstCost(50);
        maintenanceRequest.setMaintenances(maintenanceList);

        Maintenance maintenance = (Maintenance) context.getBean("maintenance");
        maintenance.setDescription("Leaky faucet");
        maintenance.setCost(300);
        maintenance.setMaintenanceRequest(maintenanceRequest);

        FacilityProblems facilityProblems = (FacilityProblems) context.getBean("facilityProblems");
        facilityProblems.setDescription("heater broken");
        facilityProblems.setCurrent(false);
        facilityProblems.setFacility(facility1);

        facilityService.addFacility(facility1);
        maintenanceService.addMaintenance(maintenance);
        //facilityService.addUse(use,facility1);
        //facilityService.addMaintenanceRequest(maintenanceRequest,facility1);
    }
}
