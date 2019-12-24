/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;

/**
 * Doctor User
 *
 * @author Charlie Parsons
 */
        
public class Doctor extends User_Template {

    public Doctor() {
    }
    
    public Doctor(String ID, String fName, String sName, String address) {
        
        setUserID(ID);
        setfName(fName);
        setlName(sName);
        setAddress(address);                
    }
    
    
}
