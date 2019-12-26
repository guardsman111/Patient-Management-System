/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import GUIs.Login;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Charlie Parsons
 */
public class PatientManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login LoginScreen = new Login();
        LoginScreen.setVisible(true);
        
        try{
            File tempFile = new File("Database/Users/UserIDList.txt");
            if(!tempFile.exists()){
                Path path = Paths.get("Database/Users/UserIDList.txt");
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
