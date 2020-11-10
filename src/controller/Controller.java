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
import model.Pesanan;
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
                User.setIdUser(rs.getInt("ID_User"));
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
    public static Users getUser(String username){
        conn.connect();
        Users user = new Users();
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                user.setIdUser(rs.getInt("ID_User"));
                user.setNama(rs.getString("nama"));
                user.setAlamat(rs.getString("alamat"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return(user);
    }
    public static boolean insertNewUser(Users new_user) {
        conn.connect();
        String query = "INSERT INTO users VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, Controller.getAllUsers().size());
            stmt.setString(2, new_user.getNama());
            stmt.setString(3, new_user.getAlamat());
            stmt.setString(4, new_user.getEmail());
            stmt.setString(5, new_user.getUsername());
            stmt.setString(6, new_user.getPassword());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static ArrayList<Pesanan> getAllPesanan(){
        ArrayList<Pesanan> allPesanan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesanan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pesanan pesanan = new Pesanan();
                pesanan.setIdPesanan(rs.getInt("ID_Pesanan"));
                pesanan.setTipePesanan(rs.getString("tipe_pesanan"));
                pesanan.setAlamatJemput(rs.getString("alamat_jemput"));
                pesanan.setAlamatTujuan(rs.getString("alamat_tujuan"));
                pesanan.setTotalHarga(rs.getInt("total_harga"));
                pesanan.setTanggalPemesanan(rs.getString("tanggal_pemesanan"));
                allPesanan.add(pesanan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allPesanan);
    }
    public boolean setStatusPesanan(Pesanan pesanan){
        conn.connect();
        String query = "UPDATE pesanan SET status=" + pesanan.getStatus() + " "
                + " WHERE ID_Pesanan=" + pesanan.getIdPesanan() + "";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
