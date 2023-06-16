/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.User;
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
public class UpdatePatientController implements Initializable {

    private User oldUser;
    @FXML
    private Button saveBtn;
    @FXML
    private TextField usernameTf;
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
    private RadioButton femaleRadio;
    @FXML
    private RadioButton maleRadio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.oldUser = Controller.Admin.AdminDashboardController.selectedPatientToUpdate;
        usernameTf.setText(oldUser.getUsername());
        firstNameTf.setText(oldUser.getFirstname());
        lastNameTf.setText(oldUser.getLastname());
        ageTf.setText(String.valueOf(oldUser.getAge()));
        emailTf.setText(oldUser.getEmail());
        phoneTf.setText(String.valueOf(oldUser.getPhone()));
        if (oldUser.getGender().equals("female")) {
            genderGroup.selectToggle(femaleRadio);
        }

    }

    @FXML
    private void saveBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String username = usernameTf.getText();
        String firstname = firstNameTf.getText();
        String lastname = lastNameTf.getText();
        int age = Integer.parseInt(ageTf.getText()); // Convert to int
        long phone = Long.parseLong(phoneTf.getText()); // Convert to long
        String email = emailTf.getText();
        String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();

        User newUser = new User(username, firstname, lastname, age, email, phone, gender);
        newUser.setId(oldUser.getId());
        newUser.update();
        Controller.Admin.AdminDashboardController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();
    }

}
