/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DatabaseControl;
import controller.MemberManager;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Member extends Users{
    private int saldoOVO;
    private ArrayList<Pesanan> Pesanan=new ArrayList<Pesanan>();
    
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

    @Override
    public boolean cekRegister(String username, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cekLogin(String username, String password) {
        ArrayList<Member> allMember = DatabaseControl.getAllMember();
        boolean ketemu = false;
        for(int i = 0; (!ketemu) && (i < allMember.size()); i++){
            if((allMember.get(i).getUsername().equals(username)) && (allMember.get(i).getPassword().equals(password))){
                ketemu = true;
                MemberManager.getInstance().setMember(allMember.get(i));
            }
        }
        return ketemu;
    }
    
    
}
