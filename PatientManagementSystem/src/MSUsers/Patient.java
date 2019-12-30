/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MSUsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import MSUsers.IDCheck;

/**
 * Patient User
 *
 * @author Charlie Parsons
 */
        
public class Patient extends User_Template {

    private Integer age;
    private String gender;
    
    private FileWriter writer;
    private BufferedWriter buffWriter; 
    
    public Patient() {
    }
    
    public Patient(String ID, String password) {
        setUserID(ID);
        setPassword(password);
        
        try{
        Path path = Paths.get("Database/Users/Patients/" + getUserID() + ".txt");
        Files.createDirectories(path.getParent());
        Files.createFile(path);
        writer = new FileWriter("Database/Users/Patients/" + getUserID() + ".txt",true);
        buffWriter = new BufferedWriter(writer);
        buffWriter.write(password);
        buffWriter.newLine();

        buffWriter.close();

        FileWriter writer = new FileWriter("Database/Users/UserIDList.txt", true);
        BufferedWriter buffWriter = new BufferedWriter(writer);
            
        buffWriter.write(getUserID());
        buffWriter.newLine();
        buffWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Patient(String fName, String sName, String address, Integer tAge, String tGender, String password) {
        
        String TempID = GenerateID();
        setUserID(TempID);
        setfName(fName);
        setlName(sName);
        setAddress(address);          
        setAge(tAge);
        setGender(tGender);
        setPassword(password);
        
        try{
        Path path = Paths.get("Database/Users/Patients/" + getUserID() + ".txt");
        Files.createDirectories(path.getParent());
        Files.createFile(path);
        writer = new FileWriter("Database/Users/Patients/" + getUserID() + ".txt",true);
        buffWriter = new BufferedWriter(writer);
        buffWriter.write(password);
        buffWriter.newLine();
        buffWriter.write(fName);
        buffWriter.newLine();
        buffWriter.write(sName);
        buffWriter.newLine();
        buffWriter.write(address);
        buffWriter.newLine();
        buffWriter.write(Integer.toString(tAge));
        buffWriter.newLine();
        buffWriter.write(tGender);
        buffWriter.newLine();
        buffWriter.close();

        FileWriter writer = new FileWriter("Database/Users/UserIDList.txt", true);
        BufferedWriter buffWriter = new BufferedWriter(writer);
            
        buffWriter.write(getUserID());
        buffWriter.newLine();
        buffWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public String GenerateID(){
        IDCheck Checker = new IDCheck();
        Boolean original = false;
        String ID = null;
        while(original == false){
            int x = (int)(Math.random()*((9999-1000)+1))+1000;
            ID = Integer.toString(x);
            ID = "P" + ID;
            original = Checker.CheckIDDuplicate(ID);
        }
        return ID;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
