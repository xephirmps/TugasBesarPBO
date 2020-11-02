/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Pesanan {
    int idPesanan;
    String tipePesanan;
    String alamatJemput;
    String alamatTujuan;
    int totalHarga;
    Date tanggalPemesanan;
    
    public Pesanan(){
        
    }

    public Pesanan(int idPesanan, String tipePesanan, String alamatJemput, String alamatTujuan, int totalHarga, Date tanggalPemesanan) {
        this.idPesanan = idPesanan;
        this.tipePesanan = tipePesanan;
        this.alamatJemput = alamatJemput;
        this.alamatTujuan = alamatTujuan;
        this.totalHarga = totalHarga;
        this.tanggalPemesanan = tanggalPemesanan;
    }

    public int getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(int idPesanan) {
        this.idPesanan = idPesanan;
    }

    public String getTipePesanan() {
        return tipePesanan;
    }

    public void setTipePesanan(String tipePesanan) {
        this.tipePesanan = tipePesanan;
    }

    public String getAlamatJemput() {
        return alamatJemput;
    }

    public void setAlamatJemput(String alamatJemput) {
        this.alamatJemput = alamatJemput;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Date getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public void setTanggalPemesanan(Date tanggalPemesanan) {
        this.tanggalPemesanan = tanggalPemesanan;
    }
}
