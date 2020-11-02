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
public class controller {
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
                User.setNama(rs.getString("nama"));
                User.setAlamat(rs.getString("alamat"));
                User.setEmail(rs.getString("email"));
                User.setUsername(rs.getString("username"));
                User.setPassword(rs.getString("password"));
                users.add(User);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    
    public static boolean insertNewUser(Users new_user) {
        conn.connect();
        String query = "INSERT INTO users VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, new_user.getNama());
            stmt.setString(2, new_user.getAlamat());
            stmt.setString(3, new_user.getEmail());
            stmt.setString(4, new_user.getUsername());
            stmt.setString(5, new_user.getPassword());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
