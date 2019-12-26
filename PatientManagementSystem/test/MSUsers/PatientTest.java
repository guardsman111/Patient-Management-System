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
public class PatientTest {
    
    public PatientTest() {
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
    public void testCreatePatient() {
        // TODO review the generated test code and remove the default call to fail.
        Patient test1 = new Patient("Harry", "Parsons", "Plymouth", 21, "Male", "Password");
        Patient test2= new Patient("Alan", "Dane", "Kent", 35, "Male", "Password");
        Patient test3 = new Patient("Francis", "Dane", "Kent", 35, "Female", "Password");
        
        
    }    
}
