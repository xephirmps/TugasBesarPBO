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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class MenuUpGrab2 {
    JFrame frame;
    private JLabel labelAlamat;
    private JTextField tfAlamat;
    private JButton buttonNext, buttonBack, buttonLogout;
    public MenuUpGrab2(){
        frame = new JFrame("UP GRAB");
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelAlamat = new JLabel("Silahkan Isi Alamat Tujuan");
        tfAlamat = new JTextField();
        buttonNext = new JButton("Next");
        buttonBack = new JButton("Back");
        buttonLogout = new JButton("Logout");
        
        labelAlamat.setFont(new Font(labelAlamat.getFont().getName(), labelAlamat.getFont().getStyle(), 18));
        
        labelAlamat.setBounds(100, 10, 300, 20);
        tfAlamat.setBounds(120, 50, 200, 20);
        buttonNext.setBounds(170, 100, 100, 20);
        buttonBack.setBounds(10, 150, 100, 20);
        buttonLogout.setBounds(320, 150, 100, 20);
        
        buttonNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(tfAlamat.getText().equals(PesananManager.getInstance().getPesanan().getAlamatJemput())){
                    JOptionPane.showMessageDialog(null, "Maaf, Alamat Jemput dan Alamat Tujuan Tidak Boleh Sama!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    int jawab = JOptionPane.showConfirmDialog(null, "Sudah Benar?");
                    if(jawab == JOptionPane.YES_OPTION){
                        PesananManager.getInstance().getPesanan().setAlamatTujuan(String.valueOf(tfAlamat.getText()));
                        frame.setVisible(false);
                        new MenuUpGrab3();
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
                    new MenuLogin();
                }
            }
        });
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuUpGrab1();
            }
        });
        frame.add(tfAlamat);
        frame.add(labelAlamat);
        frame.add(buttonNext);
        frame.add(buttonLogout);
        frame.add(buttonBack);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
