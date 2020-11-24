/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminManager;
import controller.DriversManager;
import controller.MemberManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Drivers;
import model.Member;
import model.Pesanan;

/**
 *
 * @author User
 */
public class MenuHistory {
    private JTable tableHistory;
    private JButton buttonBack, buttonLogout;
    private JScrollPane sp;
    JFrame frame = new JFrame();
    public MenuHistory(){
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Pesanan> allPesanan = new ArrayList<>();
        String kolom[] = {"ID", "Tipe Pesanan", "Tanggal Pemesanan", "Alamat Jemput", "Alamat Tujuan", "Total Harga", "Status"};
        
        if(MemberManager.getInstance().getLogin()){
            Member member = MemberManager.getInstance().getMember();
            allPesanan = member.getPesanan();
        }else if(DriversManager.getInstance().getLogin()){
            Drivers driver = DriversManager.getInstance().getDrivers();
            allPesanan = driver.getPesanan();
        }
        String[][] data = new String[allPesanan.size()][7];

        for(int i = 0; i < allPesanan.size(); i++){
            String status;
            if(allPesanan.get(i).getStatus() == 2){
                status = "Selesai";
            }else if(allPesanan.get(i).getStatus() == 1){
                status = "Diterima";
            }else{
                status = "Belum Diterima";
            }
            data[i][0] = String.valueOf(allPesanan.get(i).getIdPesanan());
            data[i][1] = allPesanan.get(i).getTipePesanan();
            data[i][2] = allPesanan.get(i).getTanggalPemesanan();
            data[i][3] = allPesanan.get(i).getAlamatJemput();
            data[i][4] = allPesanan.get(i).getAlamatTujuan();
            data[i][5] = "Rp. " + String.valueOf(allPesanan.get(i).getTotalHarga());
            data[i][6] = status;
        }
        
        tableHistory = new JTable(data, kolom);
        buttonBack = new JButton("Back");
        buttonLogout = new JButton("Logout");
        
        tableHistory.setBounds(30, 40, 800, 300);
        buttonBack.setBounds(300, 300, 100, 20);
        buttonLogout.setBounds(410, 300, 100, 20);
        
        sp = new JScrollPane(tableHistory);
        
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        JOptionPane.showMessageDialog(null, "Terima kasih terlah menggunakan aplikasi ini!");
                        frame.setVisible(false);
                        if(MemberManager.getInstance().getLogin()){
                            MemberManager.getInstance().setLogin(false);
                            MemberManager.getInstance().setMember(null);
                        }else if(AdminManager.getInstance().getLogin()){
                            AdminManager.getInstance().setLogin(false);
                            AdminManager.getInstance().setAdmin(null);
                        }else if(DriversManager.getInstance().getLogin()){
                            DriversManager.getInstance().setLogin(false);
                            DriversManager.getInstance().setDrivers(null);
                        }
                        new MenuLogin();
                }
            }
        });
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(MemberManager.getInstance().getLogin()){
                    frame.setVisible(false);
                    new MenuCustomer();
                }else if(DriversManager.getInstance().getLogin()){
                    frame.setVisible(false);
                    new MenuDriver();
                }
            }
        });
        frame.add(buttonBack);
        frame.add(buttonLogout);
        frame.add(sp);
        frame.setVisible(true);
    }
}
