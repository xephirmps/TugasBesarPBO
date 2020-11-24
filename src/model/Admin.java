/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AdminManager;
import controller.DatabaseControl;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Admin extends Users{
    private boolean admin;
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean cekRegister(String username, String email) {
        return true;
    }

    @Override
    public boolean cekLogin(String username, String password) {
        ArrayList<Admin> allAdmin = DatabaseControl.getAllAdmin();
        boolean ketemu = false;
        for(int i = 0; (!ketemu) && (i < allAdmin.size()); i++){
            if((allAdmin.get(i).getUsername().equals(username)) && (allAdmin.get(i).getPassword().equals(password))){
                ketemu = true;
                AdminManager.getInstance().setAdmin(allAdmin.get(i));
            }
        }
        return ketemu;
    }
    
}
