/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.User;
import View.ViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SCc
 */
public class PatientLoginController implements Initializable {

    @FXML
    private Button signupBtn;
    @FXML
    private Button adminLoginBtn;
    @FXML
    private Button signinPatientBtn;
    @FXML
    private TextField usernamePatientTf;
    @FXML
    private PasswordField passwordPatientTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signupBtn(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToPatientRegisters();
    }

    @FXML
    private void adminLoginBtn(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToAdminLogin();
    }

    @FXML
    private void signinPatientBtn(ActionEvent event) {
        String username = usernamePatientTf.getText();
        String password = passwordPatientTf.getText();
        boolean credentialsValid = User.loginPatient(username, password);
        if (credentialsValid) {
            ViewManager.patientLoginpage.changeSceneToPatientDashboard();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        usernamePatientTf.clear();
        passwordPatientTf.clear();
    }

}
