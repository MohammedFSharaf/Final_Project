/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.BookedAppointments;
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
public class AddCommentController implements Initializable {

    private BookedAppointments oldValue;
    @FXML
    private Button saveBtn;
    @FXML
    private TextField commentTf;
    @FXML
    private RadioButton finishedRadio;
    private ToggleGroup statusGroup;
    @FXML
    private RadioButton waitingRadio;
    @FXML
    private ToggleGroup statusGroup1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.oldValue = Controller.Admin.AdminDashboardController.selectedValueToUpdate;

        commentTf.setText(oldValue.getDoctorComment());
        if (oldValue.getStatus().equals("waiting")) {
            statusGroup1.selectToggle(waitingRadio);
        }
    }

    @FXML
    private void saveBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String doctorComment = commentTf.getText();
        String status = ((RadioButton) statusGroup1.getSelectedToggle()).getText();
        BookedAppointments newBookedAppointment = new BookedAppointments(status,doctorComment);
        newBookedAppointment.setId(oldValue.getId());
        newBookedAppointment.addComment();
        Controller.Admin.AdminDashboardController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Comment");
        alert.setContentText("Added Comment");
        alert.showAndWait();
    }

}
