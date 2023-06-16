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
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SCc
 */
public class Appointment {

    private int id;
    private String appointmentDate;
    private String appointmentDay;
    private float appointmentTime;
    private String status;

    public Appointment(String appointmentDate, String appointmentDay, float appointmentTime, String status) {
        this.appointmentDate = appointmentDate;
        this.appointmentDay = appointmentDay;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public Appointment(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(String appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public float getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(float appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int save() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO APPOINTMENTS (ID,APPOINTMENT_DATE,APPOINTMENT_DAY,APPOINTMENT_TIME,STATUS) VALUES (?, ?, ?, ?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setString(2, this.getAppointmentDate());
        ps.setString(3, this.getAppointmentDay());
        ps.setFloat(4, this.getAppointmentTime());
        ps.setString(5, this.getStatus());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(
                    "  successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    public static ArrayList<Appointment> getAllAppointments() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT id, appointment_date, appointment_day, appointment_time, status FROM appointments WHERE status = 'free'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Appointment appointment = new Appointment(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5));
            appointment.setId(rs.getInt(1));
            appointments.add(appointment);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return appointments;
    }

    public int update() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE APPOINTMENTS SET appointment_date=?,appointment_day=?,appointment_time=?,status=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getAppointmentDate());
        ps.setString(2, this.getAppointmentDay());
        ps.setFloat(3, this.getAppointmentTime());
        ps.setString(4, this.getStatus());
        ps.setInt(5, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("User with id : " + this.getId() + " was updated successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    public int delete() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "DELETE FROM appointments WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The user with id : " + this.getId() + " was deleted successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    public int updateStatus() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE appointments  SET status=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getStatus());
        ps.setInt(2, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("status with id : " + this.getId() + " was updated successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }
}
