/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIProcesses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Action caused by pressing login, checks the usersID to password to allow for login. 
 * Separated it from main login code to try create a more secure login
 *
 * @author Charlie Parsons
 */
public class LoginPress {

    public LoginPress() {
    }
    
    
    public Boolean Login(String enteredID, String enteredPass){
        
        try{
        
        FileReader reader = null;
        BufferedReader buffReader;
            
        if (enteredID.charAt(0) == 'P'){
            reader = new FileReader("Database/Users/Patients/" + enteredID + ".txt");
        }
        else if (enteredID.charAt(0) == 'D'){
            reader = new FileReader("Database/Users/Doctor/" + enteredID + ".txt");
        }
        else if (enteredID.charAt(0) == 'S'){
            reader = new FileReader("Database/Users/Secretary/" + enteredID + ".txt");
        } 
        else if (enteredID.charAt(0) == 'A'){
            reader = new FileReader("Database/Users/Admin/" + enteredID + ".txt");
        } 
        else {
            reader = new FileReader("Database/Users/Patients/" + enteredID + ".txt");
        }
        buffReader = new BufferedReader(reader); 
        if (CheckPassword(buffReader,enteredPass) == true){
            buffReader.close();
            return true;
        } else {
            buffReader.close();
            return false;
        }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Login Press no return");
        return false;
    }
    
    public Boolean CheckPassword(BufferedReader buffReader, String ePassword){
        try{
        String tempPassword = buffReader.readLine();
        
        System.out.println(tempPassword);
        System.out.println(ePassword);
        
        if (ePassword.equals(tempPassword)){
            return true;
        } else {
            return false;
        }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
