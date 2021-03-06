/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIProcesses;

import GUIs.SecretaryHome;
import MSUsers.Patient;
import Main.Appointment;
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
 * Inherits from request interface and allows interaction with requests and doctor/patient appointments
 * 
 * @author Charlie
 */
public class NewAppointmentOperations implements RequestInterface{

    private int pending;
    public File[] reqArray;
    private int currentReq = 1;
    private String[] newAppointment;
    
    private File currentReqF = null;
    
    private SecretaryHome sGUI = null;
    
    FileReader requestReader;
    
    FileWriter requestWriter;
    
    FileWriter appointmentWriter;
    
    public void NewAppointmentOperations(){
        
    }
    
    public void UpdateList(){
        reqArray = new File("Database/Requests/Appointments").listFiles();
        pending = reqArray.length - 1;
        
        if (currentReq != reqArray.length){
            if (currentReq < reqArray.length){
                if (currentReq == 1){
                    DisplayFirstReq();
                }
            }
            else if (currentReq > reqArray.length){     
            }
        }
    }
    
    public void DisplayFirstReq(){
        newAppointment = new String[6];
        
        try{
            File check = reqArray[1];
            
            requestReader = new FileReader(check);
            BufferedReader buffReader = new BufferedReader(requestReader);
            for(int i = 0; i < newAppointment.length; i++){
                newAppointment[i] = buffReader.readLine();
            }
            currentReqF = check;
            buffReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean CheckForRequest() {
        try{
            if(Files.list(Paths.get("Database/Requests/Appointments")).findAny().isPresent()){
                UpdateList();
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

    @Override
    public void NextRequest(String Direction) {
        newAppointment = new String[6];
        
        
        try{
            File check = new File("");
            if ((Direction.equals("Prev")) && (currentReq > 0)){
                currentReq -= 1;
                check = reqArray[currentReq];
            } 
            else  {
                currentReq += 1;
                if (currentReq < reqArray.length){
                    check = reqArray[currentReq];
                }
            }
            
            requestReader = new FileReader(check);
            BufferedReader buffReader = new BufferedReader(requestReader);
            for(int i = 0; i < newAppointment.length; i++){
                newAppointment[i] = buffReader.readLine();
            }
            currentReqF = check;
            buffReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String DisplayRequest() {
        
        String newString = "";

        for(int i = 0; i < newAppointment.length; i++){
            newString += newAppointment[i] + "\n";
        }
            
        return newString;
    }
    
    public String DisplayRequest(String part) {
        
        String newString = "";
        
        if (part.equals("Name")){
            newString = newAppointment[5];
        } else if (part.equals("Doctor")){
            newString = newAppointment[1];
        } else if (part.equals("Date")){
            newString = newAppointment[2] + "/" + newAppointment[3] + "/" + newAppointment[4];
        }
            
        return newString;
    }
    
    public void CreateRequest(String patientID, String reason, String doctorID, int day, String month, int year){
        
        try{
            File check = new File("Database/Requests/Appointments/Request0.txt");
            Path newReqPath = Paths.get("Database/Requests/Appointments/Request0.txt");
            Files.createDirectories(newReqPath.getParent());
            int count = 0;
            boolean exists = true;
            while(exists){
                check = new File("Database/Requests/Appointments/Request" + Integer.toString(count) + ".txt");
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
            buffWriter.write(reason);
            buffWriter.newLine();
            buffWriter.write(doctorID);
            buffWriter.newLine();
            buffWriter.write(Integer.toString(day));
            buffWriter.newLine();
            buffWriter.write(month);
            buffWriter.newLine();
            buffWriter.write(Integer.toString(year));
            buffWriter.newLine();
            buffWriter.write(patientID);
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
            currentReqF.delete();
            UpdateList();
            currentReq -= 1;
            String tempDate = newAppointment[2] + "-" + newAppointment[3] + "-" + newAppointment[4];
            try{
                Path path = Paths.get("Database/Users/Doctor/" + newAppointment[1]);
                Files.createDirectories(path.getParent());
                int randomID = (int)(Math.random()*((99-10)+1))+10;
                path = Paths.get("Database/Users/Doctor/" + newAppointment[1] + "/" + tempDate  + newAppointment[5] + randomID + ".txt");
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                requestWriter = new FileWriter("Database/Users/Doctor/" + newAppointment[1] + "/" + tempDate + newAppointment[5] + randomID + ".txt");
                BufferedWriter buffWriter = new BufferedWriter(requestWriter);
                buffWriter.write(newAppointment[5]);
                buffWriter.newLine();
                buffWriter.write(newAppointment[0]);
                buffWriter.newLine();
                buffWriter.close();
                
                path = Paths.get("Database/Appointments/Patients/" + newAppointment[5]);
                Files.createDirectories(path.getParent());
                randomID = (int)(Math.random()*((99-10)+1))+10;
                path = Paths.get("Database/Appointments/Patients/" + newAppointment[5] + "/" + tempDate  + newAppointment[1] + ".txt");
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                requestWriter = new FileWriter("Database/Appointments/Patients/" + newAppointment[5] + "/" + tempDate + newAppointment[1] + ".txt");
                buffWriter = new BufferedWriter(requestWriter);
                buffWriter.write(newAppointment[5]);
                buffWriter.newLine();
                buffWriter.write(newAppointment[0]);
                buffWriter.newLine();
                buffWriter.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
        } else {
            currentReqF.delete();
        }
    }
    
    public boolean GetEndOfList(){
        if (reqArray == null){
            return true;
        }
        else if (currentReq < reqArray.length -1){
            return false;
        } else {
            return true;
        }
    }
    
    public void SetGUI(SecretaryHome GUI){
        sGUI = GUI;
    }

    public int getCurrentReq() {
        return currentReq;
    }

    public int getPending() {
        return pending;
    }
    
}
