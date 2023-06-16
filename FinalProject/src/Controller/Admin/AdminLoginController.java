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
public class AdminLoginController implements Initializable {

    @FXML
    private Button signupBtn;
    @FXML
    private Button patientLoginBtn;
    @FXML
    private Button signinAdminBtn;
    @FXML
    private TextField usernameAdminTf;
    @FXML
    private PasswordField passwordAdminTf;

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
    private void patientLoginBtn(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToPatientLogin();
    }

    @FXML
    private void signinAdminBtn(ActionEvent event) {
        String username = usernameAdminTf.getText();
        String password = passwordAdminTf.getText();
        boolean credentialsValid = User.loginAdmin(username, password);
        if (credentialsValid) {
            ViewManager.patientLoginpage.changeSceneToAdminDashboard();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        usernameAdminTf.clear();
        passwordAdminTf.clear();

    }

}
