/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Only useful method is the find doctors method, which lists all doctor user files for other operations
 *
 * @author Charlie Parsons
 */
        
public class Doctor extends User_Template {

    public String[] doctors;
    public File[] docArray;
    
    FileReader docReader;
    BufferedReader buffReader;
    
    public Doctor() {
    }
    
    public Doctor(String ID, String fName, String sName, String address, String password) {
        CreateUser("Doctor", fName, sName, address, password);
    }
    
    public String[] FindDoctors(){
        docArray = new File("Database/Users/Doctor/").listFiles();
        doctors = new String[docArray.length];
        try{
            for (int i = 0; i < docArray.length; i++){
                try{
                docReader = new FileReader(docArray[i]);
                BufferedReader buffReader = new BufferedReader(docReader);
                
                buffReader.readLine();
                doctors[i] = buffReader.readLine();
                doctors[i] += " " + buffReader.readLine();
                doctors[i] += " " + buffReader.readLine();
                buffReader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        finally{
            
        }
        
        return doctors;
    }
}
