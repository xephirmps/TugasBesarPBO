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
public class Pembayaran extends Pesanan{
    private String metodePembayaran;
    private int diskon;
    
    public Pembayaran(){
        
    }

    public Pembayaran(String metodePembayaran, int diskon, int idPesanan, String tipePesanan, String alamatJemput, String alamatTujuan, int totalHarga, String tanggalPemesanan, int status) {
        super(idPesanan, tipePesanan, alamatJemput, alamatTujuan, totalHarga, tanggalPemesanan, status);
        this.metodePembayaran = metodePembayaran;
        this.diskon = diskon;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }
    
    
}
