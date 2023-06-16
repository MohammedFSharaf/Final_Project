/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Appointment;
import Model.BookedAppointments;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SCc
 */
public class PatientDashboardController implements Initializable {

    public static Appointment selectedAppointmentToUpdate;
    public static Stage updateStage;

    @FXML
    private Button BookedWaitingAppointmentsBtn;
    @FXML
    private Button LogOutBtn;
    @FXML
    private Button BookedFinishedAppointmentsBtn;
    @FXML
    private TableView<Appointment> allFreeAppointmentsTableA;
    @FXML
    private TableColumn<Appointment, Integer> idA;
    @FXML
    private TableColumn<Appointment, String> appointmentDateA;
    @FXML
    private TableColumn<Appointment, String> appointmentDayA;
    @FXML
    private TableColumn<Appointment, Float> appointmentTimeA;
    @FXML
    private TableColumn<Appointment, String> statusA;
    @FXML
    private TableView<BookedAppointments> allBookedWaitingAppointmentsTableB;
    @FXML
    private TableColumn<BookedAppointments, Integer> idB;
    @FXML
    private TableColumn<BookedAppointments, Integer> AppointmentIdB;
    @FXML
    private TableColumn<BookedAppointments, Integer> userIdB;
    @FXML
    private TableColumn<BookedAppointments, String> statusB;
    @FXML
    private TableView<BookedAppointments> allBookedFinishedAppointmentsTableC;
    @FXML
    private TableColumn<BookedAppointments, Integer> idC;
    @FXML
    private TableColumn<BookedAppointments, Integer> appointmentIdC;
    @FXML
    private TableColumn<BookedAppointments, Integer> userIdC;
    @FXML
    private TableColumn<BookedAppointments, String> statusC;
    @FXML
    private TableColumn<BookedAppointments, String> doctorCommnetC;
    @FXML
    private Button BookAnFreeAppointmentBtn;
    @FXML
    private Button HomeBtn;
    @FXML
    private Button ShowAllBtnA;
    @FXML
    private Button ShowAllBtnB;
    @FXML
    private Button ShowAllBtnC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idA.setCellValueFactory(new PropertyValueFactory("id"));
        appointmentDateA.setCellValueFactory(new PropertyValueFactory("appointmentDate"));
        appointmentDayA.setCellValueFactory(new PropertyValueFactory("appointmentDay"));
        appointmentTimeA.setCellValueFactory(new PropertyValueFactory("appointmentTime"));
        statusA.setCellValueFactory(new PropertyValueFactory("status"));
        /////////////////////////////////////////////////////////////////////////
        idB.setCellValueFactory(new PropertyValueFactory("id"));
        AppointmentIdB.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        userIdB.setCellValueFactory(new PropertyValueFactory("user_id"));
        statusB.setCellValueFactory(new PropertyValueFactory("status"));
        //////////////////////////////////////////////////////////////////////////
        idC.setCellValueFactory(new PropertyValueFactory("id"));
        appointmentIdC.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        userIdC.setCellValueFactory(new PropertyValueFactory("user_id"));
        statusC.setCellValueFactory(new PropertyValueFactory("status"));
        doctorCommnetC.setCellValueFactory(new PropertyValueFactory("doctorComment"));

    }

    @FXML
    private void LogOutBtn(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToPatientLogin();
    }

    @FXML
    private void BookedWaitingAppointmentsBtn(ActionEvent event) {
        allFreeAppointmentsTableA.setVisible(false);
        allBookedWaitingAppointmentsTableB.setVisible(true);
        allBookedFinishedAppointmentsTableC.setVisible(false);
        ShowAllBtnA.setVisible(false);
        ShowAllBtnB.setVisible(true);
        ShowAllBtnC.setVisible(false);
        BookAnFreeAppointmentBtn.setVisible(false);
    }

    @FXML
    private void BookedFinishedAppointmentsBtn(ActionEvent event) {
        allFreeAppointmentsTableA.setVisible(false);
        allBookedWaitingAppointmentsTableB.setVisible(false);
        allBookedFinishedAppointmentsTableC.setVisible(true);
        ShowAllBtnA.setVisible(false);
        ShowAllBtnB.setVisible(false);
        ShowAllBtnC.setVisible(true);
        BookAnFreeAppointmentBtn.setVisible(false);
    }

    @FXML
    private void BookAnFreeAppointmentBtn(ActionEvent event) throws IOException {
        if (allFreeAppointmentsTableA.getSelectionModel().getSelectedItem() != null) {
            selectedAppointmentToUpdate = allFreeAppointmentsTableA.getSelectionModel().getSelectedItem();
            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/UpdateStatus.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            Scene updateStatusScene = new Scene(rootUpdate);
            updateStage = new Stage();
            updateStage.setScene(updateStatusScene);
            updateStage.setTitle("Update Status " + selectedAppointmentToUpdate.getStatus());
            updateStage.show();
        }
    }

    @FXML
    private void HomeBtn(ActionEvent event) {
        allFreeAppointmentsTableA.setVisible(true);
        allBookedWaitingAppointmentsTableB.setVisible(false);
        allBookedFinishedAppointmentsTableC.setVisible(false);
        ShowAllBtnA.setVisible(true);
        ShowAllBtnB.setVisible(false);
        ShowAllBtnC.setVisible(false);
        BookAnFreeAppointmentBtn.setVisible(true);
    }

    @FXML
    private void ShowAllBtnA(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Appointment> appointmentsList
                = FXCollections.observableArrayList(Appointment.getAllAppointments());
        allFreeAppointmentsTableA.setItems(appointmentsList);
    }

    @FXML
    private void ShowAllBtnB(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<BookedAppointments> bookedWaitingAppointmentsList
                = FXCollections.observableArrayList(BookedAppointments.getAllBookedWaitingAppointments());
        allBookedWaitingAppointmentsTableB.setItems(bookedWaitingAppointmentsList);
    }

    @FXML
    private void ShowAllBtnC(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<BookedAppointments> bookedFinshedAppointments
                = FXCollections.observableArrayList(BookedAppointments.getAllBookedFinishedBookedAppointments());
        allBookedFinishedAppointmentsTableC.setItems(bookedFinshedAppointments);
    }

}
