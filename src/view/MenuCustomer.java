/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.UserManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
        
        labelNama = new JLabel("Welcome " + UserManager.getInstance().getUser().getNama());
        buttonLogout = new JButton("Logout");
        buttonProfil = new JButton("Profile");
        buttonHistory = new JButton("History");
        
        labelNama.setBounds(10, 10, 200, 20);
        buttonLogout.setBounds(300, 10, 100, 20);
        buttonHistory.setBounds(100, 180, 100, 20);
        buttonProfil.setBounds(210, 180, 100, 20);
        
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
                        UserManager.getInstance().setUser(null);
                        new MenuLogin();
                }
            }
        });
        frame.add(buttonHistory);
        frame.add(buttonProfil);
        frame.add(labelNama);
        frame.add(buttonLogout);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
