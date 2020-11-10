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
import model.Drivers;
import model.Member;

/**
 *
 * @author dense
 */
public class MenuProfile {
    private JLabel labelNama, labelUsername, labelAlamat, labelSaldoOvo, labelIsiNama, labelIsiUsername, labelIsiAlamat, labelIsiSaldo;
    private JButton buttonBack, buttonLogout;
    JFrame frame = new JFrame("My Profile");
    public MenuProfile(){
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelNama = new JLabel("Nama");
        labelUsername = new JLabel("Username");
        labelAlamat = new JLabel("Alamat");
        
        buttonBack = new JButton("Back");
        buttonLogout = new JButton("Logout");
        
        if(UserManager.getInstance().getUser() instanceof Member){
            Member member = (Member) UserManager.getInstance().getUser();
            labelSaldoOvo = new JLabel("Saldo Ovo");
            labelIsiSaldo = new JLabel("Rp. " + member.getSaldoOVO());
            frame.add(labelSaldoOvo);
            frame.add(labelIsiSaldo);
        }else if(UserManager.getInstance().getUser() instanceof Drivers){
            Drivers driver = (Drivers) UserManager.getInstance().getUser();
        }
        labelIsiNama = new JLabel(UserManager.getInstance().getUser().getNama());
        labelIsiUsername = new JLabel(UserManager.getInstance().getUser().getUsername());
        labelIsiAlamat = new JLabel(UserManager.getInstance().getUser().getAlamat());
        
        labelNama.setBounds(50, 10, 100, 20);
        labelUsername.setBounds(50, 40, 100, 20);
        labelAlamat.setBounds(50, 70, 100, 20);
        labelSaldoOvo.setBounds(50, 100, 100, 20);
        
        labelIsiNama.setBounds(120, 10, 200, 20);
        labelIsiUsername.setBounds(120, 40, 200, 20);
        labelIsiAlamat.setBounds(120, 70, 200, 20);
        labelIsiSaldo.setBounds(120, 100, 200, 20);
        
        buttonBack.setBounds(100, 180, 100, 20);
        buttonLogout.setBounds(210, 180, 100, 20);
        
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
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(UserManager.getInstance().getUser() instanceof Member){
                    frame.setVisible(false);
                    new MenuCustomer();
                }else if(UserManager.getInstance().getUser() instanceof Drivers){
                    frame.setVisible(false);
                    new MenuDriver();
                }
            }
        });
        
        frame.add(labelNama);
        frame.add(labelUsername);
        frame.add(labelAlamat);
        frame.add(labelIsiNama);
        frame.add(labelIsiUsername);
        frame.add(buttonBack);
        frame.add(buttonLogout);
        frame.add(labelIsiAlamat);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
