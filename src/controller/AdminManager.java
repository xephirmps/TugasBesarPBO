/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Admin;


/**
 *
 * @author User
 */
public class AdminManager {
    static AdminManager instance;
    private Admin admin;
    private boolean login;
    
    public static AdminManager getInstance() {
        if (instance == null) {
            instance = new AdminManager();
        }
        return instance;
    }
    
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    public boolean getLogin(){
        return login;
    }
    public void setLogin(boolean login){
        this.login = login;
    }
}
