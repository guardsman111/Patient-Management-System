/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
 * @author Charlie
 */
public class Appointment {
    
    private String reason;
    private String doctorName;
    private int dayDate;
    private String monthDate;
    private int yearDate;
    
    private FileWriter writer;
    private BufferedWriter buffWriter; 

    public Appointment() {
    }
    
    public Appointment(String nReason, String doc, int day, String month, int year, String patientID) {
        
        String TempID = GenerateID(patientID);
        
        try{
        Path path = Paths.get("Database/Appointments/Patients/" + patientID + "/Appointment" + TempID + ".txt");
        Files.createDirectories(path.getParent());
        Files.createFile(path);
        writer = new FileWriter("Database/Appointments/Patients/" + patientID + "/Appointment" + TempID + ".txt",true);
        buffWriter = new BufferedWriter(writer);
        buffWriter.write(nReason);
        buffWriter.newLine();
        buffWriter.write(doc);
        buffWriter.newLine();
        buffWriter.write(Integer.toString(day));
        buffWriter.newLine();
        buffWriter.write(month);
        buffWriter.newLine();
        buffWriter.write(Integer.toString(year));
        buffWriter.newLine();
        buffWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public String GenerateID(String patient){
        
        String ID;
        
        try{
            File check = new File("Database/Appointments/Patients/" + patient + "/Appointment0.txt");
            Path newReqPath = Paths.get("Database/Appointments/Patients/" + patient + "/Appointment0.txt");
            Files.createDirectories(newReqPath.getParent());
            int count = 0;
            boolean exists = true;
            while(exists){
                check = new File("Database/Appointments/Patients/" + patient + "/Appointment" + Integer.toString(count) + ".txt");
                if (!check.exists()){
                    ID = Integer.toString(count);
                    exists = false;
                    return ID;
                } else {
                    count += 1;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        ID = "100";
        return ID;
    }
}
