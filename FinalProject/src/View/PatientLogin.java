package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SCc
 */
public class PatientLogin extends Stage {

    private Scene patientRegistersScene;
    private Scene patientDashboardScene;
    private Scene patientLoginScene;
    private Scene adminLoginScene;
    private Scene adminDashboardScene;
    private Scene CreateNewPatientScene;
    private Scene CreateNewAppointmentScene;

    public PatientLogin() throws IOException {
        FXMLLoader patientLoginLoader = new FXMLLoader(getClass().getResource("AdminFXML/PatientLogin.fxml"));
        Parent patientLoginRoot = patientLoginLoader.load();
        patientLoginScene = new Scene(patientLoginRoot);

        FXMLLoader appointmentCreateNewLoader = new FXMLLoader(getClass().getResource("AdminFXML/CreateNewAppoinment.fxml"));
        Parent appointmentCreateNewRoot = appointmentCreateNewLoader.load();
        CreateNewAppointmentScene = new Scene(appointmentCreateNewRoot);

        FXMLLoader patientCreateLoader = new FXMLLoader(getClass().getResource("AdminFXML/CreateNewPatient.fxml"));
        Parent patientCreateNewRoot = patientCreateLoader.load();
        CreateNewPatientScene = new Scene(patientCreateNewRoot);

        FXMLLoader patientDashboardLoader = new FXMLLoader(getClass().getResource("AdminFXML/PatientDashboard.fxml"));
        Parent patientDashboardRoot = patientDashboardLoader.load();
        patientDashboardScene = new Scene(patientDashboardRoot);

        FXMLLoader adminDashboardLoader = new FXMLLoader(getClass().getResource("AdminFXML/AdminDashboard.fxml"));
        Parent adminDashboardRoot = adminDashboardLoader.load();
        adminDashboardScene = new Scene(adminDashboardRoot);

        FXMLLoader patientRegistersLoader = new FXMLLoader(getClass().getResource("AdminFXML/PatientRegister.fxml"));
        Parent patientRegistersRoot = patientRegistersLoader.load();
        patientRegistersScene = new Scene(patientRegistersRoot);
        FXMLLoader adminLoginLoader = new FXMLLoader(getClass().getResource("AdminFXML/AdminLogin.fxml"));
        Parent adminLoginRoot = adminLoginLoader.load();
        adminLoginScene = new Scene(adminLoginRoot);

        this.setScene(patientLoginScene);
        this.setTitle("Patient Login");
    }

    public void changeSceneToPatientLogin() {
        this.setScene(patientLoginScene);
    }

    public void changeSceneToPatientDashboard() {
        this.setScene(patientDashboardScene);
    }

    public void changeSceneToPatientRegisters() {
        this.setScene(patientRegistersScene);
    }

    public void changeSceneToAdminLogin() {
        this.setScene(adminLoginScene);
    }

    public void changeSceneToAdminDashboard() {
        this.setScene(adminDashboardScene);
    }

    public void changeSceneToCreateNewPatient() {
        this.setScene(CreateNewPatientScene);
    }

    public void changeSceneToCreateNewAppointment() {
        this.setScene(CreateNewAppointmentScene);
    }
}
