/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DatabaseControl;
import java.sql.Driver;
import java.util.ArrayList;
import view.MenuCustomer;
import view.MenuDriver;

/**
 *
 * @author User
 */
public abstract class Users {
    private int idUser;
    private String nama;
    private String alamat;
    private String email;
    private String username;
    private String password;
    
    public int getIdUser(){
        return idUser;
    }
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public abstract boolean cekRegister(String username, String email);
    
    public abstract boolean cekLogin(String username, String password);
    
}
