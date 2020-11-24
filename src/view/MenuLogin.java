/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminManager;
import controller.DatabaseControl;
import controller.DriversManager;
import controller.MemberManager;
import model.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Admin;
import model.Drivers;
import model.Member;

/**
 *
 * @author User
 */
public class MenuLogin extends JFrame implements ActionListener{
    JFrame loginFrame = new JFrame("Login");
    
    JLabel l_username = new JLabel("Username");
    JTextField tf_username = new JTextField();

    JLabel l_password = new JLabel("Password");
    JPasswordField tf_password = new JPasswordField();
    
    JLabel l_register = new JLabel("Register");
    
    JButton btn_insert = new JButton("Submit");
    JButton btn_register = new JButton("Register");

    
    public MenuLogin(){
        loginFrame.setSize(450,250);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        l_username.setText("Username ");
        l_username.setBounds(10,0,150,50);
        tf_username.setBounds(160,15, 250, 20);
        loginFrame.add(tf_username);
        loginFrame.add(l_username);
        
        l_password.setText("Password ");
        l_password.setBounds(10,25,150,50);
        tf_password.setBounds(160,40, 250, 20);
        loginFrame.add(tf_password);
        loginFrame.add(l_password);
        
        btn_insert.setBounds(10,110,80,30);
        btn_insert.setActionCommand("Submit");
        btn_insert.addActionListener(this);
        loginFrame.add(btn_insert);
        
        btn_register.setBounds(290,110,100,30);
        btn_register.setActionCommand("Register");
        btn_register.addActionListener(this);
        loginFrame.add(btn_register);
        
        l_register.setText("Belum punya akun? Register ");
        l_register.setBounds(250,130,200,50);
        loginFrame.add(l_register);
        
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Submit":
                String username = tf_username.getText();
                String password = tf_password.getText();
                Member member = new Member();
                Admin admin = new Admin();
                Drivers driver = new Drivers();
                if(member.cekLogin(username, password)){
                    JOptionPane.showMessageDialog(null, "Welcome " + MemberManager.getInstance().getMember().getNama());
                    MemberManager.getInstance().setLogin(true);
                    loginFrame.setVisible(false);
                    new MenuCustomer();
                }else if(driver.cekLogin(username, password)){
                    JOptionPane.showMessageDialog(null, "Welcome " + DriversManager.getInstance().getDrivers().getNama());
                    DriversManager.getInstance().setLogin(true);
                    loginFrame.setVisible(false);
                    new MenuDriver();
                }else if(admin.cekLogin(username, password)){
                    JOptionPane.showMessageDialog(null, "Welcome " + AdminManager.getInstance().getAdmin().getNama());
                    AdminManager.getInstance().setLogin(true);
                    loginFrame.setVisible(false);
                    new MenuAdmin();
                }else{
                    JOptionPane.showMessageDialog(null, "Username / Password Salah!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    tf_username.setText("");
                    tf_password.setText("");
                }
                break;
            case "Register":
                loginFrame.setVisible(false);
                new MenuRegister();
                
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
    
}
