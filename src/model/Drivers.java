/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Drivers extends Users{
    String kendaraan;
    String platNomor;
    int pendapatan;
    boolean status;
    ArrayList<Pesanan> Pesanan=new ArrayList<Pesanan>();
    
    public Drivers(){
        
    }

    public Drivers(String kendaraan, String platNomor, int pendapatan, boolean status, String nama, String alamat, String email, String username, String password) {
        super(nama, alamat, email, username, password);
        this.kendaraan = kendaraan;
        this.platNomor = platNomor;
        this.pendapatan = pendapatan;
        this.status = status;
    }

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

    public boolean isStatus() {
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
}
