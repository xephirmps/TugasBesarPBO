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
import model.Admin;
import model.Drivers;
import model.Member;
import model.Pesanan;

/**
 *
 * @author User
 */
public class DatabaseControl {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<Member> getAllMember() {
        ArrayList<Member> allMember = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM member";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setIdUser(rs.getInt("id_member"));
                member.setNama(rs.getString("nama"));
                member.setAlamat(rs.getString("alamat"));
                member.setEmail(rs.getString("email"));
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setSaldoOVO(rs.getInt("saldo_ovo"));
                member.setPesanan(getPesananMember(member.getIdUser()));
                allMember.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allMember);
    }
    public static ArrayList<Pesanan> getPesananMember(int idMember){
        ArrayList<Pesanan> allPesanan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesanan WHERE id_member=" + idMember;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pesanan pesanan = new Pesanan();
                pesanan.setIdPesanan(rs.getInt("id_pesanan"));
                pesanan.setIdMember(rs.getInt("id_member"));
                pesanan.setIdDriver(rs.getInt("id_driver"));
                pesanan.setTipePesanan(rs.getString("tipe_pesanan"));
                pesanan.setAlamatJemput(rs.getString("alamat_jemput"));
                pesanan.setAlamatTujuan(rs.getString("alamat_tujuan"));
                pesanan.setTotalHarga(rs.getInt("total_harga"));
                pesanan.setTanggalPemesanan(rs.getString("tanggal_pemesanan"));
                pesanan.setStatus(rs.getInt("status"));
                allPesanan.add(pesanan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allPesanan);
    }
    public static ArrayList<Drivers> getAllDriver() {
        ArrayList<Drivers> allDriver = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM driver";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Drivers driver = new Drivers();
                driver.setIdUser(rs.getInt("id_driver"));
                driver.setNama(rs.getString("nama"));
                driver.setAlamat(rs.getString("alamat"));
                driver.setEmail(rs.getString("email"));
                driver.setUsername(rs.getString("username"));
                driver.setPassword(rs.getString("password"));
                driver.setKendaraan(rs.getString("kendaraan"));
                driver.setPlatNomor(rs.getString("plat_nomor"));
                driver.setPendapatan(rs.getInt("pendapatan"));
                if(rs.getString("status").equals("Ready")){
                    driver.setStatus(false);
                }else if(rs.getString("status").equals("Not Ready")){
                    driver.setStatus(true);
                }
                allDriver.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allDriver);
    }
    public static ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> allAdmin = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM admin";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setIdUser(rs.getInt("id_admin"));
                admin.setNama(rs.getString("nama"));
                admin.setAlamat(rs.getString("alamat"));
                admin.setEmail(rs.getString("email"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setAdmin(true);
                allAdmin.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allAdmin);
    }
    public static boolean insertNewMember(Member newMember) {
        conn.connect();
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, newMember.getNama());
            stmt.setString(3, newMember.getAlamat());
            stmt.setString(4, newMember.getEmail());
            stmt.setString(5, newMember.getUsername());
            stmt.setString(6, newMember.getPassword());
            stmt.setInt(7, 0);
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
                pesanan.setIdPesanan(rs.getInt("id_pesanan"));
                pesanan.setIdMember(rs.getInt("id_member"));
                pesanan.setIdDriver(rs.getInt("id_driver"));
                pesanan.setTipePesanan(rs.getString("tipe_pesanan"));
                pesanan.setAlamatJemput(rs.getString("alamat_jemput"));
                pesanan.setAlamatTujuan(rs.getString("alamat_tujuan"));
                pesanan.setTotalHarga(rs.getInt("total_harga"));
                pesanan.setTanggalPemesanan(rs.getString("tanggal_pemesanan"));
                pesanan.setStatus(rs.getInt("status"));
                allPesanan.add(pesanan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allPesanan);
    }
    public static boolean setStatusPesanan(Pesanan pesanan, int idDriver){
        conn.connect();
        String query = "UPDATE pesanan SET status=" + pesanan.getStatus() + ", "
                + "id_driver=" + idDriver + " "
                + " WHERE id_pesanan=" + pesanan.getIdPesanan() + "";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean updateMember(Member member){
        conn.connect();
        String query = "UPDATE member SET "
                + "nama='" + member.getNama() + "', "
                + "alamat='" + member.getAlamat() + "', "
                + "email='" + member.getEmail() + "', "
                + "username='" + member.getUsername() + "', "
                + "password='" + member.getPassword() + "', "
                + "saldo_ovo='" + member.getSaldoOVO() + "' "
                + " WHERE id_member='" + member.getIdUser() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean updateDriver(Drivers driver){
        conn.connect();
        String status = "";
        if(driver.getStatus()){
            status = "Not Ready";
        }else{
            status = "Ready";
        }
        String query = "UPDATE driver SET "
                + "nama='" + driver.getNama() + "', "
                + "alamat='" + driver.getAlamat() + "', "
                + "email='" + driver.getEmail() + "', "
                + "username='" + driver.getUsername() + "', "
                + "password='" + driver.getPassword() + "', "
                + "kendaraan='" + driver.getKendaraan() + "', "
                + "plat_nomor='" + driver.getPlatNomor() + "', "
                + "pendapatan=" + driver.getPendapatan() + ", "
                + "status='" + status + "' "
                + " WHERE id_driver=" + driver.getIdUser();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean insertNewPesanan(Pesanan pesanan){
        conn.connect();
        String query = "INSERT INTO pesanan VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, MemberManager.getInstance().getMember().getIdUser());
            stmt.setInt(3, 0);
            stmt.setString(4, pesanan.getTipePesanan());
            stmt.setString(5, pesanan.getAlamatJemput());
            stmt.setString(6, pesanan.getAlamatTujuan());
            stmt.setInt(7, pesanan.getTotalHarga());
            stmt.setString(8, pesanan.getTanggalPemesanan());
            stmt.setString(9, pesanan.getMetodePembayaran());
            stmt.setInt(10, pesanan.getStatus());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
