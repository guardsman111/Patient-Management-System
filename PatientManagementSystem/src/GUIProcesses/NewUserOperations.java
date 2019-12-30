/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIProcesses;

import GUIs.SecretaryHome;
import MSUsers.Patient;
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
 *
 * @author Charlie Parsons
 */
public class NewUserOperations implements RequestInterface {

    private int pending;
    private File[] reqArray;
    private int currentReq = 0;
    private String[] newPatient;
    
    private SecretaryHome sGUI = null;
    
    FileReader requestReader;
    
    FileWriter requestWriter;
    
    public void NewUserOperations(){
        
    }
    
    public void UpdateList(){
        reqArray = new File("Database/Requests").listFiles();
        if (currentReq != reqArray.length){
            if (currentReq < reqArray.length){
                if (currentReq == 0){
                    DisplayFirstReq();
                }
                currentReq = reqArray.length;
            }
            else if (currentReq > reqArray.length){
                currentReq = reqArray.length;                
            }
        }
    }
    
    public void DisplayFirstReq(){
        newPatient = new String[6];
        
        try{
            File check = reqArray[0];
            
            requestReader = new FileReader(check);
            BufferedReader buffReader = new BufferedReader(requestReader);
            for(int i = 0; i < newPatient.length; i++){
                newPatient[i] = buffReader.readLine();
            }
            buffReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
    @Override
    public boolean CheckForRequest() {
        try{
            if(Files.list(Paths.get("Database/Requests")).findAny().isPresent()){
                return true;
            }
            else {
                return false;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
    //Direction refers to how it is travelling accross the list - i.e. next is +1 request, 
    //or down the list, previous is -1 request, or up the list.
    @Override
    public void NextRequest(String Direction) {
        newPatient = new String[6];
        
        
        try{
            File check = new File("Database/Requests/Request0.txt");
            if ((Direction.equals("Prev")) && (currentReq != 0)){
                currentReq -= 1;
                check = reqArray[currentReq];
            } 
            else  {
                currentReq += 1;
                if (currentReq <= reqArray.length){
                    check = reqArray[currentReq];
                }
            }
            
            requestReader = new FileReader(check);
            BufferedReader buffReader = new BufferedReader(requestReader);
            for(int i = 0; i < newPatient.length; i++){
                newPatient[i] = buffReader.readLine();
            }
            buffReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        DisplayRequest(newPatient);
    }

    @Override
    public String DisplayRequest(String[] array) {
        
        String newString = "";

        for(int i = 0; i < newPatient.length; i++){
            newString += newPatient[i] + "\n";
        }
            
        return newString;
    }
    
    @Override
    public void CreateRequest(String fName, String lName, String address, int age, String gender, String password){
        
        try{
            File check = new File("Database/Requests/Request0.txt");
            Path newReqPath = Paths.get("Database/Requests/Request0.txt");
            Files.createDirectories(newReqPath.getParent());
            int count = 0;
            boolean exists = true;
            while(exists){
                check = new File("Database/Requests/Request" + Integer.toString(count) + ".txt");
                if (!check.exists()){
                    newReqPath = check.toPath();
                    exists = false;
                } else {
                    count += 1;
                }
            }
            UpdateList();
            
            Files.createFile(newReqPath);
            requestWriter = new FileWriter(check);
            BufferedWriter buffWriter = new BufferedWriter(requestWriter);
            buffWriter.write(password);
            buffWriter.newLine();
            buffWriter.write(fName);
            buffWriter.newLine();
            buffWriter.write(lName);
            buffWriter.newLine();
            buffWriter.write(address);
            buffWriter.newLine();
            buffWriter.write(Integer.toString(age));
            buffWriter.newLine();
            buffWriter.write(gender);
            buffWriter.newLine();
            buffWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void ActionRequest(boolean action) {
        if (action){
            Patient tempP = new Patient(newPatient[1],newPatient[2],newPatient[3],Integer.parseInt(newPatient[4]),newPatient[5],newPatient[0]);
        }
    }
    
    public void GetGUI(SecretaryHome GUI){
        sGUI = GUI;
    }
    
}
