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
import java.util.Calendar;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Pesanan;

/**
 *
 * @author User
 */
public class MenuPembayaran {
    JFrame frame;
    JLabel labelPembayaran, labelIdPesanan, labelNamaMember, labelTipePesanan, labelAlamatJemput, labelAlamatTujuan, labelTanggalPemesanan, labelMetodePembayaran, labelDiskon, labelTotalHarga, labelStatus;
    JLabel labelIsiIdPesanan, labelIsiNamaMember, labelIsiTipePesanan, labelIsiAlamatJemput, labelIsiAlamatTujuan, labelIsiTanggalPemesanan, labelIsiMetodePembayaran, labelIsiDiskon, labelIsiTotalHarga, labelIsiStatus;
    JButton buttonTerima, buttonBatal;
    public MenuPembayaran(){
        frame = new JFrame("UP GRAB");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Pesanan> allPesanan = DatabaseControl.getAllPesanan();
        if(allPesanan == null){
            PesananManager.getInstance().getPesanan().setIdPesanan(1);
            allPesanan.add(PesananManager.getInstance().getPesanan());
        }else{
            PesananManager.getInstance().getPesanan().setIdPesanan(allPesanan.size()+1);
        }
        PesananManager.getInstance().getPesanan().setTanggalPemesanan(getTanggal());
        PesananManager.getInstance().getPesanan().setStatus(0);
        
        
        labelPembayaran = new JLabel("Keterangan Pembayaran");
        labelIdPesanan = new JLabel("Id Pesanan");
        labelNamaMember = new JLabel("Nama Member");
        labelTipePesanan = new JLabel("Tipe Pesanan");
        labelAlamatJemput = new JLabel("Alamat Jemput");
        labelAlamatTujuan = new JLabel("Alamat Tujuan");
        labelTanggalPemesanan = new JLabel("TanggalPemesanan");
        labelMetodePembayaran = new JLabel("Metode Pembayaran");
        labelDiskon = new JLabel("Diskon");
        labelTotalHarga = new JLabel("TotalHarga");
        labelStatus = new JLabel("Status");
        buttonTerima = new JButton("Terima");
        buttonBatal = new JButton("Batal");
        
        labelIsiIdPesanan = new JLabel(String.valueOf(PesananManager.getInstance().getPesanan().getIdPesanan()));
        labelIsiNamaMember = new JLabel(MemberManager.getInstance().getMember().getNama());
        labelIsiTipePesanan = new JLabel(PesananManager.getInstance().getPesanan().getTipePesanan());
        labelIsiAlamatJemput = new JLabel(PesananManager.getInstance().getPesanan().getAlamatJemput());
        labelIsiAlamatTujuan = new JLabel(PesananManager.getInstance().getPesanan().getAlamatTujuan());
        labelIsiTanggalPemesanan = new JLabel(PesananManager.getInstance().getPesanan().getTanggalPemesanan());
        labelIsiMetodePembayaran = new JLabel(PesananManager.getInstance().getPesanan().getMetodePembayaran());
        labelIsiDiskon = new JLabel(String.valueOf(PesananManager.getInstance().getPesanan().getDiskon()));
        labelIsiTotalHarga = new JLabel(String.valueOf(PesananManager.getInstance().getPesanan().getTotalHarga()));
        labelIsiStatus = new JLabel("Belum Diterima");
        
        labelPembayaran.setBounds(330, 30, 200, 30);
        labelIdPesanan.setBounds(100, 100, 200, 30);
        labelNamaMember.setBounds(100, 130, 200, 30);
        labelTipePesanan.setBounds(100, 160, 200, 30);
        labelAlamatJemput.setBounds(100, 190, 200, 30);
        labelAlamatTujuan.setBounds(100, 220, 200, 30);
        labelTanggalPemesanan.setBounds(100, 250, 200, 30);
        labelMetodePembayaran.setBounds(100, 280, 200, 30);
        labelDiskon.setBounds(100, 310, 200, 30);
        labelTotalHarga.setBounds(100, 340, 200, 30);
        labelStatus.setBounds(100, 370, 200, 30);
        labelIsiIdPesanan.setBounds(500, 100, 200, 30);
        labelIsiNamaMember.setBounds(500, 130, 200, 30);
        labelIsiTipePesanan.setBounds(500, 160, 200, 30);
        labelIsiAlamatJemput.setBounds(500, 190, 200, 30);
        labelIsiAlamatTujuan.setBounds(500, 220, 200, 30);
        labelIsiTanggalPemesanan.setBounds(500, 250, 200, 30);
        labelIsiMetodePembayaran.setBounds(500, 280, 200, 30);
        labelIsiDiskon.setBounds(500, 310, 200, 30);
        labelIsiTotalHarga.setBounds(500, 340, 200, 30);
        labelIsiStatus.setBounds(500, 370, 200, 30);
        buttonBatal.setBounds(55, 465, 100, 30);
        buttonTerima.setBounds(630, 465, 100, 30);
        
        labelPembayaran.setFont(new Font(labelPembayaran.getFont().getName(), labelPembayaran.getFont().getStyle(), 22));
        labelIdPesanan.setFont(new Font(labelIdPesanan.getFont().getName(), labelIdPesanan.getFont().getStyle(), 17));
        labelNamaMember.setFont(new Font(labelNamaMember.getFont().getName(), labelNamaMember.getFont().getStyle(), 17));
        labelTipePesanan.setFont(new Font(labelTipePesanan.getFont().getName(), labelTipePesanan.getFont().getStyle(), 17));
        labelAlamatJemput.setFont(new Font(labelAlamatJemput.getFont().getName(), labelAlamatJemput.getFont().getStyle(), 17));
        labelAlamatTujuan.setFont(new Font(labelAlamatTujuan.getFont().getName(), labelAlamatTujuan.getFont().getStyle(), 17));
        labelTanggalPemesanan.setFont(new Font(labelTanggalPemesanan.getFont().getName(), labelTanggalPemesanan.getFont().getStyle(), 17));
        labelMetodePembayaran.setFont(new Font(labelMetodePembayaran.getFont().getName(), labelMetodePembayaran.getFont().getStyle(), 17));
        labelDiskon.setFont(new Font(labelDiskon.getFont().getName(), labelDiskon.getFont().getStyle(), 17));
        labelTotalHarga.setFont(new Font(labelTotalHarga.getFont().getName(), labelTotalHarga.getFont().getStyle(), 17));
        labelStatus.setFont(new Font(labelStatus.getFont().getName(), labelStatus.getFont().getStyle(), 17));
        labelIsiIdPesanan.setFont(new Font(labelIsiIdPesanan.getFont().getName(), labelIsiIdPesanan.getFont().getStyle(), 17));
        labelIsiNamaMember.setFont(new Font(labelIsiNamaMember.getFont().getName(), labelIsiNamaMember.getFont().getStyle(), 17));
        labelIsiTipePesanan.setFont(new Font(labelIsiTipePesanan.getFont().getName(), labelIsiTipePesanan.getFont().getStyle(), 17));
        labelIsiAlamatJemput.setFont(new Font(labelIsiAlamatJemput.getFont().getName(), labelIsiAlamatJemput.getFont().getStyle(), 17));
        labelIsiAlamatTujuan.setFont(new Font(labelIsiAlamatTujuan.getFont().getName(), labelIsiAlamatTujuan.getFont().getStyle(), 17));labelIdPesanan.setFont(new Font(labelIdPesanan.getFont().getName(), labelIdPesanan.getFont().getStyle(), 17));
        labelIsiTanggalPemesanan.setFont(new Font(labelIsiTanggalPemesanan.getFont().getName(), labelIsiTanggalPemesanan.getFont().getStyle(), 17));
        labelIsiMetodePembayaran.setFont(new Font(labelIsiMetodePembayaran.getFont().getName(), labelIsiMetodePembayaran.getFont().getStyle(), 17));
        labelIsiDiskon.setFont(new Font(labelIsiDiskon.getFont().getName(), labelIsiDiskon.getFont().getStyle(), 17));
        labelIsiTotalHarga.setFont(new Font(labelIsiTotalHarga.getFont().getName(), labelIsiTotalHarga.getFont().getStyle(), 17));
        labelIsiStatus.setFont(new Font(labelIsiStatus.getFont().getName(), labelIsiStatus.getFont().getStyle(), 17));
        
        buttonBatal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Ingin Dibatalkan?");
                if(jawab == JOptionPane.YES_OPTION){
                    frame.setVisible(false);
                    new MenuCustomer();
                }
            }
        });
        buttonTerima.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Apakah Sudah Benar?");
                if(jawab == JOptionPane.YES_OPTION){
                    DatabaseControl.insertNewPesanan(PesananManager.getInstance().getPesanan());
                    JOptionPane.showMessageDialog(null, "Terima Kasih!");
                    frame.setVisible(false);
                    new MenuCustomer();
                }
            }
        });
        frame.add(labelPembayaran);
        frame.add(labelIdPesanan);
        frame.add(labelNamaMember);
        frame.add(labelTipePesanan);
        frame.add(labelAlamatJemput);
        frame.add(labelAlamatTujuan);
        frame.add(labelTanggalPemesanan);
        frame.add(labelMetodePembayaran);
        frame.add(labelDiskon);
        frame.add(labelTotalHarga);
        frame.add(labelStatus);
        frame.add(labelIsiIdPesanan);
        frame.add(labelIsiNamaMember);
        frame.add(labelIsiTipePesanan);
        frame.add(labelIsiAlamatJemput);
        frame.add(labelIsiAlamatTujuan);
        frame.add(labelIsiTanggalPemesanan);
        frame.add(labelIsiMetodePembayaran);
        frame.add(labelIsiDiskon);
        frame.add(labelIsiTotalHarga);
        frame.add(labelIsiStatus);
        frame.add(buttonBatal);
        frame.add(buttonTerima);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public int getRandomNumber(){
        Random getRandom = new Random();
        int getAngka = getRandom.nextInt(10);
        return getAngka;
    }
    public String getTanggal() {
        Calendar now = Calendar.getInstance();
        String tanggal, bulan, tahun;
        tahun = String.valueOf(now.get(Calendar.YEAR));
            
        bulan = String.valueOf(1+now.get(Calendar.MONTH));
        if(Integer.parseInt(bulan) > 12){
            bulan = "01";
        }else if(now.get(Calendar.MONTH) < 10){
            bulan = "0" + bulan;
        }else{
            bulan = bulan;
        }
        if(now.get(Calendar.DATE) < 10){
            tanggal = "0" + String.valueOf(now.get(Calendar.DATE));
        }else{
            tanggal = String.valueOf(now.get(Calendar.DATE));
        }
        String tgl = tanggal + "-" + bulan + "-" + tahun;
        
        return tgl;
    }
}
