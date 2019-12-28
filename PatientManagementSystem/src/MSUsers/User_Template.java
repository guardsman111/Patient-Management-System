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
        
    private FileWriter writer;
    private FileReader reader;
    private BufferedWriter buffWriter;
    private BufferedReader buffReader;
    
    public void CreateUser(String type, String gName, String sName, String nAddress, String nPassword){    
        
        userID = GenerateID(type);
        fName = gName;
        lName = sName;
        address = nAddress;
        password = nPassword;
        
        try{
        Path path = Paths.get("Database/Users/" + type + "/" + getUserID() + ".txt");
        Files.createDirectories(path.getParent());
        Files.createFile(path);
        writer = new FileWriter("Database/Users/" + type + "/" + getUserID() + ".txt",true);
        buffWriter = new BufferedWriter(writer);
        buffWriter.write(password);
        buffWriter.newLine();
        buffWriter.write(fName);
        buffWriter.newLine();
        buffWriter.write(lName);
        buffWriter.newLine();
        buffWriter.write(address);
        buffWriter.newLine();
        buffWriter.close();

        FileWriter writer = new FileWriter("Database/Users/UserIDList.txt", true);
        BufferedWriter buffWriter = new BufferedWriter(writer);
            
        buffWriter.write(getUserID());
        buffWriter.newLine();
        buffWriter.close();
        
        reader = new FileReader("Database/Users/" + type + "/" + getUserID() + ".txt");
        buffReader = new BufferedReader(reader); 
        buffReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


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
    
    public String GenerateID(String type){
        IDCheck Checker = new IDCheck();
        char preface = 'E';
        Boolean original = false;
        String ID = null;
        while(original == false){
            int x = (int)(Math.random()*((9999-1000)+1))+1000;
            ID = Integer.toString(x);
            if (type == "Secretary"){
                preface = 'S';
            } 
            else if (type == "Doctor") {
                preface = 'D';
            }
            else if (type == "Admin") {
                preface = 'A';
            }
            ID = preface + ID;
            original = Checker.CheckIDDuplicate(ID);
        }
        return ID;
    }
    
}
