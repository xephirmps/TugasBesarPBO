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
public class Member extends Users{
    int saldoOVO;
    ArrayList<Pesanan> Pesanan=new ArrayList<Pesanan>();
    
    public Member(){
        
    }

    public Member(ArrayList Pesanan, int saldoOVO, String nama, String alamat, String email, String username, String password) {
        super(nama, alamat, email, username, password);
        this.Pesanan = Pesanan;
        this.saldoOVO = saldoOVO;
    }

    public int getSaldoOVO() {
        return saldoOVO;
    }

    public void setSaldoOVO(int saldoOVO) {
        this.saldoOVO = saldoOVO;
    }

    public ArrayList<Pesanan> getPesanan() {
        return Pesanan;
    }

    public void setPesanan(ArrayList<Pesanan> Pesanan) {
        this.Pesanan = Pesanan;
    }
    
    
}
