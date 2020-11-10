/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Drivers;
import model.Member;
import model.Pesanan;
import model.Users;

/**
 *
 * @author dense
 */
public class DummyData {
    ArrayList<Pesanan> allPesanan = new ArrayList<>();
    ArrayList<Users> allUser = new ArrayList<>();
    public DummyData(){
        Pesanan pesanan = new Pesanan();
        pesanan.setIdPesanan(1);
        pesanan.setTipePesanan("UP SEND");
        pesanan.setAlamatJemput("Jl. Sukarajin 15");
        pesanan.setAlamatTujuan("Jl. Dipatiukur 10");
        pesanan.setTotalHarga(30000);
        pesanan.setTanggalPemesanan("11-10-2020");
        allPesanan.add(pesanan);
        
        Member member = new Member();
        member.setIdUser(1);
        member.setNama("Sebastian Berto");
        member.setEmail("sebastian@gmail.com");
        member.setAlamat("Jl. Dipatiukur No 1");
        member.setUsername("sebastian");
        member.setPassword("123456");
        member.setSaldoOVO(10000);
        member.setPesanan(allPesanan);
        allUser.add(member);
        
        Drivers driver = new Drivers();
        driver.setIdUser(2);
        driver.setNama("William Kolis");
        driver.setEmail("kolis@gmail.com");
        driver.setAlamat("Jl. Soreang No. 45");
        driver.setUsername("williamkolis");
        driver.setPassword("kolis123");
        driver.setKendaraan("Honda Beat");
        driver.setPlatNomor("D 2901 IF");
        driver.setPendapatan(0);
        driver.setStatus(false);
        driver.setPesanan(allPesanan);
        allUser.add(driver);
    }
    public ArrayList<Pesanan> getAllPesanan(){
        return allPesanan;
    }
    public ArrayList<Users> getAllUsers(){
        return allUser;
    }
}
