/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import Controller.UserManager;
import controller.DummyData;
import java.util.ArrayList;
import view.MenuCustomer;
import view.MenuDriver;

/**
 *
 * @author User
 */
public class Users {
    private int idUser;
    private String nama;
    private String alamat;
    private String email;
    private String username;
    private String password;
    
    public Users (){
        
    }

    public Users(int idUser, String nama, String alamat, String email, String username, String password) {
        this.idUser = idUser;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
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
    
    public boolean cekRegister(String username, String email){
        ArrayList<Users> users = Controller.getAllUsers();
        int i = 0;
        boolean status = true;
        while(status && i < users.size()){
            if(username.equals(users.get(i).getUsername()) && email.equals(users.get(i).getEmail())){
                status = false;
            }
            i++;
        }
        return status;
    }
    
    public String cekLogin(String username, String password){
        int i = 0;
        DummyData data = new DummyData(); //panggil semua data user/akun.
        ArrayList<Users> allUser = new ArrayList<>();
        allUser = data.getAllUsers();
        String tipe = "";
        boolean status = false;
        
        while (status == false && i < allUser.size()) {
            if(allUser.get(i) instanceof Member){
                Member member = (Member) allUser.get(i);
                if(username.equals(member.getUsername()) && password.equals(member.getPassword())){
                    UserManager.getInstance().setUser(member);
                    status = true;
                    tipe = "member";
                }
            }else if(allUser.get(i) instanceof Drivers){
                Drivers driver = (Drivers) allUser.get(i);
                if(username.equals(driver.getUsername()) && password.equals(driver.getPassword())){
                    UserManager.getInstance().setUser(driver);
                    status = true;
                    tipe = "driver";
                }
            }else if(allUser.get(i) instanceof Admin){
                Admin admin = (Admin) allUser.get(i);
                if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
                    UserManager.getInstance().setUser(admin);
                    status = true;
                    tipe = "admin";
                }
            }
            i++;
        }
        return(tipe);
    }
    
}
