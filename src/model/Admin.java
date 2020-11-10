/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Admin extends Users{
    private boolean admin;
    
    public Admin(){
        
    }

    public Admin(boolean admin, int idUser, String nama, String alamat, String email, String username, String password) {
        super(idUser, nama, alamat, email, username, password);
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
