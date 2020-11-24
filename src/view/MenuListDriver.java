/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminManager;
import controller.DatabaseControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Drivers;

/**
 *
 * @author User
 */
public class MenuListDriver {
    private JButton buttonBack;
    private JTable tableDriver;
    private JScrollPane sp;
    JFrame frame = new JFrame();
    public MenuListDriver(){
        frame.setSize(800, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Drivers> allDriver = DatabaseControl.getAllDriver();
        String[][] data = new String[allDriver.size()][9];
        String column[] = {"ID Driver", "Nama", "Alamat", "Email", "Username", "Kendaraan", "Plat Nomor", "Pendapatan", "Status"};
        for(int i = 0; i < allDriver.size(); i++){
            data[i][0] = String.valueOf(allDriver.get(i).getIdUser());
            data[i][1] = allDriver.get(i).getNama();
            data[i][2] = allDriver.get(i).getAlamat();
            data[i][3] = allDriver.get(i).getEmail();
            data[i][4] = allDriver.get(i).getUsername();
            data[i][5] = allDriver.get(i).getKendaraan();
            data[i][6] = allDriver.get(i).getPlatNomor();
            data[i][7] = String.valueOf(allDriver.get(i).getPendapatan());
            if(allDriver.get(i).getStatus()){
                data[i][8] = "Not Ready";
            }else{
                data[i][8] = "Ready";
            }
        }
        
        tableDriver = new JTable(data, column);
        tableDriver.setBounds(0, 1000, 500, 150);
        tableDriver.setCellSelectionEnabled(true);
        sp = new JScrollPane(tableDriver);
        sp.setBounds(0, 1000, 500, 150);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(300, 180, 100, 20);
        
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuAdmin();
            }
        });
        frame.add(buttonBack);
        frame.add(sp);
        
        frame.setVisible(true);
    }
}
