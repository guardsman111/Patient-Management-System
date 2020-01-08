/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIProcesses;

/**
 *
 * for request processes
 * 
 * @author Charlie Parsons
 */
public interface RequestInterface {
    
    Integer pending = 0;
    
    boolean CheckForRequest();
    
    void NextRequest(String Direction);
    
    String DisplayRequest();
    
    void ActionRequest(boolean action);
    
    
}
