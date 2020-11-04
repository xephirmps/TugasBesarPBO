/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Users;

/**
 *
 * @author User
 */
public class register extends JFrame implements ActionListener{
    JPanel panel;
    JFrame registerFrame = new JFrame("Register");
    
    JLabel l_nama = new JLabel("Nama");
    JTextField tf_nama = new JTextField();
    
    JLabel l_email = new JLabel("Username");
    JTextField tf_email = new JTextField();
    
    JLabel l_username = new JLabel("Username");
    JTextField tf_username = new JTextField();

    JLabel l_password = new JLabel("Password");
    JTextField tf_password = new JTextField();
    
    JLabel l_alamat = new JLabel("Alamat");
    JTextField tf_alamat = new JTextField();
    
    JLabel l_register = new JLabel("Register");
    
    JButton btn_insert = new JButton("Submit");
    JButton btn_login = new JButton("Login");

    
    public register(){
        registerFrame.setSize(450,250);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        l_nama.setText("Nama ");
        l_nama.setBounds(10,0,150,50);
        tf_nama.setBounds(160,15, 250, 20);
        registerFrame.add(tf_nama);
        registerFrame.add(l_nama);
        
        l_email.setText("Email ");
        l_email.setBounds(10,25,150,50);
        tf_email.setBounds(160,40, 250, 20);
        registerFrame.add(tf_email);
        registerFrame.add(l_email);
        
        l_username.setText("Username ");
        l_username.setBounds(10,50,150,50);
        tf_username.setBounds(160,65, 250, 20);
        registerFrame.add(tf_username);
        registerFrame.add(l_username);
        
        l_password.setText("Password ");
        l_password.setBounds(10,75,150,50);
        tf_password.setBounds(160,90, 250, 20);
        registerFrame.add(tf_password);
        registerFrame.add(l_password);
        
        l_alamat.setText("Alamat ");
        l_alamat.setBounds(10,100,150,50);
        tf_alamat.setBounds(160,115, 250, 20);
        registerFrame.add(tf_alamat);
        registerFrame.add(l_alamat);
        
        btn_insert.setBounds(10,150,80,30);
        btn_insert.setActionCommand("Submit");
        btn_insert.addActionListener(this);
        registerFrame.add(btn_insert);
        
        btn_login.setBounds(290,150,100,30);
        btn_login.setActionCommand("Login");
        btn_login.addActionListener(this);
        registerFrame.add(btn_login);
        
        l_register.setText("Sudah punya akun? Login ");
        l_register.setBounds(275,170,200,50);
        registerFrame.add(l_register);
        
        registerFrame.setLayout(null);
        registerFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Submit":
                Users new_user = new Users();
                new_user.nama = tf_nama.getText();
                new_user.email = tf_email.getText();
                new_user.username = tf_username.getText();
                new_user.password = tf_password.getText();
                new_user.alamat = tf_alamat.getText();
                boolean CekRegister = Users.CekRegister(new_user.username, new_user.email);
                if(CekRegister){
                    JOptionPane.showMessageDialog(registerFrame, "Username atau Email Sudah Terdaftar!", "Error", JOptionPane.WARNING_MESSAGE);
                }else{
                    Controller.insertNewUser(new_user);
                    JOptionPane.showMessageDialog(registerFrame, "Register Berhasil!");
                    //masukkan menu selanjutnya
                }
                break;
            case "Login":
                new login();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
