/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Drivers;

/**
 *
 * @author User
 */
public class DriversManager {
    static DriversManager instance;
    private Drivers driver;
    private boolean login;
    
    public static DriversManager getInstance() {
        if (instance == null) {
            instance = new DriversManager();
        }
        return instance;
    }
    
    public Drivers getDrivers() {
        return driver;
    }

    public void setDrivers(Drivers driver) {
        this.driver = driver;
    }
    public boolean getLogin(){
        return login;
    }
    public void setLogin(boolean login){
        this.login = login;
    }
}
