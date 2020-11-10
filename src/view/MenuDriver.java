/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.UserManager;
import controller.Controller;
import controller.DummyData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Drivers;
import model.Pesanan;
import model.Users;

/**
 *
 * @author Sebastian
 */
public class MenuDriver {
    private JComboBox boxTipe, boxAlamatJemput, boxAlamatTujuan, boxTanggal;
    private JLabel labelTipe, labelOrder, labelAlamatJemput, labelAlamatTujuan, labelTanggal, labelTotalHarga, labelIsiTotalHarga;
    private JButton buttonSubmit, buttonLogout;
    private ArrayList<Pesanan> allPesanan = new ArrayList<>();
    private boolean upgrab = false, upsend = false;
    
    JFrame frame = new JFrame();
    public MenuDriver(){
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DummyData data = new DummyData();
        
        allPesanan = data.getAllPesanan();
        labelTipe = new JLabel("Tipe Order");
        
        boxTipe = new JComboBox();
        boxAlamatJemput = new JComboBox();
        boxAlamatTujuan = new JComboBox();
        boxTanggal = new JComboBox();
        
        labelOrder = new JLabel("Tidak ada order");
        labelAlamatJemput = new JLabel("Alamat Jemput");
        labelAlamatTujuan = new JLabel("Alamat Tujuan");
        labelTanggal = new JLabel("Tanggal");
        labelTotalHarga = new JLabel("Total Harga: ");
        labelIsiTotalHarga = new JLabel("");
        
        buttonSubmit = new JButton("Submit");
        buttonLogout = new JButton("Logout");
        
        boxTipe.addItem("UP SEND");
        boxTipe.addItem("UP GRAB");
        
        boxTipe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boxAlamatJemput.removeAllItems();
                boxAlamatTujuan.removeAllItems();
                boxTanggal.removeAllItems();
                labelIsiTotalHarga.setText("");
                for(int i = 0; i < allPesanan.size(); i++){
                    if(boxTipe.getSelectedItem().equals(allPesanan.get(i).getTipePesanan())){
                        boxAlamatJemput.addItem(allPesanan.get(i).getAlamatJemput());
                        boxAlamatTujuan.addItem(allPesanan.get(i).getAlamatTujuan());
                        boxTanggal.addItem(allPesanan.get(i).getTanggalPemesanan());
                        labelIsiTotalHarga.setText("Rp. " + String.valueOf(allPesanan.get(i).getTotalHarga()));
                    }
                }
            }
        });
        
        if(allPesanan.isEmpty()){
            frame.remove(boxAlamatJemput);
            frame.remove(boxAlamatTujuan);
            frame.remove(boxTanggal);
            frame.remove(labelAlamatJemput);
            frame.remove(labelAlamatTujuan);
            frame.remove(labelTanggal);
            frame.remove(labelTotalHarga);
            frame.remove(labelIsiTotalHarga);
            frame.add(labelOrder);
        }else{
            frame.add(boxAlamatJemput);
            frame.add(boxAlamatTujuan);
            frame.add(boxTanggal);
            frame.add(labelAlamatJemput);
            frame.add(labelAlamatTujuan);
            frame.add(labelTanggal);
            frame.add(labelTotalHarga);
            frame.add(labelIsiTotalHarga);
            frame.add(buttonSubmit);
            frame.remove(labelOrder);
            
        }
        
        labelTipe.setBounds(50, 30, 200, 20);
        labelAlamatJemput.setBounds(50, 60, 200, 20);
        labelAlamatTujuan.setBounds(50, 90, 200, 20);
        labelTanggal.setBounds(50, 120, 200, 20);
        labelTotalHarga.setBounds(50, 150, 200, 20);
        
        labelOrder.setBounds(100, 60, 200, 20);
        
        boxTipe.setBounds(150, 30, 200, 20);
        boxAlamatJemput.setBounds(150, 60, 200, 20);
        boxAlamatTujuan.setBounds(150, 90, 200, 20);
        boxTanggal.setBounds(150, 120, 200, 20);
        labelIsiTotalHarga.setBounds(160, 150, 200, 20);
        
        buttonSubmit.setBounds(100, 180, 100, 20);
        buttonLogout.setBounds(210, 180, 100, 20);
        
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        UserManager.getInstance().setUser(null);
                        frame.setVisible(false);
                        new MenuLogin();
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                    default:
                        break;
                }
            }
        });
        buttonSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin terima?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        for(int i = 0; i < allPesanan.size(); i++){
                            if(boxTipe.getSelectedItem().equals(allPesanan.get(i).getTipePesanan())){
                                if(boxAlamatJemput.getSelectedItem().equals(allPesanan.get(i).getAlamatJemput())){
                                    if(boxAlamatTujuan.getSelectedItem().equals(allPesanan.get(i).getAlamatTujuan())){
                                        Pesanan pesanan = allPesanan.get(i);
                                        pesanan.setStatus(true);
                                        Users user = UserManager.getInstance().getUser();
                                        Drivers driver = (Drivers) user;
                                        driver.setStatus(true);
                                        JOptionPane.showMessageDialog(null, "Selamat!! Pesanan diterima!!");
                                    }
                                }
                            }
                        }
                }
            }
        });
        frame.add(buttonLogout);
        frame.add(labelTipe);
        frame.add(boxTipe);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
