/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Appointment;
import Model.BookedAppointments;
import Model.User;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SCc
 */
public class AdminDashboardController implements Initializable {

    public static User selectedPatientToUpdate;
    public static Appointment selectedAppointmentToUpdate;
    public static BookedAppointments selectedValueToUpdate;
    public static Stage updateStage;
    @FXML
    private Button LogOutBtn;
    @FXML
    private Button FreeAppointmentsBtn;
    @FXML
    private Button BookedAppointmentsBtn;
    @FXML
    private Button ShowAllBtn;

    @FXML
    private TableColumn<Appointment, String> statusB;
    @FXML
    private TableColumn<BookedAppointments, String> statusC;
    @FXML
    private TableView<User> allregisterdpatientsTableA;
    @FXML
    private TableColumn<User, Integer> idA;
    @FXML
    private TableColumn<User, String> userNameA;
    @FXML
    private TableColumn<User, String> firstNameA;
    @FXML
    private TableColumn<User, String> lastNameA;
    @FXML
    private TableColumn<User, Integer> ageA;
    @FXML
    private TableColumn<User, String> emailA;
    @FXML
    private TableColumn<User, Long> phoneA;
    @FXML
    private TableColumn<User, String> genderA;
    @FXML
    private TableColumn<User, String> roleA;
    @FXML
    private TableView<Appointment> allfreepatientsTableB;
    @FXML
    private TableColumn<Appointment, Integer> idB;
    @FXML
    private TableColumn<Appointment, String> appointmentDateB;
    @FXML
    private TableColumn<Appointment, String> appointmentDayB;
    @FXML
    private TableColumn<Appointment, Float> appointmentTimeB;
    @FXML
    private TableView<BookedAppointments> allbookedpatientsTableC;
    @FXML
    private TableColumn<BookedAppointments, Integer> idC;
    @FXML
    private TableColumn<BookedAppointments, String> doctorCommentC;
    @FXML
    private Button UpdateBtn;
    @FXML
    private Button DeleteBtn;
    @FXML
    private Button CreateBtn;
    @FXML
    private TextField searchTF;
    @FXML
    private Button searchFirstnameBtn;
    @FXML
    private Button ShowAllBtnB;
    @FXML
    private Button ShowAllBtnC;
    @FXML
    private Button CreateBtnB;
    @FXML
    private Button UpdateBtnB;
    @FXML
    private Button DeleteBtnB;
    @FXML
    private Button homeBtn;
    @FXML
    private TableColumn<User, String> firstNameC;
    @FXML
    private TableColumn<User, String> lastNameC;
    @FXML
    private Button UpdateBtnC;
    @FXML
    private TableColumn<Appointment, Integer> appointmentIdC;
    @FXML
    private TableColumn<User, Integer> userIdC;
    @FXML
    private TextField searchTF2;
    @FXML
    private Button searchFirstnameBtn2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idA.setCellValueFactory(new PropertyValueFactory("id"));
        userNameA.setCellValueFactory(new PropertyValueFactory("username"));
        firstNameA.setCellValueFactory(new PropertyValueFactory("firstname"));
        lastNameA.setCellValueFactory(new PropertyValueFactory("lastname"));
        ageA.setCellValueFactory(new PropertyValueFactory("Age"));
        emailA.setCellValueFactory(new PropertyValueFactory("Email"));
        phoneA.setCellValueFactory(new PropertyValueFactory("Phone"));
        genderA.setCellValueFactory(new PropertyValueFactory("Gender"));
        roleA.setCellValueFactory(new PropertyValueFactory("Role"));
        //----------------------------------------------------------------//
        idB.setCellValueFactory(new PropertyValueFactory("id"));
        appointmentDateB.setCellValueFactory(new PropertyValueFactory("appointmentDate"));
        appointmentDayB.setCellValueFactory(new PropertyValueFactory("appointmentDay"));
        appointmentTimeB.setCellValueFactory(new PropertyValueFactory("appointmentTime"));
        statusB.setCellValueFactory(new PropertyValueFactory("status"));
        //----------------------------------------------------------------//
        idC.setCellValueFactory(new PropertyValueFactory("id"));
        appointmentIdC.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        userIdC.setCellValueFactory(new PropertyValueFactory("user_id"));
        statusC.setCellValueFactory(new PropertyValueFactory("status"));
        doctorCommentC.setCellValueFactory(new PropertyValueFactory("doctorComment"));
        firstNameC.setCellValueFactory(new PropertyValueFactory("firstname"));
        lastNameC.setCellValueFactory(new PropertyValueFactory("lastname"));
    }

    @FXML
    private void LogOutBtn(ActionEvent event) {

        ViewManager.patientLoginpage.changeSceneToAdminLogin();
    }

    @FXML
    private void ShowAllBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<User> usersList
                = FXCollections.observableArrayList(User.getAllUsers());
        allregisterdpatientsTableA.setItems(usersList);
    }

    @FXML
    private void homeBtn(ActionEvent event) {
        allregisterdpatientsTableA.setVisible(true);
        allbookedpatientsTableC.setVisible(false);
        allfreepatientsTableB.setVisible(false);
        searchTF.setVisible(true);
        searchFirstnameBtn.setVisible(true);
        ShowAllBtn.setVisible(true);
        ShowAllBtnB.setVisible(false);
        ShowAllBtnC.setVisible(false);
        UpdateBtn.setVisible(true);
        DeleteBtn.setVisible(true);
        CreateBtn.setVisible(true);
        UpdateBtnB.setVisible(false);
        DeleteBtnB.setVisible(false);
        CreateBtnB.setVisible(false);
        UpdateBtnC.setVisible(false);
        searchTF2.setVisible(false);
        searchFirstnameBtn2.setVisible(false);
        searchTF.setVisible(true);
        searchFirstnameBtn.setVisible(true);
    }

    @FXML
    private void FreeAppointmentsBtn(ActionEvent event) {
        allregisterdpatientsTableA.setVisible(false);
        allbookedpatientsTableC.setVisible(false);
        allfreepatientsTableB.setVisible(true);
        searchTF.setVisible(false);
        searchFirstnameBtn.setVisible(false);
        ShowAllBtn.setVisible(false);
        ShowAllBtnB.setVisible(true);
        ShowAllBtnC.setVisible(false);
        UpdateBtn.setVisible(false);
        DeleteBtn.setVisible(false);
        CreateBtn.setVisible(false);
        UpdateBtnB.setVisible(true);
        DeleteBtnB.setVisible(true);
        CreateBtnB.setVisible(true);
        UpdateBtnC.setVisible(false);
        searchTF2.setVisible(false);
        searchFirstnameBtn2.setVisible(false);
        searchTF.setVisible(false);
        searchFirstnameBtn.setVisible(false);
    }

    @FXML
    private void BookedAppointmentsBtn(ActionEvent event) {
        allregisterdpatientsTableA.setVisible(false);
        allbookedpatientsTableC.setVisible(true);
        allfreepatientsTableB.setVisible(false);
        searchTF.setVisible(false);
        searchFirstnameBtn.setVisible(false);
        ShowAllBtn.setVisible(false);
        ShowAllBtnB.setVisible(false);
        ShowAllBtnC.setVisible(true);
        UpdateBtn.setVisible(false);
        DeleteBtn.setVisible(false);
        CreateBtn.setVisible(false);
        UpdateBtnB.setVisible(false);
        DeleteBtnB.setVisible(false);
        CreateBtnB.setVisible(false);
        UpdateBtnC.setVisible(true);
        searchTF2.setVisible(true);
        searchFirstnameBtn2.setVisible(true);
        searchTF.setVisible(false);
        searchFirstnameBtn.setVisible(false);
    }

    @FXML
    private void UpdateBtn(ActionEvent event) throws IOException {

        if (allregisterdpatientsTableA.getSelectionModel().getSelectedItem() != null) {

            selectedPatientToUpdate = allregisterdpatientsTableA.getSelectionModel().getSelectedItem();

            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/UpdatePatient.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            Scene updatePatientScene = new Scene(rootUpdate);

            updateStage = new Stage();
            updateStage.setScene(updatePatientScene);
            updateStage.setTitle("Update Patient " + selectedPatientToUpdate.getUsername());
            updateStage.show();
        }
    }

    @FXML
    private void DeleteBtn(ActionEvent event) {

        if (allregisterdpatientsTableA.getSelectionModel().getSelectedItem() != null) {

            User selectedUser = allregisterdpatientsTableA.getSelectionModel().getSelectedItem();
            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("User delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this user ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {

                        selectedUser.delete();
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                    deletedSuccessAlert.setTitle("User deleted");
                    deletedSuccessAlert.setContentText("User deleted");
                    deletedSuccessAlert.show();
                }
            });

        } else {
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setTitle("Select an user");
            warnAlert.setContentText("Please select an user from the table view");
            warnAlert.show();
        }
    }

    @FXML
    private void CreateBtn(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToCreateNewPatient();
    }

    @FXML
    private void ShowAllBtnB(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Appointment> appointmentsList
                = FXCollections.observableArrayList(Appointment.getAllAppointments());
        allfreepatientsTableB.setItems(appointmentsList);
    }

    @FXML
    private void ShowAllBtnC(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<BookedAppointments> bookedAppointmentsList
                = FXCollections.observableArrayList(BookedAppointments.getInfo());
        allbookedpatientsTableC.setItems(bookedAppointmentsList);
    }

    @FXML
    private void CreateBtnB(ActionEvent event) {
        ViewManager.patientLoginpage.changeSceneToCreateNewAppointment();

    }

    @FXML
    private void UpdateBtnB(ActionEvent event) throws IOException {
        if (allfreepatientsTableB.getSelectionModel().getSelectedItem() != null) {
            selectedAppointmentToUpdate = allfreepatientsTableB.getSelectionModel().getSelectedItem();
            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/UpdateAppointment.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            Scene updateAppointmentScene = new Scene(rootUpdate);
            //store loaded fxml in our global stage updateStage and show it
            updateStage = new Stage();
            updateStage.setScene(updateAppointmentScene);
            updateStage.setTitle("Update Appointment " + selectedAppointmentToUpdate.getId());
            updateStage.show();
        }
    }

    @FXML
    private void DeleteBtnB(ActionEvent event) {
        if (allfreepatientsTableB.getSelectionModel().getSelectedItem() != null) {

            Appointment selectedAppointment = allfreepatientsTableB.getSelectionModel().getSelectedItem();

            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("Appointment delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this appointment ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {

                        selectedAppointment.delete();
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                    deletedSuccessAlert.setTitle("Appointment deleted");
                    deletedSuccessAlert.setContentText("Appointment deleted");
                    deletedSuccessAlert.show();
                }
            });

        } else {
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setTitle("Select an Appointment");
            warnAlert.setContentText("Please select an Appointment from the table view");
            warnAlert.show();
        }
    }

    @FXML
    private void UpdateBtnC(ActionEvent event) throws IOException {
        if (allbookedpatientsTableC.getSelectionModel().getSelectedItem() != null) {
            selectedValueToUpdate = allbookedpatientsTableC.getSelectionModel().getSelectedItem();
            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/AddComment.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            Scene updateValueScene = new Scene(rootUpdate);
            //store loaded fxml in our global stage updateStage and show it
            updateStage = new Stage();
            updateStage.setScene(updateValueScene);
            updateStage.setTitle("Added Comment " + selectedValueToUpdate.getId());
            updateStage.show();
        }
    }

    @FXML
    private void searchFirstnameBtn2(ActionEvent event) {
        String searchText = searchTF2.getText().toLowerCase();
        ObservableList<BookedAppointments> bookedAppointmentsList = allbookedpatientsTableC.getItems();

        FilteredList<BookedAppointments> filteredList = new FilteredList<>(bookedAppointmentsList);

        filteredList.setPredicate(appointment -> {
            String firstName = appointment.getFirstname().toLowerCase();
            return firstName.contains(searchText);
        });

        allbookedpatientsTableC.setItems(filteredList);
    }

    @FXML
    private void searchFirstnameBtn(ActionEvent event) {
        String searchText = searchTF.getText().toLowerCase();

        ObservableList<User> userList = allregisterdpatientsTableA.getItems();

        FilteredList<User> filteredList = new FilteredList<>(userList);

        filteredList.setPredicate(user -> {
            String firstName = user.getFirstname().toLowerCase();
            return firstName.contains(searchText);
        });

        allregisterdpatientsTableA.setItems(filteredList);
    }

}
