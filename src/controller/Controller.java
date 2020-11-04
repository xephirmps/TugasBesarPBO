/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Users;

/**
 *
 * @author User
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<Users> getAllUsers() {
        ArrayList<Users> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM users";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Users User = new Users();
                User.setNama(rs.getString("Nama"));
                User.setEmail(rs.getString("Email"));
                User.setUsername(rs.getString("Username"));
                User.setPassword(rs.getString("Password"));
                User.setAlamat(rs.getString("Alamat"));
                users.add(User);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    
    public static boolean insertNewUser(Users new_user) {
        conn.connect();
        String query = "INSERT INTO users(Nama, Email, Username, Password, Alamat) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, new_user.getNama());
            stmt.setString(2, new_user.getEmail());
            stmt.setString(3, new_user.getUsername());
            stmt.setString(4, new_user.getPassword());
            stmt.setString(5, new_user.getAlamat());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
