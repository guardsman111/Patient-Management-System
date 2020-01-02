/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIProcesses;

import GUIs.SecretaryHome;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Charlie
 */
public class NewAppointmentOperationsTest {
    
    public NewAppointmentOperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCreateRequest() {
        System.out.println("CreateRequest");
        String reason = "Im Ill";
        String doctor = "Doctor Jones";
        int day = 1;
        String month = "July";
        int year = 2020;
        String patient = "P1234";
        NewAppointmentOperations instance = new NewAppointmentOperations();
        instance.CreateRequest(patient, reason, doctor, day, month, year);
    }

    @Test
    public void testActionRequest() {
        System.out.println("ActionRequest");
        boolean action = true;
        NewAppointmentOperations instance = new NewAppointmentOperations();
        instance.CreateRequest("P1234","I Have a cold", "Doctor May", 13, "January", 2020);
        Boolean Request = instance.CheckForRequest();
        System.out.println(Request);
        instance.UpdateList();
        System.out.println(instance.DisplayRequest());
        instance.ActionRequest(action);
    }
    
}
