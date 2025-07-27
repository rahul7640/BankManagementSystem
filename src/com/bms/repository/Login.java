package com.bms.repository;

import com.bms.ui.AdminLogin;
import com.bms.ui.Main;
import com.bms.ui.StaffLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame {
    public Login(){
        setTitle("Login Page");
        setSize(400,400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Login Here");
        label.setBounds(118,40,150,30);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        add(label);

        JButton cus = new JButton("Staff Login");
        cus.setBounds(115,110,140,40);
        cus.setFont(new Font("Arial",Font.BOLD,16));
        add(cus);
        cus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StaffLogin();
            }
        });

        JButton cus1 = new JButton("Admin Login");
        cus1.setBounds(115,170,140,40);
        cus1.setFont(new Font("Arial",Font.BOLD,16));
        add(cus1);

        cus1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminLogin();
            }
        });
             JButton mn = new JButton("Exit");
             mn.setBounds(115,230,140,40);
             mn.setFont(new Font("Arial",Font.BOLD,16));
             add(mn);
             mn.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     dispose();
                     new Main();
                 }
             });

        setVisible(true);

    }
}
