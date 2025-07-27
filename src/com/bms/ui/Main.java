package com.bms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Management System");
        frame.setSize(600,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);


        JLabel lable = new JLabel("Bank Management System");
        lable.setBounds(140,50,320,70);
        lable.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(lable);

        JButton cus = new JButton("Staff Login");
        cus.setBounds(220,130,140,40);
        cus.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(cus);
        cus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           //     dispose();
                new StaffLogin();
            }
        });

        JButton cus1 = new JButton("Admin Login");
        cus1.setBounds(220,190,140,40);
        cus1.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(cus1);

        cus1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
                new AdminLogin();
            }
        });
        JButton mn = new JButton("Exit");
        mn.setBounds(220,250,140,40);
        mn.setFont(new Font("Arial",Font.BOLD,16));
        frame.add(mn);
        mn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   dispose();
                new Main();
            }
        });

        frame.setVisible(true);

    }
}