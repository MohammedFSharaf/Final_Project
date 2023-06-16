/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SCc
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private long phone;
    private String gender;
    private String role;

    public User(String username, String password, String firstname, String lastname, int age, String email, long phone, String gender, String role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public User(String username, String firstname, String lastname, int age, String email, long phone, String gender) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int save() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO USERS (ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,AGE,EMAIL,PHONE,GENDER,ROLE) VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setString(2, this.getUsername());
        ps.setString(3, this.getPassword());
        ps.setString(4, this.getFirstname());
        ps.setString(5, this.getLastname());
        ps.setInt(6, this.getAge());
        ps.setString(7, this.getEmail());
        ps.setLong(8, this.getPhone());
        ps.setString(9, this.getGender());
        ps.setString(10, this.getRole());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getUsername()
                    + " User was added successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    public static boolean loginPatient(String username, String password) {
        try (Connection connection = DB.getInstance().getConnection()) {
            String sql = "SELECT username, password FROM users WHERE username = ? AND password = ? AND role = 'patient'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean loginAdmin(String username, String password) {
        try (Connection connection = DB.getInstance().getConnection()) {
            String sql = "SELECT username, password FROM users WHERE username = ? AND password = ? AND role = 'admin'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static ArrayList<User> getAllUsers() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT id, username, password, firstname, lastname, age, email, phone, gender, role FROM users WHERE role = 'patient'";

        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getLong(8), rs.getString(9), rs.getString(10));
            user.setId(rs.getInt(1));
            users.add(user);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return users;
    }

    public int update() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE USERS SET USERNAME=?,FIRSTNAME=?,LASTNAME=?,AGE=?,EMAIL=? ,PHONE=?,GENDER=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getUsername());
        ps.setString(2, this.getFirstname());
        ps.setString(3, this.getLastname());
        ps.setInt(4, this.getAge());
        ps.setString(5, this.getEmail());
        ps.setLong(6, this.getPhone());
        ps.setString(7, this.getGender());
        ps.setInt(8, this.getId());
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
        String sql = "DELETE FROM USERS WHERE ID=? ";
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
}
