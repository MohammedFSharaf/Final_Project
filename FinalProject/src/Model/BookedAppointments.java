/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SCc
 */
public class BookedAppointments {

    private int id;
    private String firstname; // from users table 
    private String lastname; // from users table 
    private int appointment_id;// from appointments table 
    private int user_id;// from users table 
    private String status;
    private String doctorComment;

    public BookedAppointments(int appointment_id, int user_id, String status, String doctorComment, String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.appointment_id = appointment_id;
        this.user_id = user_id;
        this.status = status;
        this.doctorComment = doctorComment;
    }

    public BookedAppointments(int appointment_id, int user_id, String status, String doctorComment) {
        this.appointment_id = appointment_id;
        this.user_id = user_id;
        this.status = status;
        this.doctorComment = doctorComment;
    }

    public BookedAppointments(int appointment_id, int user_id, String status) {
        this.appointment_id = appointment_id;
        this.user_id = user_id;
        this.status = status;
    }

    public BookedAppointments(String status, String doctorComment) {
        this.status = status;
        this.doctorComment = doctorComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctorComment() {
        return doctorComment;
    }

    public void setDoctorComment(String doctorComment) {
        this.doctorComment = doctorComment;
    }

    public static ArrayList<BookedAppointments> getInfo() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointments> bookedAppointments = new ArrayList<>();
        String sql = "SELECT ba.id, ba.appointment_id, ba.user_id, ba.status, ba.doctor_comment, u.firstname, u.lastname "
                + "FROM booked_appointments ba "
                + "JOIN users u ON ba.user_id = u.id";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointments bookedAppointment = new BookedAppointments(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            bookedAppointment.setId(rs.getInt(1));
            bookedAppointments.add(bookedAppointment);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return bookedAppointments;
    }

    public static ArrayList<BookedAppointments> getAllBookedWaitingAppointments() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointments> bookedappointments = new ArrayList<>();
        String sql = "SELECT id, appointment_id, user_id,status FROM  booked_appointments WHERE status = 'waiting'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointments bookedwaitingappointment = new BookedAppointments(rs.getInt(2), rs.getInt(3), rs.getString(4));
            bookedwaitingappointment.setId(rs.getInt(1));
            bookedappointments.add(bookedwaitingappointment);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return bookedappointments;
    }

    public static ArrayList<BookedAppointments> getAllBookedFinishedBookedAppointments() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointments> bookedappointments = new ArrayList<>();
        String sql = "SELECT id, appointment_id, user_id, status, doctor_comment FROM booked_appointments WHERE status = 'finished'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointments bookedfinishedappointment = new BookedAppointments(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            bookedfinishedappointment.setId(rs.getInt(1));
            bookedappointments.add(bookedfinishedappointment);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return bookedappointments;
    }

    public int addComment() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE booked_appointments SET doctor_comment = ?, status = ? WHERE id = ?";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getDoctorComment());
        ps.setString(2, this.getStatus());
        ps.setInt(3, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getId() + " was updated successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

}
