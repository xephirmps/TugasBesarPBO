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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Drivers;

/**
 *
 * @author User
 */
public class MenuUpGrab3 {
    JFrame frame;
    private JLabel labelKendaraan;
    private JComboBox cbKendaraan;
    private JButton buttonNext, buttonBack, buttonLogout;
    public MenuUpGrab3(){
        frame = new JFrame("UP GRAB");
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String kendaraan[] = new String[2];
        kendaraan[0] = "Mobil";
        kendaraan[1] = "Motor";
        
        labelKendaraan = new JLabel("Silahkan Pilih Kendaraan");
        cbKendaraan = new JComboBox(kendaraan);
        buttonNext = new JButton("Next");
        buttonBack = new JButton("Back");
        buttonLogout = new JButton("Logout");
        
        labelKendaraan.setFont(new Font(labelKendaraan.getFont().getName(), labelKendaraan.getFont().getStyle(), 18));
        
        labelKendaraan.setBounds(100, 10, 300, 20);
        cbKendaraan.setBounds(120, 50, 200, 20);
        buttonNext.setBounds(170, 100, 100, 20);
        buttonBack.setBounds(10, 150, 100, 20);
        buttonLogout.setBounds(320, 150, 100, 20);
        
        buttonNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Sudah Benar?");
                if(jawab == JOptionPane.YES_OPTION){
                    PesananManager.getInstance().getPesanan().setIdDriver(0);
                    frame.setVisible(false);
                    new MenuMetodePembayaran();
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
        frame.add(cbKendaraan);
        frame.add(labelKendaraan);
        frame.add(buttonNext);
        frame.add(buttonBack);
        frame.add(buttonLogout);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
