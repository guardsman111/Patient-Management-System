/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIProcesses;

import MSUsers.Patient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
public class LoginPressTest {
    
    public LoginPressTest() {
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
     * Test of Login method, of class LoginPress.
     */
    @Test
    public void testLogin() {
        System.out.println("Login");
        Patient tempP = new Patient("PasswordTest", "PasswordTest");
        String enteredID = "PasswordTest";
        String enteredPass = "PasswordTest";
        LoginPress instance = new LoginPress();
        instance.Login(enteredID, enteredPass);
    }

    /**
     * Test of CheckPassword method, of class LoginPress.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("CheckPassword");
        BufferedReader buffReader = null;
        try{
        buffReader = new BufferedReader(new FileReader("Database/Users/Patients/PasswordTest.txt"));
        String ePassword = "PasswordTest";
        LoginPress instance = new LoginPress();
        Boolean expResult = true;
        Boolean result = instance.CheckPassword(buffReader, ePassword);
        buffReader.close();
        assertEquals(expResult, result);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
