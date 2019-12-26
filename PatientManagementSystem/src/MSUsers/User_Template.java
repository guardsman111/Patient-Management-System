/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Template class for all user types
 * 
 * 
 * @author Charlie Parsons
 */
public class User_Template {
    
    private String userID;
    
    private String fName;
    private String lName;
    private String address;
    private String password;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String UserID) {
        this.userID = UserID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String GenerateID(){
        return userID;
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
                if (tempLine == ID){
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
