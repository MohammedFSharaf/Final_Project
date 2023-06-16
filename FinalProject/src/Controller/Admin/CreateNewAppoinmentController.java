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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author SCc
 */
public class CreateNewAppoinmentController implements Initializable {

    @FXML
    private Button saveBtn;
    @FXML
    private TextField appointmentDayTf;
    @FXML
    private TextField appointmentDateTf;
    @FXML
    private TextField appointmentTimeTf;
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
    }

    @FXML
    private void saveBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String appointmentDate = appointmentDateTf.getText();
        String appointmentDay = appointmentDayTf.getText();
        float appointmentTime = Float.parseFloat(appointmentTimeTf.getText());
        String status = ((RadioButton) statusGroup.getSelectedToggle()).getText();
        Appointment appointment = new Appointment(appointmentDate, appointmentDay, appointmentTime, status);
        appointment.save();
        ViewManager.patientLoginpage.changeSceneToAdminDashboard();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Appointment inserted");
        alert.setContentText("Appointment inserted");
        alert.showAndWait();
    }

    @FXML
    private void cancelBtn(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToAdminDashboard();
    }

}
