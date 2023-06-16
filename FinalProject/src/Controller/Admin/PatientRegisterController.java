/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.User;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author SCc
 */
public class PatientRegisterController implements Initializable {

    @FXML
    private Button registerBtn;
    @FXML
    private TextField usernameTf;
    @FXML
    private PasswordField passwordTf;
    @FXML
    private TextField lastNameTf;
    @FXML
    private TextField firstNameTf;
    @FXML
    private TextField ageTf;
    @FXML
    private TextField emailTf;
    @FXML
    private TextField phoneTf;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private ToggleGroup roleGroup;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void registerBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String username = usernameTf.getText();
        String password = passwordTf.getText();
        String firstname = firstNameTf.getText();
        String lastname = lastNameTf.getText();
        int age = Integer.parseInt(ageTf.getText()); // Convert to int
        long phone = Long.parseLong(phoneTf.getText()); // Convert to long
        String email = emailTf.getText();
        String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
        String role = ((RadioButton) roleGroup.getSelectedToggle()).getText();
        User user = new User(username, password, firstname, lastname, age, email, phone, gender, role);
        user.save();

        ViewManager.patientLoginpage.changeSceneToPatientLogin();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();

    }

    @FXML
    private void backBtn(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToPatientLogin();
    }

}
