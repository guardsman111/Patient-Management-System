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
 * @author Charlie Parsons
 */
public class NewUserOperationsTest {
    
    public NewUserOperationsTest() {
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
    public void FirstUseTest(){
        System.out.println("DoingFirstStartup");
        NewUserOperations instance = new NewUserOperations();
        Boolean Request = instance.CheckForRequest();
        System.out.println(Request);
    }

    /**
     * Test of CreateRequest method, of class NewUserOperations.
     */
    @Test
    public void testCreateRequest() {
        System.out.println("CreateRequest");
        String fName = "Test";
        String lName = "Bro";
        String address = "Dont";
        int age = 0;
        String gender = "Hurt";
        String password = "Me";
        NewUserOperations instance = new NewUserOperations();
        instance.CreateRequest(fName, lName, address, age, gender, password);
    }
    
    @Test
    public void AcceptRequest(){
        System.out.println("AcceptingRequest");
        NewUserOperations instance = new NewUserOperations();
        Boolean Request = instance.CheckForRequest();
        System.out.println("Request Checked");
        instance.CreateRequest("Charlie", "Parsons", "address", 0, "gender", "password");
        System.out.println(Request);
        instance.UpdateList();
        System.out.println(instance.DisplayRequest());
        instance.ActionRequest(true);
        System.out.println(instance.reqArray[0]);
        instance.NextRequest("Next");
        instance.ActionRequest(true);
        
    }
}