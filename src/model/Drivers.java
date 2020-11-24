/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DatabaseControl;
import controller.DriversManager;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Drivers extends Users{
    private String kendaraan;
    private String platNomor;
    private int pendapatan;
    private boolean status;
    private ArrayList<Pesanan> Pesanan = new ArrayList<Pesanan>();
    
    public String getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(String kendaraan) {
        this.kendaraan = kendaraan;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public int getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(int pendapatan) {
        this.pendapatan = pendapatan;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Pesanan> getPesanan() {
        return Pesanan;
    }

    public void setPesanan(ArrayList<Pesanan> Pesanan) {
        this.Pesanan = Pesanan;
    }

    @Override
    public boolean cekRegister(String username, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cekLogin(String username, String password) {
        ArrayList<Drivers> allDriver = DatabaseControl.getAllDriver();
        boolean ketemu = false;
        for(int i = 0; (!ketemu) && (i < allDriver.size()); i++){
            if((allDriver.get(i).getUsername().equals(username)) && (allDriver.get(i).getPassword().equals(password))){
                ketemu = true;
                DriversManager.getInstance().setDrivers(allDriver.get(i));
            }
        }
        return ketemu;
    }
}
