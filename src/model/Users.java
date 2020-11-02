/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Users {
    public String nama;
    public String alamat;
    public String email;
    public String username;
    public String password;
    
    public Users (){
        
    }

    public Users(String nama, String alamat, String email, String username, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.username = username;
        this.password = password;
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
        
    public boolean CekLogin(String username, String password){
        int i = 0;
        Users akun = new Users();
        ArrayList <Users> users = controller.getAllUsers(); //panggil semua data user/akun.
        boolean status = false;
        
        while (status == false && i < users.size()) {
            if(username.equals(users.get(i).username) && password.equals(users.get(i).password)){
                status = true;
            }
            i++;
        }
        return(status);
    }
    
}
