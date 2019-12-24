/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;

/**
 * Patient User
 *
 * @author Charlie Parsons
 */
        
public class Patient extends User_Template {

    public Patient() {
    }
    
    public Patient(String ID, String fName, String sName, String address) {
        
        setUserID(ID);
        setfName(fName);
        setlName(sName);
        setAddress(address);                
    }
    
    
}
