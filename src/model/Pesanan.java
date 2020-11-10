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
    private int idPesanan;
    private String tipePesanan;
    private String alamatJemput;
    private String alamatTujuan;
    private int totalHarga;
    private String tanggalPemesanan;
    private int status;
    
    public Pesanan(){
        
    }

    public Pesanan(int idPesanan, String tipePesanan, String alamatJemput, String alamatTujuan, int totalHarga, String tanggalPemesanan, int status) {
        this.idPesanan = idPesanan;
        this.tipePesanan = tipePesanan;
        this.alamatJemput = alamatJemput;
        this.alamatTujuan = alamatTujuan;
        this.totalHarga = totalHarga;
        this.tanggalPemesanan = tanggalPemesanan;
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
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

    public String getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public void setTanggalPemesanan(String tanggalPemesanan) {
        this.tanggalPemesanan = tanggalPemesanan;
    }
}
