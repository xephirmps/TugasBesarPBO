/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MemberManager;
import controller.PesananManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Pesanan;

/**
 *
 * @author User
 */
public class MenuCustomer {
    private JLabel labelNama;
    private JButton buttonLogout, buttonProfil, buttonUpGrab, buttonUpSend, buttonHistory;
    
    JFrame frame = new JFrame();
    public MenuCustomer(){
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelNama = new JLabel("Welcome " + MemberManager.getInstance().getMember().getNama());
        buttonLogout = new JButton("Logout");
        buttonProfil = new JButton("Profile");
        buttonHistory = new JButton("History");
        buttonUpGrab = new JButton("UP GRAB");
        buttonUpSend = new JButton("UP SEND");
        
        labelNama.setBounds(10, 10, 200, 20);
        buttonLogout.setBounds(300, 10, 100, 20);
        buttonHistory.setBounds(100, 180, 100, 20);
        buttonProfil.setBounds(210, 180, 100, 20);
        buttonUpGrab.setBounds(100, 80, 100, 30);
        buttonUpSend.setBounds(210, 80, 100, 30);
        
        buttonUpGrab.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Pesanan pesanan = new Pesanan();
                PesananManager.getInstance().setPesanan(pesanan);
                PesananManager.getInstance().getPesanan().setTipePesanan("UP GRAB");
                frame.setVisible(false);
                new MenuUpGrab1();
            }
        });
        buttonHistory.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuHistory();
            }
        });
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        JOptionPane.showMessageDialog(null, "Terima kasih terlah menggunakan aplikasi ini!");
                        frame.setVisible(false);
                        MemberManager.getInstance().setMember(null);
                        MemberManager.getInstance().setLogin(false);
                        new MenuLogin();
                }
            }
        });
        buttonProfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MenuProfile();
            }
        });
        frame.add(buttonHistory);
        frame.add(buttonProfil);
        frame.add(labelNama);
        frame.add(buttonLogout);
        frame.add(buttonUpGrab);
        frame.add(buttonUpSend);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
