/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;

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
public class User_TemplateTest {
    
    public User_TemplateTest() {
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

    /**
     * Test of CreateUser method, of class User_Template.
     */
    @Test
    public void testCreateUser() {
        System.out.println("CreateUser");
        String type = "Secretary";
        String gName = "Secretary";
        String sName = "Of State";
        String nAddress = "White House";
        String nPassword = "Password";
        User_Template instance = new User_Template();
        instance.CreateUser(type, gName, sName, nAddress, nPassword);
        String result = instance.getAddress();
        String expResult = "White House";
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GenerateID method, of class User_Template.
     */
    @Test
    public void testGenerateID_String() {
        System.out.println("GenerateID");
        String type = "Doctor";
        User_Template instance = new User_Template();
        String tempID = instance.GenerateID(type);
        char expResult = 'D';
        char result = tempID.charAt(0);
        assertEquals(expResult, result);
    }
    
    @Test
    public void GenerateTestUsers(){
        User_Template tempUT = new User_Template();
        Doctor tempD = new Doctor("Doctor", "Doctor", "Jones", "Plymouth", "Password");
        Admin tempA = new Admin("Admin", "Admin", "Five Finger", "Plymouth", "Password");
    }
}
