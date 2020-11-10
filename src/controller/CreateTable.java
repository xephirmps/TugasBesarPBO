/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dense
 */
public class CreateTable{
    static DatabaseHandler conn = new DatabaseHandler();
    public static Statement stm;
    
    public CreateTable(){
        conn.connect();
        String sql = "";
        try{
            stm = (Statement) conn.con.createStatement();
            
            sql = "CREATE TABLE User (" +
"                   ID_User INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   nama VARCHAR(100) NOT NULL," +
"                   email VARCHAR(100) NOT NULL," +
"                   username VARCHAR(255) NOT NULL," +
"                   password VARCHAR(255) NOT NULL," +
"                   alamat VARCHAR(255) NOT NULL," +
"                   saldo_ovo INT NOT NULL," +
"                   status VARCHAR(100) NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE driver(" + 
"                   ID_Driver INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   kendaraan VARCHAR(100) NOT NULL," +
"                   plat_nomor VARCHAR(100) NOT NULL" +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE pembayaran(" +
"                   ID_Pembayaran INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   ID_User INT NOT NULL," +
"                   ID_Driver INT NOT NULL," +
"                   price INT NOT NULL," +
"                   tanggal_pemesanan DATE NOT NULL," +
"                   metode_pembayaran VARCHAR(100) NOT NULL," +
"                   discount INT NOT NULL," +
"                   alamat_awal VARCHAR(255) NOT NULL" +
"                   alamat_tujuan VARCHAR(255) NOT NULL" +
"                   jarak INT NOT NULL" +
"                 )";
            stm.execute(sql);
            sql = "CREATE TABLE pesanan(" +
"                   ID_Pesanan INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   tipe_pesanan VARCHAR(100) NOT NULL," +
"                   alamat_jemput VARCHAR(255) NOT NULL," +
"                   alamat_tujuan VARCHAR(255) NOT NULL," +
"                   total_harga INT NOT NULL," +
"                   tanggal_pemesanan VARCHAR(100) NOT NULL" +
"                 )";
            stm.execute(sql);
            stm.close();
            conn.disconnect();
        }catch (Exception e){
            System.err.println("Connection Failure" + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new CreateTable();
    }
}
