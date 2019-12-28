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
public class IDCheckTest {
    
    public IDCheckTest() {
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
     * Test of CheckIDDuplicate method, of class IDCheck.
     */
    @Test
    public void testCheckIDDuplicate() {
        System.out.println("CheckIDDuplicate");
        
        Patient test4 = new Patient("Test",  "Test");
        
        String ID = "Test";
        IDCheck instance = new IDCheck();
        Boolean expResult = false;
        Boolean result = instance.CheckIDDuplicate(ID);
        assertEquals(expResult, result);
    }
    
}
