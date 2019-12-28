/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;

/**
 * Secretary User
 *
 * @author Charlie Parsons
 */
        
public class Secretary extends User_Template {

    public Secretary() {
    }
    
    public Secretary(String fName, String sName, String address, String password) {
        CreateUser("Secretary", fName, sName, address, password);
    }
    
    
}
