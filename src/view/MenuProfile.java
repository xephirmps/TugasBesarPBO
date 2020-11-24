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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Drivers;
import model.Member;

/**
 *
 * @author User
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
        
        if(MemberManager.getInstance().getLogin()){
            Member member = (Member) MemberManager.getInstance().getMember();
            labelIsiNama = new JLabel(MemberManager.getInstance().getMember().getNama());
            labelIsiUsername = new JLabel(MemberManager.getInstance().getMember().getUsername());
            labelIsiAlamat = new JLabel(MemberManager.getInstance().getMember().getAlamat());
            labelSaldoOvo = new JLabel("Saldo Ovo");
            labelIsiSaldo = new JLabel("Rp. " + member.getSaldoOVO());
            frame.add(labelSaldoOvo);
            frame.add(labelIsiSaldo);
        }else if(DriversManager.getInstance().getLogin()){
            Drivers driver = DriversManager.getInstance().getDrivers();
            labelIsiNama = new JLabel(DriversManager.getInstance().getDrivers().getNama());
            labelIsiUsername = new JLabel(DriversManager.getInstance().getDrivers().getUsername());
            labelIsiAlamat = new JLabel(DriversManager.getInstance().getDrivers().getAlamat());
        }
        
        
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
