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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * Checks user ID's list exists and creates it if not.
 * Checks whether User ID's already exist to prevent duplicate account creation
 * 
 * @author Charlie Parsons
 */
public class IDCheck {

    public IDCheck() {
    }
    
    public Boolean CheckIDDuplicate(String ID){
        
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
        
        try {
            FileReader reader = new FileReader("Database/Users/UserIDList.txt");
            BufferedReader buffReader = new BufferedReader(reader);
            
            String tempLine;
            tempLine = buffReader.readLine();
            while(tempLine != null){
                if (tempLine.equals(ID)){
                    return false;
                }
                else {
                    tempLine = buffReader.readLine();
                }
            }
            buffReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
         return true;
    }
}
