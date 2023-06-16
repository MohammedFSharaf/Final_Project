/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;

/**
 *
 * @author SCc
 */
public class ViewManager {
    
     public static PatientLogin patientLoginpage;

    public ViewManager() {
    }
    
    
    public static void openPatientLoginPage() throws IOException{
        if (patientLoginpage == null) {
            patientLoginpage = new PatientLogin();
            patientLoginpage.show();
        } else {
            patientLoginpage.show();
        }
        
    }
    public static void closePatientLoginPage(){
        if(patientLoginpage != null)
            patientLoginpage.close();
    }
}
