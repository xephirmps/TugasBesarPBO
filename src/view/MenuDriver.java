/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseControl;
import controller.DriversManager;
import java.awt.Font;
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
    private JLabel labelAda, labelTipe, labelOrder, labelAlamatJemput, labelAlamatTujuan, labelTanggal, labelTotalHarga, labelIsiTotalHarga;
    private JButton buttonSelesai, buttonSubmit, buttonLogout;
    private ArrayList<Pesanan> allPesanan = new ArrayList<>();
    private boolean upgrab = false, upsend = false;
    
    JFrame frame = new JFrame();
    public MenuDriver(){
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(DriversManager.getInstance().getDrivers().getStatus()){
            labelAda = new JLabel("Anda Sedang Memiliki Pesanan");
            buttonSelesai = new JButton("Selesai");
            labelAda.setBounds(150, 50, 300, 20);
            buttonSelesai.setBounds(150, 180, 100, 20);
            labelAda.setFont(new Font(labelAda.getFont().getName(), labelAda.getFont().getStyle(), 17));

            buttonSelesai.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ArrayList<Pesanan> allPesanan = DatabaseControl.getAllPesanan();
                    for(int i = 0; i < allPesanan.size(); i++){
                        if(allPesanan.get(i).getIdDriver() == DriversManager.getInstance().getDrivers().getIdUser() && allPesanan.get(i).getStatus() == 1){
                            JOptionPane.showMessageDialog(null, "Saldo sudah masuk");
                            DriversManager.getInstance().getDrivers().setPendapatan(DriversManager.getInstance().getDrivers().getPendapatan() + allPesanan.get(i).getTotalHarga());
                            allPesanan.get(i).setStatus(2);
                            DriversManager.getInstance().getDrivers().setStatus(false);
                            DatabaseControl.updateDriver(DriversManager.getInstance().getDrivers());
                            DatabaseControl.setStatusPesanan(allPesanan.get(i), DriversManager.getInstance().getDrivers().getIdUser());
                            frame.setVisible(false);
                            new MenuDriver();
                        }
                    }
                }
            });
            frame.add(labelAda);
            frame.add(buttonSelesai);
        }else{
            allPesanan = DatabaseControl.getAllPesanan();
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
                        if(boxTipe.getSelectedItem().equals(allPesanan.get(i).getTipePesanan()) && allPesanan.get(i).getStatus() == 0){
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
                            DriversManager.getInstance().setDrivers(null);
                            DriversManager.getInstance().setLogin(false);
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
                                            pesanan.setStatus(1);
                                            DriversManager.getInstance().getDrivers().setStatus(true);
                                            DatabaseControl.setStatusPesanan(pesanan, DriversManager.getInstance().getDrivers().getIdUser());
                                            DatabaseControl.updateDriver(DriversManager.getInstance().getDrivers());
                                            JOptionPane.showMessageDialog(null, "Selamat!! Pesanan diterima!!");
                                            frame.setVisible(false);
                                            new MenuDriver();
                                        }
                                    }
                                }
                            }
                        break;
                        case JOptionPane.NO_OPTION:
                            break;
                        default:
                            break;
                    }
                }
            });
            frame.add(buttonLogout);
            frame.add(labelTipe);
            frame.add(boxTipe);
        }
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
