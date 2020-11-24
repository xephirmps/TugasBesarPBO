/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminManager;
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
public class MenuAdmin {
    private JLabel labelNama;
    private JButton buttonLogout, buttonDriver;
    
    JFrame frame = new JFrame();
    public MenuAdmin(){
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelNama = new JLabel("Welcome " + AdminManager.getInstance().getAdmin().getNama());
        buttonLogout = new JButton("Logout");
        buttonDriver = new JButton("Driver");
        
        labelNama.setBounds(10, 10, 200, 20);
        buttonLogout.setBounds(300, 10, 100, 20);
        buttonDriver.setBounds(150, 180, 100, 20);
        
        buttonDriver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuListDriver();
            }
        });
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        JOptionPane.showMessageDialog(null, "Terima kasih terlah menggunakan aplikasi ini!");
                        frame.setVisible(false);
                        AdminManager.getInstance().setAdmin(null);
                        AdminManager.getInstance().setLogin(false);
                        new MenuLogin();
                }
            }
        });
        frame.add(buttonDriver);
        frame.add(labelNama);
        frame.add(buttonLogout);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
