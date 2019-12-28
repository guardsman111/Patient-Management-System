/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;

/**
 * Administrator User
 *
 * @author Charlie Parsons
 */
        
public class Admin extends User_Template {

    public Admin() {
    }
    
    public Admin(String ID, String fName, String sName, String address, String password) {
        CreateUser("Admin", fName, sName, address, password);
    }
    
    
}
