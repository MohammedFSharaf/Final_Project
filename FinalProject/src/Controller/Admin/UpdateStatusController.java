/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Appointment;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author SCc
 */
public class UpdateStatusController implements Initializable {
private Appointment oldAppointment;
    @FXML
    private Button saveBtn;
    @FXML
    private RadioButton bookedRadio;
    @FXML
    private ToggleGroup statusGroup;
    @FXML
    private RadioButton freeRadio;
    @FXML
    private Button cancelBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        this.oldAppointment = Controller.Admin.PatientDashboardController.selectedAppointmentToUpdate;
        if (oldAppointment.getStatus().equals("booked")) {
            statusGroup.selectToggle(bookedRadio);
        }
    }    

    @FXML
    private void saveBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        
         String status = ((RadioButton)statusGroup.getSelectedToggle()).getText();
       
        
        
        Appointment newAppointment = new Appointment(status);
        
     
        newAppointment.setId(oldAppointment.getId());
        
     
        newAppointment.updateStatus();
        Controller.Admin.PatientDashboardController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();
    }

    
    
}
