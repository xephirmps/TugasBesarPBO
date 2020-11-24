/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseControl;
import controller.MemberManager;
import controller.PesananManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MenuMetodePembayaran {
    JFrame frame;
    private JLabel labelPembayaran;
    private JComboBox cbPembayaran;
    private JButton buttonNext, buttonBack, buttonLogout;
    public MenuMetodePembayaran(){
        frame = new JFrame("UP GRAB");
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String pembayaran[] = new String[2];
        pembayaran[0] = "CASH";
        pembayaran[1] = "OVO";
        
        labelPembayaran = new JLabel("Silahkan Pilih Metode Pembayaran");
        cbPembayaran = new JComboBox(pembayaran);
        buttonNext = new JButton("Next");
        buttonBack = new JButton("Back");
        buttonLogout = new JButton("Logout");
        
        labelPembayaran.setFont(new Font(labelPembayaran.getFont().getName(), labelPembayaran.getFont().getStyle(), 18));
        
        labelPembayaran.setBounds(100, 10, 300, 20);
        cbPembayaran.setBounds(120, 50, 200, 20);
        buttonNext.setBounds(170, 100, 100, 20);
        buttonBack.setBounds(10, 150, 100, 20);
        buttonLogout.setBounds(320, 150, 100, 20);
        
        int totalHarga = getRandomNumber() * 10000;
        totalHarga = totalHarga - (totalHarga * PesananManager.getInstance().getPesanan().getDiskon());
        PesananManager.getInstance().getPesanan().setTotalHarga(totalHarga);
        
        cbPembayaran.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(cbPembayaran.getSelectedItem().equals("OVO")){
                    if(MemberManager.getInstance().getMember().getSaldoOVO() < PesananManager.getInstance().getPesanan().getTotalHarga()){
                        JOptionPane.showMessageDialog(null, "Maaf, saldo OVO anda tidak mencukupi");
                    }
                }
            }
        });
        
        buttonNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(cbPembayaran.getSelectedItem().equals("OVO")){
                    if(MemberManager.getInstance().getMember().getSaldoOVO() < PesananManager.getInstance().getPesanan().getTotalHarga()){
                        JOptionPane.showMessageDialog(null, "Maaf, saldo OVO anda tidak mencukupi");
                    }
                }else{
                    int jawab = JOptionPane.showConfirmDialog(null, "Sudah Benar?");
                        if(jawab == JOptionPane.YES_OPTION){
                        PesananManager.getInstance().getPesanan().setMetodePembayaran(String.valueOf(cbPembayaran.getSelectedItem()));
                        frame.setVisible(false);
                        new MenuPembayaran();
                    }
                }
                
            }
        });
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin logout?");
                if(jawab == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Terima Kasih Telah Menggunakan Aplikasi Ini!!");
                    DatabaseControl.updateMember(MemberManager.getInstance().getMember());
                    frame.setVisible(false);
                    new MenuUpGrab2();
                }
            }
        });
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuCustomer();
            }
        });
        frame.add(cbPembayaran);
        frame.add(labelPembayaran);
        frame.add(buttonNext);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public int getRandomNumber(){
        Random getRandom = new Random();
        int getAngka = getRandom.nextInt(10);
        return getAngka;
    }
}
