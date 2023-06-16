/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Appointment;
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
public class UpdateAppointmentController implements Initializable {

    private Appointment oldUser;
    @FXML
    private Button saveBtn;
    private TextField appointmentDayTf;
    private TextField appointmentDateTf;
    private TextField appointmentTimeTf;
    private RadioButton femaleRadio;
    private ToggleGroup genderGroup;
    @FXML
    private ToggleGroup statusGroup;
    @FXML
    private RadioButton bookedRadio;
    @FXML
    private RadioButton freeRadio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.oldUser = Controller.Admin.AdminDashboardController.selectedAppointmentToUpdate;
        appointmentDayTf.setText(oldUser.getAppointmentDay());
        appointmentDateTf.setText(oldUser.getAppointmentDate());
        float appointmentTime = oldUser.getAppointmentTime();
        String appointmentTimeStr = Float.toString(appointmentTime);
        appointmentTimeTf.setText(appointmentTimeStr);
        if (oldUser.getStatus().equals("booked")) {
            statusGroup.selectToggle(bookedRadio);
        }
    }

    @FXML
    private void saveBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String appointmentDate = appointmentDateTf.getText();
        String appointmentDay = appointmentDayTf.getText();
        float appointmentTime = Float.parseFloat(appointmentTimeTf.getText());
        String status = ((RadioButton) statusGroup.getSelectedToggle()).getText();
        Appointment newAppointment = new Appointment(appointmentDate, appointmentDay, appointmentTime, status);
        newAppointment.setId(oldUser.getId());
        newAppointment.update();
        Controller.Admin.AdminDashboardController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();
    }

}
